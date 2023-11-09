package com.autel.common.camera.base;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum MediaMode {
    SINGLE("singal", "Single"),
    VIDEO("video", "Record"),
    TIMELAPSE("timelapse", "Timelapse"),
    BURST("burst", "Burst"),
    AEB("aeb", "AEB"),
    HDR("hdr", "HDR"),
    MFNR("mfnr", "MFNR"),
    MOTION_DELAY_SHOT("MotionDelayShot", "MotionDelayShot"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, "");
    
    private String value10;
    private String value20;

    private MediaMode(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String getValue10() {
        return this.value10;
    }

    public String getValue20() {
        return this.value20;
    }

    public static MediaMode find(String str) {
        MediaMode mediaMode = SINGLE;
        if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
            mediaMode = VIDEO;
            if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                mediaMode = TIMELAPSE;
                if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                    mediaMode = BURST;
                    if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                        mediaMode = AEB;
                        if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                            mediaMode = HDR;
                            if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                                mediaMode = MFNR;
                                if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                                    mediaMode = MOTION_DELAY_SHOT;
                                    if (!mediaMode.getValue10().equals(str) && !mediaMode.getValue20().equals(str)) {
                                        return UNKNOWN;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return mediaMode;
    }
}
