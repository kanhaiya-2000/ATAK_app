package com.autel.common.camera.XT706;

import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ShutterSpeed;

public interface XT706CameraInfo {
    float getAverageTemperature();

    CameraAperture getCameraAperture();

    float getCenterTemperature();

    long getCurrentRecordTime();

    ExposureCompensation getExposureCompensation();

    float getHighTemperature();

    float getHighX();

    float getHighY();

    float getHorizontalFOV();

    CameraISO getISO();

    float getLowTemperature();

    float getLowX();

    float getLowY();

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

    float getTouchTemperature();

    float getVerticalFOV();

    WorkState getWorkState();

    int getZoomScale();
}
