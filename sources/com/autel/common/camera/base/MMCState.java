package com.autel.common.camera.base;

import com.autel.common.error.AutelError;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum MMCState {
    CARD_READY("Ready", (int) null),
    CARD_ERROR("Error", AutelError.CAMERA_SDCARD_STATE_CARD_ERROR),
    CARD_FULL("Full", AutelError.CAMERA_SDCARD_STATE_CARD_FULL),
    UNKNOWN_FILE_SYSTEM_FAT("UnknownFileSystem", AutelError.CAMERA_SDCARD_STATE_UNKNOWN_FS_FAT),
    LOOP_RECORD_LACK_OF_SPACE("LOOP_RECORD_LACK_OF_SPACE", AutelError.CAMERA_SDCARD_STATE_CARD_PROTECT),
    UNKNOWN(SoloControllerUnits.UNKNOWN, AutelError.COMMAND_FAILED);
    
    private AutelError error;
    private String value;

    private MMCState(String str, AutelError autelError) {
        this.value = str;
        this.error = autelError;
    }

    public String getValue() {
        return this.value;
    }

    public AutelError getError() {
        return this.error;
    }

    public static MMCState find(String str) {
        MMCState mMCState = CARD_READY;
        if (mMCState.getValue().equals(str)) {
            return mMCState;
        }
        MMCState mMCState2 = CARD_ERROR;
        if (mMCState2.getValue().equals(str)) {
            return mMCState2;
        }
        MMCState mMCState3 = CARD_FULL;
        if (mMCState3.getValue().equals(str)) {
            return mMCState3;
        }
        MMCState mMCState4 = UNKNOWN_FILE_SYSTEM_FAT;
        if (mMCState4.getValue().equals(str)) {
            return mMCState4;
        }
        MMCState mMCState5 = LOOP_RECORD_LACK_OF_SPACE;
        if (mMCState5.getValue().equals(str)) {
            return mMCState5;
        }
        return UNKNOWN;
    }
}
