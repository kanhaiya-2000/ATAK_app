package com.autel.camera.protocol.protocol10.enums;

import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;

public enum AutelCameraType {
    CAMERA_TYPE_MODE(AutelCameraStatusInternal.KEY_CURR_MODE),
    CAMERA_TYPE_CAMERA_CLOCK(AutelCameraSettingInternal.KEY_CAMERA_CLOCK),
    CAMERA_TYPE_LOCATION_METER("location_meter"),
    CAMERA_TYPE_AE_LOCK("ae_lock"),
    CAMERA_TYPE_EV("p_exposure"),
    CAMERA_TYPE_ISO(AutelCameraSettingInternal.KEY_P_ISO),
    CAMERA_TYPE_SHUTTER(AutelCameraSettingInternal.KEY_P_SHUTTER),
    CAMERA_TYPE_SUBTITLE_SWITCH(AutelCameraSettingInternal.KEY_SUBTITLE_SWITCH),
    CAMERA_TYPE_S_MCTF("s_mctf"),
    CAMERA_TYPE_S_HISTO(AutelCameraSettingInternal.KEY_S_HISTO),
    CAMERA_TYPE_TIMELAPSE_NUM(AutelCameraSettingInternal.KEY_TIMELAPSE_MODE),
    CAMERA_TYPE_P_AEBNUM(AutelCameraSettingInternal.KEY_P_AEBNUM),
    CAMERA_TYPE_BURST_NUM(AutelCameraSettingInternal.KEY_BURST_MODE),
    CAMERA_TYPE_CAPTURE_MODE(AutelCameraSettingInternal.KEY_CAPTURE_MODE),
    CAMERA_TYPE_ZOOMFACTOR(AutelCameraSettingInternal.KEY_S_ZOOMFACTOR),
    CAMERA_TYPE_D("D:");
    
    private final String value;

    private AutelCameraType(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static AutelCameraType find(String str) {
        AutelCameraType autelCameraType = CAMERA_TYPE_MODE;
        if (autelCameraType.value().equals(str)) {
            return autelCameraType;
        }
        AutelCameraType autelCameraType2 = CAMERA_TYPE_CAMERA_CLOCK;
        if (autelCameraType2.value().equals(str)) {
            return autelCameraType2;
        }
        AutelCameraType autelCameraType3 = CAMERA_TYPE_LOCATION_METER;
        if (autelCameraType3.value().equals(str)) {
            return autelCameraType3;
        }
        AutelCameraType autelCameraType4 = CAMERA_TYPE_AE_LOCK;
        if (autelCameraType4.value().equals(str)) {
            return autelCameraType4;
        }
        AutelCameraType autelCameraType5 = CAMERA_TYPE_EV;
        if (autelCameraType5.value().equals(str)) {
            return autelCameraType5;
        }
        AutelCameraType autelCameraType6 = CAMERA_TYPE_ISO;
        if (autelCameraType6.value().equals(str)) {
            return autelCameraType6;
        }
        AutelCameraType autelCameraType7 = CAMERA_TYPE_SHUTTER;
        if (autelCameraType7.value().equals(str)) {
            return autelCameraType7;
        }
        AutelCameraType autelCameraType8 = CAMERA_TYPE_SUBTITLE_SWITCH;
        if (autelCameraType8.value().equals(str)) {
            return autelCameraType8;
        }
        AutelCameraType autelCameraType9 = CAMERA_TYPE_S_MCTF;
        if (autelCameraType9.value().equals(str)) {
            return autelCameraType9;
        }
        AutelCameraType autelCameraType10 = CAMERA_TYPE_S_HISTO;
        if (autelCameraType10.value().equals(str)) {
            return autelCameraType10;
        }
        AutelCameraType autelCameraType11 = CAMERA_TYPE_TIMELAPSE_NUM;
        if (autelCameraType11.value().equals(str)) {
            return autelCameraType11;
        }
        AutelCameraType autelCameraType12 = CAMERA_TYPE_P_AEBNUM;
        if (autelCameraType12.value().equals(str)) {
            return autelCameraType12;
        }
        AutelCameraType autelCameraType13 = CAMERA_TYPE_BURST_NUM;
        if (autelCameraType13.value().equals(str)) {
            return autelCameraType13;
        }
        AutelCameraType autelCameraType14 = CAMERA_TYPE_CAPTURE_MODE;
        if (autelCameraType14.value().equals(str)) {
            return autelCameraType14;
        }
        AutelCameraType autelCameraType15 = CAMERA_TYPE_ZOOMFACTOR;
        if (autelCameraType15.value().equals(str)) {
            return autelCameraType15;
        }
        AutelCameraType autelCameraType16 = CAMERA_TYPE_D;
        if (autelCameraType16.value().equals(str)) {
            return autelCameraType16;
        }
        return null;
    }
}
