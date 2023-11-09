package com.autel.common.camera.base;

import com.autel.common.camera.CameraProduct;

public interface BaseStateInfo {
    GimbalLockState getGimbalLockState();

    MediaMode getMediaMode();

    SDCardState getSDCardState();

    CameraProduct getType();

    WorkState getWorkState();
}
