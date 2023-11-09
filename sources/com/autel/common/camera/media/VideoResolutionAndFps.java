package com.autel.common.camera.media;

public class VideoResolutionAndFps {
    public VideoFps fps = VideoFps.UNKNOWN;
    public VideoResolution resolution = VideoResolution.UNKNOWN;

    public VideoResolutionAndFps() {
    }

    public VideoResolutionAndFps(VideoResolution videoResolution, VideoFps videoFps) {
        this.resolution = videoResolution;
        this.fps = videoFps;
    }

    public String toString() {
        if (this.resolution == null || this.fps == null) {
            return "";
        }
        return this.resolution.value() + this.fps.value();
    }

    public static VideoResolutionAndFps create(String str) {
        VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
        int indexOf = str.indexOf("p");
        if (-1 != indexOf) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf);
            videoResolutionAndFps.resolution = VideoResolution.find(substring);
            videoResolutionAndFps.fps = VideoFps.find(substring2);
        }
        return videoResolutionAndFps;
    }
}
