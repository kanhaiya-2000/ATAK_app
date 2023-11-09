package com.autel.internal.sdk.camera.flir;

public class FLIRRecordSetting {
    private IRFileFormat fileFormat;
    private FLIRVideoRecordMode recordVideoMode;

    public IRFileFormat getFileFormat() {
        return this.fileFormat;
    }

    public void setFileFormat(IRFileFormat iRFileFormat) {
        this.fileFormat = iRFileFormat;
    }

    public FLIRVideoRecordMode getRecordVideoMode() {
        return this.recordVideoMode;
    }

    public void setRecordVideoMode(FLIRVideoRecordMode fLIRVideoRecordMode) {
        this.recordVideoMode = fLIRVideoRecordMode;
    }

    public String toString() {
        return "IRFileFormat = " + this.fileFormat + " FLIRVideoRecordMode = " + this.recordVideoMode;
    }
}
