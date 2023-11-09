package com.autel.common.camera.base;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ISOMode {
    AUTO("Auto"),
    MANUAL("Manual"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private ISOMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static ISOMode find(String str) {
        ISOMode iSOMode = AUTO;
        if (iSOMode.value().equals(str)) {
            return iSOMode;
        }
        ISOMode iSOMode2 = MANUAL;
        if (iSOMode2.value().equals(str)) {
            return iSOMode2;
        }
        return UNKNOWN;
    }
}
