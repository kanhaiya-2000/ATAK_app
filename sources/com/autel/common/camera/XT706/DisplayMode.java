package com.autel.common.camera.XT706;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum DisplayMode {
    VISIBLE("Visible"),
    PICTURE_IN_PICTURE("PictureInPicture"),
    IR("IR"),
    OVERLAP("Overlap"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private DisplayMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static DisplayMode find(String str) {
        DisplayMode displayMode = VISIBLE;
        if (displayMode.value().equals(str)) {
            return displayMode;
        }
        DisplayMode displayMode2 = PICTURE_IN_PICTURE;
        if (displayMode2.value().equals(str)) {
            return displayMode2;
        }
        DisplayMode displayMode3 = IR;
        if (displayMode3.value().equals(str)) {
            return displayMode3;
        }
        DisplayMode displayMode4 = OVERLAP;
        if (displayMode4.value().equals(str)) {
            return displayMode4;
        }
        return UNKNOWN;
    }
}
