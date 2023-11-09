package com.autel.internal.sdk.camera.xb015;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.xb015.XB015CameraInfo;

public class Xb015CameraInfoImpl implements XB015CameraInfo {
    public ExposureCompensation exposureCompensation = ExposureCompensation.UNKNOWN;
    public CameraISO iso = CameraISO.UNKNOWN;
    public ShutterSpeed shutterSpeed = ShutterSpeed.UNKNOWN;
    public int temperature;

    public long getCurrentRecordTime() {
        return 0;
    }

    public int getPhotoSumCanTake() {
        return 0;
    }

    public long getTotalTimeCanRecord() {
        return 0;
    }

    public int getZoomScale() {
        return 0;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public ExposureCompensation getExposureCompensation() {
        return this.exposureCompensation;
    }

    public CameraISO getISO() {
        return this.iso;
    }

    public ShutterSpeed getShutterSpeed() {
        return this.shutterSpeed;
    }

    public String toString() {
        return "exposureCompensation : " + this.exposureCompensation + "; iso : " + this.iso + "; shutterSpeed = " + this.shutterSpeed + "; temperature : " + this.temperature;
    }
}
