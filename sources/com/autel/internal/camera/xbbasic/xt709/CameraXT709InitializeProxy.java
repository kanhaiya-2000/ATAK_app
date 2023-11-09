package com.autel.internal.camera.xbbasic.xt709;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.FailedCallback;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrImageModeParam;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.XT706.IrTempetureWarningParams;
import com.autel.common.camera.XT706.XT706CameraInfo;
import com.autel.common.camera.XT706.XT706ParameterRangeManager;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionDelayShot;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.base.SettingEvent;
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
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.BaseCameraInitializeProxy;
import com.autel.internal.camera.CameraFactory;
import com.autel.sdk.camera.p005rx.RxAutelXT709;
import java.util.List;

public class CameraXT709InitializeProxy extends BaseCameraInitializeProxy implements CameraXT709Service4Initialize {
    protected RxAutelXT709 rxAutelXT709;
    protected CameraXT709Service xtService;

    public CameraXT709InitializeProxy(AutelListenerManager autelListenerManager) {
        this.listenerManager = autelListenerManager;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraXT709Service createXT709 = CameraFactory.createXT709(autelServiceVersion);
        this.xtService = createXT709;
        createXT709.init(this.stateManager);
        this.cameraService = this.xtService;
        return this.xtService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.xtService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.CameraAutoFocusListener);
            if (obj instanceof CallbackWithTwoParams) {
                this.xtService.setAutoFocusStateListener((CallbackWithTwoParams) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.CameraHistogramListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.xtService.setHistogramListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.CameraMediaInfoListener);
            if (obj3 instanceof CallbackWithOneParam) {
                this.xtService.setInfoListener((CallbackWithOneParam) obj3);
            }
            Object obj4 = this.listenerManager.get(AutelListenerManager.FlashMemoryCardStateListener);
            if (obj4 instanceof CallbackWithOneParam) {
                this.xtService.setFlashMemoryCardStateListener((CallbackWithOneParam) obj4);
            }
            Object obj5 = this.listenerManager.get(AutelListenerManager.SettingChangedListener);
            if (obj5 instanceof CallbackWithOneParam) {
                this.xtService.setSettingChangedListener((CallbackWithOneParam) obj5);
            }
            Object obj6 = this.listenerManager.get(AutelListenerManager.AFCenterListener);
            if (obj6 instanceof CallbackWithOneParam) {
                this.xtService.setAFCenterListener((CallbackWithOneParam) obj6);
            }
            Object obj7 = this.listenerManager.get(AutelListenerManager.MotionDelayShotListener);
            if (obj7 instanceof CallbackWithOneParam) {
                this.xtService.setMotionDelayShotListener((CallbackWithOneParam) obj7);
            }
            Object obj8 = this.listenerManager.get(AutelListenerManager.TemperatureWarningListener);
            if (obj8 instanceof CallbackWithOneParam) {
                this.xtService.setTemperatureWarningListener((CallbackWithOneParam) obj8);
            }
            Object obj9 = this.listenerManager.get(AutelListenerManager.PhotoExposureListener);
            if (obj9 instanceof CallbackWithOneParam) {
                this.xtService.setPhotoExposureListener((CallbackWithOneParam) obj9);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError checkError = checkError();
        if (!(checkError == null || failedCallback == null)) {
            failedCallback.onFailure(checkError);
        }
        return checkError == null;
    }

    private AutelError checkError() {
        if (!this.hasInit || this.stateManager == null) {
            return AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        }
        if (!this.stateManager.isSdkValidate()) {
            return AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        }
        if (!this.stateManager.isProductConnected()) {
            return AutelError.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT;
        }
        if (!this.stateManager.isCameraConnected()) {
            return AutelError.SDK_HAS_NOT_CONNECT_TO_CAMERA;
        }
        return null;
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.listenerManager.put(AutelListenerManager.CameraAutoFocusListener, callbackWithTwoParams);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setAutoFocusStateListener(callbackWithTwoParams);
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraHistogramListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setHistogramListener(callbackWithOneParam);
        }
    }

    public void setTemperatureWarningListener(CallbackWithOneParam<IrTempetureWarningParams> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.TemperatureWarningListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setTemperatureWarningListener(callbackWithOneParam);
        }
    }

    public void setFlashMemoryCardStateListener(CallbackWithOneParam<MMCState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlashMemoryCardStateListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setFlashMemoryCardStateListener(callbackWithOneParam);
        }
    }

    public void setPhotoExposureListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.PhotoExposureListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setPhotoExposureListener(callbackWithOneParam);
        }
    }

    public void setAFCenterListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.AFCenterListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setAFCenterListener(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotListener(CallbackWithOneParam<MotionDelayShot> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.MotionDelayShotListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setMotionDelayShotListener(callbackWithOneParam);
        }
    }

    public void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.SettingChangedListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setSettingChangedListener(callbackWithOneParam);
        }
    }

    public void setInfoListener(CallbackWithOneParam<XT706CameraInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraMediaInfoListener, callbackWithOneParam);
        CameraXT709Service cameraXT709Service = this.xtService;
        if (cameraXT709Service != null) {
            cameraXT709Service.setInfoListener(callbackWithOneParam);
        }
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (LensFocusMode.UNKNOWN != lensFocusMode) {
            this.xtService.setFocusMode(lensFocusMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getFocusMode(callbackWithOneParam);
        }
    }

    public void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getFocusAFSpotArea(callbackWithOneParam);
        }
    }

    public void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getFocusDistance(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setDigitalZoomScale(i, callbackWithNoParam);
        }
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
        }
    }

    public void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setFocusDistance(i, callbackWithNoParam);
        }
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.startTakePhotoWithFocus(callbackWithNoParam);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureMode.UNKNOWN != exposureMode) {
            this.xtService.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setSpotMeteringArea(i, i2, callbackWithNoParam);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AutoExposureLockState.UNKNOWN != autoExposureLockState) {
            this.xtService.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureCompensation.UNKNOWN != exposureCompensation) {
            this.xtService.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (CameraISO.UNKNOWN != cameraISO) {
            this.xtService.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setShutter(shutterSpeed, callbackWithNoParam);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (WhiteBalanceType.UNKNOWN != whiteBalance.type) {
            this.xtService.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ColorStyle.UNKNOWN != colorStyle) {
            this.xtService.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.set3DNoiseReductionEnable(z, callbackWithNoParam);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AntiFlicker.UNKNOWN != antiFlicker) {
            this.xtService.setAntiFlicker(antiFlicker, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.isHistogramStatusEnable(callbackWithOneParam);
        }
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getExposureMode(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoStyle(photoStyleType, callbackWithNoParam);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoSubtitleEnable(z, callbackWithNoParam);
        }
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.isSubtitleEnable(callbackWithOneParam);
        }
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPhotoFormat(photoFormat, callbackWithNoParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
        }
    }

    public void setVideoEncoder(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoEncoder(videoEncodeFormat, callbackWithNoParam);
        }
    }

    public void getVideoEncoderConfiguration(CallbackWithOneParam<VideoEncoderConfiguration> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoEncoderConfiguration(callbackWithOneParam);
        }
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoRotation(videoRotation, callbackWithNoParam);
        }
    }

    public void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoRotation(callbackWithOneParam);
        }
    }

    public void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setShutterMode(shutterMode, callbackWithNoParam);
        }
    }

    public void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getShutterMode(callbackWithOneParam);
        }
    }

    public void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setAFAssistFocusEnable(z, callbackWithNoParam);
        }
    }

    public void getAFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getAFAssistFocusEnable(callbackWithOneParam);
        }
    }

    public void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setMFAssistFocusEnable(z, callbackWithNoParam);
        }
    }

    public void getMFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getMFAssistFocusEnable(callbackWithOneParam);
        }
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setPIVMode(pIVMode, callbackWithNoParam);
        }
    }

    public void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPIVMode(callbackWithOneParam);
        }
    }

    public void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, callbackWithNoParam);
        }
    }

    public void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.switchToPreviousPhotoMode(callbackWithOneParam);
        }
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setTrackingModeEnable(z, callbackWithNoParam);
        }
    }

    public void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getSkylinePositionData(i, i2, callbackWithOneParam);
        }
    }

    public void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoEncodeFormat(videoEncodeFormat, callbackWithNoParam);
        }
    }

    public void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoEncodeFormat(callbackWithOneParam);
        }
    }

    public void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setAlbumSaveLocation(saveLocation, callbackWithNoParam);
        }
    }

    public void getAlbumLocation(CallbackWithOneParam<SaveLocation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getAlbumLocation(callbackWithOneParam);
        }
    }

    public void getFMCStatus(CallbackWithOneParam<FlashCardStatus> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getFMCStatus(callbackWithOneParam);
        }
    }

    public void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.formatFlashMemoryCard(callbackWithNoParam);
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoFormat(videoFormat, callbackWithNoParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setVideoStandard(videoStandard, callbackWithNoParam);
        }
    }

    public void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoSum(callbackWithOneParam);
        }
    }

    public void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getLeftPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getPhotoFormat(callbackWithOneParam);
        }
    }

    public XT706ParameterRangeManager getParameterRangeManager() {
        return this.xtService.getParameterRangeManager();
    }

    public void setDisplayMode(DisplayMode displayMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setDisplayMode(displayMode, callbackWithNoParam);
        }
    }

    public void getDisplayMode(CallbackWithOneParam<DisplayMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getDisplayMode(callbackWithOneParam);
        }
    }

    public void setIrColor(IrColor irColor, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrColor(irColor, callbackWithNoParam);
        }
    }

    public void getIrColor(CallbackWithOneParam<IrColor> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrColor(callbackWithOneParam);
        }
    }

    public void setIrPosition(IrPosition irPosition, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrPosition(irPosition, callbackWithNoParam);
        }
    }

    public void getIrPosition(CallbackWithOneParam<IrPosition> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrPosition(callbackWithOneParam);
        }
    }

    public void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setHDREnable(z, callbackWithNoParam);
        }
    }

    public void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getHDREnable(callbackWithOneParam);
        }
    }

    public void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setDeFogEnable(z, callbackWithNoParam);
        }
    }

    public void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setDeFogStrength(i, callbackWithNoParam);
        }
    }

    public void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getDeFogParams(callbackWithOneParam);
        }
    }

    public void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setImageRoiEnable(z, callbackWithNoParam);
        }
    }

    public void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setImageRoiStrength(i, callbackWithNoParam);
        }
    }

    public void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setImageRoiArea(i, i2, callbackWithNoParam);
        }
    }

    public void getImageRoiParams(CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getImageRoiParams(callbackWithOneParam);
        }
    }

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setFocusMFSpotArea(i, i2, callbackWithNoParam);
        }
    }

    public void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getFocusMFSpotArea(callbackWithOneParam);
        }
    }

    public void setIrFlushShutter(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrFlushShutter(callbackWithNoParam);
        }
    }

    public void setIrTemperatureParams(IrTemperatureParams irTemperatureParams, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrTemperatureParams(irTemperatureParams, callbackWithNoParam);
        }
    }

    public void getIrTemperatureParams(CallbackWithOneParam<IrTemperatureParams> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrTemperatureParams(callbackWithOneParam);
        }
    }

    public void setIrTemperatureWarningParams(IrTemperatureWarnParams irTemperatureWarnParams, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrTemperatureWarningParams(irTemperatureWarnParams, callbackWithNoParam);
        }
    }

    public void getIrTemperatureWarningParams(CallbackWithOneParam<IrTemperatureWarnParams> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrTemperatureWarningParams(callbackWithOneParam);
        }
    }

    public void setIrTemperatureEmit(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrTemperatureEmit(i, callbackWithNoParam);
        }
    }

    public void getIrTemperatureEmit(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrTemperatureEmit(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setMotionDelayShotInterval(i, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getMotionDelayShotInterval(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setMotionDelayShotDuration(i, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getMotionDelayShotDuration(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getMotionDelayShotKeepPhoto(callbackWithOneParam);
        }
    }

    public void setIrImageMode(ImageMode imageMode, int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrImageMode(imageMode, i, i2, callbackWithNoParam);
        }
    }

    public void getIrImageMode(CallbackWithOneParam<IrImageModeParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrImageMode(callbackWithOneParam);
        }
    }

    public void setIrEnhance(boolean z, int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrEnhance(z, i, callbackWithNoParam);
        }
    }

    public void getIrEnhance(CallbackWithOneParam<IrEnhanceParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrEnhance(callbackWithOneParam);
        }
    }

    public void setIrDeNoise(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrDeNoise(z, callbackWithNoParam);
        }
    }

    public void getIrDeNoise(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrDeNoise(callbackWithOneParam);
        }
    }

    public void setIrGain(IrGainMode irGainMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrGain(irGainMode, callbackWithNoParam);
        }
    }

    public void getIrGain(CallbackWithOneParam<IrGainMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrGain(callbackWithOneParam);
        }
    }

    public void setIrIsoTherm(IrIsoThermMode irIsoThermMode, int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xtService.setIrIsoTherm(irIsoThermMode, i, i2, callbackWithNoParam);
        }
    }

    public void getIrIsoTherm(CallbackWithOneParam<IrThresholdParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xtService.getIrIsoTherm(callbackWithOneParam);
        }
    }

    public RxAutelXT709 toRx() {
        if (this.rxAutelXT709 == null) {
            this.rxAutelXT709 = new RxAutelXT709Impl(this);
        }
        return this.rxAutelXT709;
    }
}
