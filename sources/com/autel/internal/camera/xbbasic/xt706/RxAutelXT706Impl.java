package com.autel.internal.camera.xbbasic.xt706;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.XT706.XT706ParameterRangeManager;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
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
import com.autel.common.error.AutelError;
import com.autel.internal.camera.RxAutelBaseCameraImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.camera.AutelXT706;
import com.autel.sdk.camera.p005rx.RxAutelXT706;
import io.reactivex.Observable;
import java.util.List;

public class RxAutelXT706Impl extends RxAutelBaseCameraImpl implements RxAutelXT706 {
    AutelXT706 autelXT706;

    public RxAutelXT706Impl(AutelXT706 autelXT7062) {
        super(autelXT7062);
        this.autelXT706 = autelXT7062;
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.autelXT706.setHistogramListener(callbackWithOneParam);
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.autelXT706.setAutoFocusStateListener(callbackWithTwoParams);
    }

    public Observable<Boolean> setSpotMeteringArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C37291.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C37291.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C37572.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C37572.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C37793.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C37793.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C38014.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C38014.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C38235.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C38235.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C38456.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C38456.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C38677.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C38677.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C38888.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C38888.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> set3DNoiseReductionEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C39109.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C39109.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C373110.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C373110.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C373911.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C373911.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C374112.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C374112.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C374313.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C374313.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C374514.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C374514.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C374715.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C374715.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C374916.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C374916.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C375117.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C375117.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C375318.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C375318.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C375519.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C375519.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C375920.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C375920.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C376121.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C376121.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C376322.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C376322.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C376523.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C376523.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C376724.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C376724.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<LensFocusMode> getFocusMode() {
        return new RxLock<LensFocusMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getFocusMode(new CallbackWithOneParam<LensFocusMode>() {
                    public void onSuccess(LensFocusMode lensFocusMode) {
                        C376925.this.setData(lensFocusMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C376925.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusMode(final LensFocusMode lensFocusMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setFocusMode(lensFocusMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C377126.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C377126.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C377327.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C377327.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getFocusDistance() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getFocusDistance(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C377528.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C377528.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusDistance(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setFocusDistance(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C377729.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C377729.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C378130.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C378130.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C378331.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C378331.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAutoFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoAutoFocusMeter(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C378532.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C378532.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setManualFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setFocusMFSpotArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C378733.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C378733.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startTakePhotoWithFocus() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.startTakePhotoWithFocus(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C378934.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C378934.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C379135.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C379135.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C379336.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C379336.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C379537.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C379537.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C379738.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C379738.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C379939.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C379939.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C380340.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C380340.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSum> getVideoSum() {
        return new RxLock<VideoSum>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                    public void onSuccess(VideoSum videoSum) {
                        C380541.this.setData(videoSum);
                    }

                    public void onFailure(AutelError autelError) {
                        C380541.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getLeftPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getLeftPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C380742.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C380742.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C380943.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C380943.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C381144.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C381144.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C381345.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C381345.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C381546.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C381546.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C381747.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C381747.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C381948.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C381948.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C382149.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C382149.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C382550.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C382550.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C382751.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C382751.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C382952.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C382952.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C383153.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C383153.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncoder(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoEncoder(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C383354.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C383354.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return new RxLock<VideoEncoderConfiguration>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoEncoderConfiguration(new CallbackWithOneParam<VideoEncoderConfiguration>() {
                    public void onSuccess(VideoEncoderConfiguration videoEncoderConfiguration) {
                        C383555.this.setData(videoEncoderConfiguration);
                    }

                    public void onFailure(AutelError autelError) {
                        C383555.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoRotation(final VideoRotation videoRotation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoRotation(videoRotation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C383756.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C383756.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoRotation> getVideoRotation() {
        return new RxLock<VideoRotation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoRotation(new CallbackWithOneParam<VideoRotation>() {
                    public void onSuccess(VideoRotation videoRotation) {
                        C383957.this.setData(videoRotation);
                    }

                    public void onFailure(AutelError autelError) {
                        C383957.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutterMode(final ShutterMode shutterMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setShutterMode(shutterMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C384158.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C384158.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterMode> getShutterMode() {
        return new RxLock<ShutterMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
                    public void onSuccess(ShutterMode shutterMode) {
                        C384359.this.setData(shutterMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C384359.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C384760.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C384760.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getAFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getAFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C384961.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C384961.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setMFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C385162.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C385162.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getMFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getMFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C385363.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C385363.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPIVMode(final PIVMode pIVMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setPIVMode(pIVMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C385564.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C385564.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PIVMode> getPIVMode() {
        return new RxLock<PIVMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    public void onSuccess(PIVMode pIVMode) {
                        C385765.this.setData(pIVMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C385765.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C385966.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C385966.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> switchToPreviousMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.switchToPreviousPhotoMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C386167.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C386167.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTrackingModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setTrackingModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C386368.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C386368.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SkylinePositionData> getSkylinePositionData(final int i, final int i2) {
        return new RxLock<SkylinePositionData>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getSkylinePositionData(i, i2, new CallbackWithOneParam<SkylinePositionData>() {
                    public void onSuccess(SkylinePositionData skylinePositionData) {
                        C386569.this.setData(skylinePositionData);
                    }

                    public void onFailure(AutelError autelError) {
                        C386569.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setVideoEncodeFormat(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C386970.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C386970.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncodeFormat> getVideoEncodeFormat() {
        return new RxLock<VideoEncodeFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    public void onSuccess(VideoEncodeFormat videoEncodeFormat) {
                        C387171.this.setData(videoEncodeFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C387171.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getFocusAFSpotArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getFocusAFSpotArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C387372.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C387372.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SaveLocation> getAlbumLocation() {
        return new RxLock<SaveLocation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getAlbumLocation(new CallbackWithOneParam<SaveLocation>() {
                    public void onSuccess(SaveLocation saveLocation) {
                        C387573.this.setData(saveLocation);
                    }

                    public void onFailure(AutelError autelError) {
                        C387573.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAlbumSaveLocation(final SaveLocation saveLocation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setAlbumSaveLocation(saveLocation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C387774.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C387774.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> formatFlashMemoryCard() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.formatFlashMemoryCard(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C387975.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C387975.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<FlashCardStatus> getFMCStatus() {
        return new RxLock<FlashCardStatus>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getFMCStatus(new CallbackWithOneParam<FlashCardStatus>() {
                    public void onSuccess(FlashCardStatus flashCardStatus) {
                        C388176.this.setData(flashCardStatus);
                    }

                    public void onFailure(AutelError autelError) {
                        C388176.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<XT706ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XT706ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XT706ParameterRangeManager parameterRangeManager = RxAutelXT706Impl.this.autelXT706.getParameterRangeManager();
                if (parameterRangeManager != null) {
                    setData(parameterRangeManager);
                } else {
                    setException(AutelError.COMMAND_FAILED);
                }
            }
        }.fire();
    }

    public Observable<DisplayMode> getDisplayMode() {
        return new RxLock<DisplayMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getDisplayMode(new CallbackWithOneParam<DisplayMode>() {
                    public void onSuccess(DisplayMode displayMode) {
                        C388478.this.setData(displayMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C388478.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDisplayMode(final DisplayMode displayMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setDisplayMode(displayMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C388679.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C388679.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrColor> getIrColor() {
        return new RxLock<IrColor>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getIrColor(new CallbackWithOneParam<IrColor>() {
                    public void onSuccess(IrColor irColor) {
                        C389080.this.setData(irColor);
                    }

                    public void onFailure(AutelError autelError) {
                        C389080.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrColor(final IrColor irColor) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrColor(irColor, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C389281.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C389281.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrPosition> getIrPosition() {
        return new RxLock<IrPosition>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getIrPosition(new CallbackWithOneParam<IrPosition>() {
                    public void onSuccess(IrPosition irPosition) {
                        C389482.this.setData(irPosition);
                    }

                    public void onFailure(AutelError autelError) {
                        C389482.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrPosition(final IrPosition irPosition) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrPosition(irPosition, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C389683.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C389683.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureParams(final IrTemperatureParams irTemperatureParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrTemperatureParams(irTemperatureParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C389884.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C389884.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrTemperatureParams> getIrTemperatureParams() {
        return new RxLock<IrTemperatureParams>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getIrTemperatureParams(new CallbackWithOneParam<IrTemperatureParams>() {
                    public void onSuccess(IrTemperatureParams irTemperatureParams) {
                        C390085.this.setData(irTemperatureParams);
                    }

                    public void onFailure(AutelError autelError) {
                        C390085.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureWarningParams(final IrTemperatureWarnParams irTemperatureWarnParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrTemperatureWarningParams(irTemperatureWarnParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C390286.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C390286.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrTemperatureWarnParams> getIrTemperatureWarningParams() {
        return new RxLock<IrTemperatureWarnParams>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getIrTemperatureWarningParams(new CallbackWithOneParam<IrTemperatureWarnParams>() {
                    public void onSuccess(IrTemperatureWarnParams irTemperatureWarnParams) {
                        C390487.this.setData(irTemperatureWarnParams);
                    }

                    public void onFailure(AutelError autelError) {
                        C390487.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrFlushShutter() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrFlushShutter(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C390688.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C390688.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureEmit(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setIrTemperatureEmit(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C390889.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C390889.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getIrTemperatureEmit() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getIrTemperatureEmit(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C391290.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C391290.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setHDREnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setHDREnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C391491.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C391491.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getHDREnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getHDREnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C391692.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C391692.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotInterval(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setMotionDelayShotInterval(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C391893.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C391893.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotInterval() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getMotionDelayShotInterval(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C392094.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C392094.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotDuration(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setMotionDelayShotDuration(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C392295.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C392295.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotDuration() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getMotionDelayShotDuration(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C392496.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C392496.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotKeepPhoto(final RawFormat rawFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setMotionDelayShotKeepPhoto(rawFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C392697.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C392697.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MotionPhotoInfo> getMotionDelayShotKeepPhoto() {
        return new RxLock<MotionPhotoInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getMotionDelayShotKeepPhoto(new CallbackWithOneParam<MotionPhotoInfo>() {
                    public void onSuccess(MotionPhotoInfo motionPhotoInfo) {
                        C392898.this.setData(motionPhotoInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C392898.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setDeFogEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C393099.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C393099.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setDeFogStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass100.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass100.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<DeFogParam> getDeFogParams() {
        return new RxLock<DeFogParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getDeFogParams(new CallbackWithOneParam<DeFogParam>() {
                    public void onSuccess(DeFogParam deFogParam) {
                        AnonymousClass101.this.setData(deFogParam);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass101.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setImageRoiEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass102.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass102.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setImageRoiStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass103.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass103.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.setImageRoiArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass104.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass104.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ImageRoiParam> getImageRoiParams() {
        return new RxLock<ImageRoiParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT706Impl.this.autelXT706.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
                    public void onSuccess(ImageRoiParam imageRoiParam) {
                        AnonymousClass105.this.setData(imageRoiParam);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass105.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
