package com.autel.internal.camera.xbbasic.xb015;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
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
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.camera.xb015.RealTimeVideoResolution;
import com.autel.common.camera.xb015.XB015CameraInfo;
import com.autel.common.camera.xb015.XB015ParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera20PreconditionProxy;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil;
import com.autel.sdk.camera.p005rx.RxAutelXB015;

public class CameraXb015PreconditionProxy extends BaseCamera20PreconditionProxy implements CameraXb015Service {
    /* access modifiers changed from: private */
    public CameraXb015Service cameraXb012Service;

    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelXB015 toRx() {
        return null;
    }

    public CameraXb015PreconditionProxy(CameraXb015Service cameraXb015Service) {
        super(cameraXb015Service);
        this.cameraXb012Service = cameraXb015Service;
    }

    public XB015ParameterRangeManager getParameterRangeManager() {
        return this.cameraXb012Service.getParameterRangeManager();
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        SDCardState find = SDCardState.find(getSdCardStatus());
        if (find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD) {
            WorkState find2 = WorkState.find(getWorkStatus());
            MediaMode find3 = MediaMode.find(getCameraMode());
            if (MediaMode.BURST == find3 || MediaMode.AEB == find3 || MediaMode.SINGLE == find3 || MediaMode.TIMELAPSE == find3) {
                if (WorkState.IDLE != find2) {
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE);
                        return;
                    }
                    return;
                }
            } else if (MediaMode.VIDEO != find3) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE);
                    return;
                }
                return;
            } else if (WorkState.RECORD != find2) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NEED_RECORD_STATE_ON_VIDEO_MODE);
                return;
            } else {
                VideoEncodeFormat find4 = VideoEncodeFormat.find(CameraXB015Data.instance().getVideoMainEncoding());
                VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
                if (videoMainResolutionAndFps.resolution == VideoResolution.Resolution_4096x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps && find4 == VideoEncodeFormat.H265) {
                    callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265);
                    return;
                }
            }
            this.cameraXb012Service.startTakePhoto(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(find.getError());
        }
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
            if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
                SDCardState find = SDCardState.find(getSdCardStatus());
                if (find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD) {
                    this.cameraXb012Service.startRecordVideo(callbackWithNoParam);
                } else if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(find.getError());
                }
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_IDLE_STATE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_VIDEO_MODE);
        }
    }

    public void setInfoListener(CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam) {
        this.cameraXb012Service.setInfoListener(callbackWithOneParam);
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.cameraXb012Service.setHistogramListener(callbackWithOneParam);
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        RangePair<Integer> digitalZoomScale = getParameterRangeManager().getDigitalZoomScale();
        if (i >= digitalZoomScale.getValueFrom().intValue() && i <= digitalZoomScale.getValueTo().intValue()) {
            this.cameraXb012Service.setDigitalZoomScale(i, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (exposureMode != null) {
            this.cameraXb012Service.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setSpotMeteringArea(final int i, final int i2, final CallbackWithNoParam callbackWithNoParam) {
        XB015ParameterRangeManager parameterRangeManager = getParameterRangeManager();
        RangePair<Integer> spotMeteringAreaX = parameterRangeManager.getSpotMeteringAreaX();
        RangePair<Integer> spotMeteringAreaY = parameterRangeManager.getSpotMeteringAreaY();
        if (i >= spotMeteringAreaX.getValueFrom().intValue() && i <= spotMeteringAreaX.getValueTo().intValue() && i2 >= spotMeteringAreaY.getValueFrom().intValue() && i2 <= spotMeteringAreaY.getValueTo().intValue()) {
            this.cameraXb012Service.getAutoExposureLockState(new CallbackWithOneParam<AutoExposureLockState>() {
                public void onSuccess(AutoExposureLockState autoExposureLockState) {
                    if (AutoExposureLockState.UNLOCK == autoExposureLockState) {
                        CameraXb015PreconditionProxy.this.cameraXb012Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
                        return;
                    }
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_SPOT_METER_AE_NOT_UNLOCK);
                    }
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setAutoExposureLockState(final AutoExposureLockState autoExposureLockState, final CallbackWithNoParam callbackWithNoParam) {
        if (autoExposureLockState == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (AutoExposureLockState.LOCK == autoExposureLockState || AutoExposureLockState.UNLOCK == autoExposureLockState) {
            this.cameraXb012Service.getExposureMode(new CallbackWithOneParam<ExposureMode>() {
                public void onSuccess(ExposureMode exposureMode) {
                    if (ExposureMode.Manual == exposureMode) {
                        CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_AE_LOCK_STATE_ON_MANUAL_GEAR);
                            return;
                        }
                        return;
                    }
                    CameraXb015PreconditionProxy.this.cameraXb012Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (exposureCompensation != null) {
            this.cameraXb012Service.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (cameraISO != null) {
            this.cameraXb012Service.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (shutterSpeed == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (ShutterSpeed.UNKNOWN == shutterSpeed) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
            }
        } else if (ExposureMode.find(CameraXB015Data.instance().getCameraGear()) != ExposureMode.Manual && callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE);
        } else if (getParameterRangeManager().getCameraShutterSpeed().contains(shutterSpeed) || callbackWithNoParam == null) {
            this.cameraXb012Service.setShutter(shutterSpeed, callbackWithNoParam);
        } else {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (whiteBalance != null) {
            if (whiteBalance.type == WhiteBalanceType.CUSTOM) {
                RangePair<Integer> colorTemperature = getParameterRangeManager().getColorTemperature();
                if (whiteBalance.colorTemperature < colorTemperature.getValueFrom().intValue() || whiteBalance.colorTemperature > colorTemperature.getValueTo().intValue()) {
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_COLOR_TEMPERATURE_RANGE_OUT);
                        return;
                    }
                    return;
                }
            }
            this.cameraXb012Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (colorStyle != null) {
            this.cameraXb012Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (antiFlicker == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (ExposureMode.find(CameraXB015Data.instance().getCameraGear()) == ExposureMode.Auto) {
            if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
                VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
                if (!(videoMainResolutionAndFps.fps == null || videoMainResolutionAndFps.fps.fps() <= 100 || antiFlicker == AntiFlicker.ANTI_FLICKER_60HZ)) {
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_ANTI_FLICKER_ONLY_60Hz_FOR_VIDEO_FPS_OVER_100);
                        return;
                    }
                    return;
                }
            }
            this.cameraXb012Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXb012Service.isHistogramEnable(callbackWithOneParam);
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getExposureMode(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (photoStyleType == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (PhotoStyleType.Custom != photoStyleType) {
            this.cameraXb012Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (i >= -3 && i <= 3 && i2 >= -3 && i2 <= 3 && i3 >= -3 && i3 <= 3) {
            this.cameraXb012Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoBurstCount != null) {
            this.cameraXb012Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (photoTimelapseInterval != null) {
            this.cameraXb012Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoAEBCount != null) {
            this.cameraXb012Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXb012Service.isSubtitleEnable(callbackWithOneParam);
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (photoAspectRatio != null) {
            this.cameraXb012Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (photoFormat != null) {
            this.cameraXb012Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        boolean z;
        if (videoResolutionAndFps != null) {
            int i = C30293.$SwitchMap$com$autel$common$camera$media$VideoStandard[VideoStandard.find(CameraXB015Data.instance().getVideoStandard()).ordinal()];
            if (i == 1) {
                z = ResolutionFpsSupportUtil.isNTSCSupport(CameraProduct.XB015, videoResolutionAndFps.resolution, videoResolutionAndFps.fps);
            } else if (i != 2) {
                z = ResolutionFpsSupportUtil.isPALSupport(CameraProduct.XB015, videoResolutionAndFps.resolution, videoResolutionAndFps.fps);
            } else {
                z = ResolutionFpsSupportUtil.isPALSupport(CameraProduct.XB015, videoResolutionAndFps.resolution, videoResolutionAndFps.fps);
            }
            if (z) {
                this.cameraXb012Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.RESOLUTION_OR_FPS_IS_NOT_MATCH);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    /* renamed from: com.autel.internal.camera.xbbasic.xb015.CameraXb015PreconditionProxy$3 */
    /* synthetic */ class C30293 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$VideoStandard;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.common.camera.media.VideoStandard[] r0 = com.autel.common.camera.media.VideoStandard.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$media$VideoStandard = r0
                com.autel.common.camera.media.VideoStandard r1 = com.autel.common.camera.media.VideoStandard.NTSC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$VideoStandard     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.media.VideoStandard r1 = com.autel.common.camera.media.VideoStandard.PAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.camera.xbbasic.xb015.CameraXb015PreconditionProxy.C30293.<clinit>():void");
        }
    }

    public void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (videoEncodeFormat != null) {
            this.cameraXb012Service.setVideoEncodeFormat(videoEncodeFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        this.cameraXb012Service.getVideoEncodeFormat(callbackWithOneParam);
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setVideoRotation(videoRotation, callbackWithNoParam);
    }

    public void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        this.cameraXb012Service.getVideoRotation(callbackWithOneParam);
    }

    public void getRealTimeVideoResolution(CallbackWithOneParam<RealTimeVideoResolution> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getRealTimeVideoResolution(callbackWithOneParam);
        }
    }

    public void setRealTimeVideoResolution(RealTimeVideoResolution realTimeVideoResolution, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setRealTimeVideoResolution(realTimeVideoResolution, callbackWithNoParam);
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setPIVMode(pIVMode, callbackWithNoParam);
    }

    public void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPIVMode(callbackWithOneParam);
        }
    }

    public void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, callbackWithNoParam);
    }

    public void getAutoPIVTimelapseInterval(CallbackWithOneParam<VideoSnapshotTimelapseInterval> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getAutoPIVTimelapseInterval(callbackWithOneParam);
        }
    }

    public void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.cameraXb012Service.switchToPreviousPhotoMode(callbackWithOneParam);
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (videoFormat != null) {
            this.cameraXb012Service.setVideoFormat(videoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (videoStandard != null) {
            this.cameraXb012Service.setVideoStandard(videoStandard, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getVideoSum(callbackWithOneParam);
        }
    }

    public void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getLeftPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXb012Service.getPhotoFormat(callbackWithOneParam);
        }
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXb012Service.setTrackingModeEnable(z, callbackWithNoParam);
    }

    public void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        this.cameraXb012Service.getSkylinePositionData(i, i2, callbackWithOneParam);
    }
}
