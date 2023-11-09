package com.autel.common.camera.media;

public interface VideoEncoderConfiguration {
    int getBitrate();

    VideoBitrateType getBitrateType();

    VideoEncodeType getEncodeType();

    VideoEncodeFormat getEncoding();

    int getIntervalOfIFrame();

    int getQuality();

    VideoResolutionAndFps getVideoResolutionAndFps();
}
