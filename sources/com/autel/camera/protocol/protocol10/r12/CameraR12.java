package com.autel.camera.protocol.protocol10.r12;

import com.autel.camera.communication.udp.CameraHistogram;
import com.autel.camera.protocol.protocol10.base.BaseCamera10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.engine.HistogramInfo;
import com.autel.camera.protocol.protocol10.interfaces.r12.AutelR12Service;
import com.autel.camera.protocol.protocol10.request.CameraR12Request;
import com.autel.camera.protocol.protocol10.request.HistogramManager;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.CameraProduct;
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
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;
import com.autel.internal.sdk.camera.base.AutelSwitchState;

public class CameraR12 extends BaseCamera10 implements AutelR12Service {
    private CameraR12Request request = new CameraR12Request();

    public void setHistogramListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.setHistogramStatusEnable(AutelSwitchState.ON, new CallbackWithNoParam() {
                public void onSuccess() {
                    CameraHistogram.instance().connect();
                    HistogramManager.instance().addHistogramListener(BaseCamera10.class.getClass().getSimpleName(), new CallbackWithOneParam<HistogramInfo>() {
                        public void onSuccess(HistogramInfo histogramInfo) {
                            if (histogramInfo != null) {
                                callbackWithOneParam.onSuccess(histogramInfo.getData());
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithOneParam.onFailure(autelError);
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
            return;
        }
        CameraHistogram.instance().disconnect();
        this.request.setHistogramStatusEnable(AutelSwitchState.OFF, new CallbackWithNoParam() {
            public void onSuccess() {
                HistogramManager.instance().removeHistogramListener(BaseCamera10.class.getClass().getSimpleName());
            }

            public void onFailure(AutelError autelError) {
                HistogramManager.instance().removeHistogramListener(BaseCamera10.class.getClass().getSimpleName());
            }
        });
    }

    public void setHistogramStatusEnable(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        this.request.setHistogramStatusEnable(autelSwitchState, callbackWithNoParam);
    }

    public void setSpotMeteringArea(final int i, final int i2, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setSpotMeteringArea(i, i2, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingWithParser10 instance = AutelCameraSettingWithParser10.instance();
                instance.setSportMeter(i + "" + i2);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getSpotMeteringArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingWithParser10.instance().setSportMeter(autelCameraSettingWithParser10.getSpotMeter());
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getSpotMeterLocation());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposure(exposureCompensation, callbackWithNoParam);
    }

    public void getExposure(final CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getExposureValue());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setISO(final CameraISO cameraISO, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setISO(cameraISO, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingInternal.instance().setIso(cameraISO.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getISO(final CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingInternal.instance().setIso(autelCameraSettingWithParser10.getISO().getValue());
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getISO());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setShutter(final ShutterSpeed shutterSpeed, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutter(shutterSpeed, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingWithParser10.instance().setShutter(shutterSpeed.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getShutter(final CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingWithParser10.instance().setShutter(autelCameraSettingWithParser10.getShutter());
                callbackWithOneParam.onSuccess(ShutterSpeed.find(autelCameraSettingWithParser10.getShutter()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        this.request.setColorStyle(colorStyle, callbackWithNoParam);
    }

    public void getColorStyle(final CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(ColorStyle.find(autelCameraSettingWithParser10.getColor()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        this.request.setWhiteBalance(whiteBalance, callbackWithNoParam);
    }

    public void getWhiteBalance(final CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getWhiteBalance());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void set3DNoiseReductionEnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.set3DNoiseReductionEnable(z, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingWithParser10.instance().set3DDenoise(z ? "1" : "0");
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void is3DNoiseReductionEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingWithParser10.instance().set3DDenoise(autelCameraSettingWithParser10.is3DDenoiseEnable() ? "ON" : "OFF");
                callbackWithOneParam.onSuccess(Boolean.valueOf(autelCameraSettingWithParser10.is3DDenoiseEnable()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAntiFlicker(final CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getAntiFlicker());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAutoExposureLockState(final AutoExposureLockState autoExposureLockState, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoExposureLockState(autoExposureLockState, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingInternal.instance().setAeLock(autoExposureLockState.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAutoExposureLockState(final CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingInternal.instance().setAeLock(autelCameraSettingWithParser10.getAutoExposureLockState().value());
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getAutoExposureLockState());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void isHistogramStatusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(Boolean.valueOf(autelCameraSettingWithParser10.isHistogramStatusEnable()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setExposureMode(final ExposureMode exposureMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposureMode(exposureMode, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingInternal.instance().setCaptureMode(exposureMode.value10());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getExposureMode(final CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingInternal.instance().setCaptureMode(autelCameraSettingWithParser10.getCaptureMode());
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getExposureMode());
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
        this.request.setPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void getPhotoStyle(final CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getPhotoStyle());
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
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(Boolean.valueOf(autelCameraSettingWithParser10.isSubtitleSwitchEnable()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
    }

    public void getPhotoBurstCount(final CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getBurstNum());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
    }

    public void getPhotoTimelapseInterval(final CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getTimelapseIntervalTime());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
    }

    public void getPhotoAEBCount(final CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getAebNum());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoSum(final CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraStatusWithParser10.getVideoNum());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoSum(final CallbackWithOneParam<PhotoSum> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraStatusWithParser10.getPhotoNum());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCurrentRecordTimeSeconds(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getCurrentRecordTimeSeconds(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                String param = baseCameraMsgParser.getParam("param");
                if (param.contains("|")) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(param.split("\\|")[0]));
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoFormat(videoFormat, callbackWithNoParam);
    }

    public void getVideoFormat(final CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getVideoFormat());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoStandard(videoStandard, callbackWithNoParam);
    }

    public void getVideoStandard(final CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getVideoStandard());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoFormat(photoFormat, callbackWithNoParam);
    }

    public void getPhotoFormat(final CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getPhotoFormat());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAspectRatio(String str, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAspectRatio(str, callbackWithNoParam);
    }

    public void getAspectRatio(final CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(PhotoAspectRatio.find(autelCameraSettingWithParser10.getPhotoSize(), CameraProduct.R12));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingWithParser10.instance().setVideoResolution(videoResolutionAndFps.toString());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getVideoResolutionAndFrameRate(final CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                VideoResolutionAndFps videoResolution = autelCameraSettingWithParser10.getVideoResolution();
                AutelCameraSettingWithParser10.instance().setVideoResolution(videoResolution.toString());
                callbackWithOneParam.onSuccess(videoResolution);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getDigitalZoomScale(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                AutelCameraSettingWithParser10.instance().setCameraZoomFactor(String.valueOf(autelCameraSettingWithParser10.getDigitalZoomScale()));
                callbackWithOneParam.onSuccess(Integer.valueOf(autelCameraSettingWithParser10.getDigitalZoomScale()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setDigitalZoomScale(final int i, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, new CallbackWithNoParam() {
            public void onSuccess() {
                AutelCameraSettingWithParser10.instance().setCameraZoomFactor(String.valueOf(i));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }
}
