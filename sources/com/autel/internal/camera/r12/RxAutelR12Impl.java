package com.autel.internal.camera.r12;

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
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.r12.R12CameraInfo;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.RxAutelBaseCameraImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.camera.AutelR12;
import com.autel.sdk.camera.p005rx.RxAutelR12;
import io.reactivex.Observable;

public class RxAutelR12Impl extends RxAutelBaseCameraImpl implements RxAutelR12 {
    /* access modifiers changed from: private */
    public AutelR12 mAutelR12;

    public RxAutelR12Impl(AutelR12 autelR12) {
        super(autelR12);
        this.mAutelR12 = autelR12;
    }

    public void setInfoListener(CallbackWithOneParam<R12CameraInfo> callbackWithOneParam) {
        this.mAutelR12.setInfoListener(callbackWithOneParam);
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.mAutelR12.setHistogramListener(callbackWithOneParam);
    }

    public Observable<Boolean> setSpotMeteringArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C28971.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C28971.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C29192.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C29192.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C29413.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C29413.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C29634.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C29634.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C29825.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C29825.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C29846.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C29846.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C29867.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C29867.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C29888.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C29888.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C29909.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C29909.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C289910.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C289910.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C290111.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C290111.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C290312.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C290312.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> set3DNoiseReductionEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C290513.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C290513.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> is3DNoiseReductionEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.is3DNoiseReductionEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C290714.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C290714.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C290915.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C290915.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C291116.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C291116.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C291317.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C291317.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C291518.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C291518.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.isHistogramEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C291719.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C291719.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C292120.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C292120.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C292321.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C292321.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C292522.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C292522.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C292723.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C292723.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C292924.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C292924.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C293125.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C293125.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C293326.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C293326.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C293527.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C293527.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C293728.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C293728.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C293929.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C293929.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C294330.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C294330.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C294531.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C294531.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C294732.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C294732.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Long> getRemainRecordTime() {
        return new RxLock<Long>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getLeftRecordTime(new CallbackWithOneParam<Long>() {
                    public void onSuccess(Long l) {
                        C294933.this.setData(l);
                    }

                    public void onFailure(AutelError autelError) {
                        C294933.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C295134.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C295134.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C295335.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C295335.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C295536.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C295536.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C295737.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C295737.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C295938.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C295938.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C296139.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C296139.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C296540.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C296540.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C296741.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C296741.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C296942.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C296942.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C297143.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C297143.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C297344.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C297344.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C297545.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C297545.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C297746.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C297746.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelR12Impl.this.mAutelR12.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C297947.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C297947.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<R12ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<R12ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                R12ParameterRangeManager parameterRangeManager = RxAutelR12Impl.this.mAutelR12.getParameterRangeManager();
                if (parameterRangeManager == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }
}
