package com.autel.internal.camera.r12;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
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
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.r12.R12CameraInfo;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.BaseCameraInitializeProxy;
import com.autel.internal.camera.CameraFactory;
import com.autel.sdk.camera.p005rx.RxAutelR12;

public class CameraR12InitializeProxy extends BaseCameraInitializeProxy implements CameraR12Service4Initialize {
    CameraR12Service cameraR12Service;
    RxAutelR12 mRxAutelR12;

    public CameraR12InitializeProxy(AutelListenerManager autelListenerManager) {
        this.listenerManager = autelListenerManager;
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.MediaModeListener, callbackWithOneParam);
        CameraR12Service cameraR12Service2 = this.cameraR12Service;
        if (cameraR12Service2 != null) {
            cameraR12Service2.setMediaModeListener(callbackWithOneParam);
        }
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.cameraR12Service != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.CameraHistogramListener);
            if (obj instanceof CallbackWithOneParam) {
                this.cameraR12Service.setHistogramListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.MediaModeListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.cameraR12Service.setMediaModeListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.CameraMediaInfoListener);
            if (obj3 instanceof CallbackWithOneParam) {
                this.cameraR12Service.setInfoListener((CallbackWithOneParam) obj3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraR12Service createXb004 = CameraFactory.createXb004(autelServiceVersion);
        this.cameraR12Service = createXb004;
        this.cameraService = createXb004;
        this.cameraService.init(this.stateManager);
        return this.cameraService;
    }

    public void setInfoListener(CallbackWithOneParam<R12CameraInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraMediaInfoListener, callbackWithOneParam);
        CameraR12Service cameraR12Service2 = this.cameraR12Service;
        if (cameraR12Service2 != null) {
            cameraR12Service2.setInfoListener(callbackWithOneParam);
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraHistogramListener, callbackWithOneParam);
        CameraR12Service cameraR12Service2 = this.cameraR12Service;
        if (cameraR12Service2 != null) {
            cameraR12Service2.setHistogramListener(callbackWithOneParam);
        }
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AutoExposureLockState.UNKNOWN != autoExposureLockState) {
            this.cameraR12Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureCompensation.UNKNOWN != exposureCompensation) {
            this.cameraR12Service.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (CameraISO.UNKNOWN != cameraISO) {
            this.cameraR12Service.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ShutterSpeed.UNKNOWN != shutterSpeed) {
            this.cameraR12Service.setShutter(shutterSpeed, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (WhiteBalanceType.UNKNOWN != whiteBalance.type) {
            this.cameraR12Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ColorStyle.UNKNOWN != colorStyle) {
            this.cameraR12Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.set3DNoiseReductionEnable(z, callbackWithNoParam);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AntiFlicker.UNKNOWN != antiFlicker) {
            this.cameraR12Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.isHistogramEnable(callbackWithOneParam);
        }
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getExposureMode(callbackWithOneParam);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setExposureMode(exposureMode, callbackWithNoParam);
        }
    }

    public void is3DNoiseReductionEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.is3DNoiseReductionEnable(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setVideoSubtitleEnable(z, callbackWithNoParam);
        }
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.isSubtitleEnable(callbackWithOneParam);
        }
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setVideoFormat(videoFormat, callbackWithNoParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setVideoStandard(videoStandard, callbackWithNoParam);
        }
    }

    public void getLeftRecordTime(CallbackWithOneParam<Long> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getLeftRecordTime(callbackWithOneParam);
        }
    }

    public void getPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraR12Service.setDigitalZoomScale(i, callbackWithNoParam);
        }
    }

    public R12ParameterRangeManager getParameterRangeManager() {
        return this.cameraR12Service.getParameterRangeManager();
    }

    public RxAutelR12 toRx() {
        if (this.mRxAutelR12 == null) {
            this.mRxAutelR12 = new RxAutelR12Impl(this);
        }
        return this.mRxAutelR12;
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraR12Service.getPhotoFormat(callbackWithOneParam);
        }
    }
}
