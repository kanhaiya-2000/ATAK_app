package com.autel.camera.protocol.protocol20.xb015;

import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.Histogram;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.entity.TrackingStatus;
import com.autel.camera.protocol.protocol20.interfaces.Xb015.CameraXb015;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.CameraHttpRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoBitrateType;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncodeType;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.visual.TrackState;
import com.autel.common.camera.visual.TrackStateInfo;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.xb008.FileNamingMode;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.util.log.AutelLog;
import java.util.ArrayList;

/* renamed from: com.autel.camera.protocol.protocol20.xb015.Xb015 */
public class C2416Xb015 extends BaseCamera20 implements CameraXb015 {
    private CameraHttpRequest request = new CameraHttpRequest();

    public void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            BaseCameraRequest.instance().removeCameraSystemStatusListener(str);
        } else {
            BaseCameraRequest.instance().addCameraSystemStatusListener(str, callbackWithOneParam);
        }
    }

    public void setHistogramListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.setHistogramListener(new CallbackWithOneParam<Histogram>() {
                public void onSuccess(Histogram histogram) {
                    CameraXB015Data.instance().setHistogramEnable(1);
                    callbackWithOneParam.onSuccess(histogram.getHistogramData());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else if (CameraXB015Data.instance().getHistogramEnable() != 0) {
            this.request.setHistogramListener((CallbackWithOneParam<Histogram>) null);
        }
    }

    public void setSpotMeteringArea(final int i, final int i2, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setLocation_X(i);
                CameraXB015Data.instance().setLocation_Y(i2);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setAutoExposureLockState(final AutoExposureLockState autoExposureLockState, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAeLocked(autoExposureLockState == AutoExposureLockState.LOCK ? 1 : 0);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setExposure(final ExposureCompensation exposureCompensation, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposure(exposureCompensation, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageExposure(Double.parseDouble(exposureCompensation.getValue20()));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setISO(final CameraISO cameraISO, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setISO(cameraISO, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageISO(Integer.parseInt(cameraISO.getValue()));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setShutter(final ShutterSpeed shutterSpeed, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutter(shutterSpeed, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setShutter(shutterSpeed.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getColorStyle(final CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.request.getColorStyle(new CallbackWithOneParam<CameraAllSettings.ImageColor>() {
            public void onSuccess(CameraAllSettings.ImageColor imageColor) {
                CameraXB015Data.instance().setImageColor(imageColor.getColor());
                callbackWithOneParam.onSuccess(ColorStyle.find(imageColor.getColor()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setWhiteBalance(final WhiteBalance whiteBalance, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setWhiteBalanceMode(whiteBalance.type.value20());
                CameraXB015Data.instance().setWBColorTemperature(whiteBalance.colorTemperature);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setColorStyle(final ColorStyle colorStyle, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setColorStyle(colorStyle, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageColor(colorStyle.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setAntiFlicker(final AntiFlicker antiFlicker, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAntiFlicker(antiFlicker.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAutoExposureLockState(final CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.request.getAutoExposureLockState(new CallbackWithOneParam<CameraAllSettings.AELock>() {
            public void onSuccess(CameraAllSettings.AELock aELock) {
                if (aELock != null) {
                    CameraXB015Data.instance().setAeLocked(aELock.getLocked());
                    callbackWithOneParam.onSuccess(aELock.getLocked() == 1 ? AutoExposureLockState.LOCK : AutoExposureLockState.UNLOCK);
                    return;
                }
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError("Json Exception"));
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
                if (locationMeter != null) {
                    CameraXB015Data.instance().setLocation_X(locationMeter.getX());
                    CameraXB015Data.instance().setLocation_Y(locationMeter.getY());
                    spotMeteringArea.f8467X = locationMeter.getX();
                    spotMeteringArea.f8468Y = locationMeter.getY();
                    callbackWithOneParam.onSuccess(spotMeteringArea);
                    return;
                }
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError("Json Exception"));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getAntiFlicker(final CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.request.getAntiFlicker(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                if (videoSourceConfiguration != null) {
                    CameraXB015Data.instance().setAntiFlicker(videoSourceConfiguration.getAntiFlicker());
                    callbackWithOneParam.onSuccess(AntiFlicker.find(videoSourceConfiguration.getAntiFlicker()));
                    return;
                }
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError("Json Exception"));
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
                CameraXB015Data.instance().setWhiteBalanceMode(whiteBalance.getMode());
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
                CameraXB015Data.instance().setImageExposure(imageExposure.getExposure());
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
                CameraXB015Data.instance().setShutter(shutterSpeed.getShutter());
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
                CameraXB015Data.instance().setImageISO(imageISO.getISO());
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
                CameraXB015Data.instance().setCameraGear(cameraGear.getGear());
                callbackWithOneParam.onSuccess(ExposureMode.find(cameraGear.getGear()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoStyle(final PhotoStyleType photoStyleType, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setStyle(photoStyleType.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
        this.request.setCameraCustomPhotoStyle(i, i2, i3, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setContrast(i4);
                CameraXB015Data.instance().setSaturation(i5);
                CameraXB015Data.instance().setSharpness(i6);
                CameraXB015Data.instance().setStyle(PhotoStyleType.Custom.value());
                callbackWithNoParam2.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam2.onFailure(autelError);
            }
        });
    }

    public void isHistogramStatusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isHistogramStatusEnable(new CallbackWithOneParam<CameraAllSettings.HistogramSettings>() {
            public void onSuccess(CameraAllSettings.HistogramSettings histogramSettings) {
                CameraXB015Data.instance().setHistogramEnable(histogramSettings.getEnable());
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

    public void setVideoSubtitleEnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSubtitleEnable(z, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setEnableSubtitle(z ? 1 : 0);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void isSubtitleEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isSubtitleEnable(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CameraXB015Data.instance().setEnableSubtitle(recordingSettings.getEnableSubtitle());
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
                CameraXB015Data.instance().setContrast(imageStyle.getContrast());
                CameraXB015Data.instance().setSaturation(imageStyle.getSaturation());
                CameraXB015Data.instance().setSharpness(imageStyle.getSharpness());
                CameraXB015Data.instance().setHue(imageStyle.getHue());
                CameraXB015Data.instance().setBrightness(imageStyle.getBrightness());
                CameraXB015Data.instance().setStyle(imageStyle.getStyle());
                callbackWithOneParam.onSuccess(photoStyle);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setExposureMode(final ExposureMode exposureMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposureMode(exposureMode, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setCameraGear(exposureMode.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getColorTemperature(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getColorTemperature(new CallbackWithOneParam<CameraAllSettings.WhiteBalance>() {
            public void onSuccess(CameraAllSettings.WhiteBalance whiteBalance) {
                CameraXB015Data.instance().setWBColorTemperature(whiteBalance.getColorTemperature());
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
                CameraXB015Data.instance().setZoomValue(zoomFactor.getZoomValue());
                callbackWithOneParam.onSuccess(Integer.valueOf(zoomFactor.getZoomValue()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setDigitalZoomScale(final int i, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setZoomValue(i);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, final CallbackWithNoParam callbackWithNoParam) {
        if (PhotoBurstCount.UNKNOWN == photoBurstCount) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoBurstCount.value20()).intValue();
        this.request.setPhotoBurstCount(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setBurstNumPerSecond(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, final CallbackWithNoParam callbackWithNoParam) {
        if (photoTimelapseInterval == PhotoTimelapseInterval.UNKNOWN) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoTimelapseInterval.value20()).intValue();
        this.request.setPhotoTimelapseInterval(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setTimelapseInterval(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, final CallbackWithNoParam callbackWithNoParam) {
        if (PhotoAEBCount.UNKNOWN == photoAEBCount) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoAEBCount.value20()).intValue();
        this.request.setPhotoAEBCount(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAebNumPerSecond(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoAEBCount(final CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                CameraXB015Data.instance().setAebNumPerSecond(photoTakingSettings.getAEBModeSettings().getNumPhotosAtOnce());
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
                CameraXB015Data.instance().setBurstNumPerSecond(photoTakingSettings.getBurstModeSettings().getNumPhotosPerSecond());
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
                CameraXB015Data.instance().setTimelapseInterval(photoTakingSettings.getTimelapseModeSettings().getInterval());
                callbackWithOneParam.onSuccess(PhotoTimelapseInterval.find(String.valueOf(photoTakingSettings.getTimelapseModeSettings().getInterval())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoEncoderConfiguration(final int i, final CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration> callbackWithOneParam) {
        this.request.getVideoEncoderConfiguration(i, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
            public void onSuccess(final CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
                ArrayList arrayList = new ArrayList();
                if (i == 0) {
                    arrayList.add(new VideoEncoderConfiguration() {
                        public VideoEncodeFormat getEncoding() {
                            CameraXB015Data.instance().setVideoMainEncoding(videoEncoderConfiguration.getEncoding());
                            return VideoEncodeFormat.find(videoEncoderConfiguration.getEncoding());
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                            CameraXB015Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution()));
                            return VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution());
                        }

                        public int getQuality() {
                            return videoEncoderConfiguration.getQuality();
                        }

                        public int getIntervalOfIFrame() {
                            return videoEncoderConfiguration.getGovLength();
                        }

                        public int getBitrate() {
                            return videoEncoderConfiguration.getBitrate();
                        }

                        public VideoBitrateType getBitrateType() {
                            return VideoBitrateType.find(videoEncoderConfiguration.getBitrateType());
                        }

                        public VideoEncodeType getEncodeType() {
                            return VideoEncodeType.find(videoEncoderConfiguration.getProfile());
                        }
                    });
                    arrayList.add(new VideoEncoderConfiguration() {
                        public VideoEncodeFormat getEncoding() {
                            return VideoEncodeFormat.find(CameraXB015Data.instance().getVideoOtherEncoding());
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                            return CameraXB015Data.instance().getVideoOtherResolutionAndFps();
                        }

                        public int getQuality() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(1).getQuality();
                        }

                        public int getIntervalOfIFrame() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(1).getIntervalOfIFrame();
                        }

                        public int getBitrate() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(1).getBitrate();
                        }

                        public VideoBitrateType getBitrateType() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(1).getBitrateType();
                        }

                        public VideoEncodeType getEncodeType() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(1).getEncodeType();
                        }
                    });
                }
                if (i == 1) {
                    arrayList.add(new VideoEncoderConfiguration() {
                        public VideoEncodeFormat getEncoding() {
                            return VideoEncodeFormat.find(CameraXB015Data.instance().getVideoMainEncoding());
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                            return CameraXB015Data.instance().getVideoMainResolutionAndFps();
                        }

                        public int getQuality() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getQuality();
                        }

                        public int getIntervalOfIFrame() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getIntervalOfIFrame();
                        }

                        public int getBitrate() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getBitrate();
                        }

                        public VideoBitrateType getBitrateType() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getBitrateType();
                        }

                        public VideoEncodeType getEncodeType() {
                            return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getEncodeType();
                        }
                    });
                    arrayList.add(new VideoEncoderConfiguration() {
                        public VideoEncodeFormat getEncoding() {
                            CameraXB015Data.instance().setVideoOtherEncoding(videoEncoderConfiguration.getEncoding());
                            return VideoEncodeFormat.find(videoEncoderConfiguration.getEncoding());
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                            CameraXB015Data.instance().setVideoOtherResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution()));
                            return VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution());
                        }

                        public int getQuality() {
                            return videoEncoderConfiguration.getQuality();
                        }

                        public int getIntervalOfIFrame() {
                            return videoEncoderConfiguration.getGovLength();
                        }

                        public int getBitrate() {
                            return videoEncoderConfiguration.getBitrate();
                        }

                        public VideoBitrateType getBitrateType() {
                            return VideoBitrateType.find(videoEncoderConfiguration.getBitrateType());
                        }

                        public VideoEncodeType getEncodeType() {
                            return VideoEncodeType.find(videoEncoderConfiguration.getProfile());
                        }
                    });
                }
                CameraXB015Data.instance().setVideoEncoderConfiguration(arrayList);
                callbackWithOneParam.onSuccess(videoEncoderConfiguration);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoTakingSettings(final CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings> callbackWithOneParam) {
        this.request.getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                CameraXB015Data.instance().setPicType(photoTakingSettings.getPicType());
                CameraXB015Data.instance().setPicResolution(photoTakingSettings.getResolution());
                CameraXB015Data.instance().setBurstNumPerSecond(photoTakingSettings.getBurstModeSettings().getNumPhotosPerSecond());
                CameraXB015Data.instance().setAebNumPerSecond(photoTakingSettings.getAEBModeSettings().getNumPhotosAtOnce());
                CameraXB015Data.instance().setTimelapseInterval(photoTakingSettings.getTimelapseModeSettings().getInterval());
                callbackWithOneParam.onSuccess(photoTakingSettings);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getRecordingSettings(final CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam) {
        this.request.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CameraXB015Data.instance().setVideoFileFormat(recordingSettings.getFileFormat());
                CameraXB015Data.instance().setEnableSubtitle(recordingSettings.getEnableSubtitle());
                CameraXB015Data.instance().setAutoSnapshotEnable(recordingSettings.getAutoSnapshot().getEnable());
                CameraXB015Data.instance().setAutoSnapshotInterval(recordingSettings.getAutoSnapshot().getInterval());
                callbackWithOneParam.onSuccess(recordingSettings);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoSourceConfiguration(final CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam) {
        this.request.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                CameraXB015Data.instance().setVideoRotation(videoSourceConfiguration.getRotation());
                CameraXB015Data.instance().setAntiFlicker(videoSourceConfiguration.getAntiFlicker());
                CameraXB015Data.instance().setVideoStandard(videoSourceConfiguration.getVideoStandard());
                callbackWithOneParam.onSuccess(videoSourceConfiguration);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoSourceConfigurationOptions(CallbackWithOneParam<CameraAllSettings.VideoSourceConfigurationOptions> callbackWithOneParam) {
        this.request.getVideoSourceConfigurationOptions(callbackWithOneParam);
    }

    public void getCameraMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.request.getCameraMode(new CallbackWithOneParam<CameraAllSettings.CameraMode>() {
            public void onSuccess(CameraAllSettings.CameraMode cameraMode) {
                CameraXB015Data.instance().setCameraMode(cameraMode.getMode());
                callbackWithOneParam.onSuccess(MediaMode.find(cameraMode.getMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraAutoExposureState(final CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam) {
        this.request.getCameraAutoExposureState(new CallbackWithOneParam<CameraAllSettings.AELock>() {
            public void onSuccess(CameraAllSettings.AELock aELock) {
                CameraXB015Data.instance().setAeLocked(aELock.getLocked());
                callbackWithOneParam.onSuccess(aELock);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setFileNamingMode(FileNamingMode fileNamingMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFileNamingMode(fileNamingMode.getValue(), callbackWithNoParam);
    }

    public void setVideoRotation(final VideoRotation videoRotation, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSourceConfiguration(videoRotation.getValue(), new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setVideoRotation(videoRotation.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setAutoSnapshotEnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoSnapshotEnable(z, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAutoSnapshotEnable(z ? 1 : 0);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setAutoSnapshotInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoSnapshotInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAutoSnapshotInterval(videoSnapshotTimelapseInterval.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setCurrentRealResolution(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        this.request.setCurrentRealResolution(videoResolutionAndFps, callbackWithNoParam);
    }

    public void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam) {
        if (PacketDisPatcher.getInstance().isDebug()) {
            AutelLog.debug_i("Tracking_Test", "tracking send setTrackingGoalArea to camera x: " + trackingTarget.xRatio + " y:" + trackingTarget.yRatio);
        }
        this.request.setTrackingGoalArea(trackingTarget, callbackWithNoParam);
    }

    public void cancelTracking(CallbackWithNoParam callbackWithNoParam) {
        this.request.stopTracking(callbackWithNoParam);
    }

    public void setTrackingMode(TrackMode trackMode, CallbackWithNoParam callbackWithNoParam) {
        if (PacketDisPatcher.getInstance().isDebug()) {
            AutelLog.debug_i("Tracking_Test", "tracking send enter track cmd to camera trackingMode -> " + trackMode);
        }
        this.request.setTrackingMode(trackMode.getValue(), callbackWithNoParam);
    }

    public void getTrackingState(final CallbackWithOneParam<TrackStateInfo> callbackWithOneParam) {
        this.request.getTrackingMode(new CallbackWithOneParam<TrackingStatus>() {
            public void onSuccess(TrackingStatus trackingStatus) {
                TrackStateInfo trackStateInfo = new TrackStateInfo();
                trackStateInfo.trackMode = TrackMode.find(trackingStatus.getAction());
                trackStateInfo.trackState = TrackState.find(trackingStatus.getState());
                callbackWithOneParam.onSuccess(trackStateInfo);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setProductSubtitleSNEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setProduceParametersEnable(z ? 1 : 0, callbackWithNoParam);
    }

    public void setVideoEncoderConfiguration(final int i, final VideoEncoderConfiguration videoEncoderConfiguration, final CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration2 = new CameraAllSettings.VideoEncoderConfiguration();
        if (videoEncoderConfiguration.getEncoding() != null) {
            videoEncoderConfiguration2.setEncoding(videoEncoderConfiguration.getEncoding().getValue());
        }
        if (videoEncoderConfiguration.getVideoResolutionAndFps() != null) {
            videoEncoderConfiguration2.setResolution(videoEncoderConfiguration.getVideoResolutionAndFps().toString());
        }
        this.request.setVideoEncoderConfiguration(i, videoEncoderConfiguration2, new CallbackWithNoParam() {
            public void onSuccess() {
                if (i == 0) {
                    if (videoEncoderConfiguration.getEncoding() != null) {
                        CameraXB015Data.instance().setVideoMainEncoding(videoEncoderConfiguration.getEncoding().getValue());
                    }
                    if (videoEncoderConfiguration.getVideoResolutionAndFps() != null) {
                        CameraXB015Data.instance().setVideoMainResolutionAndFps(videoEncoderConfiguration.getVideoResolutionAndFps());
                    }
                } else {
                    if (videoEncoderConfiguration.getEncoding() != null) {
                        CameraXB015Data.instance().setVideoOtherEncoding(videoEncoderConfiguration.getEncoding().getValue());
                    }
                    if (videoEncoderConfiguration.getVideoResolutionAndFps() != null) {
                        CameraXB015Data.instance().setVideoOtherResolutionAndFps(videoEncoderConfiguration.getVideoResolutionAndFps());
                    }
                }
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }
}
