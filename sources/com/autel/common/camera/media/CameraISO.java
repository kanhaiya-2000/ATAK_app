package com.autel.common.camera.media;

import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum CameraISO {
    ISO_100(UIPreferenceFragment.DEFAULT_UI_SCALE),
    ISO_200("200"),
    ISO_400("400"),
    ISO_800("800"),
    ISO_1600("1600"),
    ISO_3200("3200"),
    ISO_6400("6400"),
    ISO_12800("12800"),
    ISO_25600("25600"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private String value;

    private CameraISO(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static CameraISO find(String str) {
        CameraISO cameraISO = ISO_100;
        if (cameraISO.getValue().equals(str)) {
            return cameraISO;
        }
        CameraISO cameraISO2 = ISO_200;
        if (cameraISO2.getValue().equals(str)) {
            return cameraISO2;
        }
        CameraISO cameraISO3 = ISO_400;
        if (cameraISO3.getValue().equals(str)) {
            return cameraISO3;
        }
        CameraISO cameraISO4 = ISO_800;
        if (cameraISO4.getValue().equals(str)) {
            return cameraISO4;
        }
        CameraISO cameraISO5 = ISO_1600;
        if (cameraISO5.getValue().equals(str)) {
            return cameraISO5;
        }
        CameraISO cameraISO6 = ISO_3200;
        if (cameraISO6.getValue().equals(str)) {
            return cameraISO6;
        }
        CameraISO cameraISO7 = ISO_6400;
        if (cameraISO7.getValue().equals(str)) {
            return cameraISO7;
        }
        CameraISO cameraISO8 = ISO_12800;
        if (cameraISO8.getValue().equals(str)) {
            return cameraISO8;
        }
        CameraISO cameraISO9 = ISO_25600;
        if (cameraISO9.getValue().equals(str)) {
            return cameraISO9;
        }
        return UNKNOWN;
    }
}
