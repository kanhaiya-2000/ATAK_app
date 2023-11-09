package com.autel.common.camera.XT706;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum IrTemperatureWarningStatus {
    HIGH("Hot"),
    LOW("Cold"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private IrTemperatureWarningStatus(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static IrTemperatureWarningStatus find(String str) {
        IrTemperatureWarningStatus irTemperatureWarningStatus = HIGH;
        if (irTemperatureWarningStatus.value().equals(str)) {
            return irTemperatureWarningStatus;
        }
        IrTemperatureWarningStatus irTemperatureWarningStatus2 = LOW;
        if (irTemperatureWarningStatus2.value().equals(str)) {
            return irTemperatureWarningStatus2;
        }
        return UNKNOWN;
    }
}
