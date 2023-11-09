package com.autel.camera.protocol.protocol20.xb008;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.Histogram;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.interfaces.xb008.CameraXb08Service;
import com.autel.camera.protocol.protocol20.request.CameraHttpRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.base.MediaMode;
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
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.data.model.CameraXB008Data;
import com.autel.internal.sdk.camera.xb008.FileNamingMode;
import java.util.List;

public class Xb008 extends BaseCamera20 implements CameraXb08Service {
    private CameraHttpRequest request = new CameraHttpRequest();

    public void setHistogramListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.setHistogramListener(new CallbackWithOneParam<Histogram>() {
                public void onSuccess(Histogram histogram) {
                    callbackWithOneParam.onSuccess(histogram.getHistogramData());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.request.setHistogramListener((CallbackWithOneParam<Histogram>) null);
        }
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.request.setAutoFocusStateListener("setAutoFocusStateListener", callbackWithTwoParams);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setSpotMeteringArea(i, i2, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposure(exposureCompensation, callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        this.request.setISO(cameraISO, callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutter(shutterSpeed, callbackWithNoParam);
    }

    public void getColorStyle(final CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.request.getColorStyle(new CallbackWithOneParam<CameraAllSettings.ImageColor>() {
            public void onSuccess(CameraAllSettings.ImageColor imageColor) {
                callbackWithOneParam.onSuccess(ColorStyle.find(imageColor.getColor()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        this.request.setWhiteBalance(whiteBalance, callbackWithNoParam);
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        this.request.setColorStyle(colorStyle, callbackWithNoParam);
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAutoExposureLockState(final CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.request.getAutoExposureLockState(new CallbackWithOneParam<CameraAllSettings.AELock>() {
            public void onSuccess(CameraAllSettings.AELock aELock) {
                callbackWithOneParam.onSuccess(AutoExposureLockState.find((aELock.getLocked() == 1 ? AutoExposureLockState.LOCK : AutoExposureLockState.UNLOCK).value()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getSpotMeteringArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getSpotMeteringArea(new CallbackWithOneParam<CameraAllSettings.LocationMeter>() {
            public void onSuccess(CameraAllSettings.LocationMeter locationMeter) {
                SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
                spotMeteringArea.f8467X = locationMeter.getX();
                spotMeteringArea.f8468Y = locationMeter.getY();
                callbackWithOneParam.onSuccess(spotMeteringArea);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getAntiFlicker(final CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.request.getAntiFlicker(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                callbackWithOneParam.onSuccess(AntiFlicker.find(videoSourceConfiguration.getAntiFlicker()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getWhiteBalance(final CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        this.request.getWhiteBalance(new CallbackWithOneParam<CameraAllSettings.WhiteBalance>() {
            public void onSuccess(CameraAllSettings.WhiteBalance whiteBalance) {
                WhiteBalance whiteBalance2 = new WhiteBalance();
                whiteBalance2.type = WhiteBalanceType.find(whiteBalance.getMode());
                whiteBalance2.colorTemperature = whiteBalance.getColorTemperature();
                callbackWithOneParam.onSuccess(whiteBalance2);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getExposure(final CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        this.request.getExposure(new CallbackWithOneParam<CameraAllSettings.ImageExposure>() {
            public void onSuccess(CameraAllSettings.ImageExposure imageExposure) {
                callbackWithOneParam.onSuccess(ExposureCompensation.find(String.valueOf(imageExposure.getExposure())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getShutter(final CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        this.request.getShutter(new CallbackWithOneParam<CameraAllSettings.ShutterSpeed>() {
            public void onSuccess(CameraAllSettings.ShutterSpeed shutterSpeed) {
                callbackWithOneParam.onSuccess(ShutterSpeed.find(shutterSpeed.getShutter()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getISO(final CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        this.request.getISO(new CallbackWithOneParam<CameraAllSettings.ImageISO>() {
            public void onSuccess(CameraAllSettings.ImageISO imageISO) {
                callbackWithOneParam.onSuccess(CameraISO.find(String.valueOf(imageISO.getISO())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getExposureMode(final CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        this.request.getExposureMode(new CallbackWithOneParam<CameraAllSettings.CameraGear>() {
            public void onSuccess(CameraAllSettings.CameraGear cameraGear) {
                CameraXB008Data.instance().setCameraGear(cameraGear.getGear());
                callbackWithOneParam.onSuccess(ExposureMode.find(cameraGear.getGear()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoStyle(photoStyleType, callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        this.request.setCameraCustomPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void isHistogramStatusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isHistogramStatusEnable(new CallbackWithOneParam<CameraAllSettings.HistogramSettings>() {
            public void onSuccess(CameraAllSettings.HistogramSettings histogramSettings) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                boolean z = true;
                if (histogramSettings.getEnable() != 1) {
                    z = false;
                }
                callbackWithOneParam.onSuccess(Boolean.valueOf(z));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void isSubtitleEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isSubtitleEnable(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                boolean z = true;
                if (recordingSettings.getEnableSubtitle() != 1) {
                    z = false;
                }
                callbackWithOneParam.onSuccess(Boolean.valueOf(z));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoStyle(final CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        this.request.getPhotoStyle(new CallbackWithOneParam<CameraAllSettings.ImageStyle>() {
            public void onSuccess(CameraAllSettings.ImageStyle imageStyle) {
                PhotoStyle photoStyle = new PhotoStyle();
                photoStyle.contrast = imageStyle.getContrast();
                photoStyle.brightness = imageStyle.getBrightness();
                photoStyle.hue = imageStyle.getHue();
                photoStyle.saturation = imageStyle.getSaturation();
                photoStyle.sharpness = imageStyle.getSharpness();
                photoStyle.type = PhotoStyleType.find(imageStyle.getStyle());
                callbackWithOneParam.onSuccess(photoStyle);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setCameraAperture(CameraAperture cameraAperture, CallbackWithNoParam callbackWithNoParam) {
        this.request.setIRIS(cameraAperture, callbackWithNoParam);
    }

    public void getCameraAperture(final CallbackWithOneParam<CameraAperture> callbackWithOneParam) {
        this.request.getIRIS(new CallbackWithOneParam<CameraAllSettings.IRIS>() {
            public void onSuccess(CameraAllSettings.IRIS iris) {
                callbackWithOneParam.onSuccess(CameraAperture.find(String.valueOf(iris.getIrisValue())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFocusMode(lensFocusMode, callbackWithNoParam);
    }

    public void setExposureMode(final ExposureMode exposureMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposureMode(exposureMode, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB008Data.instance().setCameraGear(exposureMode.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getFocusMode(final CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        this.request.getFocusMode(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                callbackWithOneParam.onSuccess(LensFocusMode.find(focus.getMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getFocusDistance(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getFocusDistance(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                callbackWithOneParam.onSuccess(Integer.valueOf(focus.getObjectDistance()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getColorTemperature(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getColorTemperature(new CallbackWithOneParam<CameraAllSettings.WhiteBalance>() {
            public void onSuccess(CameraAllSettings.WhiteBalance whiteBalance) {
                callbackWithOneParam.onSuccess(Integer.valueOf(whiteBalance.getColorTemperature()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getDigitalZoomScale(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getDigitalZoomScale(new CallbackWithOneParam<CameraAllSettings.ZoomFactor>() {
            public void onSuccess(CameraAllSettings.ZoomFactor zoomFactor) {
                callbackWithOneParam.onSuccess(Integer.valueOf(zoomFactor.getZoomValue()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
    }

    public void setManualFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setManualFocusDistance(i, callbackWithNoParam);
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        this.request.startTakePhotoWithFocus(callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        int i = C240825.$SwitchMap$com$autel$common$camera$media$PhotoBurstCount[photoBurstCount.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 5;
            } else if (i == 3) {
                i2 = 7;
            }
        }
        this.request.setPhotoBurstCount(i2, callbackWithNoParam);
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        int i = C240825.$SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval[photoTimelapseInterval.ordinal()];
        int i2 = 5;
        if (i != 1) {
            if (i == 2) {
                i2 = 7;
            } else if (i == 3) {
                i2 = 10;
            } else if (i == 4) {
                i2 = 20;
            } else if (i == 5) {
                i2 = 30;
            }
        }
        this.request.setPhotoTimelapseInterval(i2, callbackWithNoParam);
    }

    /* renamed from: com.autel.camera.protocol.protocol20.xb008.Xb008$25 */
    /* synthetic */ class C240825 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$PhotoAEBCount;
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$PhotoBurstCount;
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.autel.common.camera.media.PhotoAEBCount[] r0 = com.autel.common.camera.media.PhotoAEBCount.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$media$PhotoAEBCount = r0
                r1 = 1
                com.autel.common.camera.media.PhotoAEBCount r2 = com.autel.common.camera.media.PhotoAEBCount.CAPTURE_3     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$autel$common$camera$media$PhotoAEBCount     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.media.PhotoAEBCount r3 = com.autel.common.camera.media.PhotoAEBCount.CAPTURE_5     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.autel.common.camera.media.PhotoTimelapseInterval[] r2 = com.autel.common.camera.media.PhotoTimelapseInterval.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval = r2
                com.autel.common.camera.media.PhotoTimelapseInterval r3 = com.autel.common.camera.media.PhotoTimelapseInterval.SECOND_5     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.autel.common.camera.media.PhotoTimelapseInterval r3 = com.autel.common.camera.media.PhotoTimelapseInterval.SECOND_7     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.autel.common.camera.media.PhotoTimelapseInterval r4 = com.autel.common.camera.media.PhotoTimelapseInterval.SECOND_10     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval     // Catch:{ NoSuchFieldError -> 0x004e }
                com.autel.common.camera.media.PhotoTimelapseInterval r4 = com.autel.common.camera.media.PhotoTimelapseInterval.SECOND_20     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = $SwitchMap$com$autel$common$camera$media$PhotoTimelapseInterval     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.autel.common.camera.media.PhotoTimelapseInterval r4 = com.autel.common.camera.media.PhotoTimelapseInterval.SECOND_30     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.autel.common.camera.media.PhotoBurstCount[] r3 = com.autel.common.camera.media.PhotoBurstCount.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$autel$common$camera$media$PhotoBurstCount = r3
                com.autel.common.camera.media.PhotoBurstCount r4 = com.autel.common.camera.media.PhotoBurstCount.BURST_3     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = $SwitchMap$com$autel$common$camera$media$PhotoBurstCount     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.autel.common.camera.media.PhotoBurstCount r3 = com.autel.common.camera.media.PhotoBurstCount.BURST_5     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$PhotoBurstCount     // Catch:{ NoSuchFieldError -> 0x007e }
                com.autel.common.camera.media.PhotoBurstCount r1 = com.autel.common.camera.media.PhotoBurstCount.BURST_7     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.protocol.protocol20.xb008.Xb008.C240825.<clinit>():void");
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        int i = C240825.$SwitchMap$com$autel$common$camera$media$PhotoAEBCount[photoAEBCount.ordinal()];
        int i2 = 3;
        if (i != 1 && i == 2) {
            i2 = 5;
        }
        this.request.setPhotoAEBCount(i2, callbackWithNoParam);
    }

    public void getPhotoAEBCount(final CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoAEBCount.find(String.valueOf(photoTakingSettings.getAEBModeSettings().getNumPhotosAtOnce())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoBurstCount(final CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoBurstCount.find(String.valueOf(photoTakingSettings.getBurstModeSettings().getNumPhotosPerSecond())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoTimelapseInterval(final CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoTimelapseInterval.find(String.valueOf(photoTakingSettings.getTimelapseModeSettings().getInterval())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoEncoderConfiguration(int i, CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration> callbackWithOneParam) {
        this.request.getVideoEncoderConfiguration(i, callbackWithOneParam);
    }

    public void getPhotoTakingSettings(CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings> callbackWithOneParam) {
        this.request.getPhotoTakingSettings(callbackWithOneParam);
    }

    public void getRecordingSettings(CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam) {
        this.request.getRecordingSettings(callbackWithOneParam);
    }

    public void getVideoSourceConfiguration(CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam) {
        this.request.getVideoSourceConfiguration(callbackWithOneParam);
    }

    public void getVideoSourceConfigurationOptions(CallbackWithOneParam<CameraAllSettings.VideoSourceConfigurationOptions> callbackWithOneParam) {
        this.request.getVideoSourceConfigurationOptions(callbackWithOneParam);
    }

    public void getCameraFocus(CallbackWithOneParam<CameraAllSettings.Focus> callbackWithOneParam) {
        this.request.getCameraFocus(callbackWithOneParam);
    }

    public void getFocusAFSpotArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
                spotMeteringArea.f8467X = focus.getAFMeter().getSpotArea().get(0).getX();
                spotMeteringArea.f8468Y = focus.getAFMeter().getSpotArea().get(0).getY();
                callbackWithOneParam.onSuccess(spotMeteringArea);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.request.getCameraMode(new CallbackWithOneParam<CameraAllSettings.CameraMode>() {
            public void onSuccess(CameraAllSettings.CameraMode cameraMode) {
                callbackWithOneParam.onSuccess(MediaMode.find(cameraMode.getMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraAutoExposureState(CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam) {
        this.request.getCameraAutoExposureState(callbackWithOneParam);
    }

    public void setFocusAFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFocusAFSpotArea(i, i2, callbackWithNoParam);
    }

    public void setFileNamingMode(FileNamingMode fileNamingMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFileNamingMode(fileNamingMode.getValue(), callbackWithNoParam);
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSourceConfiguration(videoRotation.getValue(), callbackWithNoParam);
    }

    public void setVideoEncoderConfiguration(int i, VideoEncoderConfiguration videoEncoderConfiguration, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration2 = new CameraAllSettings.VideoEncoderConfiguration();
        if (videoEncoderConfiguration.getEncoding() != null) {
            videoEncoderConfiguration2.setEncoding(videoEncoderConfiguration.getEncoding().getValue());
        }
        if (videoEncoderConfiguration.getVideoResolutionAndFps() != null) {
            videoEncoderConfiguration2.setResolution(videoEncoderConfiguration.getVideoResolutionAndFps().toString());
        }
        this.request.setVideoEncoderConfiguration(i, videoEncoderConfiguration2, callbackWithNoParam);
    }
}
