package com.autel.internal.camera.p001rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.internal.sdk.camera.xb008.XB008ParameterRangeManager;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;
import io.reactivex.Observable;
import java.util.List;

/* renamed from: com.autel.internal.camera.rx.RxAutelXB008 */
public interface RxAutelXB008 extends RxAutelBaseCamera {
    Observable<AntiFlicker> getAntiFlicker();

    Observable<PhotoAspectRatio> getAspectRatio();

    Observable<AutoExposureLockState> getAutoExposureLockState();

    Observable<ColorStyle> getColorStyle();

    Observable<Integer> getCurrentRecordTime();

    Observable<Integer> getDigitalZoomScale();

    Observable<ExposureCompensation> getExposure();

    Observable<ExposureMode> getExposureMode();

    Observable<Integer> getFocusDistance();

    Observable<LensFocusMode> getFocusMode();

    Observable<CameraAperture> getIRIS();

    Observable<CameraISO> getISO();

    Observable<Integer> getLeftPhotoSum();

    Observable<XB008ParameterRangeManager> getParameterRangeManager();

    Observable<PhotoAEBCount> getPhotoAEBCount();

    Observable<PhotoBurstCount> getPhotoBurstCount();

    Observable<PhotoFormat> getPhotoFormat();

    Observable<PhotoStyle> getPhotoStyle();

    Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval();

    Observable<ShutterSpeed> getShutter();

    Observable<SpotMeteringArea> getSpotMeteringArea();

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

    Observable<Boolean> setAntiFlicker(AntiFlicker antiFlicker);

    Observable<Boolean> setAspectRatio(PhotoAspectRatio photoAspectRatio);

    Observable<Boolean> setAutoExposureLockState(AutoExposureLockState autoExposureLockState);

    void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams);

    Observable<Boolean> setColorStyle(ColorStyle colorStyle);

    Observable<Boolean> setDigitalZoomScale(int i);

    Observable<Boolean> setExposure(ExposureCompensation exposureCompensation);

    Observable<Boolean> setExposureMode(ExposureMode exposureMode);

    Observable<Boolean> setFocusDistance(int i);

    Observable<Boolean> setFocusMode(LensFocusMode lensFocusMode);

    void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    Observable<Boolean> setIRIS(CameraAperture cameraAperture);

    Observable<Boolean> setISO(CameraISO cameraISO);

    Observable<Boolean> setPhotoAEBCount(PhotoAEBCount photoAEBCount);

    Observable<Boolean> setPhotoAutoFocusMeter(int i, int i2);

    Observable<Boolean> setPhotoBurstCount(PhotoBurstCount photoBurstCount);

    Observable<Boolean> setPhotoFormat(PhotoFormat photoFormat);

    Observable<Boolean> setPhotoStyle(int i, int i2, int i3);

    Observable<Boolean> setPhotoStyle(PhotoStyleType photoStyleType);

    Observable<Boolean> setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval);

    Observable<Boolean> setShutter(ShutterSpeed shutterSpeed);

    Observable<Boolean> setSpotMeteringArea(int i, int i2);

    Observable<Boolean> setVideoEncoder(VideoEncodeFormat videoEncodeFormat);

    Observable<Boolean> setVideoFormat(VideoFormat videoFormat);

    Observable<Boolean> setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps);

    Observable<Boolean> setVideoRotation(VideoRotation videoRotation);

    Observable<Boolean> setVideoStandard(VideoStandard videoStandard);

    Observable<Boolean> setVideoSubtitleEnable(boolean z);

    Observable<Boolean> setWhiteBalance(WhiteBalance whiteBalance);

    Observable<Boolean> startTakePhotoWithFocus();
}
