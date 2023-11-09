package com.autel.sdk.camera.p005rx;

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
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.camera.rx.RxAutelXB015 */
public interface RxAutelXB015 extends RxAutelBaseCamera {
    Observable<AntiFlicker> getAntiFlicker();

    Observable<PhotoAspectRatio> getAspectRatio();

    Observable<AutoExposureLockState> getAutoExposureLockState();

    Observable<VideoSnapshotTimelapseInterval> getAutoPIVTimelapseInterval();

    Observable<ColorStyle> getColorStyle();

    Observable<Integer> getCurrentRecordTime();

    Observable<Integer> getDigitalZoomScale();

    Observable<ExposureCompensation> getExposure();

    Observable<ExposureMode> getExposureMode();

    Observable<CameraISO> getISO();

    Observable<Integer> getLeftPhotoSum();

    Observable<PIVMode> getPIVMode();

    Observable<XB015ParameterRangeManager> getParameterRangeManager();

    Observable<PhotoAEBCount> getPhotoAEBCount();

    Observable<PhotoBurstCount> getPhotoBurstCount();

    Observable<PhotoFormat> getPhotoFormat();

    Observable<PhotoStyle> getPhotoStyle();

    Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval();

    Observable<RealTimeVideoResolution> getRealTimeVideoResolution();

    Observable<ShutterSpeed> getShutter();

    Observable<SkylinePositionData> getSkylinePositionData(int i, int i2);

    Observable<SpotMeteringArea> getSpotMeteringArea();

    Observable<VideoEncodeFormat> getVideoEncodeFormat();

    Observable<VideoFormat> getVideoFormat();

    Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate();

    Observable<VideoRotation> getVideoRotation();

    Observable<VideoStandard> getVideoStandard();

    Observable<VideoSum> getVideoSum();

    Observable<WhiteBalance> getWhiteBalance();

    Observable<Boolean> isHistogramStatusEnable();

    Observable<Boolean> isSubtitleEnable();

    Observable<Boolean> setAntiFlicker(AntiFlicker antiFlicker);

    Observable<Boolean> setAspectRatio(PhotoAspectRatio photoAspectRatio);

    Observable<Boolean> setAutoExposureLockState(AutoExposureLockState autoExposureLockState);

    Observable<Boolean> setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval);

    Observable<Boolean> setColorStyle(ColorStyle colorStyle);

    Observable<Boolean> setDigitalZoomScale(int i);

    Observable<Boolean> setExposure(ExposureCompensation exposureCompensation);

    Observable<Boolean> setExposureMode(ExposureMode exposureMode);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    Observable<Boolean> setISO(CameraISO cameraISO);

    void setInfoListener(CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam);

    Observable<Boolean> setPIVMode(PIVMode pIVMode);

    Observable<Boolean> setPhotoAEBCount(PhotoAEBCount photoAEBCount);

    Observable<Boolean> setPhotoBurstCount(PhotoBurstCount photoBurstCount);

    Observable<Boolean> setPhotoFormat(PhotoFormat photoFormat);

    Observable<Boolean> setPhotoStyle(int i, int i2, int i3);

    Observable<Boolean> setPhotoStyle(PhotoStyleType photoStyleType);

    Observable<Boolean> setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval);

    Observable<Boolean> setRealTimeVideoResolution(RealTimeVideoResolution realTimeVideoResolution);

    Observable<Boolean> setShutter(ShutterSpeed shutterSpeed);

    Observable<Boolean> setSpotMeteringArea(int i, int i2);

    Observable<Boolean> setTrackingModeEnable(boolean z);

    Observable<Boolean> setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat);

    Observable<Boolean> setVideoFormat(VideoFormat videoFormat);

    Observable<Boolean> setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps);

    Observable<Boolean> setVideoRotation(VideoRotation videoRotation);

    Observable<Boolean> setVideoStandard(VideoStandard videoStandard);

    Observable<Boolean> setVideoSubtitleEnable(boolean z);

    Observable<Boolean> setWhiteBalance(WhiteBalance whiteBalance);

    Observable<MediaMode> switchToPreviousMediaMode();
}
