package com.autel.internal.sdk.camera.base;

import com.autel.common.camera.media.VideoResolutionAndFps;

public class AutelVideoResolutionInternal {
    private VideoResolutionAndFps resolutionAndFps;

    public VideoResolutionAndFps getResolutionAndFps() {
        return this.resolutionAndFps;
    }

    public void setResolutionAndFps(VideoResolutionAndFps videoResolutionAndFps) {
        this.resolutionAndFps = videoResolutionAndFps;
    }
}
