package com.autel.internal.sdk.camera;

import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.VideoSum;

public interface CameraStatus {
    WorkState getCameraStatus();

    MediaMode getCurrentMode();

    long getCurrentRecordTime();

    PhotoSum getPhotoNum();

    SDCardState getSDCardStatus();

    long getSdFreeSpace();

    VideoSum getVideoNum();
}
