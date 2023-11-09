package com.autel.sdk10.AutelNet.AutelRemoteController.udp;

import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCButtonInfo;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCIpConst;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IUdpRcvCallback;
import com.autel.sdk10.AutelNet.socket.UdpSocketBase;
import com.autel.sdk10.utils.BytesUtils;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteButtonControllerUdp extends UdpSocketBase {
    /* access modifiers changed from: private */
    public volatile boolean isConnected = false;
    /* access modifiers changed from: private */
    public boolean isDisConnectTcp = true;
    /* access modifiers changed from: private */
    public IUdpRcvCallback mIUdpRcvCallback;
    /* access modifiers changed from: private */
    public WeakReference<DatagramSocket> mSocket;
    private ExecutorService rcvThreadPool = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public byte[] recvData;

    /* access modifiers changed from: protected */
    public int getConnectPort() {
        return 14558;
    }

    /* access modifiers changed from: protected */
    public int getSendPort() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void sendUdpMessage(byte[] bArr) {
    }

    public RemoteButtonControllerUdp(IUdpRcvCallback iUdpRcvCallback) {
        this.mIUdpRcvCallback = iUdpRcvCallback;
    }

    public synchronized void connect() {
        if (!isConnected()) {
            this.isDisConnectTcp = false;
            release();
            connectUdp();
        }
    }

    private boolean isConnected() {
        return !this.isDisConnectTcp;
    }

    /* access modifiers changed from: protected */
    public String getStrIP() {
        return RCIpConst.getRemoteSocketAddr();
    }

    /* access modifiers changed from: protected */
    public DatagramSocket getSocket() {
        WeakReference<DatagramSocket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (DatagramSocket) this.mSocket.get();
    }

    /* access modifiers changed from: protected */
    public synchronized void connectUdp() {
        if (!this.isDisConnectTcp) {
            this.rcvThreadPool.execute(new RcvRunnable());
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void reconnect() {
        release();
        connectUdp();
    }

    public synchronized void closeUdpConnect() {
        if (isConnected()) {
            AutelLog.m15084e(AutelLogTags.TAG_CAMERA_REMOTE_BUTTON_CONTROLLER, "disConnectTcp:");
            this.isDisConnectTcp = true;
            release();
        }
    }

    private synchronized void release() {
        try {
            WeakReference<DatagramSocket> weakReference = this.mSocket;
            if (weakReference != null) {
                DatagramSocket datagramSocket = (DatagramSocket) weakReference.get();
                if (datagramSocket != null && !datagramSocket.isClosed()) {
                    datagramSocket.close();
                }
                this.mSocket.clear();
            }
            this.mSocket = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isConnected = false;
    }

    /* access modifiers changed from: protected */
    public int receiverData(byte[] bArr) {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        WeakReference<DatagramSocket> weakReference = this.mSocket;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((DatagramSocket) this.mSocket.get()).receive(datagramPacket);
        }
        return datagramPacket.getLength();
    }

    private class RcvRunnable implements Runnable {
        private RcvRunnable() {
        }

        public void run() {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(RemoteButtonControllerUdp.this.getConnectPort());
                datagramSocket.setBroadcast(true);
                datagramSocket.setReuseAddress(true);
                WeakReference unused = RemoteButtonControllerUdp.this.mSocket = new WeakReference(datagramSocket);
                boolean unused2 = RemoteButtonControllerUdp.this.isConnected = true;
                byte[] unused3 = RemoteButtonControllerUdp.this.recvData = new byte[16];
                while (RemoteButtonControllerUdp.this.isConnected) {
                    RemoteButtonControllerUdp remoteButtonControllerUdp = RemoteButtonControllerUdp.this;
                    int receiverData = remoteButtonControllerUdp.receiverData(remoteButtonControllerUdp.recvData);
                    AutelLog.m15082d(AutelLogTags.TAG_CAMERA_REMOTE_BUTTON_CONTROLLER, "receiver data size:" + receiverData);
                    if (receiverData <= 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (RemoteButtonControllerUdp.this.mIUdpRcvCallback != null) {
                        RemoteButtonControllerUdp.this.mIUdpRcvCallback.receiverData(new RCButtonInfo().parseMessage(BytesUtils.byte2hex(RemoteButtonControllerUdp.this.recvData)));
                    }
                }
            } catch (IOException unused4) {
                if (!RemoteButtonControllerUdp.this.isDisConnectTcp) {
                    RemoteButtonControllerUdp.this.handler.sendEmptyMessageDelayed(1, 2000);
                }
            }
        }
    }
}
