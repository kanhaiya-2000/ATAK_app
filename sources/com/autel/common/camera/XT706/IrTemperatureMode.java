package com.autel.common.camera.XT706;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum IrTemperatureMode {
    NONE("TempNone"),
    CENTER("TempCenter"),
    HOT("TempHot"),
    COLD("TempCold"),
    TOUCH("TempTouch"),
    REGION("TempRegion"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private IrTemperatureMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static IrTemperatureMode find(String str) {
        IrTemperatureMode irTemperatureMode = NONE;
        if (irTemperatureMode.value().equals(str)) {
            return irTemperatureMode;
        }
        IrTemperatureMode irTemperatureMode2 = CENTER;
        if (irTemperatureMode2.value().equals(str)) {
            return irTemperatureMode2;
        }
        IrTemperatureMode irTemperatureMode3 = HOT;
        if (irTemperatureMode3.value().equals(str)) {
            return irTemperatureMode3;
        }
        IrTemperatureMode irTemperatureMode4 = COLD;
        if (irTemperatureMode4.value().equals(str)) {
            return irTemperatureMode4;
        }
        IrTemperatureMode irTemperatureMode5 = TOUCH;
        if (irTemperatureMode5.value().equals(str)) {
            return irTemperatureMode5;
        }
        IrTemperatureMode irTemperatureMode6 = REGION;
        if (irTemperatureMode6.value().equals(str)) {
            return irTemperatureMode6;
        }
        return UNKNOWN;
    }
}
