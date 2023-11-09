package com.autel.common.camera.XT701;

import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FlashCardStatus;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.MeteringMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.xb015.PIVMode;

public interface XT701StateInfo extends BaseStateInfo {
    PhotoAEBCount getAEBCount();

    AntiFlicker getAntiFlicker();

    AutoExposureLockState getAutoExposureLockState();

    VideoSnapshotTimelapseInterval getAutoPIVTimelapseInterval();

    PhotoBurstCount getBurstCount();

    ColorStyle getColorStyle();

    DeFogParam getDeFogParam();

    int getDigitalZoomScale();

    ExposureMode getExposureMode();

    FlashCardStatus getFlashCardStatus();

    int getFocusDistance();

    LensFocusMode getFocusMode();

    ImageRoiParam getImageRoiParam();

    String getLensModel();

    MeteringMode getMeteringMode();

    PIVMode getPIVMode();

    PhotoAspectRatio getPhotoAspectRatio();

    PhotoFormat getPhotoFormat();

    PhotoStyle getPhotoStyle();

    ShutterMode getShutterMode();

    SaveLocation getStorageType();

    PhotoTimelapseInterval getTimelapseInterval();

    VideoEncodeFormat getVideoEncodeFormat();

    VideoFormat getVideoFormat();

    VideoResolutionAndFps getVideoResolutionAndFrameRate();

    WhiteBalance getWhiteBalance();

    boolean isHistogramEnable();

    boolean isSubtitleEnable();
}
