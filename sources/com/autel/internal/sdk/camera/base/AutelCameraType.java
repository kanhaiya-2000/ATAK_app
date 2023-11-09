package com.autel.internal.sdk.camera.base;

public enum AutelCameraType {
    CURRENT_MODE(AutelCameraStatusInternal.KEY_CURR_MODE),
    CAMERA_CLOCK(AutelCameraSettingInternal.KEY_CAMERA_CLOCK),
    LOCATION_METER("location_meter"),
    AE_LOCK("ae_lock"),
    EXPOSURE_VALUE("p_exposure"),
    ISO(AutelCameraSettingInternal.KEY_P_ISO),
    SHUTTER(AutelCameraSettingInternal.KEY_P_SHUTTER),
    SUBTITLE_SWITCH(AutelCameraSettingInternal.KEY_SUBTITLE_SWITCH),
    DIGITAL_NOISE_REDUCE_3D("s_mctf"),
    HISTOGRAM(AutelCameraSettingInternal.KEY_S_HISTO),
    TIMELAPSE_NUMBER(AutelCameraSettingInternal.KEY_TIMELAPSE_MODE),
    AEB_NUMBER(AutelCameraSettingInternal.KEY_P_AEBNUM),
    BURST_NUMBER(AutelCameraSettingInternal.KEY_BURST_MODE),
    GEAR_MODE(AutelCameraSettingInternal.KEY_CAPTURE_MODE),
    ZOOM_FACTOR(AutelCameraSettingInternal.KEY_S_ZOOMFACTOR),
    RESET("D:");
    
    private final String value;

    private AutelCameraType(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static AutelCameraType find(String str) {
        AutelCameraType autelCameraType = CURRENT_MODE;
        if (autelCameraType.value().equals(str)) {
            return autelCameraType;
        }
        AutelCameraType autelCameraType2 = CAMERA_CLOCK;
        if (autelCameraType2.value().equals(str)) {
            return autelCameraType2;
        }
        AutelCameraType autelCameraType3 = LOCATION_METER;
        if (autelCameraType3.value().equals(str)) {
            return autelCameraType3;
        }
        AutelCameraType autelCameraType4 = AE_LOCK;
        if (autelCameraType4.value().equals(str)) {
            return autelCameraType4;
        }
        AutelCameraType autelCameraType5 = EXPOSURE_VALUE;
        if (autelCameraType5.value().equals(str)) {
            return autelCameraType5;
        }
        AutelCameraType autelCameraType6 = ISO;
        if (autelCameraType6.value().equals(str)) {
            return autelCameraType6;
        }
        AutelCameraType autelCameraType7 = SHUTTER;
        if (autelCameraType7.value().equals(str)) {
            return autelCameraType7;
        }
        AutelCameraType autelCameraType8 = SUBTITLE_SWITCH;
        if (autelCameraType8.value().equals(str)) {
            return autelCameraType8;
        }
        AutelCameraType autelCameraType9 = DIGITAL_NOISE_REDUCE_3D;
        if (autelCameraType9.value().equals(str)) {
            return autelCameraType9;
        }
        AutelCameraType autelCameraType10 = HISTOGRAM;
        if (autelCameraType10.value().equals(str)) {
            return autelCameraType10;
        }
        AutelCameraType autelCameraType11 = TIMELAPSE_NUMBER;
        if (autelCameraType11.value().equals(str)) {
            return autelCameraType11;
        }
        AutelCameraType autelCameraType12 = AEB_NUMBER;
        if (autelCameraType12.value().equals(str)) {
            return autelCameraType12;
        }
        AutelCameraType autelCameraType13 = BURST_NUMBER;
        if (autelCameraType13.value().equals(str)) {
            return autelCameraType13;
        }
        AutelCameraType autelCameraType14 = GEAR_MODE;
        if (autelCameraType14.value().equals(str)) {
            return autelCameraType14;
        }
        AutelCameraType autelCameraType15 = ZOOM_FACTOR;
        if (autelCameraType15.value().equals(str)) {
            return autelCameraType15;
        }
        AutelCameraType autelCameraType16 = RESET;
        if (autelCameraType16.value().equals(str)) {
            return autelCameraType16;
        }
        return null;
    }
}
