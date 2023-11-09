package org.droidplanner.services.android.impl.core.MAVLink.connection;

import android.content.Context;
import android.os.Bundle;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.utils.NetworkUtils;

public abstract class UdpConnection extends MavLinkConnection {
    private InetAddress hostAdd;
    private int hostPort;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;
    private int serverPort;
    private AtomicReference<DatagramSocket> socketRef = new AtomicReference<>();

    public final int getConnectionType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract int loadServerPort();

    protected UdpConnection(Context context) {
        super(context);
    }

    private void getUdpStream(Bundle bundle) {
        DatagramSocket datagramSocket = new DatagramSocket(this.serverPort);
        datagramSocket.setBroadcast(true);
        datagramSocket.setReuseAddress(true);
        NetworkUtils.bindSocketToNetwork(bundle, datagramSocket);
        this.socketRef.set(datagramSocket);
    }

    public final void closeConnection() {
        DatagramSocket datagramSocket = this.socketRef.get();
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public final void openConnection(Bundle bundle) {
        getUdpStream(bundle);
        onConnectionOpened(bundle);
    }

    public final void sendBuffer(byte[] bArr) {
        DatagramSocket datagramSocket = this.socketRef.get();
        if (datagramSocket != null) {
            try {
                if (this.hostAdd != null) {
                    DatagramPacket datagramPacket = this.sendPacket;
                    if (datagramPacket == null) {
                        this.sendPacket = new DatagramPacket(bArr, bArr.length, this.hostAdd, this.hostPort);
                    } else {
                        datagramPacket.setData(bArr, 0, bArr.length);
                        this.sendPacket.setAddress(this.hostAdd);
                        this.sendPacket.setPort(this.hostPort);
                    }
                    datagramSocket.send(this.sendPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendBuffer(InetAddress inetAddress, int i, byte[] bArr) {
        DatagramSocket datagramSocket = this.socketRef.get();
        if (datagramSocket != null && inetAddress != null && bArr != null) {
            datagramSocket.send(new DatagramPacket(bArr, bArr.length, inetAddress, i));
        }
    }

    public final int readDataBlock(byte[] bArr) {
        DatagramSocket datagramSocket = this.socketRef.get();
        if (datagramSocket == null) {
            return 0;
        }
        DatagramPacket datagramPacket = this.receivePacket;
        if (datagramPacket == null) {
            this.receivePacket = new DatagramPacket(bArr, bArr.length);
        } else {
            datagramPacket.setData(bArr);
        }
        datagramSocket.receive(this.receivePacket);
        this.hostAdd = this.receivePacket.getAddress();
        this.hostPort = this.receivePacket.getPort();
        return this.receivePacket.getLength();
    }

    public final void loadPreferences() {
        this.serverPort = loadServerPort();
    }
}
