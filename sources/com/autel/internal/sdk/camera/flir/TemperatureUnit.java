package com.autel.internal.sdk.camera.flir;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum TemperatureUnit {
    CELCIUS("Celcius"),
    FAHRENHEIT("Fahrenheit"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private String value;

    private TemperatureUnit(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static TemperatureUnit find(String str) {
        TemperatureUnit temperatureUnit = CELCIUS;
        if (temperatureUnit.getValue().equals(str)) {
            return temperatureUnit;
        }
        TemperatureUnit temperatureUnit2 = FAHRENHEIT;
        if (temperatureUnit2.getValue().equals(str)) {
            return temperatureUnit2;
        }
        return UNKNOWN;
    }
}
