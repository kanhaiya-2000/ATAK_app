package com.autel.internal.camera.xbbasic.xt709;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrImageModeParam;
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
import com.autel.common.camera.media.IrEnhanceParam;
import com.autel.common.camera.media.IrGainMode;
import com.autel.common.camera.media.IrIsoThermMode;
import com.autel.common.camera.media.IrThresholdParam;
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
import com.autel.sdk.camera.AutelXT709;
import com.autel.sdk.camera.p005rx.RxAutelXT709;
import io.reactivex.Observable;
import java.util.List;

public class RxAutelXT709Impl extends RxAutelBaseCameraImpl implements RxAutelXT709 {
    AutelXT709 autelXT709;

    public RxAutelXT709Impl(AutelXT709 autelXT7092) {
        super(autelXT7092);
        this.autelXT709 = autelXT7092;
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.autelXT709.setHistogramListener(callbackWithOneParam);
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.autelXT709.setAutoFocusStateListener(callbackWithTwoParams);
    }

    public Observable<Boolean> setSpotMeteringArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C40091.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C40091.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C40472.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C40472.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C40693.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C40693.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C40914.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C40914.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C41135.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C41135.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C41356.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C41356.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C41577.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C41577.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C41788.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C41788.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> set3DNoiseReductionEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C42009.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C42009.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C401110.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C401110.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C402311.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C402311.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C403112.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C403112.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C403313.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C403313.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C403514.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C403514.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C403715.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C403715.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C403916.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C403916.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C404117.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C404117.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C404318.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C404318.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C404519.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C404519.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C404920.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C404920.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C405121.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C405121.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C405322.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C405322.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C405523.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C405523.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C405724.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C405724.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<LensFocusMode> getFocusMode() {
        return new RxLock<LensFocusMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getFocusMode(new CallbackWithOneParam<LensFocusMode>() {
                    public void onSuccess(LensFocusMode lensFocusMode) {
                        C405925.this.setData(lensFocusMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C405925.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusMode(final LensFocusMode lensFocusMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setFocusMode(lensFocusMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C406126.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C406126.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C406327.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C406327.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getFocusDistance() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getFocusDistance(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C406528.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C406528.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusDistance(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setFocusDistance(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C406729.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C406729.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C407130.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C407130.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C407331.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C407331.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAutoFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoAutoFocusMeter(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C407532.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C407532.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setManualFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setFocusMFSpotArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C407733.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C407733.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startTakePhotoWithFocus() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.startTakePhotoWithFocus(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C407934.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C407934.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C408135.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C408135.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C408336.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C408336.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C408537.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C408537.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C408738.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C408738.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C408939.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C408939.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C409340.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C409340.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSum> getVideoSum() {
        return new RxLock<VideoSum>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                    public void onSuccess(VideoSum videoSum) {
                        C409541.this.setData(videoSum);
                    }

                    public void onFailure(AutelError autelError) {
                        C409541.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getLeftPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getLeftPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C409742.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C409742.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C409943.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C409943.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C410144.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C410144.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C410345.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C410345.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C410546.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C410546.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C410747.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C410747.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C410948.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C410948.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C411149.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C411149.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C411550.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C411550.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C411751.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C411751.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C411952.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C411952.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C412153.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C412153.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncoder(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoEncoder(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C412354.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C412354.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return new RxLock<VideoEncoderConfiguration>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoEncoderConfiguration(new CallbackWithOneParam<VideoEncoderConfiguration>() {
                    public void onSuccess(VideoEncoderConfiguration videoEncoderConfiguration) {
                        C412555.this.setData(videoEncoderConfiguration);
                    }

                    public void onFailure(AutelError autelError) {
                        C412555.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoRotation(final VideoRotation videoRotation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoRotation(videoRotation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C412756.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C412756.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoRotation> getVideoRotation() {
        return new RxLock<VideoRotation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoRotation(new CallbackWithOneParam<VideoRotation>() {
                    public void onSuccess(VideoRotation videoRotation) {
                        C412957.this.setData(videoRotation);
                    }

                    public void onFailure(AutelError autelError) {
                        C412957.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutterMode(final ShutterMode shutterMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setShutterMode(shutterMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C413158.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C413158.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterMode> getShutterMode() {
        return new RxLock<ShutterMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
                    public void onSuccess(ShutterMode shutterMode) {
                        C413359.this.setData(shutterMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C413359.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C413760.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C413760.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getAFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getAFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C413961.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C413961.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setMFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C414162.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C414162.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getMFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getMFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C414363.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C414363.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPIVMode(final PIVMode pIVMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setPIVMode(pIVMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C414564.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C414564.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PIVMode> getPIVMode() {
        return new RxLock<PIVMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    public void onSuccess(PIVMode pIVMode) {
                        C414765.this.setData(pIVMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C414765.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C414966.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C414966.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> switchToPreviousMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.switchToPreviousPhotoMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C415167.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C415167.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTrackingModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setTrackingModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C415368.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C415368.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SkylinePositionData> getSkylinePositionData(final int i, final int i2) {
        return new RxLock<SkylinePositionData>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getSkylinePositionData(i, i2, new CallbackWithOneParam<SkylinePositionData>() {
                    public void onSuccess(SkylinePositionData skylinePositionData) {
                        C415569.this.setData(skylinePositionData);
                    }

                    public void onFailure(AutelError autelError) {
                        C415569.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setVideoEncodeFormat(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C415970.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C415970.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncodeFormat> getVideoEncodeFormat() {
        return new RxLock<VideoEncodeFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    public void onSuccess(VideoEncodeFormat videoEncodeFormat) {
                        C416171.this.setData(videoEncodeFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C416171.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getFocusAFSpotArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getFocusAFSpotArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C416372.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C416372.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SaveLocation> getAlbumLocation() {
        return new RxLock<SaveLocation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getAlbumLocation(new CallbackWithOneParam<SaveLocation>() {
                    public void onSuccess(SaveLocation saveLocation) {
                        C416573.this.setData(saveLocation);
                    }

                    public void onFailure(AutelError autelError) {
                        C416573.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAlbumSaveLocation(final SaveLocation saveLocation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setAlbumSaveLocation(saveLocation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C416774.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C416774.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> formatFlashMemoryCard() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.formatFlashMemoryCard(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C416975.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C416975.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<FlashCardStatus> getFMCStatus() {
        return new RxLock<FlashCardStatus>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getFMCStatus(new CallbackWithOneParam<FlashCardStatus>() {
                    public void onSuccess(FlashCardStatus flashCardStatus) {
                        C417176.this.setData(flashCardStatus);
                    }

                    public void onFailure(AutelError autelError) {
                        C417176.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<XT706ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XT706ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XT706ParameterRangeManager parameterRangeManager = RxAutelXT709Impl.this.autelXT709.getParameterRangeManager();
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
                RxAutelXT709Impl.this.autelXT709.getDisplayMode(new CallbackWithOneParam<DisplayMode>() {
                    public void onSuccess(DisplayMode displayMode) {
                        C417478.this.setData(displayMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C417478.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDisplayMode(final DisplayMode displayMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setDisplayMode(displayMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C417679.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C417679.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrColor> getIrColor() {
        return new RxLock<IrColor>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrColor(new CallbackWithOneParam<IrColor>() {
                    public void onSuccess(IrColor irColor) {
                        C418080.this.setData(irColor);
                    }

                    public void onFailure(AutelError autelError) {
                        C418080.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrColor(final IrColor irColor) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrColor(irColor, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C418281.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C418281.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrPosition> getIrPosition() {
        return new RxLock<IrPosition>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrPosition(new CallbackWithOneParam<IrPosition>() {
                    public void onSuccess(IrPosition irPosition) {
                        C418482.this.setData(irPosition);
                    }

                    public void onFailure(AutelError autelError) {
                        C418482.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrPosition(final IrPosition irPosition) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrPosition(irPosition, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C418683.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C418683.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureParams(final IrTemperatureParams irTemperatureParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrTemperatureParams(irTemperatureParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C418884.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C418884.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrTemperatureParams> getIrTemperatureParams() {
        return new RxLock<IrTemperatureParams>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrTemperatureParams(new CallbackWithOneParam<IrTemperatureParams>() {
                    public void onSuccess(IrTemperatureParams irTemperatureParams) {
                        C419085.this.setData(irTemperatureParams);
                    }

                    public void onFailure(AutelError autelError) {
                        C419085.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureWarningParams(final IrTemperatureWarnParams irTemperatureWarnParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrTemperatureWarningParams(irTemperatureWarnParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C419286.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C419286.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrTemperatureWarnParams> getIrTemperatureWarningParams() {
        return new RxLock<IrTemperatureWarnParams>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrTemperatureWarningParams(new CallbackWithOneParam<IrTemperatureWarnParams>() {
                    public void onSuccess(IrTemperatureWarnParams irTemperatureWarnParams) {
                        C419487.this.setData(irTemperatureWarnParams);
                    }

                    public void onFailure(AutelError autelError) {
                        C419487.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrFlushShutter() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrFlushShutter(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C419688.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C419688.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrTemperatureEmit(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrTemperatureEmit(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C419889.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C419889.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getIrTemperatureEmit() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrTemperatureEmit(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C420290.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C420290.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setHDREnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setHDREnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C420491.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C420491.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getHDREnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getHDREnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C420692.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C420692.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotInterval(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setMotionDelayShotInterval(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C420893.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C420893.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotInterval() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getMotionDelayShotInterval(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C421094.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C421094.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotDuration(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setMotionDelayShotDuration(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C421295.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C421295.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotDuration() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getMotionDelayShotDuration(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C421496.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C421496.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotKeepPhoto(final RawFormat rawFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setMotionDelayShotKeepPhoto(rawFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C421697.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C421697.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MotionPhotoInfo> getMotionDelayShotKeepPhoto() {
        return new RxLock<MotionPhotoInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getMotionDelayShotKeepPhoto(new CallbackWithOneParam<MotionPhotoInfo>() {
                    public void onSuccess(MotionPhotoInfo motionPhotoInfo) {
                        C421898.this.setData(motionPhotoInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C421898.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setDeFogEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C422099.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C422099.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setDeFogStrength(i, new CallbackWithNoParam() {
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
                RxAutelXT709Impl.this.autelXT709.getDeFogParams(new CallbackWithOneParam<DeFogParam>() {
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
                RxAutelXT709Impl.this.autelXT709.setImageRoiEnable(z, new CallbackWithNoParam() {
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
                RxAutelXT709Impl.this.autelXT709.setImageRoiStrength(i, new CallbackWithNoParam() {
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
                RxAutelXT709Impl.this.autelXT709.setImageRoiArea(i, i2, new CallbackWithNoParam() {
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
                RxAutelXT709Impl.this.autelXT709.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
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

    public Observable<Boolean> setIrImageMode(final ImageMode imageMode, final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrImageMode(imageMode, i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass106.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass106.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrImageModeParam> getIrImageMode() {
        return new RxLock<IrImageModeParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrImageMode(new CallbackWithOneParam<IrImageModeParam>() {
                    public void onSuccess(IrImageModeParam irImageModeParam) {
                        AnonymousClass107.this.setData(irImageModeParam);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass107.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrEnhance(final boolean z, final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrEnhance(z, i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass108.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass108.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrEnhanceParam> getIrEnhance() {
        return new RxLock<IrEnhanceParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrEnhance(new CallbackWithOneParam<IrEnhanceParam>() {
                    public void onSuccess(IrEnhanceParam irEnhanceParam) {
                        AnonymousClass109.this.setData(irEnhanceParam);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass109.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrDeNoise(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrDeNoise(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass110.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass110.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getIrDeNoise() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrDeNoise(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        AnonymousClass111.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass111.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrGain(final IrGainMode irGainMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrGain(irGainMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass112.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass112.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrGainMode> getIrGain() {
        return new RxLock<IrGainMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrGain(new CallbackWithOneParam<IrGainMode>() {
                    public void onSuccess(IrGainMode irGainMode) {
                        AnonymousClass113.this.setData(irGainMode);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass113.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setIrIsoTherm(final IrIsoThermMode irIsoThermMode, final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.setIrIsoTherm(irIsoThermMode, i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        AnonymousClass114.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass114.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<IrThresholdParam> getIrIsoTherm() {
        return new RxLock<IrThresholdParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT709Impl.this.autelXT709.getIrIsoTherm(new CallbackWithOneParam<IrThresholdParam>() {
                    public void onSuccess(IrThresholdParam irThresholdParam) {
                        AnonymousClass115.this.setData(irThresholdParam);
                    }

                    public void onFailure(AutelError autelError) {
                        AnonymousClass115.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
