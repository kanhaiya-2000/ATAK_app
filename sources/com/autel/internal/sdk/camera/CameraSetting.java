package com.autel.internal.sdk.camera;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FocusDistance;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;

public interface CameraSetting {
    PhotoAEBCount getAebNum();

    AntiFlicker getAntiFlicker();

    PhotoAspectRatio getAspectRatio();

    AutoExposureLockState getAutoExposureLockState();

    PhotoBurstCount getBurstNum();

    CameraAperture getCameraApertureValue();

    int getCameraColorTemperature();

    FocusDistance getCameraFocusDistance();

    LensFocusMode getCameraFocusMode();

    String getCameraNickName();

    CameraProduct getCameraProductType();

    ShutterSpeed getCameraShutter();

    long getCameraTimeStamp();

    int getDigitalZoomScale();

    ExposureMode getExposureMode();

    ExposureCompensation getExposureValue();

    CameraISO getISO();

    PhotoFormat getPhotoFormat();

    PhotoStyle getPhotoStyle();

    SpotMeteringArea getSpotMeterLocation();

    ColorStyle getThermalPalette();

    PhotoTimelapseInterval getTimelapseIntervalTime();

    String getVersion();

    VideoFormat getVideoFormat();

    VideoResolutionAndFps getVideoResolution();

    VideoStandard getVideoStandard();

    WhiteBalance getWhiteBalance();

    boolean is3DDenoiseEnable();

    boolean isHistogramStatusEnable();

    boolean isSubtitleSwitchEnable();
}
