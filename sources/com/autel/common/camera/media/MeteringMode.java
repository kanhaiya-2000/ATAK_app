package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum MeteringMode {
    AVERAGE("Average"),
    SPOT("Spot"),
    CENTER("Center"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private MeteringMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static MeteringMode find(String str) {
        MeteringMode meteringMode = AVERAGE;
        if (meteringMode.value().equals(str)) {
            return meteringMode;
        }
        MeteringMode meteringMode2 = SPOT;
        if (meteringMode2.value().equals(str)) {
            return meteringMode2;
        }
        MeteringMode meteringMode3 = CENTER;
        if (meteringMode3.value().equals(str)) {
            return meteringMode3;
        }
        return UNKNOWN;
    }
}
