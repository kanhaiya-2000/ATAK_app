package com.autel.AutelNet2.aircraft.flycontroller;

import android.text.TextUtils;
import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.interfaces.IHeartBeatListener;
import com.autel.AutelNet2.aircraft.flycontroller.message.HeartbeatPacket;
import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.interfaces.IConnectionListener;
import com.autel.AutelNet2.core.interfaces.IReceiveMessageListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.log.AutelLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AircraftHeatBeatManager2 implements IConnectionListener, IReceiveMessageListener {
    private static final short REGISTER_MESSAGE_TYPE = 256;
    private static final short REGISTER_MESSAGE_TYPE_EVO_2 = 320;
    private static final String TAG = "HeatBeatManager2";
    public static CalibrateCompassStatus compassStatus = CalibrateCompassStatus.NORMAL;
    private static AircraftHeatBeatManager2 instance_;
    public static boolean isStepThird;
    private final int ERROR_TIMEOUT = 200;
    private final int MSG_NORMAL = 201;
    private HeartBeatInfo heartBeatInfo = new HeartBeatInfo();
    private final ConcurrentHashMap<String, CallbackWithOneParam> mARMWarningListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public volatile HeartBeatStatus mAutelHeartBeatStatus = HeartBeatStatus.UNKNOWN;
    private final ConcurrentHashMap<String, CallbackWithOneParam> mCalibrateCompassListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam> mFCStatusListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, IHeartBeatListener> mHeartBeatListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam> mLedPilotLampListeners = new ConcurrentHashMap<>();

    public void startConnect() {
    }

    public HeartBeatInfo getHeartBeatInfo() {
        return this.heartBeatInfo;
    }

    public static synchronized AircraftHeatBeatManager2 getInstance() {
        AircraftHeatBeatManager2 aircraftHeatBeatManager2;
        synchronized (AircraftHeatBeatManager2.class) {
            if (instance_ == null) {
                instance_ = new AircraftHeatBeatManager2();
            }
            aircraftHeatBeatManager2 = instance_;
        }
        return aircraftHeatBeatManager2;
    }

    private AircraftHeatBeatManager2() {
        init();
    }

    private void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 256, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 320, this);
        ConnectionManager2.getInstance_().registerConnectListener(TAG, this);
        PacketDisPatcher.getInstance().setHeartBeatListener(new IConnectionListener() {
            public void onDisconnected() {
            }

            public void startConnect() {
            }

            public void onConnected() {
                Log.d(AircraftHeatBeatManager2.TAG, "onConnected : ");
                HeartBeatStatus unused = AircraftHeatBeatManager2.this.mAutelHeartBeatStatus = HeartBeatStatus.NORMAL;
            }

            public void onConnectError(String str) {
                HeartBeatStatus unused = AircraftHeatBeatManager2.this.mAutelHeartBeatStatus = HeartBeatStatus.ERROR;
                Log.d(AircraftHeatBeatManager2.TAG, "mHeartBeatListeners 111onConnectError : " + AircraftHeatBeatManager2.this.mAutelHeartBeatStatus);
                AircraftHeatBeatManager2.this.notifyConnect(HeartBeatStatus.ERROR, (HeartBeatInfo) null);
            }
        });
    }

    public void destroy() {
        Log.d(TAG, "destory-----------");
        this.mARMWarningListeners.clear();
        this.mCalibrateCompassListeners.clear();
        this.mFCStatusListeners.clear();
        this.mLedPilotLampListeners.clear();
    }

    public void addIAutelHeartBeatListener(String str, IHeartBeatListener iHeartBeatListener) {
        if (str != null && iHeartBeatListener != null) {
            Log.d(TAG, "addIAutelHeartBeatListener  " + str);
            this.mHeartBeatListeners.put(str, iHeartBeatListener);
        }
    }

    public void removeIAutelHeartBeatListener(String str) {
        if (str != null) {
            this.mHeartBeatListeners.remove(str);
        }
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        HeartBeatInfo heartBeatInfo2 = ((HeartbeatPacket) baseMsgPacket).getHeartBeatInfo();
        this.mAutelHeartBeatStatus = (this.mAutelHeartBeatStatus == HeartBeatStatus.NORMAL || this.mAutelHeartBeatStatus == HeartBeatStatus.FIRST) ? HeartBeatStatus.NORMAL : HeartBeatStatus.FIRST;
        this.heartBeatInfo = heartBeatInfo2;
        notifyConnect(this.mAutelHeartBeatStatus, heartBeatInfo2);
        if (heartBeatInfo2 == null) {
            AutelLog.m15082d(TAG, "info is null " + baseMsgPacket.toString());
            return;
        }
        if (!this.mARMWarningListeners.isEmpty()) {
            iteratorCallback(this.mARMWarningListeners, heartBeatInfo2.getArmErrorCode());
        }
        if (!this.mLedPilotLampListeners.isEmpty()) {
            iteratorCallback(this.mLedPilotLampListeners, heartBeatInfo2.getLedPilotLampStatus());
        }
        if (!this.mCalibrateCompassListeners.isEmpty()) {
            iteratorCallback(this.mCalibrateCompassListeners, heartBeatInfo2.getCompassStatus());
        }
        if (!this.mFCStatusListeners.isEmpty()) {
            iteratorCallback(this.mFCStatusListeners, heartBeatInfo2);
        }
    }

    /* access modifiers changed from: protected */
    public void iteratorCallback(ConcurrentHashMap<String, CallbackWithOneParam> concurrentHashMap, final Object obj) {
        for (Map.Entry<String, CallbackWithOneParam> key : concurrentHashMap.entrySet()) {
            final CallbackWithOneParam callbackWithOneParam = concurrentHashMap.get((String) key.getKey());
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null && callbackWithOneParam.getClass() != null) {
                        callbackWithOneParam.onSuccess(obj);
                    }
                }
            });
        }
    }

    public void onConnected() {
        Log.d(TAG, "onConnected ");
        this.mAutelHeartBeatStatus = HeartBeatStatus.NORMAL;
    }

    public void onDisconnected() {
        this.mAutelHeartBeatStatus = HeartBeatStatus.ERROR;
        Log.d("BaseUdpConnection", "mHeartBeatListeners onDisconnected : " + this.mAutelHeartBeatStatus);
        notifyConnect(HeartBeatStatus.ERROR, (HeartBeatInfo) null);
    }

    public void onConnectError(String str) {
        this.mAutelHeartBeatStatus = HeartBeatStatus.ERROR;
        Log.d("BaseUdpConnection", "mHeartBeatListeners onConnectError : " + this.mAutelHeartBeatStatus);
        notifyConnect(HeartBeatStatus.ERROR, (HeartBeatInfo) null);
    }

    /* access modifiers changed from: private */
    public void notifyConnect(HeartBeatStatus heartBeatStatus, HeartBeatInfo heartBeatInfo2) {
        for (IHeartBeatListener next : this.mHeartBeatListeners.values()) {
            if (heartBeatInfo2 != null) {
                next.onHeartBeatStatus(heartBeatStatus, heartBeatInfo2);
            } else if (heartBeatStatus != HeartBeatStatus.NORMAL) {
                next.onHeartBeatStatus(heartBeatStatus, new HeartBeatInfo());
            }
        }
    }

    public void addLedLampListener(String str, CallbackWithOneParam<LedPilotLamp> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mLedPilotLampListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeLedLampListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mLedPilotLampListeners.remove(str);
        }
    }

    public void addCalibrateCompassListener(String str, CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mCalibrateCompassListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeCalibrateCompassListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mCalibrateCompassListeners.remove(str);
        }
    }

    public void addArmWarningListener(String str, CallbackWithOneParam<ARMWarning> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mARMWarningListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeArmWarningListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mARMWarningListeners.remove(str);
        }
    }

    public void addFlyControllerStatusListener(String str, CallbackWithOneParam<FlyControllerStatus> callbackWithOneParam) {
        if (str != null && callbackWithOneParam != null) {
            this.mFCStatusListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeFlyControllerStatusListener(String str) {
        if (str != null) {
            this.mFCStatusListeners.remove(str);
        }
    }
}
