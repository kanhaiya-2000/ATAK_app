package com.autel.internal;

import java.util.HashMap;
import java.util.Map;

public class AutelListenerManager {
    public static final String AFCenterListener = "setAFCenterListener";
    public static final String BatteryRealTimeDataListener = "BatteryRealTimeDataListener";
    public static final String BreakPointMissionListener = "BreakPointMissionListener";
    public static final String CalibrateCompassListener = "CalibrateCompassListener";
    public static final String CameraAutoFocusListener = "CameraAutoFocusListener";
    public static final String CameraConnectStateListener = "CameraConnectStateListener";
    public static final String CameraHistogramListener = "CameraHistogramListener";
    public static final String CameraMediaInfoListener = "CameraMediaInfoListener";
    public static final String CameraSDCardStateListener = "CameraSDCardStateListener";
    public static final String CameraUploadGoalAreaListener = "CameraUploadGoalAreaListener";
    public static final String CodecStateListener = "CodecStateListener";
    public static final String DspInfoListener = "DspInfoListener";
    public static final String DspSynMsgBroadcastListener = "setSynMsgBroadcastListener";
    public static final String FCUltraSonicHeightInfoListener = "FCUltraSonicHeightInfoListener";
    public static final String FlashMemoryCardStateListener = "FlashMemoryCardStateListener";
    public static final String FlyControllerHeartBeatListener = "FlyControllerHeartBeatListener";
    public static final String FlyControllerInfoListener = "FlyControllerInfoListener";
    public static final String FlyControllerParameterChangedListener = "FlyControllerParameterChangedListener";
    public static final String FlyControllerWarningListener = "FlyControllerWarningListener";
    public static final String GimbalAngleListener = "GimbalAngleListener";
    public static final String GimbalStateListener = "GimbalStateListener";
    public static final String InitControllerConnectStateListener = "InitControllerConnectStateListener";
    public static final String InitFlyControllerHeartBeatListener = "InitFlyControllerHeartBeatListener";
    public static final String MediaModeListener = "MediaModeListener";
    public static final String MediaStateListener = "MediaStateListener";
    public static final String MissionStateBreakPointInfoListener = "MissionStateBreakPointInfoListener";
    public static final String MissionStateRealTimeInfoListener = "MissionStateRealTimeInfoListener";
    public static final String MotionDelayShotListener = "setMotionDelayShotListener";
    public static final String PhotoExposureListener = "setPhotoExposureListener";
    public static final String RCControlMenuListener = "RCControlMenuListener";
    public static final String RCInfoDataListener = "RCInfoDataListener";
    public static final String RadarInfoListener = "setAvoidanceRadarInfoListener";
    public static final String RemoteButtonControllerListener = "RemoteButtonControllerListener";
    public static final String RemoteControllerConnectStateListener = "RemoteControllerConnectStateListener";
    public static final String RtkGGAListener = "setRtkGGAListener";
    public static final String RtkInfoListener = "setRtkInfoListener";
    public static final String SettingChangedListener = "setSettingChangedListener";
    public static final String TemperatureWarningListener = "setTemperatureWarningListener";
    public static final String VisualHeartListener = "setVisualHeartListener";
    public static final String VisualSettingInfoListener = "setVisualSettingInfoListener";
    public static final String VisualViewpoingListener = "setVisualViewpoingListener";
    public static final String VisualWarnListener = "setVisualWarnListener";
    private Map<String, Object> listeners = new HashMap();

    public Object get(String str) {
        return this.listeners.get(str);
    }

    public void put(String str, Object obj) {
        this.listeners.put(str, obj);
    }

    public void clear() {
        this.listeners.clear();
    }
}
