package com.autel.sdk10.AutelNet.AutelRemoteController.socket;

import android.os.Process;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCIpConst;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IRCSocketRecCallback;
import com.autel.sdk10.AutelNet.socket.TcpSocketBase;
import com.autel.sdk10.utils.BytesUtils;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoteControllerSocket extends TcpSocketBase<RCCommandMessage> {
    public static final int CONNECTED = 2;
    public static final int CONNECTING = 1;
    public static final int DISCONNECTED = 0;
    private final int MSG_DELAY_TIME = 2000;
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public IRCSocketRecCallback mRecCallback;
    /* access modifiers changed from: private */
    public WeakReference<Socket> mSocket;
    private ExecutorService rcvThreadPool = Executors.newSingleThreadExecutor();
    private ArrayList<Byte> readBuffers = new ArrayList<>();
    private ExecutorService sendExecutor = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: protected */
    public int getPort() {
        return 8998;
    }

    public RemoteControllerSocket(IRCSocketRecCallback iRCSocketRecCallback) {
        this.mRecCallback = iRCSocketRecCallback;
    }

    public synchronized void connect() {
        connectTcp();
    }

    public synchronized void closeConnection() {
        disConnectTcp();
        IRCSocketRecCallback iRCSocketRecCallback = this.mRecCallback;
        if (iRCSocketRecCallback != null) {
            iRCSocketRecCallback.onDisconnect();
        }
    }

    public boolean isConnected() {
        return this.mConnectionStatus.get() == 2;
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Socket) this.mSocket.get();
    }

    /* access modifiers changed from: protected */
    public String getStrIP() {
        return RCIpConst.getRemoteSocketAddr();
    }

    /* access modifiers changed from: protected */
    public synchronized void connectTcp() {
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            this.rcvThreadPool.execute(new RcvRunnable());
        }
    }

    /* access modifiers changed from: protected */
    public void setRecData(Object obj) {
        IRCSocketRecCallback iRCSocketRecCallback = this.mRecCallback;
        if (iRCSocketRecCallback != null) {
            iRCSocketRecCallback.getRecData((byte[]) obj);
        }
    }

    /* access modifiers changed from: protected */
    public void reconnect() {
        if (this.mConnectionStatus.get() != 0) {
            IRCSocketRecCallback iRCSocketRecCallback = this.mRecCallback;
            if (iRCSocketRecCallback != null) {
                iRCSocketRecCallback.onReconnect();
            }
            disConnectTcp();
            connectTcp();
        }
    }

    public boolean sendMessage(final RCCommandMessage rCCommandMessage) {
        if (getSocket() == null) {
            return false;
        }
        this.sendExecutor.execute(new Runnable() {
            public void run() {
                try {
                    Socket socket = (Socket) RemoteControllerSocket.this.mSocket.get();
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(rCCommandMessage.getData());
                        outputStream.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void disConnectTcp() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.atomic.AtomicInteger r0 = r2.mConnectionStatus     // Catch:{ all -> 0x0021 }
            int r0 = r0.get()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            java.util.concurrent.ExecutorService r0 = r2.rcvThreadPool     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.isShutdown()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0014
            goto L_0x001f
        L_0x0014:
            java.util.concurrent.atomic.AtomicInteger r0 = r2.mConnectionStatus     // Catch:{ all -> 0x0021 }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x0021 }
            r2.release()     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)
            return
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelRemoteController.socket.RemoteControllerSocket.disConnectTcp():void");
    }

    private void release() {
        try {
            WeakReference<Socket> weakReference = this.mSocket;
            if (weakReference != null) {
                Socket socket = (Socket) weakReference.get();
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                this.mSocket.clear();
            }
        } catch (Exception e) {
            AutelLog.m15084e(AutelLogTags.TAG, e.toString());
        } catch (Throwable th) {
            this.mSocket = null;
            throw th;
        }
        this.mSocket = null;
    }

    private class RcvRunnable implements Runnable {
        private RcvRunnable() {
        }

        public void run() {
            try {
                Process.setThreadPriority(Process.myTid(), -15);
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(RemoteControllerSocket.this.getStrIP(), RemoteControllerSocket.this.getPort()), 2000);
                socket.setKeepAlive(true);
                socket.setSoTimeout(MAV_CMD.MAV_CMD_DO_VTOL_TRANSITION);
                WeakReference unused = RemoteControllerSocket.this.mSocket = new WeakReference(socket);
                RemoteControllerSocket.this.mConnectionStatus.set(2);
                if (RemoteControllerSocket.this.mRecCallback != null) {
                    RemoteControllerSocket.this.mRecCallback.onConnect();
                }
                RemoteControllerSocket.this.readData(socket);
            } catch (Exception e) {
                AutelLog.m15084e(AutelLogTags.TAG, e.toString());
                if (RemoteControllerSocket.this.mConnectionStatus.get() != 0) {
                    RemoteControllerSocket.this.handler.sendEmptyMessageDelayed(1, 2000);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void readData(Socket socket) {
        int i;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        this.readBuffers.clear();
        while (true) {
            short s = 0;
            while (!socket.isClosed() && !socket.isInputShutdown() && this.mConnectionStatus.get() == 2) {
                int read = bufferedInputStream.read();
                if (read == -1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.readBuffers.size() == 0) {
                    if (read == 65) {
                        this.readBuffers.add(Byte.valueOf(BytesUtils.getByte(read)));
                    } else {
                        this.readBuffers.clear();
                    }
                } else if (this.readBuffers.size() > 0 && this.readBuffers.size() < 4) {
                    this.readBuffers.add(Byte.valueOf(BytesUtils.getByte(read)));
                    if (this.readBuffers.size() == 4) {
                        s = BytesUtils.getShort(new byte[]{this.readBuffers.get(3).byteValue(), this.readBuffers.get(2).byteValue()});
                    }
                } else if (s > 0 && this.readBuffers.size() < (i = s + 4)) {
                    this.readBuffers.add(Byte.valueOf(BytesUtils.getByte(read)));
                    if (this.readBuffers.size() == i) {
                        int size = this.readBuffers.size();
                        byte[] bArr = new byte[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            bArr[i2] = this.readBuffers.get(i2).byteValue();
                        }
                        this.readBuffers.clear();
                        setRecData(bArr);
                    }
                }
            }
            return;
        }
    }
}
