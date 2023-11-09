package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoFormat {
    MOV("MOV"),
    MP4("MP4"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private VideoFormat(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static VideoFormat find(String str) {
        VideoFormat videoFormat = MOV;
        if (videoFormat.value().equals(str)) {
            return videoFormat;
        }
        VideoFormat videoFormat2 = MP4;
        if (videoFormat2.value().equals(str)) {
            return videoFormat2;
        }
        return UNKNOWN;
    }
}
