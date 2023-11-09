package com.autel.sdk10.AutelNet.AutelDsp.usb.connection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class AutelDspRFUDPConnection {
    private static final int READ_SO_TIMEOUT = 5000;
    private String histoUdpAddress = "127.0.0.1";
    private int hostPort = 16080;
    private boolean isRunning = true;
    private DatagramSocket socket;

    private void getUdpStream() {
        DatagramSocket datagramSocket = new DatagramSocket(16082);
        this.socket = datagramSocket;
        datagramSocket.setBroadcast(true);
        this.socket.setReuseAddress(true);
        this.socket.setSoTimeout(5000);
    }

    public final void closeConnection() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public final void openConnection() {
        getUdpStream();
    }

    public final void sendBuffer(byte[] bArr) {
        try {
            this.socket.send(new DatagramPacket(bArr, bArr.length, InetAddress.getByName(this.histoUdpAddress), this.hostPort));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int readDataBlock(byte[] bArr) {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.receive(datagramPacket);
        }
        return datagramPacket.getLength();
    }
}
