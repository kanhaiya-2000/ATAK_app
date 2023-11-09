package com.autel.internal.camera.r12;

import android.text.TextUtils;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
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
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.r12.R12CameraInfo;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera10PreconditionProxy;
import com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil;
import com.autel.sdk.camera.p005rx.RxAutelR12;

public class CameraR12PreconditionProxy extends BaseCamera10PreconditionProxy implements CameraR12Service {
    private CameraR12Service cameraR12Service;

    public RxAutelR12 toRx() {
        return null;
    }

    public CameraR12PreconditionProxy(CameraR12Service cameraR12Service2) {
        super(cameraR12Service2);
        this.cameraR12Service = cameraR12Service2;
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.cameraR12Service.setMediaModeListener(callbackWithOneParam);
    }

    public void setInfoListener(CallbackWithOneParam<R12CameraInfo> callbackWithOneParam) {
        this.cameraR12Service.setInfoListener(callbackWithOneParam);
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.cameraR12Service.setHistogramListener(callbackWithOneParam);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        R12ParameterRangeManager parameterRangeManager = getParameterRangeManager();
        RangePair<Integer> spotMeteringAreaX = parameterRangeManager.getSpotMeteringAreaX();
        RangePair<Integer> spotMeteringAreaY = parameterRangeManager.getSpotMeteringAreaY();
        if (i >= spotMeteringAreaX.getValueFrom().intValue() && i <= spotMeteringAreaX.getValueTo().intValue() && i2 >= spotMeteringAreaY.getValueFrom().intValue() && i2 <= spotMeteringAreaY.getValueTo().intValue()) {
            if (AutoExposureLockState.UNLOCK == AutelCameraSettingWithParser10.instance().getAutoExposureLockState()) {
                this.cameraR12Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SPOT_METER_AE_NOT_UNLOCK);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (autoExposureLockState == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (AutoExposureLockState.LOCK == autoExposureLockState || AutoExposureLockState.UNLOCK == autoExposureLockState) {
            if (ExposureMode.Manual != AutelCameraSettingWithParser10.instance().getExposureMode()) {
                this.cameraR12Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_AE_LOCK_STATE_ON_MANUAL_GEAR);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (exposureCompensation != null) {
            if (ExposureMode.Auto == AutelCameraSettingWithParser10.instance().getExposureMode()) {
                this.cameraR12Service.setExposure(exposureCompensation, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_EXPOSURE_NOT_ON_AUTO_MODE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (cameraISO != null) {
            if (ExposureMode.Manual == AutelCameraSettingWithParser10.instance().getExposureMode()) {
                this.cameraR12Service.setISO(cameraISO, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_ISO_NOT_ON_MANUAL_MODE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (shutterSpeed != null) {
            if (ExposureMode.Manual == AutelCameraSettingWithParser10.instance().getExposureMode()) {
                if (getParameterRangeManager().getCameraShutterSpeed().contains(shutterSpeed)) {
                    if (shutterSpeed != AutelCameraSettingWithParser10.instance().getCameraShutter()) {
                        this.cameraR12Service.setShutter(shutterSpeed, callbackWithNoParam);
                    } else if (callbackWithNoParam != null) {
                        callbackWithNoParam.onSuccess();
                    }
                } else if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
                }
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (whiteBalance != null) {
            this.cameraR12Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (colorStyle != null) {
            this.cameraR12Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (!TextUtils.isEmpty(AutelCameraSettingWithParser10.instance().get3DDennoise())) {
            this.cameraR12Service.set3DNoiseReductionEnable(z, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION);
        }
    }

    public void is3DNoiseReductionEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraR12Service.is3DNoiseReductionEnable(callbackWithOneParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (antiFlicker != null) {
            if (ExposureMode.Auto == AutelCameraSettingWithParser10.instance().getExposureMode()) {
                this.cameraR12Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_ANTIFLICKER_NOT_ON_AUTO_MODE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.cameraR12Service.getAutoExposureLockState(callbackWithOneParam);
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.cameraR12Service.getSpotMeteringArea(callbackWithOneParam);
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.cameraR12Service.getAntiFlicker(callbackWithOneParam);
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        this.cameraR12Service.getWhiteBalance(callbackWithOneParam);
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        this.cameraR12Service.getExposure(callbackWithOneParam);
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        this.cameraR12Service.getShutter(callbackWithOneParam);
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        this.cameraR12Service.getISO(callbackWithOneParam);
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraR12Service.isHistogramEnable(callbackWithOneParam);
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.cameraR12Service.getColorStyle(callbackWithOneParam);
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        this.cameraR12Service.getExposureMode(callbackWithOneParam);
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (exposureMode != ExposureMode.AperturePriority) {
            this.cameraR12Service.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_EXPOSURE_NOT_SUPPORT_APERTURE_PRIORITY);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (photoStyleType == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (PhotoStyleType.Custom != photoStyleType) {
            this.cameraR12Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        R12ParameterRangeManager parameterRangeManager = getParameterRangeManager();
        RangePair<Integer> photoStyleContrast = parameterRangeManager.getPhotoStyleContrast();
        RangePair<Integer> photoStyleContrast2 = parameterRangeManager.getPhotoStyleContrast();
        RangePair<Integer> photoStyleContrast3 = parameterRangeManager.getPhotoStyleContrast();
        if (i >= photoStyleContrast.getValueFrom().intValue() && i <= photoStyleContrast.getValueTo().intValue() && i2 >= photoStyleContrast2.getValueFrom().intValue() && i2 <= photoStyleContrast2.getValueTo().intValue() && i3 >= photoStyleContrast3.getValueFrom().intValue() && i3 <= photoStyleContrast3.getValueTo().intValue()) {
            this.cameraR12Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12Service.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoBurstCount != null) {
            this.cameraR12Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (photoTimelapseInterval != null) {
            this.cameraR12Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoAEBCount != null) {
            this.cameraR12Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraR12Service.isSubtitleEnable(callbackWithOneParam);
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        this.cameraR12Service.getPhotoBurstCount(callbackWithOneParam);
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        this.cameraR12Service.getPhotoTimelapseInterval(callbackWithOneParam);
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        this.cameraR12Service.getPhotoAEBCount(callbackWithOneParam);
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        this.cameraR12Service.getPhotoStyle(callbackWithOneParam);
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (photoAspectRatio != null) {
            this.cameraR12Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (photoFormat != null) {
            this.cameraR12Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (videoResolutionAndFps != null) {
            boolean z = false;
            int i = C28901.$SwitchMap$com$autel$common$camera$media$VideoStandard[AutelCameraSettingWithParser10.instance().getVideoStandard().ordinal()];
            if (i == 1) {
                z = ResolutionFpsSupportUtil.isNTSCSupport(CameraProduct.R12, videoResolutionAndFps.resolution, videoResolutionAndFps.fps);
            } else if (i == 2) {
                z = ResolutionFpsSupportUtil.isPALSupport(CameraProduct.R12, videoResolutionAndFps.resolution, videoResolutionAndFps.fps);
            }
            if (z) {
                if (videoResolutionAndFps != AutelCameraSettingWithParser10.instance().getVideoResolution()) {
                    this.cameraR12Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
                } else if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.RESOLUTION_OR_FPS_IS_NOT_MATCH);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    /* renamed from: com.autel.internal.camera.r12.CameraR12PreconditionProxy$1 */
    /* synthetic */ class C28901 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.camera.r12.CameraR12PreconditionProxy.C28901.<clinit>():void");
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (videoFormat != null) {
            this.cameraR12Service.setVideoFormat(videoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (videoStandard != null) {
            this.cameraR12Service.setVideoStandard(videoStandard, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getLeftRecordTime(CallbackWithOneParam<Long> callbackWithOneParam) {
        this.cameraR12Service.getLeftRecordTime(callbackWithOneParam);
    }

    public void getPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraR12Service.getPhotoSum(callbackWithOneParam);
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraR12Service.getCurrentRecordTime(callbackWithOneParam);
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        this.cameraR12Service.getStateInfo(callbackWithOneParam);
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        this.cameraR12Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraR12Service.getDigitalZoomScale(callbackWithOneParam);
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        RangePair<Integer> digitalZoomScale = getParameterRangeManager().getDigitalZoomScale();
        if (i >= digitalZoomScale.getValueFrom().intValue() && i <= digitalZoomScale.getValueTo().intValue()) {
            this.cameraR12Service.setDigitalZoomScale(i, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public R12ParameterRangeManager getParameterRangeManager() {
        return this.cameraR12Service.getParameterRangeManager();
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        this.cameraR12Service.getAspectRatio(callbackWithOneParam);
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        this.cameraR12Service.getVideoFormat(callbackWithOneParam);
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        this.cameraR12Service.getVideoStandard(callbackWithOneParam);
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        this.cameraR12Service.getPhotoFormat(callbackWithOneParam);
    }
}
