package com.autel.camera.protocol.protocol10.interfaces.r12;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.internal.sdk.camera.base.AutelSwitchState;

public interface AutelR12 {
    void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam);

    void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam);

    void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam);

    void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam);

    void getCurrentRecordTimeSeconds(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam);

    void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam);

    void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam);

    void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam);

    void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam);

    void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam);

    void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam);

    void getPhotoSum(CallbackWithOneParam<PhotoSum> callbackWithOneParam);

    void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam);

    void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam);

    void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam);

    void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam);

    void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam);

    void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam);

    void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam);

    void is3DNoiseReductionEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam);

    void setAspectRatio(String str, CallbackWithNoParam callbackWithNoParam);

    void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam);

    void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam);

    void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam);

    void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam);

    void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam);

    void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setHistogramStatusEnable(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam);

    void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam);

    void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam);

    void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam);

    void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam);

    void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam);

    void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam);
}
