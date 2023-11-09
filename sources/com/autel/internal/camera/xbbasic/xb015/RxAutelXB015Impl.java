package com.autel.internal.camera.xbbasic.xb015;

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
import com.autel.common.error.AutelError;
import com.autel.internal.camera.RxAutelBaseCameraImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.camera.AutelXB015;
import com.autel.sdk.camera.p005rx.RxAutelXB015;
import io.reactivex.Observable;

public class RxAutelXB015Impl extends RxAutelBaseCameraImpl implements RxAutelXB015 {
    AutelXB015 mAutelXB015;

    public RxAutelXB015Impl(AutelXB015 autelXB015) {
        super(autelXB015);
        this.mAutelXB015 = autelXB015;
    }

    public void setInfoListener(CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam) {
        this.mAutelXB015.setInfoListener(callbackWithOneParam);
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.mAutelXB015.setHistogramListener(callbackWithOneParam);
    }

    public Observable<Boolean> setSpotMeteringArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C30301.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C30301.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C30522.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C30522.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C30743.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C30743.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C30964.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C30964.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C31185.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C31185.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C31396.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C31396.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C31417.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C31417.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C31438.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C31438.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C31459.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C31459.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C303210.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C303210.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C303411.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C303411.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C303612.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C303612.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C303813.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C303813.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C304014.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C304014.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C304215.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C304215.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C304416.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C304416.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C304617.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C304617.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C304818.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C304818.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C305019.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C305019.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.isHistogramEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C305420.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C305420.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C305621.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C305621.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C305822.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C305822.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C306023.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C306023.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C306224.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C306224.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C306425.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C306425.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C306626.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C306626.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C306827.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C306827.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C307028.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C307028.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C307229.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C307229.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C307630.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C307630.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C307831.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C307831.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C308032.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C308032.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSum> getVideoSum() {
        return new RxLock<VideoSum>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                    public void onSuccess(VideoSum videoSum) {
                        C308233.this.setData(videoSum);
                    }

                    public void onFailure(AutelError autelError) {
                        C308233.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getLeftPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getLeftPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C308434.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C308434.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C308635.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C308635.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C308836.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C308836.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C309037.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C309037.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C309238.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C309238.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C309439.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C309439.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C309840.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C309840.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C310041.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C310041.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C310242.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C310242.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C310443.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C310443.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C310644.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C310644.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C310845.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C310845.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoEncodeFormat(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C311046.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C311046.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncodeFormat> getVideoEncodeFormat() {
        return new RxLock<VideoEncodeFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    public void onSuccess(VideoEncodeFormat videoEncodeFormat) {
                        C311247.this.setData(videoEncodeFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C311247.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoRotation(final VideoRotation videoRotation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setVideoRotation(videoRotation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C311448.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C311448.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoRotation> getVideoRotation() {
        return new RxLock<VideoRotation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getVideoRotation(new CallbackWithOneParam<VideoRotation>() {
                    public void onSuccess(VideoRotation videoRotation) {
                        C311649.this.setData(videoRotation);
                    }

                    public void onFailure(AutelError autelError) {
                        C311649.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RealTimeVideoResolution> getRealTimeVideoResolution() {
        return new RxLock<RealTimeVideoResolution>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getRealTimeVideoResolution(new CallbackWithOneParam<RealTimeVideoResolution>() {
                    public void onSuccess(RealTimeVideoResolution realTimeVideoResolution) {
                        C312050.this.setData(realTimeVideoResolution);
                    }

                    public void onFailure(AutelError autelError) {
                        C312050.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setRealTimeVideoResolution(final RealTimeVideoResolution realTimeVideoResolution) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setRealTimeVideoResolution(realTimeVideoResolution, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C312251.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C312251.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPIVMode(final PIVMode pIVMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setPIVMode(pIVMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C312452.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C312452.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PIVMode> getPIVMode() {
        return new RxLock<PIVMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    public void onSuccess(PIVMode pIVMode) {
                        C312653.this.setData(pIVMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C312653.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C312854.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C312854.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSnapshotTimelapseInterval> getAutoPIVTimelapseInterval() {
        return new RxLock<VideoSnapshotTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getAutoPIVTimelapseInterval(new CallbackWithOneParam<VideoSnapshotTimelapseInterval>() {
                    public void onSuccess(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
                        C313055.this.setData(videoSnapshotTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C313055.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> switchToPreviousMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.switchToPreviousPhotoMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C313256.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C313256.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTrackingModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.setTrackingModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C313457.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C313457.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SkylinePositionData> getSkylinePositionData(final int i, final int i2) {
        return new RxLock<SkylinePositionData>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXB015Impl.this.mAutelXB015.getSkylinePositionData(i, i2, new CallbackWithOneParam<SkylinePositionData>() {
                    public void onSuccess(SkylinePositionData skylinePositionData) {
                        C313658.this.setData(skylinePositionData);
                    }

                    public void onFailure(AutelError autelError) {
                        C313658.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<XB015ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XB015ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XB015ParameterRangeManager parameterRangeManager = RxAutelXB015Impl.this.mAutelXB015.getParameterRangeManager();
                if (parameterRangeManager != null) {
                    setData(parameterRangeManager);
                } else {
                    setException(AutelError.COMMAND_FAILED);
                }
            }
        }.fire();
    }
}
