package com.autel.common.camera.base;

import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;

public enum SettingEvent {
    VideoEncoderConfiguration("VideoEncoderConfiguration"),
    VideoSourceConfigurationOptions("VideoSourceConfigurationOptions"),
    VideoSourceConfiguration("VideoSourceConfiguration"),
    CameraGear("CameraGear"),
    CameraMode("CameraMode"),
    PhotoTakingSettings("PhotoTakingSettings"),
    RecordingSettings("RecordingSettings"),
    LocationMeter("LocationMeter"),
    ImageStyle("ImageStyle"),
    WhiteBalance("WhiteBalance"),
    ImageColor("ImageColor"),
    ImageExposure("ImageExposure"),
    ImageISO("ImageISO"),
    AELock("AELock"),
    ShutterSpeed("ShutterSpeed"),
    HistogramSettings("HistogramSettings"),
    Focus("Focus"),
    IRIS("IRIS"),
    ZoomFactor("ZoomFactor"),
    StorageType(CameraParamsConfig.param_StorageType),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private SettingEvent(String str) {
        this.value = str;
    }
}
