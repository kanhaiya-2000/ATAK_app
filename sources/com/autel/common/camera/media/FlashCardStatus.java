package com.autel.common.camera.media;

import com.autel.common.camera.base.MMCState;

public interface FlashCardStatus {
    long getCurrentRecordTime();

    MMCState getFlashCardStatus();

    long getFreeSpace();

    int getRemainCaptureNum();

    int getRemainRecordTime();

    long getTotalSpace();
}
