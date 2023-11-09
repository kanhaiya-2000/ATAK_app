package com.autel.common.camera.XT705;

import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;

public interface XT705CameraInfo {
    CameraAperture getCameraAperture();

    long getCurrentRecordTime();

    ExposureCompensation getExposureCompensation();

    float getHorizontalFOV();

    CameraISO getISO();

    long getMMCFreeSpace();

    MMCState getMMCState();

    long getMMCTotalSpace();

    int getPhotoIntervalMin();

    int getPhotoSumCanTake();

    SDCardState getSDCardState();

    long getSDcardFreeSpace();

    ShutterSpeed getShutterSpeed();

    int getTemperature();

    long getTotalTimeCanRecord();

    float getVerticalFOV();

    WorkState getWorkState();

    int getZoomScale();
}
