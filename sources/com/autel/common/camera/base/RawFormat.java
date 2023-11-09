package com.autel.common.camera.base;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum RawFormat {
    RAW("DNG"),
    JPEG("JPG"),
    NONE("NONE"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private RawFormat(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static RawFormat find(String str) {
        RawFormat rawFormat = RAW;
        if (rawFormat.value().equals(str)) {
            return rawFormat;
        }
        RawFormat rawFormat2 = NONE;
        if (rawFormat2.value().equals(str)) {
            return rawFormat2;
        }
        RawFormat rawFormat3 = JPEG;
        if (rawFormat3.value().equals(str)) {
            return rawFormat3;
        }
        return UNKNOWN;
    }
}
