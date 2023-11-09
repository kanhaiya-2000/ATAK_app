package com.autel.internal.camera.xbbasic.xb015;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
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
import com.autel.common.camera.media.SkylinePositionData;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoFormat;
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
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.BaseCameraInitializeProxy;
import com.autel.internal.camera.CameraFactory;
import com.autel.sdk.camera.p005rx.RxAutelXB015;

public class CameraXb015InitializeProxy extends BaseCameraInitializeProxy implements CameraXb015Service4Initialize {
    protected RxAutelXB015 mRxAutelXB015;
    protected CameraXb015Service xb015Service;

    public CameraXb015InitializeProxy(AutelListenerManager autelListenerManager) {
        this.listenerManager = autelListenerManager;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraXb015Service createXb015 = CameraFactory.createXb015(autelServiceVersion);
        this.xb015Service = createXb015;
        createXb015.init(this.stateManager);
        this.cameraService = this.xb015Service;
        return this.xb015Service;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.xb015Service != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.CameraHistogramListener);
            if (obj instanceof CallbackWithOneParam) {
                this.xb015Service.setHistogramListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.CameraMediaInfoListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.xb015Service.setInfoListener((CallbackWithOneParam) obj2);
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

    public void setInfoListener(CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraMediaInfoListener, callbackWithOneParam);
        CameraXb015Service cameraXb015Service = this.xb015Service;
        if (cameraXb015Service != null) {
            cameraXb015Service.setInfoListener(callbackWithOneParam);
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraHistogramListener, callbackWithOneParam);
        CameraXb015Service cameraXb015Service = this.xb015Service;
        if (cameraXb015Service != null) {
            cameraXb015Service.setHistogramListener(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setDigitalZoomScale(i, callbackWithNoParam);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureMode.UNKNOWN != exposureMode) {
            this.xb015Service.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AutoExposureLockState.UNKNOWN != autoExposureLockState) {
            this.xb015Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ExposureCompensation.UNKNOWN != exposureCompensation) {
            this.xb015Service.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (CameraISO.UNKNOWN != cameraISO) {
            this.xb015Service.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setShutter(shutterSpeed, callbackWithNoParam);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (WhiteBalanceType.UNKNOWN != whiteBalance.type) {
            this.xb015Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (ColorStyle.UNKNOWN != colorStyle) {
            this.xb015Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (AntiFlicker.UNKNOWN != antiFlicker) {
            this.xb015Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.isHistogramEnable(callbackWithOneParam);
        }
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getExposureMode(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoSubtitleEnable(z, callbackWithNoParam);
        }
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.isSubtitleEnable(callbackWithOneParam);
        }
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
        }
    }

    public void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoEncodeFormat(videoEncodeFormat, callbackWithNoParam);
        }
    }

    public void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoEncodeFormat(callbackWithOneParam);
        }
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoRotation(videoRotation, callbackWithNoParam);
        }
    }

    public void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoRotation(callbackWithOneParam);
        }
    }

    public void getRealTimeVideoResolution(CallbackWithOneParam<RealTimeVideoResolution> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getRealTimeVideoResolution(callbackWithOneParam);
        }
    }

    public void setRealTimeVideoResolution(RealTimeVideoResolution realTimeVideoResolution, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setRealTimeVideoResolution(realTimeVideoResolution, callbackWithNoParam);
        }
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setPIVMode(pIVMode, callbackWithNoParam);
        }
    }

    public void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPIVMode(callbackWithOneParam);
        }
    }

    public void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, callbackWithNoParam);
        }
    }

    public void getAutoPIVTimelapseInterval(CallbackWithOneParam<VideoSnapshotTimelapseInterval> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getAutoPIVTimelapseInterval(callbackWithOneParam);
        }
    }

    public void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.switchToPreviousPhotoMode(callbackWithOneParam);
        }
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.xb015Service.setTrackingModeEnable(z, callbackWithNoParam);
    }

    public void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getSkylinePositionData(i, i2, callbackWithOneParam);
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoFormat(videoFormat, callbackWithNoParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.xb015Service.setVideoStandard(videoStandard, callbackWithNoParam);
        }
    }

    public void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoSum(callbackWithOneParam);
        }
    }

    public void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getLeftPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xb015Service.getPhotoFormat(callbackWithOneParam);
        }
    }

    public XB015ParameterRangeManager getParameterRangeManager() {
        return this.xb015Service.getParameterRangeManager();
    }

    public RxAutelXB015 toRx() {
        if (this.mRxAutelXB015 == null) {
            this.mRxAutelXB015 = new RxAutelXB015Impl(this);
        }
        return this.mRxAutelXB015;
    }
}
