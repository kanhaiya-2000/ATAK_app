package com.autel.sdk.camera.p005rx;

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
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.r12.R12CameraInfo;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.camera.rx.RxAutelR12 */
public interface RxAutelR12 extends RxAutelBaseCamera {
    Observable<AntiFlicker> getAntiFlicker();

    Observable<PhotoAspectRatio> getAspectRatio();

    Observable<AutoExposureLockState> getAutoExposureLockState();

    Observable<ColorStyle> getColorStyle();

    Observable<Integer> getCurrentRecordTime();

    Observable<Integer> getDigitalZoomScale();

    Observable<ExposureCompensation> getExposure();

    Observable<ExposureMode> getExposureMode();

    Observable<CameraISO> getISO();

    Observable<R12ParameterRangeManager> getParameterRangeManager();

    Observable<PhotoAEBCount> getPhotoAEBCount();

    Observable<PhotoBurstCount> getPhotoBurstCount();

    Observable<PhotoFormat> getPhotoFormat();

    Observable<PhotoStyle> getPhotoStyle();

    Observable<Integer> getPhotoSum();

    Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval();

    Observable<Long> getRemainRecordTime();

    Observable<ShutterSpeed> getShutter();

    Observable<SpotMeteringArea> getSpotMeteringArea();

    Observable<VideoFormat> getVideoFormat();

    Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate();

    Observable<VideoStandard> getVideoStandard();

    Observable<WhiteBalance> getWhiteBalance();

    Observable<Boolean> is3DNoiseReductionEnable();

    Observable<Boolean> isHistogramStatusEnable();

    Observable<Boolean> isSubtitleEnable();

    Observable<Boolean> set3DNoiseReductionEnable(boolean z);

    Observable<Boolean> setAntiFlicker(AntiFlicker antiFlicker);

    Observable<Boolean> setAspectRatio(PhotoAspectRatio photoAspectRatio);

    Observable<Boolean> setAutoExposureLockState(AutoExposureLockState autoExposureLockState);

    Observable<Boolean> setColorStyle(ColorStyle colorStyle);

    Observable<Boolean> setDigitalZoomScale(int i);

    Observable<Boolean> setExposure(ExposureCompensation exposureCompensation);

    Observable<Boolean> setExposureMode(ExposureMode exposureMode);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    Observable<Boolean> setISO(CameraISO cameraISO);

    void setInfoListener(CallbackWithOneParam<R12CameraInfo> callbackWithOneParam);

    Observable<Boolean> setPhotoAEBCount(PhotoAEBCount photoAEBCount);

    Observable<Boolean> setPhotoBurstCount(PhotoBurstCount photoBurstCount);

    Observable<Boolean> setPhotoFormat(PhotoFormat photoFormat);

    Observable<Boolean> setPhotoStyle(int i, int i2, int i3);

    Observable<Boolean> setPhotoStyle(PhotoStyleType photoStyleType);

    Observable<Boolean> setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval);

    Observable<Boolean> setShutter(ShutterSpeed shutterSpeed);

    Observable<Boolean> setSpotMeteringArea(int i, int i2);

    Observable<Boolean> setVideoFormat(VideoFormat videoFormat);

    Observable<Boolean> setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps);

    Observable<Boolean> setVideoStandard(VideoStandard videoStandard);

    Observable<Boolean> setVideoSubtitleEnable(boolean z);

    Observable<Boolean> setWhiteBalance(WhiteBalance whiteBalance);
}
