package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum LensFocusMode {
    AUTO_FOCUS("AF"),
    AUTO_FOCUS_CONTINUOUS("AF_C"),
    MANUAL_FOCUS("MF"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private LensFocusMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static LensFocusMode find(String str) {
        LensFocusMode lensFocusMode = AUTO_FOCUS;
        if (lensFocusMode.value().equals(str)) {
            return lensFocusMode;
        }
        LensFocusMode lensFocusMode2 = AUTO_FOCUS_CONTINUOUS;
        if (lensFocusMode2.value().equals(str)) {
            return lensFocusMode2;
        }
        LensFocusMode lensFocusMode3 = MANUAL_FOCUS;
        if (lensFocusMode3.value().equals(str)) {
            return lensFocusMode3;
        }
        return UNKNOWN;
    }
}
