package com.autel.AutelNet2.aircraft.mission.controller;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.mission.message.MissionStatusPacket;
import com.autel.AutelNet2.aircraft.mission.parser.OrbitMissionInfoParser2;
import com.autel.AutelNet2.aircraft.mission.parser.WaypointMissionInfoParser2;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.mission.xstar.OrbitRealTimeInfo;
import com.autel.common.mission.xstar.WaypointRealTimeInfo;
import com.autel.internal.sdk.mission.AutelMissionStateInternal;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MissionStateManager extends AutelMissionStateInternal {
    public static final int TYPE_ORBIT = 1;
    public static final int TYPE_WAYPOINT = 0;
    private static MissionStateManager mInstance;
    private ConcurrentHashMap<String, CallbackWithOneParam> mOrbitListener = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CallbackWithOneParam> mWaypointListener = new ConcurrentHashMap<>();

    public static synchronized MissionStateManager getInstance() {
        MissionStateManager missionStateManager;
        synchronized (MissionStateManager.class) {
            if (mInstance == null) {
                mInstance = new MissionStateManager();
            }
            missionStateManager = mInstance;
        }
        return missionStateManager;
    }

    private MissionStateManager() {
    }

    public OrbitRealTimeInfo getOrbitInfo() {
        return OrbitMissionInfoParser2.getInstance();
    }

    public WaypointRealTimeInfo getWaypointInfo() {
        return WaypointMissionInfoParser2.getInstance();
    }

    public void parseData(MissionStatusPacket missionStatusPacket) {
        setCurrentMissionState(missionStatusPacket.wp_mode);
        int i = missionStatusPacket.wp_mode;
        if (i == 0) {
            WaypointMissionInfoParser2.getInstance().parseData(missionStatusPacket);
            iteratorCallback(this.mWaypointListener, WaypointMissionInfoParser2.getInstance());
        } else if (i == 1 || i == 2) {
            OrbitMissionInfoParser2.getInstance().parseData(missionStatusPacket);
            iteratorCallback(this.mOrbitListener, OrbitMissionInfoParser2.getInstance());
        }
    }

    public <T> void addRealTimeInfoListener(int i, String str, CallbackWithOneParam<T> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            if (i == 0) {
                this.mWaypointListener.put(str, callbackWithOneParam);
            } else {
                this.mOrbitListener.put(str, callbackWithOneParam);
            }
        }
    }

    public void removeRealTimeInfoListener(int i, String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            if (i == 0) {
                this.mWaypointListener.remove(str);
            } else {
                this.mOrbitListener.remove(str);
            }
        }
    }

    private void iteratorCallback(ConcurrentHashMap<String, CallbackWithOneParam> concurrentHashMap, Object obj) {
        for (Map.Entry<String, CallbackWithOneParam> key : concurrentHashMap.entrySet()) {
            CallbackWithOneParam callbackWithOneParam = concurrentHashMap.get((String) key.getKey());
            if (!(callbackWithOneParam == null || callbackWithOneParam.getClass() == null)) {
                callbackSucc(callbackWithOneParam, obj);
            }
        }
    }

    private void callbackSucc(final CallbackWithOneParam callbackWithOneParam, final Object obj) {
        if (callbackWithOneParam != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    callbackWithOneParam.onSuccess(obj);
                }
            });
        }
    }
}
