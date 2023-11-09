package com.autel.internal.sdk.camera.media;

import com.autel.common.camera.media.VideoSum;

public class VideoSumImpl implements VideoSum {
    public long currentRecordingTime;
    public long leftTime;

    public String toString() {
        return "currentRecordingTime " + this.currentRecordingTime + " leftTime  " + this.leftTime;
    }

    public long getCurrentRecordingTime() {
        return this.currentRecordingTime;
    }

    public long getLeftTime() {
        return this.leftTime;
    }
}
