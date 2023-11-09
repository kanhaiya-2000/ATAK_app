package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ExposureMode {
    Auto("Auto", "Auto"),
    Manual("M", "Manual"),
    ShutterPriority("ShutterPriority", "ShutterPriority"),
    AperturePriority("aperturePriority", "AperturePriority"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value10;
    private final String value20;

    private ExposureMode(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String value10() {
        return this.value10;
    }

    public String value20() {
        return this.value20;
    }

    public static ExposureMode find(String str) {
        ExposureMode exposureMode = Manual;
        if (!exposureMode.value10().equals(str) && !exposureMode.value20().equals(str)) {
            exposureMode = AperturePriority;
            if (!exposureMode.value10().equals(str) && !exposureMode.value20().equals(str)) {
                exposureMode = ShutterPriority;
                if (!exposureMode.value10().equals(str) && !exposureMode.value20().equals(str)) {
                    exposureMode = Auto;
                    if (!exposureMode.value10().equals(str) && !exposureMode.value20().equals(str)) {
                        return UNKNOWN;
                    }
                }
            }
        }
        return exposureMode;
    }
}
