package com.autel.common.album;

import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;

public interface MediaInfo {
    long getFileSize();

    String getFileTimeString();

    String getLargeThumbnail();

    String getOriginalMedia();

    String getSmallThumbnail();

    VideoEncodeFormat getVideoEncodeFormat();

    String getVideoPlayUrl();

    VideoResolutionAndFps getVideoResolutionAndFps();
}
