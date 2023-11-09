package com.autel.internal.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.FailedCallback;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.sdk.camera.base.AutelSwitchState;

public abstract class BaseCameraInitializeProxy extends AutelInitializeProxy implements BaseCameraService4Initialize {
    protected BaseCameraService cameraService;

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CameraSDCardStateListener, callbackWithOneParam);
        BaseCameraService baseCameraService = this.cameraService;
        if (baseCameraService != null) {
            baseCameraService.setSDCardStateListener(callbackWithOneParam);
        }
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.MediaModeListener, callbackWithOneParam);
        BaseCameraService baseCameraService = this.cameraService;
        if (baseCameraService != null) {
            baseCameraService.setMediaModeListener(callbackWithOneParam);
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.formatSDCard(callbackWithNoParam);
        }
    }

    public void resetDefaults(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.resetDefaults(callbackWithNoParam);
        }
    }

    public void getWorkState(CallbackWithOneParam<WorkState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getWorkState(callbackWithOneParam);
        }
    }

    public void getSDCardState(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getSDCardState(callbackWithOneParam);
        }
    }

    public void getSDCardFreeSpace(CallbackWithOneParam<Long> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getSDCardFreeSpace(callbackWithOneParam);
        }
    }

    public CameraProduct getProduct() {
        if (checkStateEnable((FailedCallback) null)) {
            return this.cameraService.getProduct();
        }
        return CameraProduct.UNKNOWN;
    }

    public void getVersion(CallbackWithOneParam<String> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getVersion(callbackWithOneParam);
        }
    }

    public void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        this.listenerManager.put(AutelListenerManager.MediaStateListener, callbackWithTwoParams);
        BaseCameraService baseCameraService = this.cameraService;
        if (baseCameraService != null) {
            baseCameraService.setMediaStateListener(callbackWithTwoParams);
        }
    }

    public void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.setMediaMode(mediaMode, callbackWithNoParam);
        }
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.startTakePhoto(callbackWithNoParam);
        }
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.startRecordVideo(callbackWithNoParam);
        }
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.stopRecordVideo(callbackWithNoParam);
        }
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.stopTakePhoto(callbackWithNoParam);
        }
    }

    public void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getMediaMode(callbackWithOneParam);
        }
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.cameraService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.CameraSDCardStateListener);
            if (obj instanceof CallbackWithOneParam) {
                this.cameraService.setSDCardStateListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.MediaModeListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.cameraService.setMediaModeListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.MediaStateListener);
            if (obj3 instanceof CallbackWithTwoParams) {
                this.cameraService.setMediaStateListener((CallbackWithTwoParams) obj3);
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

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.setCameraPattern(cameraPattern, callbackWithNoParam);
        }
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.lockGimbalWhenTakePhoto(autelSwitchState, callbackWithNoParam);
        }
    }

    public void setGpsCoordinateType(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraService.setGpsCoordinateType(i, callbackWithNoParam);
        }
    }

    public void getGpsCoordinateType(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraService.getGpsCoordinateType(callbackWithOneParam);
        }
    }
}
