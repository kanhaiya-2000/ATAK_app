package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum WhiteBalanceType {
    FLUOROMETER("Fluor", "Neon"),
    INCANDESCENT("Incan", "Incandescent"),
    AUTO("Auto", "Auto"),
    SUNNY("Sunny", "Sunny"),
    CLOUDY("Cloudy", "Cloudy"),
    CUSTOM("Custom", "Custom"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value10;
    private final String value20;

    private WhiteBalanceType(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String value10() {
        return this.value10;
    }

    public String value20() {
        return this.value20;
    }

    public static WhiteBalanceType find(String str) {
        WhiteBalanceType whiteBalanceType = FLUOROMETER;
        if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
            whiteBalanceType = INCANDESCENT;
            if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
                whiteBalanceType = AUTO;
                if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
                    whiteBalanceType = SUNNY;
                    if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
                        whiteBalanceType = CLOUDY;
                        if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
                            whiteBalanceType = CUSTOM;
                            if (!whiteBalanceType.value10().equals(str) && !whiteBalanceType.value20().equals(str)) {
                                return UNKNOWN;
                            }
                        }
                    }
                }
            }
        }
        return whiteBalanceType;
    }
}
