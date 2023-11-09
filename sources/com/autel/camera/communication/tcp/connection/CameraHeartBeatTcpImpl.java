package com.autel.camera.communication.tcp.connection;

import android.os.Handler;
import com.autel.camera.communication.tcp.connection.base.AbsTcpConnection;
import com.autel.camera.protocol.protocol10.engine.CameraCommandMessage;
import com.autel.camera.utils.IpConstantUtils;
import com.autel.util.log.AutelLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class CameraHeartBeatTcpImpl extends AbsTcpConnection {
    private static final String TAG = "AbsTcpConnection";
    private WeakReference<Socket> mSocket;
    private ProcessPacketTask sendThread;

    public void checkTimeOutMain() {
    }

    /* access modifiers changed from: protected */
    public int getPort() {
        return 8888;
    }

    /* access modifiers changed from: protected */
    public boolean reConnect() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String loadUrl() {
        return IpConstantUtils.getCameraControlAddress();
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null) {
            return null;
        }
        return (Socket) weakReference.get();
    }

    /* access modifiers changed from: protected */
    public void openConnection(String str) {
        AutelLog.m15082d(TAG, "heartbeat openConnection ====>>> " + getPort());
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(loadUrl(), getPort()), 5000);
            socket.setKeepAlive(true);
            socket.setSoTimeout(9000);
            this.mSocket = new WeakReference<>(socket);
            if (socket.isConnected()) {
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        CameraHeartBeatTcpImpl.this.sendMessage(new CameraCommandMessage(0, 4369, (String) null, (String) null));
                    }
                }, 500);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private class ProcessPacketTask implements Runnable {
        private ProcessPacketTask() {
        }

        public void run() {
            CameraHeartBeatTcpImpl.this.sendMessage(new CameraCommandMessage(0, 4369, (String) null, (String) null));
            CameraHeartBeatTcpImpl.this.mHandler.postDelayed(this, 2000);
        }
    }

    /* access modifiers changed from: protected */
    public void parserData(Object obj) {
        if (this.sendThread == null) {
            Handler handler = this.mHandler;
            ProcessPacketTask processPacketTask = new ProcessPacketTask();
            this.sendThread = processPacketTask;
            handler.post(processPacketTask);
        }
    }

    /* access modifiers changed from: protected */
    public void closeTcpConnection() {
        AutelLog.m15082d(TAG, "closeTcpConnection heartbeat ");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.sendThread);
            this.sendThread = null;
        }
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference != null) {
            Socket socket = (Socket) weakReference.get();
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            this.mSocket.clear();
        }
    }

    public boolean isConnected() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((Socket) this.mSocket.get()).isConnected();
    }

    public <T> boolean sendMessage(T t) {
        if (isConnected()) {
            return this.mMsgList.offer(((CameraCommandMessage) t).getData());
        }
        return false;
    }
}
