package com.o3dr.android.client.utils.connection;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.o3dr.android.client.utils.connection.AbstractIpConnection;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import org.droidplanner.services.android.impl.utils.NetworkUtils;

public class UdpConnection extends AbstractIpConnection {
    private static final String TAG = "UdpConnection";
    private InetAddress hostAddress;
    private int hostPort;
    private final int readTimeout;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;
    private final int serverPort;
    private DatagramSocket socket;

    public UdpConnection(Handler handler, int i, int i2) {
        this(handler, i, i2, false, 0);
    }

    public UdpConnection(Handler handler, int i, int i2, boolean z, int i3) {
        super(handler, i2, z);
        this.serverPort = i;
        if (z) {
            this.readTimeout = i3 <= 0 ? 33 : i3;
        } else {
            this.readTimeout = AbstractIpConnection.CONNECTION_TIMEOUT;
        }
    }

    public UdpConnection(Handler handler, String str, int i, int i2) {
        super(handler, false, true);
        this.serverPort = i2;
        this.hostPort = i;
        this.hostAddress = InetAddress.getByName(str);
        this.readTimeout = AbstractIpConnection.CONNECTION_TIMEOUT;
    }

    /* access modifiers changed from: protected */
    public void open(Bundle bundle) {
        Log.d(TAG, "Opening udp connection.");
        DatagramSocket datagramSocket = this.serverPort == -1 ? new DatagramSocket() : new DatagramSocket(this.serverPort);
        this.socket = datagramSocket;
        datagramSocket.setBroadcast(true);
        this.socket.setReuseAddress(true);
        this.socket.setSoTimeout(this.readTimeout);
        NetworkUtils.bindSocketToNetwork(bundle, this.socket);
    }

    /* access modifiers changed from: protected */
    public int read(ByteBuffer byteBuffer) {
        if (this.receivePacket == null) {
            this.receivePacket = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());
        }
        this.socket.receive(this.receivePacket);
        this.hostAddress = this.receivePacket.getAddress();
        this.hostPort = this.receivePacket.getPort();
        return this.receivePacket.getLength();
    }

    /* access modifiers changed from: protected */
    public void send(AbstractIpConnection.PacketData packetData) {
        if (this.hostAddress != null) {
            DatagramPacket datagramPacket = this.sendPacket;
            if (datagramPacket == null) {
                this.sendPacket = new DatagramPacket(packetData.data, packetData.dataLength, this.hostAddress, this.hostPort);
            } else {
                datagramPacket.setData(packetData.data, 0, packetData.dataLength);
                this.sendPacket.setAddress(this.hostAddress);
                this.sendPacket.setPort(this.hostPort);
            }
            this.socket.send(this.sendPacket);
            return;
        }
        Log.w(TAG, "Still awaiting connection from remote host.");
    }

    /* access modifiers changed from: protected */
    public void close() {
        Log.d(TAG, "Closing udp connection.");
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }
}
