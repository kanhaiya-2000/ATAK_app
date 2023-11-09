package com.autel.common.remotecontroller;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum CustomKey {
    KEY_A("A"),
    KEY_B("B"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private String value;

    private CustomKey(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static CustomKey find(String str) {
        CustomKey customKey = KEY_A;
        if (customKey.getValue().equals(str)) {
            return customKey;
        }
        CustomKey customKey2 = KEY_B;
        if (customKey2.getValue().equals(str)) {
            return customKey2;
        }
        return UNKNOWN;
    }
}
