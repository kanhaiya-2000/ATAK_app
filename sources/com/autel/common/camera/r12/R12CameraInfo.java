package com.autel.common.camera.r12;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;

public interface R12CameraInfo {
    ExposureCompensation getExposureCompensation();

    CameraISO getISO();

    ShutterSpeed getShutterSpeed();
}
