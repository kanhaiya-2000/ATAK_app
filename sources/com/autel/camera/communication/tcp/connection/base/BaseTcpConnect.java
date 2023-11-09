package com.autel.camera.communication.tcp.connection.base;

import java.net.Socket;

public abstract class BaseTcpConnect {
    /* access modifiers changed from: protected */
    public abstract void closeTcpConnection();

    /* access modifiers changed from: protected */
    public abstract int getPort();

    /* access modifiers changed from: protected */
    public abstract Socket getSocket();

    public abstract boolean isConnected();

    /* access modifiers changed from: protected */
    public abstract String loadUrl();

    /* access modifiers changed from: protected */
    public abstract void openConnection(String str);

    /* access modifiers changed from: protected */
    public abstract void parserData(Object obj);

    /* access modifiers changed from: protected */
    public abstract boolean reConnect();

    public abstract <T> boolean sendMessage(T t);
}
