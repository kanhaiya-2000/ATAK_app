package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoTimelapseInterval {
    SECOND_2("2sec", "2"),
    SECOND_5("5sec", "5"),
    SECOND_7("7sec", "7"),
    SECOND_10("10sec", "10"),
    SECOND_20("20sec", "20"),
    SECOND_30("30sec", "30"),
    SECOND_60("60sec", "60"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value;
    private final String value20;

    private PhotoTimelapseInterval(String str, String str2) {
        this.value = str;
        this.value20 = str2;
    }

    public String value() {
        return this.value;
    }

    public String value20() {
        return this.value20;
    }

    public static PhotoTimelapseInterval find(String str) {
        PhotoTimelapseInterval photoTimelapseInterval = SECOND_2;
        if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
            photoTimelapseInterval = SECOND_5;
            if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                photoTimelapseInterval = SECOND_7;
                if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                    photoTimelapseInterval = SECOND_10;
                    if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                        photoTimelapseInterval = SECOND_20;
                        if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                            photoTimelapseInterval = SECOND_30;
                            if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                                photoTimelapseInterval = SECOND_60;
                                if (!photoTimelapseInterval.value().equals(str) && !photoTimelapseInterval.value20().equals(str)) {
                                    return UNKNOWN;
                                }
                            }
                        }
                    }
                }
            }
        }
        return photoTimelapseInterval;
    }
}
