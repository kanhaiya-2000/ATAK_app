package com.autel.camera.communication.udp.connection.base;

import java.net.DatagramSocket;

public abstract class BaseUdpConnect {
    /* access modifiers changed from: protected */
    public abstract void closeUdpConnection();

    /* access modifiers changed from: protected */
    public abstract void connectUdp();

    /* access modifiers changed from: protected */
    public abstract int getConnectPort();

    /* access modifiers changed from: protected */
    public abstract int getSendPort();

    /* access modifiers changed from: protected */
    public abstract DatagramSocket getSocket();

    /* access modifiers changed from: protected */
    public abstract String getStrIP();

    /* access modifiers changed from: protected */
    public abstract boolean isConnected();

    /* access modifiers changed from: protected */
    public abstract void parserData(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract boolean reConnect();

    /* access modifiers changed from: protected */
    public abstract void sendUdpMessage(byte[] bArr);
}
