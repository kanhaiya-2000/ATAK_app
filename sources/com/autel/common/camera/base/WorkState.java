package com.autel.common.camera.base;

import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum WorkState {
    IDLE(CameraConstant10.IDLE, CameraConstant20.IDLE),
    CAPTURE(CameraConstant10.CAPTURE, CameraConstant20.TAKING_PHOTO),
    RECORD(CameraConstant10.RECORD, CameraConstant20.RECORDING),
    RECORD_PHOTO_TAKING("record_taking", "Recording_taking"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private String value10;
    private String value20;

    private WorkState(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String getValue10() {
        return this.value10;
    }

    public String getValue20() {
        return this.value20;
    }

    public static WorkState find(String str) {
        WorkState workState = IDLE;
        if (!workState.getValue10().equals(str) && !workState.getValue20().equals(str)) {
            workState = CAPTURE;
            if (!workState.getValue10().equals(str) && !workState.getValue20().equals(str)) {
                workState = RECORD;
                if (!workState.getValue10().equals(str) && !workState.getValue20().equals(str)) {
                    workState = RECORD_PHOTO_TAKING;
                    if (!workState.getValue10().equals(str) && !workState.getValue20().equals(str)) {
                        return UNKNOWN;
                    }
                }
            }
        }
        return workState;
    }
}
