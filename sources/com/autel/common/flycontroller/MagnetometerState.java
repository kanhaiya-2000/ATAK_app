package com.autel.common.flycontroller;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum MagnetometerState {
    INTERFERENCE_ATTI(-1, "Magnetic interference error, the aircraft is not able to keep the correct course (In ATTITUDE mode)"),
    CORRECT(0, "No magnetic interference, the aircraft still keeps the correct course (If GPS signal is in good condition, the aircraft can fly in GPS mode)"),
    INTERFERENCE_CAN_KEEP_RIGHT_DIRECTION(1, "Experience magnetic interference, but the aircraft still keeps the correct course"),
    INTERFERENCE_WARN_FIRST(2, "Experiencing continuous magnetic interference error, the aircraft is going to be unable to keep the correct course.(First leftTime warning. If GPS has enough satellites, the aircraft can fly in GPS mode)"),
    INTERFERENCE_WARN_SECOND(3, "Experiencing continuous magnetic interference error, the aircraft is going to be unable to keep the correct course (Second leftTime warning)"),
    UNKNOWN(-2, SoloControllerUnits.UNKNOWN);
    
    private String description;
    private int value;

    private MagnetometerState(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static MagnetometerState find(int i) {
        MagnetometerState magnetometerState = INTERFERENCE_ATTI;
        if (magnetometerState.getValue() == i) {
            return magnetometerState;
        }
        MagnetometerState magnetometerState2 = CORRECT;
        if (magnetometerState2.getValue() == i) {
            return magnetometerState2;
        }
        MagnetometerState magnetometerState3 = INTERFERENCE_CAN_KEEP_RIGHT_DIRECTION;
        if (magnetometerState3.getValue() == i) {
            return magnetometerState3;
        }
        MagnetometerState magnetometerState4 = INTERFERENCE_WARN_FIRST;
        if (magnetometerState4.getValue() == i) {
            return magnetometerState4;
        }
        MagnetometerState magnetometerState5 = INTERFERENCE_WARN_SECOND;
        if (magnetometerState5.getValue() == i) {
            return magnetometerState5;
        }
        return UNKNOWN;
    }
}
