package com.autel.internal.sdk.camera.flir;

public class FLIRPhotoSetting {
    private int duration;
    private FLIRPhotoFormat format;
    private int interval;

    public FLIRPhotoFormat getFormat() {
        return this.format;
    }

    public void setFormat(FLIRPhotoFormat fLIRPhotoFormat) {
        this.format = fLIRPhotoFormat;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String toString() {
        return "FLIRPhotoFormat : " + this.format + ", interval : " + this.interval + ", duration : " + this.duration;
    }
}
