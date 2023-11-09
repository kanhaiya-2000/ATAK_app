package com.autel.internal.camera.xbbasic.xt705;

import com.autel.common.CallbackWithNoParam;
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
import com.autel.common.error.AutelError;
import com.autel.internal.camera.RxAutelBaseCameraImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.camera.AutelXT705;
import com.autel.sdk.camera.p005rx.RxAutelXT705;
import io.reactivex.Observable;
import java.util.List;

public class RxAutelXT705Impl extends RxAutelBaseCameraImpl implements RxAutelXT705 {
    AutelXT705 autelXT701;

    public RxAutelXT705Impl(AutelXT705 autelXT705) {
        super(autelXT705);
        this.autelXT701 = autelXT705;
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
                RxAutelXT705Impl.this.autelXT701.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C34661.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C34661.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoExposureLockState(final AutoExposureLockState autoExposureLockState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C34882.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C34882.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposure(final ExposureCompensation exposureCompensation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setExposure(exposureCompensation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C35103.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C35103.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setISO(final CameraISO cameraISO) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setISO(cameraISO, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C35324.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C35324.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutter(final ShutterSpeed shutterSpeed) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setShutter(shutterSpeed, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C35545.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C35545.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ColorStyle> getColorStyle() {
        return new RxLock<ColorStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getColorStyle(new CallbackWithOneParam<ColorStyle>() {
                    public void onSuccess(ColorStyle colorStyle) {
                        C35766.this.setData(colorStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C35766.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setWhiteBalance(final WhiteBalance whiteBalance) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C35987.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C35987.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setColorStyle(final ColorStyle colorStyle) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setColorStyle(colorStyle, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C36208.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C36208.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> set3DNoiseReductionEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C36429.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C36429.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAntiFlicker(final AntiFlicker antiFlicker) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C346810.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C346810.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AutoExposureLockState> getAutoExposureLockState() {
        return new RxLock<AutoExposureLockState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                    public void onSuccess(AutoExposureLockState autoExposureLockState) {
                        C347011.this.setData(autoExposureLockState);
                    }

                    public void onFailure(AutelError autelError) {
                        C347011.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getSpotMeteringArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getSpotMeteringArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C347212.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C347212.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<AntiFlicker> getAntiFlicker() {
        return new RxLock<AntiFlicker>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getAntiFlicker(new CallbackWithOneParam<AntiFlicker>() {
                    public void onSuccess(AntiFlicker antiFlicker) {
                        C347413.this.setData(antiFlicker);
                    }

                    public void onFailure(AutelError autelError) {
                        C347413.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WhiteBalance> getWhiteBalance() {
        return new RxLock<WhiteBalance>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getWhiteBalance(new CallbackWithOneParam<WhiteBalance>() {
                    public void onSuccess(WhiteBalance whiteBalance) {
                        C347614.this.setData(whiteBalance);
                    }

                    public void onFailure(AutelError autelError) {
                        C347614.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureCompensation> getExposure() {
        return new RxLock<ExposureCompensation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getExposure(new CallbackWithOneParam<ExposureCompensation>() {
                    public void onSuccess(ExposureCompensation exposureCompensation) {
                        C347815.this.setData(exposureCompensation);
                    }

                    public void onFailure(AutelError autelError) {
                        C347815.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterSpeed> getShutter() {
        return new RxLock<ShutterSpeed>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getShutter(new CallbackWithOneParam<ShutterSpeed>() {
                    public void onSuccess(ShutterSpeed shutterSpeed) {
                        C348016.this.setData(shutterSpeed);
                    }

                    public void onFailure(AutelError autelError) {
                        C348016.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraISO> getISO() {
        return new RxLock<CameraISO>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getISO(new CallbackWithOneParam<CameraISO>() {
                    public void onSuccess(CameraISO cameraISO) {
                        C348217.this.setData(cameraISO);
                    }

                    public void onFailure(AutelError autelError) {
                        C348217.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ExposureMode> getExposureMode() {
        return new RxLock<ExposureMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                    public void onSuccess(ExposureMode exposureMode) {
                        C348418.this.setData(exposureMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C348418.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final PhotoStyleType photoStyleType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C348619.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C348619.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoStyle(final int i, final int i2, final int i3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C349020.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C349020.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isHistogramStatusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C349221.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C349221.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoSubtitleEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C349422.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C349422.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isSubtitleEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C349623.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C349623.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoStyle> getPhotoStyle() {
        return new RxLock<PhotoStyle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
                    public void onSuccess(PhotoStyle photoStyle) {
                        C349824.this.setData(photoStyle);
                    }

                    public void onFailure(AutelError autelError) {
                        C349824.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setCameraAperture(final CameraAperture cameraAperture) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setCameraAperture(cameraAperture, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C350025.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C350025.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraAperture> getCameraAperture() {
        return new RxLock<CameraAperture>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getCameraAperture(new CallbackWithOneParam<CameraAperture>() {
                    public void onSuccess(CameraAperture cameraAperture) {
                        C350226.this.setData(cameraAperture);
                    }

                    public void onFailure(AutelError autelError) {
                        C350226.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<LensFocusMode> getFocusMode() {
        return new RxLock<LensFocusMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getFocusMode(new CallbackWithOneParam<LensFocusMode>() {
                    public void onSuccess(LensFocusMode lensFocusMode) {
                        C350427.this.setData(lensFocusMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C350427.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusMode(final LensFocusMode lensFocusMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setFocusMode(lensFocusMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C350628.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C350628.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setExposureMode(final ExposureMode exposureMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setExposureMode(exposureMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C350829.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C350829.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getFocusDistance() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getFocusDistance(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C351230.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C351230.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setFocusDistance(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setFocusDistance(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C351431.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C351431.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDigitalZoomScale() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C351632.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C351632.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDigitalZoomScale(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setDigitalZoomScale(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C351833.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C351833.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAutoFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoAutoFocusMeter(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C352034.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C352034.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setManualFocusMeter(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setFocusMFSpotArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C352235.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C352235.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startTakePhotoWithFocus() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.startTakePhotoWithFocus(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C352436.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C352436.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoBurstCount(final PhotoBurstCount photoBurstCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C352637.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C352637.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoTimelapseInterval(final PhotoTimelapseInterval photoTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C352838.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C352838.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoAEBCount(final PhotoAEBCount photoAEBCount) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C353039.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C353039.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAEBCount> getPhotoAEBCount() {
        return new RxLock<PhotoAEBCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
                    public void onSuccess(PhotoAEBCount photoAEBCount) {
                        C353440.this.setData(photoAEBCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C353440.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoBurstCount> getPhotoBurstCount() {
        return new RxLock<PhotoBurstCount>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    public void onSuccess(PhotoBurstCount photoBurstCount) {
                        C353641.this.setData(photoBurstCount);
                    }

                    public void onFailure(AutelError autelError) {
                        C353641.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoTimelapseInterval> getPhotoTimelapseInterval() {
        return new RxLock<PhotoTimelapseInterval>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
                    public void onSuccess(PhotoTimelapseInterval photoTimelapseInterval) {
                        C353842.this.setData(photoTimelapseInterval);
                    }

                    public void onFailure(AutelError autelError) {
                        C353842.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoSum> getVideoSum() {
        return new RxLock<VideoSum>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                    public void onSuccess(VideoSum videoSum) {
                        C354043.this.setData(videoSum);
                    }

                    public void onFailure(AutelError autelError) {
                        C354043.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getLeftPhotoSum() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getLeftPhotoSum(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C354244.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C354244.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getCurrentRecordTime() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getCurrentRecordTime(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C354445.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C354445.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoFormat> getVideoFormat() {
        return new RxLock<VideoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
                    public void onSuccess(VideoFormat videoFormat) {
                        C354646.this.setData(videoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C354646.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoFormat(final VideoFormat videoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C354847.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C354847.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoStandard> getVideoStandard() {
        return new RxLock<VideoStandard>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    public void onSuccess(VideoStandard videoStandard) {
                        C355048.this.setData(videoStandard);
                    }

                    public void onFailure(AutelError autelError) {
                        C355048.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoStandard(final VideoStandard videoStandard) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoStandard(videoStandard, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C355249.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C355249.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoFormat> getPhotoFormat() {
        return new RxLock<PhotoFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
                    public void onSuccess(PhotoFormat photoFormat) {
                        C355650.this.setData(photoFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C355650.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPhotoFormat(final PhotoFormat photoFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C355851.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C355851.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAspectRatio(final PhotoAspectRatio photoAspectRatio) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAspectRatio(photoAspectRatio, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C356052.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C356052.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PhotoAspectRatio> getAspectRatio() {
        return new RxLock<PhotoAspectRatio>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getAspectRatio(new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        C356253.this.setData(photoAspectRatio);
                    }

                    public void onFailure(AutelError autelError) {
                        C356253.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C356454.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C356454.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionAndFrameRate() {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C356655.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C356655.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncoder(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoEncoder(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C356856.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C356856.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncoderConfiguration> getVideoEncoderConfiguration() {
        return new RxLock<VideoEncoderConfiguration>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoEncoderConfiguration(new CallbackWithOneParam<VideoEncoderConfiguration>() {
                    public void onSuccess(VideoEncoderConfiguration videoEncoderConfiguration) {
                        C357057.this.setData(videoEncoderConfiguration);
                    }

                    public void onFailure(AutelError autelError) {
                        C357057.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoRotation(final VideoRotation videoRotation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoRotation(videoRotation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C357258.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C357258.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoRotation> getVideoRotation() {
        return new RxLock<VideoRotation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoRotation(new CallbackWithOneParam<VideoRotation>() {
                    public void onSuccess(VideoRotation videoRotation) {
                        C357459.this.setData(videoRotation);
                    }

                    public void onFailure(AutelError autelError) {
                        C357459.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setShutterMode(final ShutterMode shutterMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setShutterMode(shutterMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C357860.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C357860.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ShutterMode> getShutterMode() {
        return new RxLock<ShutterMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
                    public void onSuccess(ShutterMode shutterMode) {
                        C358061.this.setData(shutterMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C358061.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C358262.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C358262.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getAFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getAFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C358463.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C358463.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMFAssistFocusEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setMFAssistFocusEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C358664.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C358664.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getMFAssistFocusEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getMFAssistFocusEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C358865.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C358865.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPIVMode(final PIVMode pIVMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setPIVMode(pIVMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C359066.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C359066.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<PIVMode> getPIVMode() {
        return new RxLock<PIVMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    public void onSuccess(PIVMode pIVMode) {
                        C359267.this.setData(pIVMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C359267.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C359468.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C359468.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> switchToPreviousMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.switchToPreviousPhotoMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C359669.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C359669.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTrackingModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setTrackingModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C360070.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C360070.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SkylinePositionData> getSkylinePositionData(final int i, final int i2) {
        return new RxLock<SkylinePositionData>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getSkylinePositionData(i, i2, new CallbackWithOneParam<SkylinePositionData>() {
                    public void onSuccess(SkylinePositionData skylinePositionData) {
                        C360271.this.setData(skylinePositionData);
                    }

                    public void onFailure(AutelError autelError) {
                        C360271.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setVideoEncodeFormat(videoEncodeFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C360472.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C360472.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoEncodeFormat> getVideoEncodeFormat() {
        return new RxLock<VideoEncodeFormat>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    public void onSuccess(VideoEncodeFormat videoEncodeFormat) {
                        C360673.this.setData(videoEncodeFormat);
                    }

                    public void onFailure(AutelError autelError) {
                        C360673.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SpotMeteringArea> getFocusAFSpotArea() {
        return new RxLock<SpotMeteringArea>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getFocusAFSpotArea(new CallbackWithOneParam<SpotMeteringArea>() {
                    public void onSuccess(SpotMeteringArea spotMeteringArea) {
                        C360874.this.setData(spotMeteringArea);
                    }

                    public void onFailure(AutelError autelError) {
                        C360874.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SaveLocation> getAlbumLocation() {
        return new RxLock<SaveLocation>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getAlbumLocation(new CallbackWithOneParam<SaveLocation>() {
                    public void onSuccess(SaveLocation saveLocation) {
                        C361075.this.setData(saveLocation);
                    }

                    public void onFailure(AutelError autelError) {
                        C361075.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAlbumSaveLocation(final SaveLocation saveLocation) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setAlbumSaveLocation(saveLocation, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C361276.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C361276.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> formatFlashMemoryCard() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.formatFlashMemoryCard(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C361477.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C361477.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<FlashCardStatus> getFMCStatus() {
        return new RxLock<FlashCardStatus>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getFMCStatus(new CallbackWithOneParam<FlashCardStatus>() {
                    public void onSuccess(FlashCardStatus flashCardStatus) {
                        C361678.this.setData(flashCardStatus);
                    }

                    public void onFailure(AutelError autelError) {
                        C361678.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setHDREnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setHDREnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C361879.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C361879.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getHDREnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getHDREnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C362280.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C362280.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setDeFogEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C362481.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C362481.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDeFogStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setDeFogStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C362682.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C362682.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<DeFogParam> getDeFogParams() {
        return new RxLock<DeFogParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getDeFogParams(new CallbackWithOneParam<DeFogParam>() {
                    public void onSuccess(DeFogParam deFogParam) {
                        C362883.this.setData(deFogParam);
                    }

                    public void onFailure(AutelError autelError) {
                        C362883.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setImageRoiEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C363084.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C363084.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiStrength(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setImageRoiStrength(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C363285.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C363285.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setImageRoiArea(final int i, final int i2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setImageRoiArea(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C363486.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C363486.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ImageRoiParam> getImageRoiParams() {
        return new RxLock<ImageRoiParam>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
                    public void onSuccess(ImageRoiParam imageRoiParam) {
                        C363687.this.setData(imageRoiParam);
                    }

                    public void onFailure(AutelError autelError) {
                        C363687.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotInterval(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setMotionDelayShotInterval(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C363888.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C363888.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotInterval() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getMotionDelayShotInterval(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C364089.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C364089.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotDuration(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setMotionDelayShotDuration(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C364490.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C364490.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getMotionDelayShotDuration() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getMotionDelayShotDuration(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C364691.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C364691.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayShotKeepPhoto(final RawFormat rawFormat) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setMotionDelayShotKeepPhoto(rawFormat, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C364892.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C364892.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MotionPhotoInfo> getMotionDelayShotKeepPhoto() {
        return new RxLock<MotionPhotoInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getMotionDelayShotKeepPhoto(new CallbackWithOneParam<MotionPhotoInfo>() {
                    public void onSuccess(MotionPhotoInfo motionPhotoInfo) {
                        C365093.this.setData(motionPhotoInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C365093.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<XT705ParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XT705ParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XT705ParameterRangeManager parameterRangeManager = RxAutelXT705Impl.this.autelXT701.getParameterRangeManager();
                if (parameterRangeManager != null) {
                    setData(parameterRangeManager);
                } else {
                    setException(AutelError.COMMAND_FAILED);
                }
            }
        }.fire();
    }

    public Observable<Boolean> setISOMode(final ISOMode iSOMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.setISOMode(iSOMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C365395.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C365395.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<ISOMode> getISOMode() {
        return new RxLock<ISOMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelXT705Impl.this.autelXT701.getISOMode(new CallbackWithOneParam<ISOMode>() {
                    public void onSuccess(ISOMode iSOMode) {
                        C365596.this.setData(iSOMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C365596.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
