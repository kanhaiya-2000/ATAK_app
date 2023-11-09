package com.autel.common.flycontroller;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum FlyLimitAreaWarning {
    NORMAL(0, "normal"),
    AIRPORT_VICINITY(1, "The aircraft is flying near the airport"),
    AIRPORT_HEIGHT_RESTRICTED_AREAS(2, "The aircraft is flying in the height restricted area"),
    AIRPORT_HEIGHT_RESTRICT_MAXHEIGHT(3, "The aircraft reached the max altitude of height restricted area"),
    AIRPORT_NO_FLY_ZONES(4, "The aircraft is flying in the no fly zone"),
    AIRPORT_NO_FLY_ZONES_CAUTIOUS(5, "The aircraft is cautious flying in the no fly zone"),
    UNKNOWN(-1, SoloControllerUnits.UNKNOWN);
    
    private String description;
    private int value;

    private FlyLimitAreaWarning(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static FlyLimitAreaWarning find(int i) {
        FlyLimitAreaWarning flyLimitAreaWarning = AIRPORT_VICINITY;
        if (flyLimitAreaWarning.getValue() == i) {
            return flyLimitAreaWarning;
        }
        FlyLimitAreaWarning flyLimitAreaWarning2 = AIRPORT_HEIGHT_RESTRICTED_AREAS;
        if (flyLimitAreaWarning2.getValue() == i) {
            return flyLimitAreaWarning2;
        }
        FlyLimitAreaWarning flyLimitAreaWarning3 = AIRPORT_HEIGHT_RESTRICT_MAXHEIGHT;
        if (flyLimitAreaWarning3.getValue() == i) {
            return flyLimitAreaWarning3;
        }
        FlyLimitAreaWarning flyLimitAreaWarning4 = AIRPORT_NO_FLY_ZONES;
        if (flyLimitAreaWarning4.getValue() == i) {
            return flyLimitAreaWarning4;
        }
        FlyLimitAreaWarning flyLimitAreaWarning5 = NORMAL;
        if (flyLimitAreaWarning5.getValue() == i) {
            return flyLimitAreaWarning5;
        }
        FlyLimitAreaWarning flyLimitAreaWarning6 = AIRPORT_NO_FLY_ZONES_CAUTIOUS;
        if (flyLimitAreaWarning6.getValue() == i) {
            return flyLimitAreaWarning6;
        }
        return UNKNOWN;
    }
}
