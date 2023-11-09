package com.autel.camera.protocol.protocol20.interfaces.Xb015;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.camera.protocol.protocol20.interfaces.base.BaseCameraService;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.visual.TrackStateInfo;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.internal.sdk.camera.xb008.FileNamingMode;

public interface CameraXb015 extends BaseCameraService {
    void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam);

    void cancelTracking(CallbackWithNoParam callbackWithNoParam);

    void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam);

    void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam);

    void getCameraAutoExposureState(CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam);

    void getCameraMode(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam);

    void getColorTemperature(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam);

    void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam);

    void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam);

    void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam);

    void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam);

    void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam);

    void getPhotoTakingSettings(CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings> callbackWithOneParam);

    void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam);

    void getRecordingSettings(CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam);

    void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam);

    void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getTrackingState(CallbackWithOneParam<TrackStateInfo> callbackWithOneParam);

    void getVideoEncoderConfiguration(int i, CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration> callbackWithOneParam);

    void getVideoSourceConfiguration(CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam);

    void getVideoSourceConfigurationOptions(CallbackWithOneParam<CameraAllSettings.VideoSourceConfigurationOptions> callbackWithOneParam);

    void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam);

    void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam);

    void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam);

    void setAutoSnapshotEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAutoSnapshotInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam);

    void setCurrentRealResolution(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam);

    void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam);

    void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam);

    void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam);

    void setFileNamingMode(FileNamingMode fileNamingMode, CallbackWithNoParam callbackWithNoParam);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam);

    void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam);

    void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setProductSubtitleSNEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam);

    void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam);

    void setTrackingMode(TrackMode trackMode, CallbackWithNoParam callbackWithNoParam);

    void setVideoEncoderConfiguration(int i, VideoEncoderConfiguration videoEncoderConfiguration, CallbackWithNoParam callbackWithNoParam);

    void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam);

    void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam);
}
