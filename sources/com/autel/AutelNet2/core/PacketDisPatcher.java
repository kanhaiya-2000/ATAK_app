package com.autel.AutelNet2.core;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.autel.AutelNet2.aircraft.visual.tracking.message.UploadGoalAreaPacket;
import com.autel.AutelNet2.core.interfaces.IReceiveMessageListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import com.autel.util.log.AutelLog;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class PacketDisPatcher {
    private static final String TAG = "PacketDisPatcher";
    private static String TRACKING_PATH = (AutelDirPathUtils.getAppDir() + "/TrackTest");
    private static PacketDisPatcher mInstance;
    private final int MAX_THREAD = 5;
    private IConnectionListener cameraListener;
    private boolean isAircraftConnect = false;
    private boolean isUpgrading = false;
    private volatile long lastCameraMsgTime = 0;
    private volatile long lastMsgTime = 0;
    private com.autel.AutelNet2.core.interfaces.IConnectionListener listener;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final ConcurrentHashMap<Short, ConcurrentHashMap<String, IReceiveMessageListener>> mReceiveListeners = new ConcurrentHashMap<>();

    private void initHandler() {
        if (this.mHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("connection 2.0 message parser Thread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    PacketDisPatcher.this.process((BaseMsgPacket) message.obj);
                }
            };
        }
    }

    public void setUpgrading(boolean z) {
        this.isUpgrading = z;
    }

    public boolean isUpgrading() {
        return this.isUpgrading;
    }

    public boolean isAircraftConnect() {
        return this.isAircraftConnect;
    }

    public void setAircraftConnect(boolean z) {
        this.isAircraftConnect = z;
    }

    public static synchronized PacketDisPatcher getInstance() {
        PacketDisPatcher packetDisPatcher;
        synchronized (PacketDisPatcher.class) {
            if (mInstance == null) {
                mInstance = new PacketDisPatcher();
            }
            packetDisPatcher = mInstance;
        }
        return packetDisPatcher;
    }

    private PacketDisPatcher() {
    }

    public void setHeartBeatListener(com.autel.AutelNet2.core.interfaces.IConnectionListener iConnectionListener) {
        this.listener = iConnectionListener;
    }

    public void setCameraHeartBeatListener(IConnectionListener iConnectionListener) {
        this.cameraListener = iConnectionListener;
    }

    public void registerReceiveListener(String str, short s, IReceiveMessageListener iReceiveMessageListener) {
        ConcurrentHashMap concurrentHashMap = this.mReceiveListeners.get(Short.valueOf(s));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
        }
        if (!concurrentHashMap.containsKey(str)) {
            concurrentHashMap.put(str, iReceiveMessageListener);
            this.mReceiveListeners.put(Short.valueOf(s), concurrentHashMap);
        }
    }

    public void unRegisterReceiveListener(String str, short s) {
        ConcurrentHashMap concurrentHashMap = this.mReceiveListeners.get(Short.valueOf(s));
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
            if (concurrentHashMap.isEmpty()) {
                this.mReceiveListeners.remove(Short.valueOf(s));
            }
        }
    }

    public void onDisPatchPacket(BaseMsgPacket baseMsgPacket) {
        if (this.mHandler == null) {
            initHandler();
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(0, baseMsgPacket));
    }

    private void dispatchPacket(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket == null || baseMsgPacket.getHead() == null) {
            AutelLog.m15082d(TAG, "dispatchPacket return");
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.mReceiveListeners.get(Short.valueOf(baseMsgPacket.getHead().msg_type));
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                IReceiveMessageListener iReceiveMessageListener = (IReceiveMessageListener) concurrentHashMap.get(str);
                if (iReceiveMessageListener != null) {
                    iReceiveMessageListener.onReceiveMessage(baseMsgPacket);
                }
            }
        }
    }

    public void clearTimer() {
        this.lastMsgTime = 0;
        this.lastCameraMsgTime = 0;
    }

    /* access modifiers changed from: private */
    public void process(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket == null) {
            AutelLog.m15084e(TAG, "receive msg process return: ");
        } else if (this.lastMsgTime == 0 || System.currentTimeMillis() - this.lastMsgTime < ConnectionType.DEFAULT_UDP_PING_PERIOD || this.isUpgrading || this.listener == null) {
            if (!(this.lastCameraMsgTime == 0 || System.currentTimeMillis() - this.lastCameraMsgTime <= 6000 || this.cameraListener == null)) {
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "receive camera heart msg timeout:");
                this.cameraListener.onConnectStatus(ConnectConnectStatus.DISCONNECT);
                this.lastCameraMsgTime = 0;
            }
            if (baseMsgPacket.getHead().msg_type != 55) {
                AutelLog.m15090w("fyh", "receive msg: " + baseMsgPacket.toString());
            }
            if (baseMsgPacket.getHead().msg_type == 256 || baseMsgPacket.getHead().msg_type == 320) {
                this.lastMsgTime = System.currentTimeMillis();
                if (this.listener != null) {
                    setAircraftConnect(true);
                    this.listener.onConnected();
                }
            }
            if (baseMsgPacket.getHead().msg_type == 25) {
                this.lastCameraMsgTime = System.currentTimeMillis();
            }
            try {
                BaseMsgPacket parseBody = baseMsgPacket.parseBody();
                if (parseBody != null) {
                    if (parseBody.getHead().msg_type == 1547) {
                        TrackingDispatch.instance().onDispatch((UploadGoalAreaPacket) parseBody);
                        if (isDebug()) {
                            AutelLog.debug_i("Tracking_Test", "receiver trackArea-> " + parseBody.getBodyString());
                            return;
                        }
                        return;
                    }
                    dispatchPacket(parseBody);
                }
            } catch (Exception e) {
                e.printStackTrace();
                AutelLog.debug_i(TAG, "msgType:" + baseMsgPacket.getType() + " parser Exception:" + e.getMessage() + " ");
            }
        } else {
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "receive Fmu heart msg timeout:");
            setAircraftConnect(false);
            this.listener.onConnectError("TimeOut");
            this.lastMsgTime = 0;
        }
    }

    public boolean isDebug() {
        return new File(TRACKING_PATH).exists();
    }

    public void destroy() {
        if (this.mHandlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            this.mHandlerThread = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }
}
