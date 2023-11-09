package com.autel.common.camera.base;

public interface MotionDelayShot {
    MotionDelayState getMotionDelayState();

    int getPhotoNumber();

    int getPhotoTime();

    int getTotalPhotoNumber();

    int getTotalPhotoTime();
}
