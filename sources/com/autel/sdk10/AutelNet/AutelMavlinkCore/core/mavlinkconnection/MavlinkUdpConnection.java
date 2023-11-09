package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection;

import android.util.Log;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.engine.MavlinkIpConst;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public abstract class MavlinkUdpConnection extends MavLinkConnection {
    private String mUrl_Route;
    private String mUrl_Rtsp;
    private int serverPort;
    private DatagramSocket socket;

    /* access modifiers changed from: protected */
    public abstract String GetRouteHost();

    /* access modifiers changed from: protected */
    public abstract String GetRtspHost();

    /* access modifiers changed from: protected */
    public abstract boolean isUseUsbTransfer();

    /* access modifiers changed from: protected */
    public abstract int loadServerPort();

    private void getUdpStream() {
        DatagramSocket datagramSocket = new DatagramSocket(this.serverPort);
        this.socket = datagramSocket;
        datagramSocket.setBroadcast(true);
        this.socket.setReuseAddress(true);
    }

    /* access modifiers changed from: protected */
    public void openConnection() {
        getUdpStream();
        this.mUrl_Rtsp = MavlinkIpConst.getFlyRtspAddr();
        this.mUrl_Route = MavlinkIpConst.getFlyRouteAddr();
        Log.d("MavlinkUdpSocket", "GetRouteHost url=" + this.mUrl_Route + " " + this);
    }

    /* access modifiers changed from: protected */
    public void closeConnection() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        try {
            InetAddress byName = InetAddress.getByName(this.mUrl_Route);
            InetAddress byName2 = InetAddress.getByName(this.mUrl_Rtsp);
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, byName, 14551);
            DatagramPacket datagramPacket2 = new DatagramPacket(bArr, bArr.length, byName2, 14551);
            try {
                this.socket.send(datagramPacket);
                if (!isUseUsbTransfer()) {
                    this.socket.send(datagramPacket2);
                }
            } catch (SocketException e) {
                AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, e.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final int readDataBlock(byte[] bArr) {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        this.socket.receive(datagramPacket);
        return datagramPacket.getLength();
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
        this.serverPort = loadServerPort();
    }
}
