package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum AutoExposureLockState {
    LOCK("LOCK"),
    UNLOCK("UNLOCK"),
    DISABLE("DISABLE"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private AutoExposureLockState(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static AutoExposureLockState find(String str) {
        AutoExposureLockState autoExposureLockState = LOCK;
        if (autoExposureLockState.value().equals(str)) {
            return autoExposureLockState;
        }
        AutoExposureLockState autoExposureLockState2 = UNLOCK;
        if (autoExposureLockState2.value().equals(str)) {
            return autoExposureLockState2;
        }
        AutoExposureLockState autoExposureLockState3 = DISABLE;
        if (autoExposureLockState3.value().equals(str)) {
            return autoExposureLockState3;
        }
        return UNKNOWN;
    }
}
