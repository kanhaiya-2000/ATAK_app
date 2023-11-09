package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoBurstCount {
    BURST_3("3 photos once", "3"),
    BURST_5("5 photos once", "5"),
    BURST_7("7 photos once", "7"),
    BURST_10("10 photos once", "10"),
    BURST_14("14 photos once", "14"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value;
    private final String value20;

    private PhotoBurstCount(String str, String str2) {
        this.value = str;
        this.value20 = str2;
    }

    public String value() {
        return this.value;
    }

    public String value20() {
        return this.value20;
    }

    public static PhotoBurstCount find(String str) {
        PhotoBurstCount photoBurstCount = BURST_3;
        if (!photoBurstCount.value().equals(str) && !photoBurstCount.value20().equals(str)) {
            photoBurstCount = BURST_5;
            if (!photoBurstCount.value().equals(str) && !photoBurstCount.value20().equals(str)) {
                photoBurstCount = BURST_7;
                if (!photoBurstCount.value().equals(str) && !photoBurstCount.value20().equals(str)) {
                    photoBurstCount = BURST_10;
                    if (!photoBurstCount.value().equals(str) && !photoBurstCount.value20().equals(str)) {
                        photoBurstCount = BURST_14;
                        if (!photoBurstCount.value().equals(str) && !photoBurstCount.value20().equals(str)) {
                            return UNKNOWN;
                        }
                    }
                }
            }
        }
        return photoBurstCount;
    }
}
