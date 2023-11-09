package com.autel.internal.camera.xbbasic.xt705;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.FailedCallback;
import com.autel.common.camera.XT705.XT705CameraInfo;
import com.autel.common.camera.XT705.XT705ParameterRangeManager;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.ISOMode;
import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionDelayShot;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.base.SettingEvent;
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
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.BaseCameraInitializeProxy;
import com.autel.internal.camera.CameraFactory;
import com.autel.sdk.camera.p005rx.RxAutelXT705;
import java.util.List;

public class CameraXT705InitializeProxy extends BaseCameraInitializeProxy implements CameraXT705Service4Initialize {
    protected RxAutelXT705 rxAutelXT705;
    protected CameraXT705Service xt705Service;

    public CameraXT705InitializeProxy(AutelListenerManager autelListenerManager) {
        this.listenerManager = autelListenerManager;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraXT705Service createXT705 = CameraFactory.createXT705(autelServiceVersion);
        this.xt705Service = createXT705;
        createXT705.init(this.stateManager);
        this.cameraService = this.xt705Service;
        return this.xt705Service;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.xt705Service != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.CameraAutoFocusListener);
            if (obj instanceof CallbackWithTwoParams) {
                this.xt705Service.setAutoFocusStateListener((CallbackWithTwoParams) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.CameraHistogramListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.xt705Service.setHistogramListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.CameraMediaInfoListener);
            if (obj3 instanceof CallbackWithOneParam) {
                this.xt705Service.setInfoListener((CallbackWithOneParam) obj3);
            }
            Object obj4 = this.listenerManager.get(AutelListenerManager.FlashMemoryCardStateListener);
            if (obj4 instanceof CallbackWithOneParam) {
                this.xt705Service.setFlashMemoryCardStateListener((CallbackWithOneParam) obj4);
            }
            Object obj5 = this.listenerManager.get(AutelListenerManager.SettingChangedListener);
            if (obj5 instanceof CallbackWithOneParam) {
                this.xt705Service.setSettingChangedListener((CallbackWithOneParam) obj5);
            }
            Object obj6 = this.listenerManager.get(AutelListenerManager.AFCenterListener);
            if (obj6 instanceof CallbackWithOneParam) {
                this.xt705Service.setAFCenterListener((CallbackWithOneParam) obj6);
            }
            Object obj7 = this.listenerManager.get(AutelListenerManager.MotionDelayShotListener);
            if (obj7 instanceof CallbackWithOneParam) {
                this.xt705Service.setMotionDelayShotListener((CallbackWithOneParam) obj7);
            }
            Object obj8 = this.listenerManager.get(AutelListenerManager.PhotoExposureListener);
            if (obj8 instanceof CallbackWithOneParam) {
                this.xt705Service.setPhotoExposureListener((CallbackWithOneParam) obj8);
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
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setAutoFocusStateListener(callbackWithTwoParams);
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraHistogramListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setHistogramListener(callbackWithOneParam);
        }
    }

    public void setFlashMemoryCardStateListener(CallbackWithOneParam<MMCState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlashMemoryCardStateListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setFlashMemoryCardStateListener(callbackWithOneParam);
        }
    }

    public void setPhotoExposureListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.PhotoExposureListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setPhotoExposureListener(callbackWithOneParam);
        }
    }

    public void setAFCenterListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.AFCenterListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setAFCenterListener(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotListener(CallbackWithOneParam<MotionDelayShot> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.MotionDelayShotListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setMotionDelayShotListener(callbackWithOneParam);
        }
    }

    public void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.SettingChangedListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setSettingChangedListener(callbackWithOneParam);
        }
    }

    public void setInfoListener(CallbackWithOneParam<XT705CameraInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraMediaInfoListener, callbackWithOneParam);
        CameraXT705Service cameraXT705Service = this.xt705Service;
        if (cameraXT705Service != null) {
            cameraXT705Service.setInfoListener(callbackWithOneParam);
        }
    }

    public void setCameraAperture(CameraAperture cameraAperture, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (CameraAperture.UNKNOWN != cameraAperture) {
            this.xt705Service.setCameraAperture(cameraAperture, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getCameraAperture(CallbackWithOneParam<CameraAperture> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getCameraAperture(callbackWithOneParam);
        }
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (LensFocusMode.UNKNOWN != lensFocusMode) {
            this.xt705Service.setFocusMode(lensFocusMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getFocusMode(callbackWithOneParam);
        }
    }

    public void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getFocusAFSpotArea(callbackWithOneParam);
        }
    }

    public void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getFocusDistance(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setDigitalZoomScale(i, callbackWithNoParam);
        }
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
        }
    }

    public void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setFocusDistance(i, callbackWithNoParam);
        }
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.startTakePhotoWithFocus(callbackWithNoParam);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureMode.UNKNOWN != exposureMode) {
            this.xt705Service.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AutoExposureLockState.UNKNOWN != autoExposureLockState) {
            this.xt705Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureCompensation.UNKNOWN != exposureCompensation) {
            this.xt705Service.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (CameraISO.UNKNOWN != cameraISO) {
            this.xt705Service.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setShutter(shutterSpeed, callbackWithNoParam);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (WhiteBalanceType.UNKNOWN != whiteBalance.type) {
            this.xt705Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ColorStyle.UNKNOWN != colorStyle) {
            this.xt705Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.set3DNoiseReductionEnable(z, callbackWithNoParam);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AntiFlicker.UNKNOWN != antiFlicker) {
            this.xt705Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.isHistogramStatusEnable(callbackWithOneParam);
        }
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getExposureMode(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoSubtitleEnable(z, callbackWithNoParam);
        }
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.isSubtitleEnable(callbackWithOneParam);
        }
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
        }
    }

    public void setVideoEncoder(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoEncoder(videoEncodeFormat, callbackWithNoParam);
        }
    }

    public void getVideoEncoderConfiguration(CallbackWithOneParam<VideoEncoderConfiguration> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoEncoderConfiguration(callbackWithOneParam);
        }
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoRotation(videoRotation, callbackWithNoParam);
        }
    }

    public void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoRotation(callbackWithOneParam);
        }
    }

    public void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setShutterMode(shutterMode, callbackWithNoParam);
        }
    }

    public void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getShutterMode(callbackWithOneParam);
        }
    }

    public void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setAFAssistFocusEnable(z, callbackWithNoParam);
        }
    }

    public void getAFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getAFAssistFocusEnable(callbackWithOneParam);
        }
    }

    public void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setMFAssistFocusEnable(z, callbackWithNoParam);
        }
    }

    public void getMFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getMFAssistFocusEnable(callbackWithOneParam);
        }
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setPIVMode(pIVMode, callbackWithNoParam);
        }
    }

    public void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPIVMode(callbackWithOneParam);
        }
    }

    public void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, callbackWithNoParam);
        }
    }

    public void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.switchToPreviousPhotoMode(callbackWithOneParam);
        }
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setTrackingModeEnable(z, callbackWithNoParam);
        }
    }

    public void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getSkylinePositionData(i, i2, callbackWithOneParam);
        }
    }

    public void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoEncodeFormat(videoEncodeFormat, callbackWithNoParam);
        }
    }

    public void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoEncodeFormat(callbackWithOneParam);
        }
    }

    public void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setAlbumSaveLocation(saveLocation, callbackWithNoParam);
        }
    }

    public void getAlbumLocation(CallbackWithOneParam<SaveLocation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getAlbumLocation(callbackWithOneParam);
        }
    }

    public void getFMCStatus(CallbackWithOneParam<FlashCardStatus> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getFMCStatus(callbackWithOneParam);
        }
    }

    public void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.formatFlashMemoryCard(callbackWithNoParam);
        }
    }

    public void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setHDREnable(z, callbackWithNoParam);
        }
    }

    public void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getHDREnable(callbackWithOneParam);
        }
    }

    public void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setDeFogEnable(z, callbackWithNoParam);
        }
    }

    public void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setDeFogStrength(i, callbackWithNoParam);
        }
    }

    public void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getDeFogParams(callbackWithOneParam);
        }
    }

    public void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setImageRoiEnable(z, callbackWithNoParam);
        }
    }

    public void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setImageRoiStrength(i, callbackWithNoParam);
        }
    }

    public void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setImageRoiArea(i, i2, callbackWithNoParam);
        }
    }

    public void getImageRoiParams(CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getImageRoiParams(callbackWithOneParam);
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoFormat(videoFormat, callbackWithNoParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setVideoStandard(videoStandard, callbackWithNoParam);
        }
    }

    public void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoSum(callbackWithOneParam);
        }
    }

    public void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getLeftPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getPhotoFormat(callbackWithOneParam);
        }
    }

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setFocusMFSpotArea(i, i2, callbackWithNoParam);
        }
    }

    public void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getFocusMFSpotArea(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setMotionDelayShotInterval(i, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getMotionDelayShotInterval(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setMotionDelayShotDuration(i, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getMotionDelayShotDuration(callbackWithOneParam);
        }
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
        }
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getMotionDelayShotKeepPhoto(callbackWithOneParam);
        }
    }

    public void setISOMode(ISOMode iSOMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xt705Service.setISOMode(iSOMode, callbackWithNoParam);
        }
    }

    public void getISOMode(CallbackWithOneParam<ISOMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xt705Service.getISOMode(callbackWithOneParam);
        }
    }

    public XT705ParameterRangeManager getParameterRangeManager() {
        return this.xt705Service.getParameterRangeManager();
    }

    public RxAutelXT705 toRx() {
        if (this.rxAutelXT705 == null) {
            this.rxAutelXT705 = new RxAutelXT705Impl(this);
        }
        return this.rxAutelXT705;
    }
}
