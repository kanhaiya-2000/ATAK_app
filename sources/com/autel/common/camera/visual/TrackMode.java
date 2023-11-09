package com.autel.common.camera.visual;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum TrackMode {
    ENTER_TRACK("EnterTrack", "TrackEntered"),
    EXIT_TRACK("ExitTrack", "TrackExited"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, "null");
    
    private String value;
    private String value1;

    private TrackMode(String str, String str2) {
        this.value = str;
        this.value1 = str2;
    }

    public String getValue() {
        return this.value;
    }

    public static TrackMode find(String str) {
        TrackMode trackMode = ENTER_TRACK;
        if (!trackMode.value.equals(str) && !trackMode.value1.equals(str)) {
            trackMode = EXIT_TRACK;
            if (!trackMode.value.equals(str) && !trackMode.value1.equals(str)) {
                return UNKNOWN;
            }
        }
        return trackMode;
    }
}
