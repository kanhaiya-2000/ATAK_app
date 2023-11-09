package com.autel.sdk10.AutelNet.socket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Socket;

public abstract class TcpSocketBase<T> {
    protected final int CONNECTERROR = 1;
    /* access modifiers changed from: protected */
    public Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            TcpSocketBase.this.reconnect();
            return false;
        }
    });

    /* access modifiers changed from: protected */
    public abstract void connectTcp();

    /* access modifiers changed from: protected */
    public abstract void disConnectTcp();

    /* access modifiers changed from: protected */
    public abstract int getPort();

    /* access modifiers changed from: protected */
    public abstract Socket getSocket();

    /* access modifiers changed from: protected */
    public abstract String getStrIP();

    /* access modifiers changed from: protected */
    public abstract void reconnect();

    /* access modifiers changed from: protected */
    public abstract boolean sendMessage(T t);

    /* access modifiers changed from: protected */
    public abstract void setRecData(Object obj);
}
