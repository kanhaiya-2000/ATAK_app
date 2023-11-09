package com.autel.camera.hardware;

import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;

public class XB016CameraAndGimbalHardware extends BaseCameraAndGimbalHardware {
    private final float Diagonal_Angle_Photo_Normal = 90.1f;
    private final float Diagonal_Angle_Video_Above4k = 79.6f;
    private final float Diagonal_Angle_Video_Normal_1080P = 73.6f;
    private final float Diagonal_Angle_Video_Normal_30 = 79.6f;
    private final float Diagonal_Angle_Video_Normal_48 = 66.9f;
    private final float Diagonal_Angle_Video_Normal_720P = 52.8f;
    private final float Diagonal_Angle_Video_Normal_other = 86.0f;
    private final float Horizontal_Angle_Photo_Normal = 79.6f;
    private final float Horizontal_Angle_Video_Above4k = 72.2f;
    private final float Horizontal_Angle_Video_Normal_1080P = 59.8f;
    private final float Horizontal_Angle_Video_Normal_30 = 72.2f;
    private final float Horizontal_Angle_Video_Normal_48 = 59.6f;
    private final float Horizontal_Angle_Video_Normal_720P = 41.5f;
    private final float Horizontal_Angle_Video_Normal_other = 78.1f;
    private final float VFOV = 49.0f;
    private final float Vertical_Angle_Photo_Normal = 57.5f;
    private final float Vertical_Angle_Video_Above4k = 43.9f;
    private final float Vertical_Angle_Video_Normal_1080P = 51.2f;
    private final float Vertical_Angle_Video_Normal_30 = 43.9f;
    private final float Vertical_Angle_Video_Normal_48 = 35.5f;
    private final float Vertical_Angle_Video_Normal_720P = 35.6f;
    private final float Vertical_Angle_Video_Normal_other = 48.5f;

    /* renamed from: h */
    private final float f8457h = 8.2f;
    private final float pixelSize = 5.76f;

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Photo_Normal() {
        return 90.1f;
    }

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Video_Above4k() {
        return 79.6f;
    }

    /* access modifiers changed from: package-private */
    public float getDiagonal_Angle_Video_Normal() {
        return 86.0f;
    }

    public float getH() {
        return 8.2f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Photo_Normal() {
        return 79.6f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Photo_Normal_16_9() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Video_Above4k() {
        return 72.2f;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontal_Angle_Video_Normal() {
        return 78.1f;
    }

    public float getPixelSize() {
        return 5.76f;
    }

    public float getValidClickAreaDottedLineHeightRatio() {
        return 0.0f;
    }

    public float getVerticalFOV() {
        return 49.0f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Photo_Normal() {
        return 57.5f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Photo_Normal_16_9() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Video_Above4k() {
        return 43.9f;
    }

    /* access modifiers changed from: package-private */
    public float getVertical_Angle_Video_Normal() {
        return 48.5f;
    }

    public float getVerticalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        VideoFps videoFps = videoMainResolutionAndFps == null ? VideoFps.UNKNOWN : videoMainResolutionAndFps.fps;
        if (!find.equals(MediaMode.VIDEO)) {
            return 57.5f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_4096x2160)) {
            return 43.9f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_3840x2160)) {
            if (videoFps.fps() >= VideoFps.FrameRate_48ps.fps()) {
                return 35.5f;
            }
            return 43.9f;
        } else if (videoResolution.equals(VideoResolution.Resolution_1920x1080)) {
            return 51.2f;
        } else {
            return videoResolution.equals(VideoResolution.Resolution_1280x720) ? 35.6f : 48.5f;
        }
    }

    public float getHorizontalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        VideoFps videoFps = videoMainResolutionAndFps == null ? VideoFps.UNKNOWN : videoMainResolutionAndFps.fps;
        if (!find.equals(MediaMode.VIDEO)) {
            return 79.6f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_4096x2160)) {
            return 72.2f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_3840x2160)) {
            if (videoFps.fps() >= VideoFps.FrameRate_48ps.fps()) {
                return 59.6f;
            }
            return 72.2f;
        } else if (videoResolution.equals(VideoResolution.Resolution_1920x1080)) {
            return 59.8f;
        } else {
            return videoResolution.equals(VideoResolution.Resolution_1280x720) ? 41.5f : 78.1f;
        }
    }

    public float getDiagonalAngle() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        VideoFps videoFps = videoMainResolutionAndFps == null ? VideoFps.UNKNOWN : videoMainResolutionAndFps.fps;
        if (!find.equals(MediaMode.VIDEO)) {
            return 90.1f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_4096x2160)) {
            return 79.6f;
        }
        if (videoResolution.equals(VideoResolution.Resolution_3840x2160)) {
            if (videoFps.fps() >= VideoFps.FrameRate_48ps.fps()) {
                return 66.9f;
            }
            return 79.6f;
        } else if (videoResolution.equals(VideoResolution.Resolution_1920x1080)) {
            return 73.6f;
        } else {
            return videoResolution.equals(VideoResolution.Resolution_1280x720) ? 52.8f : 86.0f;
        }
    }
}
