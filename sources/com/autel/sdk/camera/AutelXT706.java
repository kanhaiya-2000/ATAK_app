package com.autel.sdk.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.XT706.IrTempetureWarningParams;
import com.autel.common.camera.XT706.XT706CameraInfo;
import com.autel.common.camera.XT706.XT706ParameterRangeManager;
import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionDelayShot;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.base.SettingEvent;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FlashCardStatus;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SkylinePositionData;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.sdk.camera.p005rx.RxAutelXT706;
import java.util.List;

public interface AutelXT706 extends AutelBaseCamera {
    void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam);

    void getAFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getAlbumLocation(CallbackWithOneParam<SaveLocation> callbackWithOneParam);

    void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam);

    void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam);

    void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam);

    void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam);

    void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam);

    void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getDisplayMode(CallbackWithOneParam<DisplayMode> callbackWithOneParam);

    void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam);

    void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam);

    void getFMCStatus(CallbackWithOneParam<FlashCardStatus> callbackWithOneParam);

    void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam);

    void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam);

    void getImageRoiParams(CallbackWithOneParam<ImageRoiParam> callbackWithOneParam);

    void getIrColor(CallbackWithOneParam<IrColor> callbackWithOneParam);

    void getIrPosition(CallbackWithOneParam<IrPosition> callbackWithOneParam);

    void getIrTemperatureEmit(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getIrTemperatureParams(CallbackWithOneParam<IrTemperatureParams> callbackWithOneParam);

    void getIrTemperatureWarningParams(CallbackWithOneParam<IrTemperatureWarnParams> callbackWithOneParam);

    void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam);

    void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam);

    XT706ParameterRangeManager getParameterRangeManager();

    void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam);

    void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam);

    void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam);

    void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam);

    void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam);

    void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam);

    void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam);

    void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam);

    void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam);

    void getVideoEncoderConfiguration(CallbackWithOneParam<VideoEncoderConfiguration> callbackWithOneParam);

    void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam);

    void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam);

    void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam);

    void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam);

    void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam);

    void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam);

    void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAFCenterListener(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam);

    void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam);

    void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam);

    void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam);

    void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams);

    void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam);

    void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam);

    void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam);

    void setDisplayMode(DisplayMode displayMode, CallbackWithNoParam callbackWithNoParam);

    void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam);

    void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam);

    void setFlashMemoryCardStateListener(CallbackWithOneParam<MMCState> callbackWithOneParam);

    void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam);

    void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam);

    void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam);

    void setInfoListener(CallbackWithOneParam<XT706CameraInfo> callbackWithOneParam);

    void setIrColor(IrColor irColor, CallbackWithNoParam callbackWithNoParam);

    void setIrFlushShutter(CallbackWithNoParam callbackWithNoParam);

    void setIrPosition(IrPosition irPosition, CallbackWithNoParam callbackWithNoParam);

    void setIrTemperatureEmit(int i, CallbackWithNoParam callbackWithNoParam);

    void setIrTemperatureParams(IrTemperatureParams irTemperatureParams, CallbackWithNoParam callbackWithNoParam);

    void setIrTemperatureWarningParams(IrTemperatureWarnParams irTemperatureWarnParams, CallbackWithNoParam callbackWithNoParam);

    void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotListener(CallbackWithOneParam<MotionDelayShot> callbackWithOneParam);

    void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam);

    void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam);

    void setPhotoExposureListener(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam);

    void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam);

    void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam);

    void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam);

    void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam);

    void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setTemperatureWarningListener(CallbackWithOneParam<IrTempetureWarningParams> callbackWithOneParam);

    void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoEncoder(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam);

    void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam);

    void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam);

    void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam);

    void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam);

    void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    RxAutelXT706 toRx();
}
