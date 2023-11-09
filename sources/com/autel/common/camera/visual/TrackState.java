package com.autel.common.camera.visual;

import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum TrackState {
    TRACKING("Tracking"),
    IDLE(CameraConstant20.IDLE),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private String value;

    private TrackState(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static TrackState find(String str) {
        TrackState trackState = TRACKING;
        if (trackState.equals(str)) {
            return trackState;
        }
        TrackState trackState2 = IDLE;
        if (trackState2.equals(str)) {
            return trackState2;
        }
        return UNKNOWN;
    }
}
