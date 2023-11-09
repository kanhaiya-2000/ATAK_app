package com.autel.common.camera.base;

public enum MediaStatus {
    SINGLE_START(""),
    BURST_START(""),
    TIME_LAPSE_START(""),
    AUTO_EXPOSURE_BURST_START(""),
    HDR_START(""),
    MFNR_START(""),
    BURST_STOP(""),
    TIME_LAPSE_STOP(""),
    AUTO_EXPOSURE_BURST_STOP(""),
    PHOTO_TAKEN_DONE("PHOTO_TAKEN_DONE"),
    PHOTO_CAT("PHOTO_CAT"),
    PHOTO_SAVE("PHOTO_SAVE"),
    RECORD_START(""),
    RECORD_STOP("Success"),
    RECORD_FAILED_WRITE_ERROR("WriteError"),
    RECORD_FAILED_SDCARD_REMOVED("SdCardRemove"),
    RECOVER_START(""),
    RECOVER_COMPLETE(""),
    RECOVER_FAILED(""),
    RECORD_BUFFER_FULL("NoMoreBuffer"),
    UPDATING(""),
    UPDATE_START(""),
    UPDATE_COMPLETE(""),
    UPDATE_FAILED(""),
    SHUTDOWN(""),
    RESET_SUCCESS(""),
    RESET_FAILED(""),
    UNKNOWN("");
    
    private final String value;

    private MediaStatus(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }
}
