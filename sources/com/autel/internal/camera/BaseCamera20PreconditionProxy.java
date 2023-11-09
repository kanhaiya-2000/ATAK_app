package com.autel.internal.camera;

import android.util.Log;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;

public abstract class BaseCamera20PreconditionProxy implements BaseCameraService {
    private BaseCameraService baseCameraService;

    public void connect() {
    }

    public void disconnect() {
    }

    public BaseCamera20PreconditionProxy(BaseCameraService baseCameraService2) {
        this.baseCameraService = baseCameraService2;
    }

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.baseCameraService.setSDCardStateListener(callbackWithOneParam);
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        MediaMode find = MediaMode.find(getCameraMode());
        if (MediaMode.BURST == find || MediaMode.AEB == find || MediaMode.SINGLE == find || MediaMode.TIMELAPSE == find) {
            if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
                SDCardState find2 = SDCardState.find(getSdCardStatus());
                if (find2 == SDCardState.CARD_READY || find2 == SDCardState.LOW_SPEED_CARD) {
                    this.baseCameraService.startTakePhoto(callbackWithNoParam);
                } else if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(find2.getError());
                }
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_PHOTO_MODE);
        }
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
            if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
                SDCardState find = SDCardState.find(getSdCardStatus());
                if (find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD) {
                    this.baseCameraService.startRecordVideo(callbackWithNoParam);
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

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
            if (WorkState.RECORD == WorkState.find(getWorkStatus())) {
                this.baseCameraService.stopRecordVideo(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_RECORD_NOT_ON_RECORD_STATE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_RECORD_NOT_ON_VIDEO_MODE);
        }
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.TIMELAPSE == MediaMode.find(getCameraMode())) {
            if (WorkState.CAPTURE == WorkState.find(getWorkStatus())) {
                this.baseCameraService.stopTakePhoto(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_TIMELAPSE_NOT_ON_CAPTURE_STATE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_TIMELAPSE_NOT_ON_TIMELAPSE_MODE);
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
            SDCardState find = SDCardState.find(getSdCardStatus());
            AutelError autelError = null;
            if (SDCardState.CARD_ERROR == find) {
                autelError = AutelError.CAMERA_SDCARD_STATE_CARD_ERROR;
            } else if (SDCardState.CARD_NOT_SUPPORT == find) {
                autelError = AutelError.CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT;
            } else if (SDCardState.CARD_PROTECT == find) {
                autelError = AutelError.CAMERA_SDCARD_STATE_CARD_PROTECT;
            } else if (SDCardState.NO_CARD == find) {
                autelError = AutelError.CAMERA_SDCARD_STATE_NO_CARD;
            }
            if (autelError == null || callbackWithNoParam == null) {
                this.baseCameraService.formatSDCard(callbackWithNoParam);
            } else {
                callbackWithNoParam.onFailure(autelError);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SDCARD_FORMAT_NOT_ON_IDLE_MODE);
        }
    }

    public void resetDefaults(CallbackWithNoParam callbackWithNoParam) {
        if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
            this.baseCameraService.resetDefaults(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_RESET_NOT_ON_IDLE_MODE);
        }
    }

    public void getWorkState(CallbackWithOneParam<WorkState> callbackWithOneParam) {
        this.baseCameraService.getWorkState(callbackWithOneParam);
    }

    public void getSDCardState(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.baseCameraService.getSDCardState(callbackWithOneParam);
    }

    public void getSDCardFreeSpace(CallbackWithOneParam<Long> callbackWithOneParam) {
        this.baseCameraService.getSDCardFreeSpace(callbackWithOneParam);
    }

    public CameraProduct getProduct() {
        return this.baseCameraService.getProduct();
    }

    public void getVersion(CallbackWithOneParam<String> callbackWithOneParam) {
        this.baseCameraService.getVersion(callbackWithOneParam);
    }

    public void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        this.baseCameraService.setMediaStateListener(callbackWithTwoParams);
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.baseCameraService.setMediaModeListener(callbackWithOneParam);
    }

    public void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.setMediaMode(mediaMode, callbackWithNoParam);
    }

    public void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.baseCameraService.getMediaMode(callbackWithOneParam);
    }

    public void init(IAutelStateManager iAutelStateManager) {
        this.baseCameraService.init(iAutelStateManager);
    }

    public void destroy() {
        this.baseCameraService.destroy();
    }

    /* access modifiers changed from: protected */
    public String getCameraMode() {
        String currentMode = CameraModelDataManager.instance().getBaseCameraData().getCurrentMode();
        Log.d("camera", "mode:" + currentMode);
        return currentMode;
    }

    /* access modifiers changed from: protected */
    public String getSdCardStatus() {
        String cardStatus = CameraModelDataManager.instance().getBaseCameraData().getCardStatus();
        Log.d("camera", "sdcard status:" + cardStatus);
        return cardStatus;
    }

    /* access modifiers changed from: protected */
    public String getWorkStatus() {
        String systemStatus = CameraModelDataManager.instance().getBaseCameraData().getSystemStatus();
        Log.d("camera", "workStatus:" + systemStatus);
        return systemStatus;
    }

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.setCameraPattern(cameraPattern, callbackWithNoParam);
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.lockGimbalWhenTakePhoto(autelSwitchState, callbackWithNoParam);
    }

    public void setGpsCoordinateType(int i, CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.setGpsCoordinateType(i, callbackWithNoParam);
    }

    public void getGpsCoordinateType(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.baseCameraService.getGpsCoordinateType(callbackWithOneParam);
    }
}
