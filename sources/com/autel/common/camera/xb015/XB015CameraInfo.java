package com.autel.common.camera.xb015;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;

public interface XB015CameraInfo {
    long getCurrentRecordTime();

    ExposureCompensation getExposureCompensation();

    CameraISO getISO();

    int getPhotoSumCanTake();

    ShutterSpeed getShutterSpeed();

    int getTemperature();

    long getTotalTimeCanRecord();

    int getZoomScale();
}
