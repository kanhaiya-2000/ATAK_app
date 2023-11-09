package com.autel.internal.sdk.flycontroller;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ARMWarning01 {
    MAGNETOMETER_ERROR(1, "Compass error warning , motors can't run"),
    GPS_ERROR(2, "GPS error， motors cannot run"),
    BATTERY_UNKNOWN(4, "Unknown battery error"),
    BATTER_ERROR(8, " Low voltage battery error, motors can't be armed"),
    COMPASS_ADJUSTING(16, "Compass calibration warning, motors can't be armed"),
    BEGINNER_NO_GPS(32, "No GPS in Novice Mode, motors cannot run"),
    UPGRADE(64, "During the firmware upgrading，cannot fire motors"),
    IOC(128, "The aircraft is in IOC mode, motors can't be armed."),
    NORMAL(0, "normal"),
    UNKNOWN(-1, SoloControllerUnits.UNKNOWN);
    
    private String description;
    private int value;

    private ARMWarning01(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static ARMWarning01 find(int i) {
        ARMWarning01 aRMWarning01 = MAGNETOMETER_ERROR;
        if (aRMWarning01.getValue() == i) {
            return aRMWarning01;
        }
        ARMWarning01 aRMWarning012 = GPS_ERROR;
        if (aRMWarning012.getValue() == i) {
            return aRMWarning012;
        }
        ARMWarning01 aRMWarning013 = BATTERY_UNKNOWN;
        if (aRMWarning013.getValue() == i) {
            return aRMWarning013;
        }
        ARMWarning01 aRMWarning014 = BATTER_ERROR;
        if (aRMWarning014.getValue() == i) {
            return aRMWarning014;
        }
        ARMWarning01 aRMWarning015 = COMPASS_ADJUSTING;
        if (aRMWarning015.getValue() == i) {
            return aRMWarning015;
        }
        ARMWarning01 aRMWarning016 = BEGINNER_NO_GPS;
        if (aRMWarning016.getValue() == i) {
            return aRMWarning016;
        }
        ARMWarning01 aRMWarning017 = UPGRADE;
        if (aRMWarning017.getValue() == i) {
            return aRMWarning017;
        }
        ARMWarning01 aRMWarning018 = IOC;
        if (aRMWarning018.getValue() == i) {
            return aRMWarning018;
        }
        ARMWarning01 aRMWarning019 = NORMAL;
        if (aRMWarning019.getValue() == i) {
            return aRMWarning019;
        }
        return UNKNOWN;
    }
}
