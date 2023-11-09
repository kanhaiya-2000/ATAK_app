package com.autel.sdk10.AutelNet.AutelRemoteController.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autel.common.error.AutelError;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IRCSocketRecCallback;
import com.autel.sdk10.AutelNet.AutelRemoteController.parser.RCRespondMsgParser;
import com.autel.sdk10.AutelNet.AutelRemoteController.socket.RemoteControllerSocket;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.interfaces.IAutelConnectionStatusListener;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteControllerManager extends AutelRemoteControllerRequestManager {
    private static RemoteControllerManager instance_;
    private final long RCV_TIME_OUT = 3000;
    private final int TIMEOUT_ERROR = 0;
    private ExecutorService checkOutTimeThreadPool;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, IAutelConnectionStatusListener> connectStatusListenerMaps = new ConcurrentHashMap<>();
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            RCCommandMessage rCCommandMessage = (RCCommandMessage) message.obj;
            if (!(rCCommandMessage == null || RemoteControllerManager.this.shorttimeCallbackMaps.get(rCCommandMessage) == null)) {
                ((AutelCompletionCallback.ICompletionCallbackWith) RemoteControllerManager.this.shorttimeCallbackMaps.get(rCCommandMessage)).onFailure(AutelError.COMMON_TIMEOUT);
            }
            RemoteControllerManager.this.mTimeOutMaps.remove(rCCommandMessage);
            return false;
        }
    });
    /* access modifiers changed from: private */
    public boolean isCheckOutTimeThreadRunning = false;
    private ConcurrentHashMap<String, RCLongTimeCallbackBody> longtimeCallbackMaps = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<RCCommandMessage, Long> mTimeOutMaps = new ConcurrentHashMap<>();
    private RemoteControllerSocket remoteControllerSocket;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<RCCommandMessage, AutelCompletionCallback.ICompletionCallbackWith> shorttimeCallbackMaps = new ConcurrentHashMap<>();

    public static RemoteControllerManager getInstance() {
        if (instance_ == null) {
            instance_ = new RemoteControllerManager();
        }
        return instance_;
    }

    private RemoteControllerManager() {
    }

    private synchronized RemoteControllerSocket getRemoteControllerSocket() {
        if (this.remoteControllerSocket == null) {
            this.remoteControllerSocket = new RemoteControllerSocket(new IRCSocketRecCallback() {
                public void onConnect() {
                    RemoteControllerManager.this.notifyConnectionStatus(0);
                }

                public void onDisconnect() {
                    RemoteControllerManager.this.notifyConnectionStatus(2);
                }

                public void onReconnect() {
                    RemoteControllerManager.this.notifyConnectionStatus(2);
                }

                public void getRecData(byte[] bArr) {
                    if (bArr != null) {
                        RemoteControllerManager.this.callbackRecData(new RCCommandMessage(bArr));
                    }
                }
            });
        }
        return this.remoteControllerSocket;
    }

    public synchronized void openConnection() {
        getRemoteControllerSocket().connect();
        startCheckTimeOutThread();
    }

    public synchronized void closeConnection() {
        AutelLog.m15084e(AutelLogTags.TAG, "closeConnection");
        getRemoteControllerSocket().closeConnection();
        stopCheckTimeOutThread();
    }

    public boolean isSocketConnected() {
        RemoteControllerSocket remoteControllerSocket2 = this.remoteControllerSocket;
        return remoteControllerSocket2 != null && remoteControllerSocket2.isConnected();
    }

    public void addIAutelConnectionStatusListener(String str, IAutelConnectionStatusListener iAutelConnectionStatusListener) {
        if (iAutelConnectionStatusListener != null) {
            this.connectStatusListenerMaps.put(str, iAutelConnectionStatusListener);
            if (getRemoteControllerSocket().isConnected()) {
                iAutelConnectionStatusListener.onConnect();
            } else {
                iAutelConnectionStatusListener.onDisconnect();
            }
        }
    }

    public void removeIAutelConnectionStatusListener(String str) {
        this.connectStatusListenerMaps.remove(str);
    }

    /* access modifiers changed from: private */
    public void notifyConnectionStatus(final int i) {
        this.handler.post(new Runnable() {
            public void run() {
                for (IAutelConnectionStatusListener iAutelConnectionStatusListener : RemoteControllerManager.this.connectStatusListenerMaps.values()) {
                    int i = i;
                    if (i == 0) {
                        iAutelConnectionStatusListener.onConnect();
                    } else if (i == 1) {
                        iAutelConnectionStatusListener.onReconnect();
                    } else if (i == 2) {
                        iAutelConnectionStatusListener.onDisconnect();
                    }
                }
            }
        });
    }

    public synchronized void setICompletionCallbackWith(RCCommandMessage rCCommandMessage, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            this.shorttimeCallbackMaps.put(rCCommandMessage, iCompletionCallbackWith);
        }
        if (!getRemoteControllerSocket().sendMessage(rCCommandMessage)) {
            if (iCompletionCallbackWith != null) {
                iCompletionCallbackWith.onFailure(AutelError.COMMON_DISCONNECTED);
            }
            this.shorttimeCallbackMaps.remove(rCCommandMessage);
        } else {
            this.mTimeOutMaps.put(rCCommandMessage, Long.valueOf(System.currentTimeMillis() + 3000));
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void addIAutelRCLongTimeCallbackWith(String str, RCCommandMessage rCCommandMessage, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith) {
        this.longtimeCallbackMaps.put(str, new RCLongTimeCallbackBody(rCCommandMessage, iAutelRCLongTimeCallbackWith));
        getRemoteControllerSocket().sendMessage(rCCommandMessage);
    }

    /* access modifiers changed from: protected */
    public synchronized void removeIAutelRCLongTimeCallbackWith(String str) {
        this.longtimeCallbackMaps.remove(str);
    }

    /* access modifiers changed from: private */
    public synchronized void callbackRecData(RCCommandMessage rCCommandMessage) {
        if (!rCCommandMessage.isLongTimeUploadMsg()) {
            for (Map.Entry<RCCommandMessage, AutelCompletionCallback.ICompletionCallbackWith> key : this.shorttimeCallbackMaps.entrySet()) {
                RCCommandMessage rCCommandMessage2 = (RCCommandMessage) key.getKey();
                if (rCCommandMessage2.getMsgId() == rCCommandMessage.getMsgId()) {
                    RCRespondMsgParser.getInstance().parseRemoteCommandMessage(rCCommandMessage);
                    this.shorttimeCallbackMaps.get(rCCommandMessage2).onResult(RCRespondMsgParser.getInstance());
                    this.shorttimeCallbackMaps.remove(rCCommandMessage2);
                    this.mTimeOutMaps.remove(rCCommandMessage2);
                }
            }
        } else if (!this.longtimeCallbackMaps.isEmpty()) {
            for (RCLongTimeCallbackBody next : this.longtimeCallbackMaps.values()) {
                if (next.mMessage.getMsgId() == rCCommandMessage.getMsgId()) {
                    RCRespondMsgParser.getInstance().parseRemoteCommandMessage(rCCommandMessage);
                    next.iAutelRCLongTimeCallbackWith.onReceiveMsg(RCRespondMsgParser.getInstance());
                }
            }
        }
    }

    private void startCheckTimeOutThread() {
        this.isCheckOutTimeThreadRunning = true;
        if (this.checkOutTimeThreadPool == null) {
            this.checkOutTimeThreadPool = Executors.newSingleThreadExecutor();
        }
        this.checkOutTimeThreadPool.execute(new checkOutTimeRunnable());
    }

    private void stopCheckTimeOutThread() {
        this.isCheckOutTimeThreadRunning = false;
        this.mTimeOutMaps.clear();
    }

    private class checkOutTimeRunnable implements Runnable {
        private checkOutTimeRunnable() {
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (RemoteControllerManager.this.isCheckOutTimeThreadRunning) {
                try {
                    RemoteControllerManager.this.checkTimeOutMain();
                    if (RemoteControllerManager.this.isCheckOutTimeThreadRunning) {
                        Thread.sleep(500);
                    } else {
                        return;
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void checkTimeOutMain() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<RCCommandMessage, Long> key : this.mTimeOutMaps.entrySet()) {
            RCCommandMessage rCCommandMessage = (RCCommandMessage) key.getKey();
            if (!(this.mTimeOutMaps.get(rCCommandMessage) == null || currentTimeMillis <= this.mTimeOutMaps.get(rCCommandMessage).longValue() || this.shorttimeCallbackMaps.get(rCCommandMessage) == null)) {
                Message message = new Message();
                message.what = 0;
                message.obj = rCCommandMessage;
                this.handler.sendMessage(message);
            }
        }
    }

    class RCLongTimeCallbackBody {
        public IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith;
        public RCCommandMessage mMessage;

        public RCLongTimeCallbackBody(RCCommandMessage rCCommandMessage, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith2) {
            this.mMessage = rCCommandMessage;
            this.iAutelRCLongTimeCallbackWith = iAutelRCLongTimeCallbackWith2;
        }
    }
}
