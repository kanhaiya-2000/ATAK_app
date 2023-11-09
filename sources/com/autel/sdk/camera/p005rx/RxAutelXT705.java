package com.autel.sdk.camera.p005rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT705.XT705ParameterRangeManager;
import com.autel.common.camera.base.ISOMode;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
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
import io.reactivex.Observable;
import java.util.List;

/* renamed from: com.autel.sdk.camera.rx.RxAutelXT705 */
public interface RxAutelXT705 extends RxAutelBaseCamera {
    Observable<Boolean> formatFlashMemoryCard();

    Observable<Boolean> getAFAssistFocusEnable();

    Observable<SaveLocation> getAlbumLocation();

    Observable<AntiFlicker> getAntiFlicker();

    Observable<PhotoAspectRatio> getAspectRatio();

    Observable<AutoExposureLockState> getAutoExposureLockState();

    Observable<CameraAperture> getCameraAperture();

    Observable<ColorStyle> getColorStyle();

    Observable<Integer> getCurrentRecordTime();

    Observable<DeFogParam> getDeFogParams();

    Observable<Integer> getDigitalZoomScale();

    Observable<ExposureCompensation> getExposure();

    Observable<ExposureMode> getExposureMode();

    Observable<FlashCardStatus> getFMCStatus();

    Observable<SpotMeteringArea> getFocusAFSpotArea();

    Observable<Integer> getFocusDistance();

    Observable<LensFocusMode> getFocusMode();

    Observable<Boolean> getHDREnable();

    Observable<CameraISO> getISO();

    Observable<ISOMode> getISOMode();

    Observable<ImageRoiParam> getImageRoiParams();

    Observable<Integer> getLeftPhotoSum();

    Observable<Boolean> getMFAssistFocusEnable();

    Observable<Integer> getMotionDelayShotDuration();

    Observable<Integer> getMotionDelayShotInterval();

    Observable<MotionPhotoInfo> getMotionDelayShotKeepPhoto();

    Observable<PIVMode> getPIVMode();

    Observable<XT705ParameterRangeManager> getParameterRangeManager();

    Observable<PhotoAEBCount> getPhotoAEBCount();

    Observable<PhotoBurstCount> getPhotoBurstCount();

    Observable<PhotoFormat> getPhotoFormat();

    Observable<PhotoStyle> getPhotoStyle();

    Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval();

    Observable<ShutterSpeed> getShutter();

    Observable<ShutterMode> getShutterMode();

    Observable<SkylinePositionData> getSkylinePositionData(int i, int i2);

    Observable<SpotMeteringArea> getSpotMeteringArea();

    Observable<VideoEncodeFormat> getVideoEncodeFormat();

    Observable<VideoEncoderConfiguration> getVideoEncoderConfiguration();

    Observable<VideoFormat> getVideoFormat();

    Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate();

    Observable<VideoRotation> getVideoRotation();

    Observable<VideoStandard> getVideoStandard();

    Observable<VideoSum> getVideoSum();

    Observable<WhiteBalance> getWhiteBalance();

    Observable<Boolean> isHistogramStatusEnable();

    Observable<Boolean> isSubtitleEnable();

    Observable<Boolean> set3DNoiseReductionEnable(boolean z);

    Observable<Boolean> setAFAssistFocusEnable(boolean z);

    Observable<Boolean> setAlbumSaveLocation(SaveLocation saveLocation);

    Observable<Boolean> setAntiFlicker(AntiFlicker antiFlicker);

    Observable<Boolean> setAspectRatio(PhotoAspectRatio photoAspectRatio);

    Observable<Boolean> setAutoExposureLockState(AutoExposureLockState autoExposureLockState);

    void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams);

    Observable<Boolean> setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval);

    Observable<Boolean> setCameraAperture(CameraAperture cameraAperture);

    Observable<Boolean> setColorStyle(ColorStyle colorStyle);

    Observable<Boolean> setDeFogEnable(boolean z);

    Observable<Boolean> setDeFogStrength(int i);

    Observable<Boolean> setDigitalZoomScale(int i);

    Observable<Boolean> setExposure(ExposureCompensation exposureCompensation);

    Observable<Boolean> setExposureMode(ExposureMode exposureMode);

    Observable<Boolean> setFocusDistance(int i);

    Observable<Boolean> setFocusMode(LensFocusMode lensFocusMode);

    Observable<Boolean> setHDREnable(boolean z);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    Observable<Boolean> setISO(CameraISO cameraISO);

    Observable<Boolean> setISOMode(ISOMode iSOMode);

    Observable<Boolean> setImageRoiArea(int i, int i2);

    Observable<Boolean> setImageRoiEnable(boolean z);

    Observable<Boolean> setImageRoiStrength(int i);

    Observable<Boolean> setMFAssistFocusEnable(boolean z);

    Observable<Boolean> setManualFocusMeter(int i, int i2);

    Observable<Boolean> setMotionDelayShotDuration(int i);

    Observable<Boolean> setMotionDelayShotInterval(int i);

    Observable<Boolean> setMotionDelayShotKeepPhoto(RawFormat rawFormat);

    Observable<Boolean> setPIVMode(PIVMode pIVMode);

    Observable<Boolean> setPhotoAEBCount(PhotoAEBCount photoAEBCount);

    Observable<Boolean> setPhotoAutoFocusMeter(int i, int i2);

    Observable<Boolean> setPhotoBurstCount(PhotoBurstCount photoBurstCount);

    Observable<Boolean> setPhotoFormat(PhotoFormat photoFormat);

    Observable<Boolean> setPhotoStyle(int i, int i2, int i3);

    Observable<Boolean> setPhotoStyle(PhotoStyleType photoStyleType);

    Observable<Boolean> setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval);

    Observable<Boolean> setShutter(ShutterSpeed shutterSpeed);

    Observable<Boolean> setShutterMode(ShutterMode shutterMode);

    Observable<Boolean> setSpotMeteringArea(int i, int i2);

    Observable<Boolean> setTrackingModeEnable(boolean z);

    Observable<Boolean> setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat);

    Observable<Boolean> setVideoEncoder(VideoEncodeFormat videoEncodeFormat);

    Observable<Boolean> setVideoFormat(VideoFormat videoFormat);

    Observable<Boolean> setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps);

    Observable<Boolean> setVideoRotation(VideoRotation videoRotation);

    Observable<Boolean> setVideoStandard(VideoStandard videoStandard);

    Observable<Boolean> setVideoSubtitleEnable(boolean z);

    Observable<Boolean> setWhiteBalance(WhiteBalance whiteBalance);

    Observable<Boolean> startTakePhotoWithFocus();

    Observable<MediaMode> switchToPreviousMediaMode();
}
