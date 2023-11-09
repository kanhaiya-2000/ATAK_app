package com.autel.internal.sdk.camera.r12;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.r12.R12CameraInfo;

public class R12CameraInfoImpl implements R12CameraInfo {
    public ExposureCompensation exposureCompensation = ExposureCompensation.UNKNOWN;
    public CameraISO iso = CameraISO.UNKNOWN;
    public ShutterSpeed shutterSpeed = ShutterSpeed.UNKNOWN;

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
        return "exposureCompensation : " + this.exposureCompensation + "; iso : " + this.iso + "; shutterSpeed = " + this.shutterSpeed;
    }
}
