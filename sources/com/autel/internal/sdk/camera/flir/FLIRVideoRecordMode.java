package com.autel.internal.sdk.camera.flir;

public enum FLIRVideoRecordMode {
    IR("IR"),
    VISIBLE("Visible"),
    IR_AND_VISIBLE("IR+Visible"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private FLIRVideoRecordMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FLIRVideoRecordMode find(String str) {
        FLIRVideoRecordMode fLIRVideoRecordMode = IR;
        if (fLIRVideoRecordMode.getValue().equals(str)) {
            return fLIRVideoRecordMode;
        }
        FLIRVideoRecordMode fLIRVideoRecordMode2 = VISIBLE;
        if (fLIRVideoRecordMode2.getValue().equals(str)) {
            return fLIRVideoRecordMode2;
        }
        FLIRVideoRecordMode fLIRVideoRecordMode3 = IR_AND_VISIBLE;
        if (fLIRVideoRecordMode3.getValue().equals(str)) {
            return fLIRVideoRecordMode3;
        }
        return UNKNOWN;
    }
}
