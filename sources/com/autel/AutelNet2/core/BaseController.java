package com.autel.AutelNet2.core;

import android.util.Log;
import atakplugin.UASTool.C0827sg;
import com.autel.AutelNet2.core.interfaces.IControllerInterface;
import com.autel.AutelNet2.core.interfaces.IReceiveMessageListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseController<T> extends AbstractHandlerController implements IControllerInterface, IReceiveMessageListener {
    private int RCV_TIME_OUT = C0827sg.f6324a;
    /* access modifiers changed from: private */
    public boolean isCheckOutTimeThreadRunning = false;
    protected final ConcurrentHashMap<Integer, CallbackWithOneParam> mListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    protected ConcurrentHashMap<T, Long> mTimeOutMaps = new ConcurrentHashMap<>();
    private final HashMap<Integer, List<PacketListenerBinding>> waitingPacketList = new HashMap<>();

    public void connect() {
    }

    public void disconnect() {
    }

    /* access modifiers changed from: protected */
    public abstract T getTimeOutItem(BaseMsgPacket baseMsgPacket);

    public void destroy() {
        stopCheckTimeOutThread();
        this.mListeners.clear();
        synchronized (this.waitingPacketList) {
            this.waitingPacketList.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void setTimeOutTime(int i) {
        this.RCV_TIME_OUT = i * 1000;
    }

    /* access modifiers changed from: protected */
    public int getTimeOutTime() {
        return this.RCV_TIME_OUT;
    }

    private boolean registerMessageListener(BaseMsgPacket baseMsgPacket, CallbackWithOneParam callbackWithOneParam) {
        synchronized (this.waitingPacketList) {
            if (this.mListeners.containsKey(Integer.valueOf(baseMsgPacket.getType()))) {
                List list = this.waitingPacketList.get(Integer.valueOf(baseMsgPacket.getType()));
                if (list == null) {
                    list = new ArrayList();
                    this.waitingPacketList.put(Integer.valueOf(baseMsgPacket.getType()), list);
                }
                list.add(new PacketListenerBinding(baseMsgPacket, callbackWithOneParam));
                return false;
            }
            this.mListeners.put(Integer.valueOf(baseMsgPacket.getType()), callbackWithOneParam);
            return true;
        }
    }

    public void unRegisterMessageListener(int i) {
        synchronized (this.waitingPacketList) {
            this.mListeners.remove(Integer.valueOf(i));
            this.mTimeOutMaps.remove(Integer.valueOf(i));
            List list = this.waitingPacketList.get(Integer.valueOf(i));
            if (list != null && list.size() > 0) {
                PacketListenerBinding packetListenerBinding = (PacketListenerBinding) list.remove(0);
                this.mListeners.put(Integer.valueOf(packetListenerBinding.mMsgPacket.getType()), packetListenerBinding.mCallbackWithOneParam);
                if (ConnectionManager2.getInstance_().sendPacket(packetListenerBinding.mMsgPacket)) {
                    startCheckTimeOutThread();
                    addTimeOutCheckList(getTimeOutItem(packetListenerBinding.mMsgPacket));
                } else {
                    this.mListeners.remove(Integer.valueOf(packetListenerBinding.mMsgPacket.getType()));
                    if (packetListenerBinding.mCallbackWithOneParam != null) {
                        packetListenerBinding.mCallbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendPacket(BaseMsgPacket baseMsgPacket, CallbackWithOneParam callbackWithOneParam) {
        sendPacket(baseMsgPacket, callbackWithOneParam, false);
    }

    static class PacketListenerBinding {
        public CallbackWithOneParam mCallbackWithOneParam;
        public BaseMsgPacket mMsgPacket;

        public PacketListenerBinding() {
        }

        public PacketListenerBinding(BaseMsgPacket baseMsgPacket, CallbackWithOneParam callbackWithOneParam) {
            this.mMsgPacket = baseMsgPacket;
            this.mCallbackWithOneParam = callbackWithOneParam;
        }
    }

    /* access modifiers changed from: protected */
    public void sendPacket(BaseMsgPacket baseMsgPacket, CallbackWithOneParam callbackWithOneParam, boolean z) {
        if (baseMsgPacket != null) {
            if (callbackWithOneParam == null) {
                ConnectionManager2.getInstance_().sendPacket(baseMsgPacket);
            } else if (!registerMessageListener(baseMsgPacket, callbackWithOneParam)) {
            } else {
                if (ConnectionManager2.getInstance_().sendPacket(baseMsgPacket)) {
                    startCheckTimeOutThread();
                    addTimeOutCheckList(getTimeOutItem(baseMsgPacket));
                    return;
                }
                unRegisterMessageListener(baseMsgPacket.getType());
                callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED_JOIN_QUEUE);
            }
        }
    }

    private void addTimeOutCheckList(T t) {
        if (t != null) {
            this.mTimeOutMaps.put(t, Long.valueOf(System.currentTimeMillis() + ((long) this.RCV_TIME_OUT)));
            synchronized (this.mLock) {
                this.mLock.notify();
            }
        }
    }

    private void startCheckTimeOutThread() {
        if (!this.isCheckOutTimeThreadRunning) {
            this.isCheckOutTimeThreadRunning = true;
            new Thread(new checkOutTimeRunnable(), "base controller time out check").start();
        }
    }

    private void stopCheckTimeOutThread() {
        this.isCheckOutTimeThreadRunning = false;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        this.mTimeOutMaps.clear();
    }

    private class checkOutTimeRunnable implements Runnable {
        private checkOutTimeRunnable() {
        }

        public void run() {
            while (true) {
                try {
                    if (!BaseController.this.isCheckOutTimeThreadRunning) {
                        break;
                    }
                    synchronized (BaseController.this.mLock) {
                        if (BaseController.this.mTimeOutMaps.isEmpty()) {
                            try {
                                BaseController.this.mLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (!BaseController.this.isCheckOutTimeThreadRunning) {
                        break;
                    }
                    BaseController.this.checkTimeOut();
                    Thread.sleep(500);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    boolean unused = BaseController.this.isCheckOutTimeThreadRunning = false;
                    throw th;
                }
            }
            boolean unused2 = BaseController.this.isCheckOutTimeThreadRunning = false;
        }
    }

    /* access modifiers changed from: protected */
    public void callbackSucc(int i, Object obj) {
        synchronized (this.mListeners) {
            callbackSucc(this.mListeners.get(Integer.valueOf(i)), obj);
            unRegisterMessageListener(i);
        }
    }

    /* access modifiers changed from: protected */
    public void callbackFail(int i, AutelError autelError) {
        synchronized (this.mListeners) {
            callbackFail(this.mListeners.get(Integer.valueOf(i)), autelError);
            unRegisterMessageListener(i);
        }
    }

    /* access modifiers changed from: protected */
    public void callbackSuccOnCurrentThread(int i, Object obj) {
        synchronized (this.mListeners) {
            callbackSucc(this.mListeners.get(Integer.valueOf(i)), obj);
            unRegisterMessageListener(i);
        }
    }

    /* access modifiers changed from: protected */
    public void callbackFailOnCurrentThread(int i, AutelError autelError) {
        synchronized (this.mListeners) {
            callbackFail(this.mListeners.get(Integer.valueOf(i)), autelError);
            unRegisterMessageListener(i);
        }
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<T, Long> key : this.mTimeOutMaps.entrySet()) {
            int intValue = ((Integer) key.getKey()).intValue();
            Long l = this.mTimeOutMaps.get(Integer.valueOf(intValue));
            if (l != null) {
                Log.d("timeout", "key " + intValue);
                if (currentTimeMillis > l.longValue()) {
                    synchronized (this.mListeners) {
                        CallbackWithOneParam callbackWithOneParam = this.mListeners.get(Integer.valueOf(intValue));
                        if (callbackWithOneParam != null) {
                            callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                        }
                        unRegisterMessageListener(intValue);
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
