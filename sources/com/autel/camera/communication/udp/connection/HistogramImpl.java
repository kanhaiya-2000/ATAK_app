package com.autel.camera.communication.udp.connection;

import android.os.Handler;
import com.autel.camera.communication.udp.connection.base.AbsUdpConnection;
import com.autel.camera.communication.udp.connection.events.HistogramDispatcher;
import com.autel.camera.utils.IpConstantUtils;
import com.autel.util.log.AutelLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HistogramImpl extends AbsUdpConnection {
    private static final int READ_SO_TIMEOUT = 3000;
    private WeakReference<DatagramSocket> mSocket;
    /* access modifiers changed from: private */
    public byte[] sendData = {111, 110};
    /* access modifiers changed from: private */
    public ExecutorService sendExecutor = Executors.newSingleThreadExecutor();
    private SendPacketTask sendThread;

    /* access modifiers changed from: protected */
    public int getConnectPort() {
        return 16986;
    }

    /* access modifiers changed from: protected */
    public int getSendPort() {
        return 16985;
    }

    /* access modifiers changed from: protected */
    public boolean reConnect() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String getStrIP() {
        return IpConstantUtils.getCameraControlAddress();
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
    public void connectUdp() {
        DatagramSocket datagramSocket = new DatagramSocket(getConnectPort());
        datagramSocket.setBroadcast(true);
        datagramSocket.setReuseAddress(true);
        datagramSocket.setSoTimeout(3000);
        this.mSocket = new WeakReference<>(datagramSocket);
        Handler handler = this.mHandler;
        SendPacketTask sendPacketTask = new SendPacketTask();
        this.sendThread = sendPacketTask;
        handler.postDelayed(sendPacketTask, 500);
    }

    private class SendPacketTask implements Runnable {
        private SendPacketTask() {
        }

        public void run() {
            HistogramImpl.this.sendExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        HistogramImpl.this.sendUdpMessage(HistogramImpl.this.sendData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void closeUdpConnection() {
        try {
            if (!(this.mHandler == null || this.sendThread == null)) {
                this.mHandler.removeCallbacks(this.sendThread);
                this.sendThread = null;
            }
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
    }

    /* access modifiers changed from: protected */
    public void sendUdpMessage(byte[] bArr) {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(getStrIP()), getSendPort());
        WeakReference<DatagramSocket> weakReference = this.mSocket;
        if (weakReference != null && weakReference.get() != null) {
            ((DatagramSocket) this.mSocket.get()).send(datagramPacket);
            AutelLog.m15082d("AbsUdpConnection", "sendUdpMessage=====>>");
        }
    }

    /* access modifiers changed from: protected */
    public void parserData(byte[] bArr) {
        HistogramDispatcher.instance().onDisPatchPacket(new String(bArr));
    }

    /* access modifiers changed from: protected */
    public boolean isConnected() {
        WeakReference<DatagramSocket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((DatagramSocket) this.mSocket.get()).isConnected();
    }
}
