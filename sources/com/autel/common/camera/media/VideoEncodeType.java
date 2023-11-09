package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoEncodeType {
    BASELINE("BaseLine"),
    MAIN("Main"),
    HIGH("High"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    String value;

    private VideoEncodeType(String str) {
        this.value = str;
    }

    public static VideoEncodeType find(String str) {
        VideoEncodeType videoEncodeType = BASELINE;
        if (videoEncodeType.value.equals(str)) {
            return videoEncodeType;
        }
        VideoEncodeType videoEncodeType2 = MAIN;
        if (videoEncodeType2.value.equals(str)) {
            return videoEncodeType2;
        }
        VideoEncodeType videoEncodeType3 = HIGH;
        if (videoEncodeType3.value.equals(str)) {
            return videoEncodeType3;
        }
        return UNKNOWN;
    }
}
