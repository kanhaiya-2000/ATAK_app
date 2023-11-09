package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum LensFocusStatus {
    FUZZY("Fuzzy"),
    CLEAR("Clear"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private LensFocusStatus(String str) {
        this.value = str;
    }

    public static LensFocusStatus find(String str) {
        LensFocusStatus lensFocusStatus = FUZZY;
        if (lensFocusStatus.getValue().equals(str)) {
            return lensFocusStatus;
        }
        LensFocusStatus lensFocusStatus2 = CLEAR;
        if (lensFocusStatus2.getValue().equals(str)) {
            return lensFocusStatus2;
        }
        return UNKNOWN;
    }

    public String getValue() {
        return this.value;
    }
}
