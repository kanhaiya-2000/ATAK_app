package com.autel.sdk.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.MediaMode;
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
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SkylinePositionData;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.camera.xb015.RealTimeVideoResolution;
import com.autel.common.camera.xb015.XB015CameraInfo;
import com.autel.common.camera.xb015.XB015ParameterRangeManager;
import com.autel.sdk.camera.p005rx.RxAutelXB015;

public interface AutelXB015 extends AutelBaseCamera {
    void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam);

    void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam);

    void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam);

    void getAutoPIVTimelapseInterval(CallbackWithOneParam<VideoSnapshotTimelapseInterval> callbackWithOneParam);

    void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam);

    void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam);

    void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam);

    void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam);

    void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam);

    XB015ParameterRangeManager getParameterRangeManager();

    void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam);

    void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam);

    void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam);

    void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam);

    void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam);

    void getRealTimeVideoResolution(CallbackWithOneParam<RealTimeVideoResolution> callbackWithOneParam);

    void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam);

    void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam);

    void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam);

    void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam);

    void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam);

    void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam);

    void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam);

    void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam);

    void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam);

    void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam);

    void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam);

    void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam);

    void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam);

    void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam);

    void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam);

    void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam);

    void setInfoListener(CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam);

    void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam);

    void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam);

    void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setRealTimeVideoResolution(RealTimeVideoResolution realTimeVideoResolution, CallbackWithNoParam callbackWithNoParam);

    void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam);

    void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam);

    void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam);

    void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam);

    void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam);

    void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    RxAutelXB015 toRx();
}
