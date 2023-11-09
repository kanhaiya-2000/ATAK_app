package com.autel.camera.communication.tcp.connection.base;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.autel.camera.communication.CameraConnection;
import com.autel.camera.communication.tcp.connection.events.CameraControllerDispatcher;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.network.interfaces.ISubscribeListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsTcpConnection extends BaseTcpConnect implements ISubscribeListener {
    private static final int MSG_RE_CONNECTION = 101;
    private static final int REQUEST_CLOSE = 2003;
    private static final int REQUEST_CONNECT = 2001;
    private static final int REQUEST_DISCONNECT = 2002;
    private static final int REQUEST_RECONNECT = 2004;
    private static final int STATUS_CONNECTED = 2;
    private static final int STATUS_CONNECTING = 1;
    private static final int STATUS_DISCONNECTED = 0;
    private static final String TAG = "AbsTcpConnection";
    private final Runnable checkOutTimeRunnable = new Runnable() {
        public void run() {
            AbsTcpConnection.this.checkTimeOutMain();
            AbsTcpConnection.this.mHandler.postDelayed(this, 1000);
        }
    };
    /* access modifiers changed from: private */
    public AsyncTask curTask;
    /* access modifiers changed from: private */
    public volatile boolean isReConnect = reConnect();
    private final ConcurrentHashMap<String, IConnectionListener> mConnectionListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: protected */
    public Handler mHandler;
    protected HandlerThread mHandlerThread;
    protected LinkedBlockingDeque<String> mMsgList = new LinkedBlockingDeque<>();
    private Thread mSendThread;

    public abstract void checkTimeOutMain();

    protected AbsTcpConnection() {
        initHandler();
    }

    private void initHandler() {
        HandlerThread handlerThread = new HandlerThread("Tcp Thread SDK1.0");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 101) {
                    switch (i) {
                        case 2001:
                            AutelLog.m15082d(AbsTcpConnection.TAG, "REQUEST_CONNECT status: " + AbsTcpConnection.this.mConnectionStatus.get() + " isReConnect: " + AbsTcpConnection.this.isReConnect + " " + getClass().getSimpleName());
                            AbsTcpConnection.this.doConnect();
                            return;
                        case AbsTcpConnection.REQUEST_DISCONNECT /*2002*/:
                            AbsTcpConnection.this.doDisconnect();
                            return;
                        case 2003:
                            boolean unused = AbsTcpConnection.this.isReConnect = false;
                            if (AbsTcpConnection.this.mConnectionStatus.get() != 0) {
                                if (AbsTcpConnection.this.curTask != null) {
                                    AbsTcpConnection.this.curTask.cancel(true);
                                    AsyncTask unused2 = AbsTcpConnection.this.curTask = null;
                                }
                                AbsTcpConnection.this.mHandler.removeCallbacksAndMessages((Object) null);
                                AbsTcpConnection.this.doDisconnect();
                                Log.e(AbsTcpConnection.TAG, "loadUrl:" + AbsTcpConnection.this.loadUrl() + " port:" + AbsTcpConnection.this.getPort() + " disconnect--- ");
                                return;
                            }
                            return;
                        case AbsTcpConnection.REQUEST_RECONNECT /*2004*/:
                            AutelLog.m15082d(AbsTcpConnection.TAG, "rerereerereer Connect status: " + AbsTcpConnection.this.mConnectionStatus.get() + " isReConnect: " + AbsTcpConnection.this.isReConnect + " " + getClass().getSimpleName());
                            if (AbsTcpConnection.this.isReConnect) {
                                AbsTcpConnection.this.doConnect();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else if (AbsTcpConnection.this.isReConnect) {
                    CameraConnection.instance().connect();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        this.isReConnect = reConnect();
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            executeTask(new ConnectTask());
        }
    }

    /* access modifiers changed from: private */
    public void doDisconnect() {
        AutelLog.m15082d(TAG, "doDisconnect+++++++++++++++++ " + getClass().getSimpleName());
        try {
            Thread thread = this.mSendThread;
            if (thread != null && thread.isAlive() && !this.mSendThread.isInterrupted()) {
                this.mSendThread.interrupt();
                this.mSendThread = null;
            }
            closeTcpConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mConnectionStatus.set(0);
        notifyDisconnect();
    }

    public void connect() {
        AutelLog.m15082d(TAG, "connect---------------");
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

    public void resetConnect() {
        Log.d(TAG, "tcp resetConnect ");
        if (this.mConnectionStatus.get() != 0) {
            this.mHandler.sendEmptyMessage(REQUEST_DISCONNECT);
        }
    }

    public void registerConnectListener(String str, IConnectionListener iConnectionListener) {
        if (!this.mConnectionListeners.containsKey(str) && iConnectionListener != null) {
            this.mConnectionListeners.put(str, iConnectionListener);
            CameraControllerDispatcher.instance().registerConnectListener(str, iConnectionListener);
        }
    }

    public void unRegisterConnectListener(String str) {
        this.mConnectionListeners.remove(str);
        CameraControllerDispatcher.instance().unRegisterConnectListener(str);
    }

    private int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    private class ConnectTask extends AsyncTask {
        private ConnectTask() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object[] objArr) {
            Log.w(AbsTcpConnection.TAG, "doInBackground Connect ");
            AbsTcpConnection.this.dealConnect();
            Log.w(AbsTcpConnection.TAG, "doInBackground Rererererer Connect ");
            AbsTcpConnection.this.mHandler.sendEmptyMessageDelayed(AbsTcpConnection.REQUEST_RECONNECT, 2000);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void dealConnect() {
        StringBuilder sb;
        try {
            notifyStartConnect();
            openConnection(loadUrl());
            if (isConnected()) {
                Thread thread = new Thread(new SendRunnable(), "Camera SendThread");
                this.mSendThread = thread;
                thread.start();
                this.mHandler.postDelayed(this.checkOutTimeRunnable, 500);
                Log.d(TAG, "tcp openConnection success ip:" + loadUrl() + " port:" + getPort());
                notifyConnected();
                readData(getSocket());
            }
            resetConnect();
            sb = new StringBuilder();
        } catch (Exception e) {
            Log.e(TAG, "handleData msg finish IOException " + e.toString());
            e.printStackTrace();
            if (this.mConnectionStatus.get() != 0) {
                notifyComError();
            }
            resetConnect();
            sb = new StringBuilder();
        } catch (Throwable th) {
            resetConnect();
            Log.e(TAG, "finally msg finish IOException " + this.isReConnect);
            throw th;
        }
        sb.append("finally msg finish IOException ");
        sb.append(this.isReConnect);
        Log.e(TAG, sb.toString());
    }

    private void readData(Socket socket) {
        if (socket != null) {
            StringBuffer stringBuffer = new StringBuffer();
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            loop0:
            while (true) {
                int i = 0;
                while (!socket.isClosed() && !socket.isInputShutdown() && isConnected()) {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        SystemClock.sleep(100);
                    } else {
                        if (read == 125) {
                            i--;
                        } else if (read == 123) {
                            i++;
                        }
                        stringBuffer.append((char) read);
                        if (i == 0) {
                            if (stringBuffer.toString().trim().length() > 1) {
                                parserData(stringBuffer.toString());
                                stringBuffer.delete(0, stringBuffer.length());
                            }
                        }
                    }
                }
            }
            inputStream.close();
            bufferedInputStream.close();
        }
    }

    private class SendRunnable implements Runnable {
        private SendRunnable() {
        }

        public void run() {
            String str;
            Exception e;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    str = AbsTcpConnection.this.mMsgList.take();
                    if (str != null) {
                        try {
                            if (AbsTcpConnection.this.isConnected()) {
                                boolean unused = AbsTcpConnection.this.sendCameraMessage(str);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            AutelLog.m15084e(AbsTcpConnection.TAG, " -----send- reConnect-----Exception------------- " + e.getMessage() + " isReConnect:" + AbsTcpConnection.this.isReConnect + " msg:" + str);
                            CameraConnection.instance().resetDisconnect();
                            AbsTcpConnection.this.mHandler.sendEmptyMessageDelayed(101, 2000);
                        }
                    }
                } catch (Exception e3) {
                    Exception exc = e3;
                    str = "";
                    e = exc;
                    e.printStackTrace();
                    AutelLog.m15084e(AbsTcpConnection.TAG, " -----send- reConnect-----Exception------------- " + e.getMessage() + " isReConnect:" + AbsTcpConnection.this.isReConnect + " msg:" + str);
                    CameraConnection.instance().resetDisconnect();
                    AbsTcpConnection.this.mHandler.sendEmptyMessageDelayed(101, 2000);
                }
            }
            AutelLog.m15082d(AbsTcpConnection.TAG, " -----sendThead disconnect------------ ");
        }
    }

    /* access modifiers changed from: private */
    public boolean sendCameraMessage(String str) {
        if (getSocket() == null) {
            AutelLog.m15084e(AutelLogTags.CAMERA_STATUS, " socket is null ");
            return false;
        }
        Socket socket = getSocket();
        if (socket == null || socket.isClosed() || socket.isOutputShutdown() || !isConnected()) {
            return false;
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(str.getBytes());
        AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "send message:" + str);
        outputStream.flush();
        return true;
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
