package com.autel.internal.camera.xbbasic.xt701;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT701.XT701ParameterRangeManager;
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
import com.autel.sdk.camera.AutelXT701;
import com.autel.sdk.camera.p005rx.RxAutelXT701;
import io.reactivex.Observable;
import java.util.List;

public class RxAutelXT701Impl extends RxAutelBaseCameraImpl implements RxAutelXT701 {
    AutelXT701 autelXT701;

    public RxAutelXT701Impl(AutelXT701 autelXT7012) {
        super(autelXT7012);
        this.autelXT701 = autelXT7012;
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.autelXT701.setHistogramListener(callbackWithOneParam);
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.autelXT701.setAutoFocusStateListener(callbackWithTwoParams);
    }

    public Observable<Boolean> setSpotMeteringArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C32151.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C32151.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C32372.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C32372.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C32593.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C32593.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C32814.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C32814.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C33035.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C33035.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C33256.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C33256.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C33477.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C33477.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C33698.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C33698.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> set3DNoiseReductionEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C33919.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C33919.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C321710.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C321710.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C321911.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C321911.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C322112.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C322112.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C322313.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C322313.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C322514.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C322514.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C322715.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C322715.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C322916.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C322916.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C323117.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C323117.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C323318.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C323318.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C323519.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C323519.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C323920.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C323920.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C324121.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C324121.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C324322.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C324322.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C324523.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C324523.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C324724.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C324724.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<LensFocusMode> getFocusMode() {
        return new RxLock<LensFocusMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getFocusMode(new CallbackWithOneParam<LensFocusMode>() {
                    public void onSuccess(LensFocusMode lensFocusMode) {
                        C324925.this.setData(lensFocusMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C324925.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusMode(final LensFocusMode lensFocusMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setFocusMode(lensFocusMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C325126.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C325126.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C325327.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C325327.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getFocusDistance() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getFocusDistance(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C325528.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C325528.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusDistance(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setFocusDistance(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C325729.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C325729.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C326130.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C326130.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C326331.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C326331.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAutoFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoAutoFocusMeter(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C326532.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C326532.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setManualFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setFocusMFSpotArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C326733.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C326733.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startTakePhotoWithFocus() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.startTakePhotoWithFocus(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C326934.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C326934.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C327135.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C327135.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C327336.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C327336.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C327537.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C327537.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C327738.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C327738.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C327939.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C327939.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C328340.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C328340.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSum> getVideoSum() {
        return new RxLock<VideoSum>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                    public void onSuccess(VideoSum videoSum) {
                        C328541.this.setData(videoSum);
                    }

                    public void onFailure(AutelError autelError) {
                        C328541.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getLeftPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getLeftPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C328742.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C328742.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C328943.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C328943.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C329144.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C329144.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C329345.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C329345.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C329546.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C329546.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C329747.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C329747.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C329948.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C329948.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C330149.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C330149.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C330550.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C330550.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C330751.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C330751.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C330952.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C330952.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C331153.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C331153.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncoder(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoEncoder(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C331354.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C331354.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return new RxLock<VideoEncoderConfiguration>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoEncoderConfiguration(new CallbackWithOneParam<VideoEncoderConfiguration>() {
                    public void onSuccess(VideoEncoderConfiguration videoEncoderConfiguration) {
                        C331555.this.setData(videoEncoderConfiguration);
                    }

                    public void onFailure(AutelError autelError) {
                        C331555.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoRotation(final VideoRotation videoRotation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoRotation(videoRotation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C331756.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C331756.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoRotation> getVideoRotation() {
        return new RxLock<VideoRotation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoRotation(new CallbackWithOneParam<VideoRotation>() {
                    public void onSuccess(VideoRotation videoRotation) {
                        C331957.this.setData(videoRotation);
                    }

                    public void onFailure(AutelError autelError) {
                        C331957.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutterMode(final ShutterMode shutterMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setShutterMode(shutterMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C332158.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C332158.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterMode> getShutterMode() {
        return new RxLock<ShutterMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
                    public void onSuccess(ShutterMode shutterMode) {
                        C332359.this.setData(shutterMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C332359.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C332760.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C332760.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getAFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getAFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C332961.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C332961.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setMFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C333162.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C333162.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getMFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getMFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C333363.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C333363.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPIVMode(final PIVMode pIVMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setPIVMode(pIVMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C333564.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C333564.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PIVMode> getPIVMode() {
        return new RxLock<PIVMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    public void onSuccess(PIVMode pIVMode) {
                        C333765.this.setData(pIVMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C333765.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C333966.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C333966.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> switchToPreviousMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.switchToPreviousPhotoMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C334167.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C334167.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTrackingModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setTrackingModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C334368.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C334368.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SkylinePositionData> getSkylinePositionData(final int i, final int i2) {
        return new RxLock<SkylinePositionData>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getSkylinePositionData(i, i2, new CallbackWithOneParam<SkylinePositionData>() {
                    public void onSuccess(SkylinePositionData skylinePositionData) {
                        C334569.this.setData(skylinePositionData);
                    }

                    public void onFailure(AutelError autelError) {
                        C334569.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setVideoEncodeFormat(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C334970.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C334970.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncodeFormat> getVideoEncodeFormat() {
        return new RxLock<VideoEncodeFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    public void onSuccess(VideoEncodeFormat videoEncodeFormat) {
                        C335171.this.setData(videoEncodeFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C335171.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getFocusAFSpotArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getFocusAFSpotArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C335372.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C335372.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SaveLocation> getAlbumLocation() {
        return new RxLock<SaveLocation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getAlbumLocation(new CallbackWithOneParam<SaveLocation>() {
                    public void onSuccess(SaveLocation saveLocation) {
                        C335573.this.setData(saveLocation);
                    }

                    public void onFailure(AutelError autelError) {
                        C335573.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAlbumSaveLocation(final SaveLocation saveLocation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setAlbumSaveLocation(saveLocation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C335774.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C335774.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> formatFlashMemoryCard() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.formatFlashMemoryCard(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C335975.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C335975.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<FlashCardStatus> getFMCStatus() {
        return new RxLock<FlashCardStatus>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getFMCStatus(new CallbackWithOneParam<FlashCardStatus>() {
                    public void onSuccess(FlashCardStatus flashCardStatus) {
                        C336176.this.setData(flashCardStatus);
                    }

                    public void onFailure(AutelError autelError) {
                        C336176.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setHDREnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setHDREnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C336377.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C336377.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getHDREnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getHDREnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C336578.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C336578.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setDeFogEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C336779.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C336779.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setDeFogStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C337180.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C337180.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<DeFogParam> getDeFogParams() {
        return new RxLock<DeFogParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getDeFogParams(new CallbackWithOneParam<DeFogParam>() {
                    public void onSuccess(DeFogParam deFogParam) {
                        C337381.this.setData(deFogParam);
                    }

                    public void onFailure(AutelError autelError) {
                        C337381.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setImageRoiEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C337582.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C337582.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setImageRoiStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C337783.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C337783.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setImageRoiArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C337984.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C337984.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ImageRoiParam> getImageRoiParams() {
        return new RxLock<ImageRoiParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
                    public void onSuccess(ImageRoiParam imageRoiParam) {
                        C338185.this.setData(imageRoiParam);
                    }

                    public void onFailure(AutelError autelError) {
                        C338185.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotInterval(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setMotionDelayShotInterval(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C338386.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C338386.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotInterval() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getMotionDelayShotInterval(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C338587.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C338587.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotDuration(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setMotionDelayShotDuration(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C338788.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C338788.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotDuration() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getMotionDelayShotDuration(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C338989.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C338989.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotKeepPhoto(final RawFormat rawFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.setMotionDelayShotKeepPhoto(rawFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C339390.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C339390.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MotionPhotoInfo> getMotionDelayShotKeepPhoto() {
        return new RxLock<MotionPhotoInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT701Impl.this.autelXT701.getMotionDelayShotKeepPhoto(new CallbackWithOneParam<MotionPhotoInfo>() {
                    public void onSuccess(MotionPhotoInfo motionPhotoInfo) {
                        C339591.this.setData(motionPhotoInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C339591.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<XT701ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XT701ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XT701ParameterRangeManager parameterRangeManager = RxAutelXT701Impl.this.autelXT701.getParameterRangeManager();
                if (parameterRangeManager != null) {
                    setData(parameterRangeManager);
                } else {
                    setException(AutelError.COMMAND_FAILED);
                }
            }
        }.fire();
    }
}
