package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoStyleType {
    Standard("Standard"),
    Soft("Soft"),
    Landscape("Landscape"),
    Custom("Custom"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private PhotoStyleType(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static PhotoStyleType find(String str) {
        PhotoStyleType photoStyleType = Standard;
        if (photoStyleType.value().equals(str)) {
            return photoStyleType;
        }
        PhotoStyleType photoStyleType2 = Soft;
        if (photoStyleType2.value().equals(str)) {
            return photoStyleType2;
        }
        PhotoStyleType photoStyleType3 = Landscape;
        if (photoStyleType3.value().equals(str)) {
            return photoStyleType3;
        }
        if (str != null) {
            PhotoStyleType photoStyleType4 = Custom;
            if (str.startsWith(photoStyleType4.value())) {
                return photoStyleType4;
            }
        }
        return UNKNOWN;
    }
}
