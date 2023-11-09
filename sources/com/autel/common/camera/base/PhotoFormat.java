package com.autel.common.camera.base;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoFormat {
    RAW("DNG"),
    RawAndJPEG("JPG+DNG"),
    JPEG("JPG"),
    JpgAndTiff("JPG+TIFF"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private PhotoFormat(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static PhotoFormat find(String str) {
        PhotoFormat photoFormat = RAW;
        if (photoFormat.value().equals(str)) {
            return photoFormat;
        }
        PhotoFormat photoFormat2 = RawAndJPEG;
        if (photoFormat2.value().equals(str)) {
            return photoFormat2;
        }
        PhotoFormat photoFormat3 = JPEG;
        if (photoFormat3.value().equals(str)) {
            return photoFormat3;
        }
        PhotoFormat photoFormat4 = JpgAndTiff;
        if (photoFormat4.value().equals(str)) {
            return photoFormat4;
        }
        return UNKNOWN;
    }
}
