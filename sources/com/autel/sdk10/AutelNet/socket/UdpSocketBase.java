package com.autel.sdk10.AutelNet.socket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.net.DatagramSocket;

public abstract class UdpSocketBase {
    protected final int CONNECTERROR = 1;
    protected final int MSG_DELAY_TIME = 2000;
    protected final int RECDATASUCC = 0;
    /* access modifiers changed from: protected */
    public Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                try {
                    UdpSocketBase.this.receiverData((byte[]) message.obj);
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } else if (i != 1) {
                return false;
            } else {
                UdpSocketBase.this.reconnect();
                return false;
            }
        }
    });

    /* access modifiers changed from: protected */
    public abstract void closeUdpConnect();

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
    public abstract int receiverData(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void reconnect();

    /* access modifiers changed from: protected */
    public abstract void sendUdpMessage(byte[] bArr);
}
