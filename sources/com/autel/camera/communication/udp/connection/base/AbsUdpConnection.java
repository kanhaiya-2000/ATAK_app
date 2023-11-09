package com.autel.camera.communication.udp.connection.base;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.autel.camera.communication.udp.connection.interfaces.ISubscribeListener;
import java.net.DatagramPacket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsUdpConnection extends BaseUdpConnect implements ISubscribeListener {
    private static final int REQUEST_CLOSE = 2003;
    private static final int REQUEST_CONNECT = 2001;
    private static final int REQUEST_DISCONNECT = 2002;
    private static final int REQUEST_RECONNECT = 2004;
    private static final int STATUS_CONNECTED = 2;
    private static final int STATUS_CONNECTING = 1;
    private static final int STATUS_DISCONNECTED = 0;
    private static final String TAG = "AbsUdpConnection";
    /* access modifiers changed from: private */
    public AsyncTask curTask;
    private boolean isConnect = false;
    /* access modifiers changed from: private */
    public volatile boolean isReConnect = reConnect();
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    protected Handler mHandler;
    protected HandlerThread mHandlerThread;
    private Thread mSendThread;
    private byte[] readData = new byte[512];

    protected AbsUdpConnection() {
        initHandler();
    }

    private void initHandler() {
        HandlerThread handlerThread = new HandlerThread("Udp Thread SDK2.0");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 2001:
                        AbsUdpConnection.this.doConnect();
                        return;
                    case AbsUdpConnection.REQUEST_DISCONNECT /*2002*/:
                        AbsUdpConnection.this.doDisconnect();
                        return;
                    case 2003:
                        boolean unused = AbsUdpConnection.this.isReConnect = false;
                        if (AbsUdpConnection.this.mConnectionStatus.get() != 0) {
                            AbsUdpConnection.this.doDisconnect();
                            Log.e(AbsUdpConnection.TAG, "disconnect--- ");
                            if (AbsUdpConnection.this.curTask != null) {
                                AbsUdpConnection.this.curTask.cancel(true);
                                AsyncTask unused2 = AbsUdpConnection.this.curTask = null;
                                return;
                            }
                            return;
                        }
                        return;
                    case AbsUdpConnection.REQUEST_RECONNECT /*2004*/:
                        if (AbsUdpConnection.this.isReConnect) {
                            AbsUdpConnection.this.doConnect();
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
        this.isConnect = false;
        Thread thread = this.mSendThread;
        if (thread != null && thread.isAlive() && !this.mSendThread.isInterrupted()) {
            this.mSendThread.interrupt();
            this.mSendThread = null;
        }
        this.mConnectionStatus.set(0);
        closeUdpConnection();
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        this.isReConnect = reConnect();
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            executeTask(new ConnectTask());
        }
    }

    public void connect() {
        Log.e(TAG, "connect--- isReConnect " + this.isReConnect);
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
        Log.d(TAG, "udp resetConnect ");
        if (this.mConnectionStatus.get() != 0) {
            this.mHandler.sendEmptyMessage(REQUEST_DISCONNECT);
        }
    }

    private int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    private class ConnectTask extends AsyncTask {
        private ConnectTask() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object[] objArr) {
            Log.w(AbsUdpConnection.TAG, "doInBackground Connect ");
            AbsUdpConnection.this.dealConnect();
            AbsUdpConnection.this.mHandler.sendEmptyMessageDelayed(AbsUdpConnection.REQUEST_RECONNECT, 2000);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void dealConnect() {
        String str;
        String str2;
        try {
            connectUdp();
            notifyConnected();
            while (this.isConnect) {
                byte[] bArr = this.readData;
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                if (getSocket() != null) {
                    getSocket().receive(datagramPacket);
                }
                if (datagramPacket.getLength() > 0) {
                    parserData(this.readData);
                }
            }
            resetConnect();
            str = TAG;
            str2 = "finally msg finish IOException ";
        } catch (Exception e) {
            try {
                Log.e(TAG, "handleData msg finish IOException " + e.toString());
                e.printStackTrace();
                resetConnect();
                str = TAG;
                str2 = "finally msg finish IOException ";
            } catch (Throwable th) {
                resetConnect();
                Log.e(TAG, "finally msg finish IOException ");
                throw th;
            }
        }
        Log.e(str, str2);
        return;
    }

    private void notifyConnected() {
        if (getConnectionStatus() != 2) {
            this.isConnect = true;
            this.mConnectionStatus.set(2);
        }
    }
}
