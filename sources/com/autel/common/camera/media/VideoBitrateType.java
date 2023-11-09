package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoBitrateType {
    VBR("VBR"),
    CBR("CBR"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    String value;

    private VideoBitrateType(String str) {
        this.value = str;
    }

    public static VideoBitrateType find(String str) {
        VideoBitrateType videoBitrateType = VBR;
        if (videoBitrateType.value.equals(str)) {
            return videoBitrateType;
        }
        VideoBitrateType videoBitrateType2 = CBR;
        if (videoBitrateType2.value.equals(str)) {
            return videoBitrateType2;
        }
        return UNKNOWN;
    }
}
