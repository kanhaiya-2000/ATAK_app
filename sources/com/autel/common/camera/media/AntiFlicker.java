package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum AntiFlicker {
    AUTO("Auto", "Auto"),
    ANTI_FLICKER_50HZ("50HZ", "50Hz"),
    ANTI_FLICKER_60HZ("60HZ", "60Hz"),
    OFF("OFF", "OFF"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value10;
    private final String value20;

    private AntiFlicker(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String value10() {
        return this.value10;
    }

    public String value20() {
        return this.value20;
    }

    public static AntiFlicker find(String str) {
        AntiFlicker antiFlicker = AUTO;
        if (!antiFlicker.value10().equals(str) && !antiFlicker.value20().equals(str)) {
            antiFlicker = ANTI_FLICKER_50HZ;
            if (!antiFlicker.value10().equals(str) && !antiFlicker.value20().equals(str)) {
                antiFlicker = ANTI_FLICKER_60HZ;
                if (!antiFlicker.value10().equals(str) && !antiFlicker.value20().equals(str)) {
                    antiFlicker = OFF;
                    if (!antiFlicker.value10().equals(str) && !antiFlicker.value20().equals(str)) {
                        return UNKNOWN;
                    }
                }
            }
        }
        return antiFlicker;
    }
}
