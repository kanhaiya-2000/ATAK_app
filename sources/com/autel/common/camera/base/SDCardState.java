package com.autel.common.camera.base;

import com.autel.common.error.AutelError;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum SDCardState {
    CARD_READY("CARD_READY", "Ready", (String) null),
    NO_CARD("NO_CARD", "NoCard", AutelError.CAMERA_SDCARD_STATE_NO_CARD),
    CARD_ERROR("CARD_ERROR", "Error", AutelError.CAMERA_SDCARD_STATE_CARD_ERROR),
    CARD_FULL("CARD_FULL", "Full", AutelError.CAMERA_SDCARD_STATE_CARD_FULL),
    CARD_NOT_SUPPORT("CARD_NOT_SUPPORT", "CARD_NOT_SUPPORT", AutelError.CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT),
    UNKNOWN_FILE_SYSTEM_FAT("UNKNOWN_FS_FAT", "UnknownFileSystem", AutelError.CAMERA_SDCARD_STATE_UNKNOWN_FS_FAT),
    CARD_PROTECT("CARD_PROTECT", "Protected", AutelError.CAMERA_SDCARD_STATE_CARD_PROTECT),
    LOW_SPEED_CARD("LOW_SPEED_CARD", "LowSpeed", (String) null),
    LOW_SPEED_CARD_STOP_RECORD("LowSpeedStopRecord", "LowSpeedStopRecord", (String) null),
    FORMATTING("Formatting", "Formatting", (String) null),
    FORMAT_FAIL("FormatFail", "FormatFail", (String) null),
    FORMAT_SUCCESS("FormatSuccess", "FormatSuccess", (String) null),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, AutelError.COMMAND_FAILED);
    
    private AutelError error;
    private String value04;
    private String value08;

    private SDCardState(String str, String str2, AutelError autelError) {
        this.value04 = str;
        this.value08 = str2;
        this.error = autelError;
    }

    public String getValue04() {
        return this.value04;
    }

    public String getValue08() {
        return this.value08;
    }

    public AutelError getError() {
        return this.error;
    }

    public static SDCardState find(String str) {
        SDCardState sDCardState = CARD_READY;
        if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
            sDCardState = NO_CARD;
            if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                sDCardState = CARD_ERROR;
                if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                    sDCardState = CARD_FULL;
                    if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                        sDCardState = UNKNOWN_FILE_SYSTEM_FAT;
                        if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                            sDCardState = CARD_PROTECT;
                            if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                sDCardState = LOW_SPEED_CARD;
                                if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                    sDCardState = LOW_SPEED_CARD_STOP_RECORD;
                                    if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                        sDCardState = FORMATTING;
                                        if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                            sDCardState = FORMAT_FAIL;
                                            if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                                sDCardState = FORMAT_SUCCESS;
                                                if (!sDCardState.getValue04().equals(str) && !sDCardState.getValue08().equals(str)) {
                                                    return UNKNOWN;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sDCardState;
    }
}
