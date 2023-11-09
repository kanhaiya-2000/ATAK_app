package com.autel.common.camera.base;

import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum HDRStatus {
    Disable(CameraParamsConfig.param_Disable),
    Enable(CameraParamsConfig.param_Enable),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private HDRStatus(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static HDRStatus find(String str) {
        HDRStatus hDRStatus = Disable;
        if (hDRStatus.value().equals(str)) {
            return hDRStatus;
        }
        HDRStatus hDRStatus2 = Enable;
        if (hDRStatus2.value().equals(str)) {
            return hDRStatus2;
        }
        return UNKNOWN;
    }
}
