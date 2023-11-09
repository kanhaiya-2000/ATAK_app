package com.autel.camera.communication.http.connection;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.internal.network.abstracts.BaseHttpConnect;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.network.interfaces.ISubscribeListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.util.log.AutelLog;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsHttpConnection extends BaseHttpConnect implements ISubscribeListener {
    private static final int REQUEST_CLOSE = 2003;
    private static final int REQUEST_CONNECT = 2001;
    private static final int REQUEST_DISCONNECT = 2002;
    private static final int REQUEST_RECONNECT = 2004;
    private static final int STATUS_CONNECTED = 2;
    private static final int STATUS_CONNECTING = 1;
    private static final int STATUS_DISCONNECTED = 0;
    private static final String TAG = "AbsHttpConnection";
    /* access modifiers changed from: private */
    public AsyncTask curTask;
    /* access modifiers changed from: private */
    public volatile boolean isReConnect = reConnect();
    private final ConcurrentHashMap<String, IConnectionListener> mConnectionListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    protected Handler mHandler;
    protected HandlerThread mHandlerThread;

    protected AbsHttpConnection() {
        initHandler();
    }

    private void initHandler() {
        HandlerThread handlerThread = new HandlerThread("Http Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 2001:
                        AutelLog.m15082d(AbsHttpConnection.TAG, "REQUEST_CONNECT status: " + AbsHttpConnection.this.mConnectionStatus.get() + " isReConnect: " + AbsHttpConnection.this.isReConnect + " " + getClass().getSimpleName());
                        AbsHttpConnection.this.doConnect();
                        return;
                    case AbsHttpConnection.REQUEST_DISCONNECT /*2002*/:
                        AbsHttpConnection.this.doDisconnect();
                        return;
                    case 2003:
                        boolean unused = AbsHttpConnection.this.isReConnect = false;
                        if (AbsHttpConnection.this.curTask != null) {
                            AbsHttpConnection.this.curTask.cancel(true);
                            AsyncTask unused2 = AbsHttpConnection.this.curTask = null;
                        }
                        AbsHttpConnection.this.mHandler.removeCallbacksAndMessages((Object) null);
                        AbsHttpConnection.this.doDisconnect();
                        return;
                    case AbsHttpConnection.REQUEST_RECONNECT /*2004*/:
                        AutelLog.m15082d(AbsHttpConnection.TAG, "rerereerereer Connect status: " + AbsHttpConnection.this.mConnectionStatus.get() + " isReConnect: " + AbsHttpConnection.this.isReConnect + " " + getClass().getSimpleName());
                        if (AbsHttpConnection.this.isReConnect) {
                            AbsHttpConnection.this.doConnect();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void doDisconnect() {
        if (this.mConnectionStatus.get() != 0) {
            this.mConnectionStatus.set(0);
            try {
                closeHttpConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            notifyDisconnect();
        }
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        this.isReConnect = reConnect();
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            executeTask(new ConnectTask());
        } else {
            Log.e(TAG, "Camera already Connect ");
        }
    }

    public void connect() {
        Log.e(TAG, "Camera Connect ");
        this.mHandler.sendEmptyMessage(2001);
    }

    private void executeTask(AsyncTask asyncTask) {
        AsyncTask asyncTask2 = this.curTask;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.curTask = null;
        }
        ExecutorService executorService = this.mExecutor;
        if (executorService != null && !executorService.isShutdown()) {
            this.curTask = asyncTask;
            asyncTask.executeOnExecutor(this.mExecutor, new Object[0]);
        }
    }

    public void disconnect() {
        this.mHandler.sendEmptyMessage(2003);
    }

    private void resetConnect() {
        Log.e(TAG, "http resetConnect ");
        if (this.mConnectionStatus.get() != 0) {
            this.mHandler.sendEmptyMessage(REQUEST_DISCONNECT);
        }
    }

    public void registerConnectListener(String str, IConnectionListener iConnectionListener) {
        if (!this.mConnectionListeners.containsKey(str) && iConnectionListener != null) {
            this.mConnectionListeners.put(str, iConnectionListener);
            CameraMessageDisPatcher.instance().registerConnectListener(str, iConnectionListener);
        }
    }

    public void unRegisterConnectListener(String str) {
        this.mConnectionListeners.remove(str);
        CameraMessageDisPatcher.instance().unRegisterConnectListener(str);
    }

    private int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    private class ConnectTask extends AsyncTask {
        private ConnectTask() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object[] objArr) {
            Log.e(AbsHttpConnection.TAG, "doInBackground Connect ");
            AbsHttpConnection.this.dealConnect();
            AbsHttpConnection.this.mHandler.sendEmptyMessageDelayed(AbsHttpConnection.REQUEST_RECONNECT, 2000);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[Catch:{ Exception -> 0x006d, all -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dealConnect() {
        /*
            r10 = this;
            java.lang.String r0 = "finally resetConnect--- "
            java.lang.String r1 = "AbsHttpConnection"
            r10.notifyStartConnect()     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = r10.loadUrl()     // Catch:{ Exception -> 0x006d }
            r10.openConnection(r2)     // Catch:{ Exception -> 0x006d }
            boolean r2 = r10.isConnected()     // Catch:{ Exception -> 0x006d }
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "http openConnection success "
            android.util.Log.e(r1, r2)     // Catch:{ Exception -> 0x006d }
            r10.notifyConnected()     // Catch:{ Exception -> 0x006d }
            java.io.BufferedReader r2 = r10.getBufferedReader()     // Catch:{ Exception -> 0x006d }
            r3 = 8192(0x2000, float:1.14794E-41)
            char[] r3 = new char[r3]     // Catch:{ Exception -> 0x006d }
            r4 = 0
            r5 = 0
        L_0x0026:
            r6 = 0
        L_0x0027:
            int r7 = r2.read()     // Catch:{ Exception -> 0x006d }
            r8 = -1
            if (r7 == r8) goto L_0x005a
            int r8 = r10.getConnectionStatus()     // Catch:{ Exception -> 0x006d }
            r9 = 2
            if (r8 != r9) goto L_0x005a
            r8 = 125(0x7d, float:1.75E-43)
            if (r7 != r8) goto L_0x003c
            int r5 = r5 + -1
            goto L_0x0042
        L_0x003c:
            r8 = 123(0x7b, float:1.72E-43)
            if (r7 != r8) goto L_0x0042
            int r5 = r5 + 1
        L_0x0042:
            if (r5 != 0) goto L_0x0047
            if (r6 != 0) goto L_0x0047
            goto L_0x0027
        L_0x0047:
            int r8 = r6 + 1
            char r7 = (char) r7     // Catch:{ Exception -> 0x006d }
            r3[r6] = r7     // Catch:{ Exception -> 0x006d }
            if (r5 != 0) goto L_0x0058
            if (r8 == 0) goto L_0x0058
            java.lang.String r6 = java.lang.String.copyValueOf(r3, r4, r8)     // Catch:{ Exception -> 0x006d }
            r10.parserData(r6)     // Catch:{ Exception -> 0x006d }
            goto L_0x0026
        L_0x0058:
            r6 = r8
            goto L_0x0027
        L_0x005a:
            if (r2 == 0) goto L_0x005f
            r2.close()     // Catch:{ Exception -> 0x006d }
        L_0x005f:
            java.lang.String r2 = "bufferedReader close-------------->> "
            android.util.Log.e(r1, r2)     // Catch:{ Exception -> 0x006d }
        L_0x0064:
            android.util.Log.e(r1, r0)
            r10.resetConnect()
            goto L_0x00ac
        L_0x006b:
            r2 = move-exception
            goto L_0x00ad
        L_0x006d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r3.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "handleData msg finish IOException "
            r3.append(r4)     // Catch:{ all -> 0x006b }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x006b }
            r3.append(r4)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006b }
            android.util.Log.e(r1, r3)     // Catch:{ all -> 0x006b }
            java.util.concurrent.atomic.AtomicInteger r3 = r10.mConnectionStatus     // Catch:{ all -> 0x006b }
            int r3 = r3.get()     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x0091
            r10.notifyComError()     // Catch:{ all -> 0x006b }
        L_0x0091:
            java.lang.String r3 = "ConnectDebug"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r4.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r5 = "camera http exception "
            r4.append(r5)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x006b }
            r4.append(r2)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x006b }
            com.autel.util.log.AutelLog.debug_i(r3, r2)     // Catch:{ all -> 0x006b }
            goto L_0x0064
        L_0x00ac:
            return
        L_0x00ad:
            android.util.Log.e(r1, r0)
            r10.resetConnect()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.communication.http.connection.AbsHttpConnection.dealConnect():void");
    }

    private void notifyStartConnect() {
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener onConnectStatus : this.mConnectionListeners.values()) {
                onConnectStatus.onConnectStatus(ConnectConnectStatus.CONNECTING);
            }
        }
    }

    private void notifyComError() {
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener onConnectStatus : this.mConnectionListeners.values()) {
                onConnectStatus.onConnectStatus(ConnectConnectStatus.ERROR);
            }
        }
    }

    private void notifyConnected() {
        if (getConnectionStatus() != 2) {
            this.mConnectionStatus.set(2);
        }
    }

    private void notifyDisconnect() {
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener onConnectStatus : this.mConnectionListeners.values()) {
                onConnectStatus.onConnectStatus(ConnectConnectStatus.DISCONNECT);
            }
        }
    }
}
