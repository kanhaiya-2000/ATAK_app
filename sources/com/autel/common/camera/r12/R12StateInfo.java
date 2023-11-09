package com.autel.common.camera.r12;

import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;

public interface R12StateInfo extends BaseStateInfo {
    PhotoAEBCount getAEBCount();

    AntiFlicker getAntiFlicker();

    AutoExposureLockState getAutoExposureLockState();

    PhotoBurstCount getBurstCount();

    ColorStyle getColorStyle();

    int getDigitalZoomScale();

    ExposureMode getExposureMode();

    PhotoAspectRatio getPhotoAspectRatio();

    PhotoFormat getPhotoFormat();

    PhotoStyle getPhotoStyle();

    PhotoTimelapseInterval getTimelapseInterval();

    VideoFormat getVideoFormat();

    VideoResolutionAndFps getVideoResolutionAndFrameRate();

    VideoStandard getVideoStandard();

    WhiteBalance getWhiteBalance();

    boolean isHistogramEnable();

    boolean isSubtitleEnable();
}
