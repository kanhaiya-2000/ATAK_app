package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoAEBCount {
    CAPTURE_3("3 photos once", "3"),
    CAPTURE_5("5 photos once", "5"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value;
    private final String value20;

    private PhotoAEBCount(String str, String str2) {
        this.value = str;
        this.value20 = str2;
    }

    public String value() {
        return this.value;
    }

    public String value20() {
        return this.value20;
    }

    public static PhotoAEBCount find(String str) {
        PhotoAEBCount photoAEBCount = CAPTURE_3;
        if (!photoAEBCount.value().equals(str) && !photoAEBCount.value20().equals(str)) {
            photoAEBCount = CAPTURE_5;
            if (!photoAEBCount.value().equals(str) && !photoAEBCount.value20().equals(str)) {
                return UNKNOWN;
            }
        }
        return photoAEBCount;
    }
}
