package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoStandard {
    NTSC("NTSC"),
    PAL("PAL"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private VideoStandard(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static VideoStandard find(String str) {
        VideoStandard videoStandard = PAL;
        if (videoStandard.value().equals(str)) {
            return videoStandard;
        }
        VideoStandard videoStandard2 = NTSC;
        if (videoStandard2.value().equals(str)) {
        }
        return videoStandard2;
    }
}
