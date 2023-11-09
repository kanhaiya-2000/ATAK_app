package com.autel.internal.sdk.camera.flir;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum FLIRSkyCondition {
    CLEAR("Clear"),
    SCATTERED("Scattered"),
    CLOUDY("Cloudy"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private String value;

    private FLIRSkyCondition(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FLIRSkyCondition find(String str) {
        FLIRSkyCondition fLIRSkyCondition = CLEAR;
        if (fLIRSkyCondition.getValue().equals(str)) {
            return fLIRSkyCondition;
        }
        FLIRSkyCondition fLIRSkyCondition2 = SCATTERED;
        if (fLIRSkyCondition2.getValue().equals(str)) {
            return fLIRSkyCondition2;
        }
        FLIRSkyCondition fLIRSkyCondition3 = CLOUDY;
        if (fLIRSkyCondition3.getValue().equals(str)) {
            return fLIRSkyCondition3;
        }
        return UNKNOWN;
    }
}
