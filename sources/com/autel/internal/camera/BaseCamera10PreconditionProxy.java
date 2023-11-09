package com.autel.internal.camera;

import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
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

public abstract class BaseCamera10PreconditionProxy implements BaseCameraService {
    /* access modifiers changed from: private */
    public BaseCameraService baseCameraService;

    public void connect() {
    }

    public void disconnect() {
    }

    public BaseCamera10PreconditionProxy(BaseCameraService baseCameraService2) {
        this.baseCameraService = baseCameraService2;
    }

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.baseCameraService.setSDCardStateListener(callbackWithOneParam);
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.baseCameraService.setMediaModeListener(callbackWithOneParam);
    }

    public void startTakePhoto(final CallbackWithNoParam callbackWithNoParam) {
        MediaMode currentMode = AutelCameraStatusWithParser10.instance().getCurrentMode();
        if (MediaMode.BURST == currentMode || MediaMode.AEB == currentMode || MediaMode.SINGLE == currentMode || MediaMode.TIMELAPSE == currentMode) {
            SDCardState sDCardStatus = AutelCameraStatusWithParser10.instance().getSDCardStatus();
            if (sDCardStatus == SDCardState.CARD_READY || sDCardStatus == SDCardState.LOW_SPEED_CARD) {
                this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
                    public void onSuccess(WorkState workState) {
                        if (WorkState.IDLE != workState) {
                            CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                            if (callbackWithNoParam != null) {
                                callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE);
                                return;
                            }
                            return;
                        }
                        BaseCamera10PreconditionProxy.this.baseCameraService.startTakePhoto(callbackWithNoParam);
                    }

                    public void onFailure(AutelError autelError) {
                        CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(autelError);
                        }
                    }
                });
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(sDCardStatus.getError());
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_PHOTO_MODE);
        }
    }

    public void startRecordVideo(final CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == AutelCameraStatusWithParser10.instance().getCurrentMode()) {
            this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
                public void onSuccess(WorkState workState) {
                    if (WorkState.IDLE != workState) {
                        CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_IDLE_STATE);
                            return;
                        }
                        return;
                    }
                    SDCardState sDCardStatus = AutelCameraStatusWithParser10.instance().getSDCardStatus();
                    if (sDCardStatus == SDCardState.CARD_READY || sDCardStatus == SDCardState.LOW_SPEED_CARD) {
                        BaseCamera10PreconditionProxy.this.baseCameraService.startRecordVideo(callbackWithNoParam);
                        return;
                    }
                    CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                    if (callbackWithNoParam2 != null) {
                        callbackWithNoParam2.onFailure(sDCardStatus.getError());
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
            callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_VIDEO_MODE);
        }
    }

    public void stopRecordVideo(final CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == AutelCameraStatusWithParser10.instance().getCurrentMode()) {
            this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
                public void onSuccess(WorkState workState) {
                    if (WorkState.RECORD != workState) {
                        CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_RECORD_NOT_ON_RECORD_STATE);
                            return;
                        }
                        return;
                    }
                    BaseCamera10PreconditionProxy.this.baseCameraService.stopRecordVideo(callbackWithNoParam);
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_RECORD_NOT_ON_VIDEO_MODE);
        }
    }

    public void stopTakePhoto(final CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.TIMELAPSE == AutelCameraStatusWithParser10.instance().getCurrentMode()) {
            this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
                public void onSuccess(WorkState workState) {
                    if (WorkState.CAPTURE != workState) {
                        CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_TIMELAPSE_NOT_ON_CAPTURE_STATE);
                            return;
                        }
                        return;
                    }
                    BaseCamera10PreconditionProxy.this.baseCameraService.stopTakePhoto(callbackWithNoParam);
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_STOP_TIMELAPSE_NOT_ON_TIMELAPSE_MODE);
        }
    }

    public void formatSDCard(final CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
            public void onSuccess(WorkState workState) {
                CallbackWithNoParam callbackWithNoParam;
                if (WorkState.IDLE != workState) {
                    CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                    if (callbackWithNoParam2 != null) {
                        callbackWithNoParam2.onFailure(AutelError.CAMERA_SDCARD_FORMAT_NOT_ON_IDLE_MODE);
                        return;
                    }
                    return;
                }
                SDCardState sDCardStatus = AutelCameraStatusWithParser10.instance().getSDCardStatus();
                AutelError autelError = null;
                if (SDCardState.CARD_ERROR == sDCardStatus) {
                    autelError = AutelError.CAMERA_SDCARD_STATE_CARD_ERROR;
                } else if (SDCardState.CARD_NOT_SUPPORT == sDCardStatus) {
                    autelError = AutelError.CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT;
                } else if (SDCardState.CARD_PROTECT == sDCardStatus) {
                    autelError = AutelError.CAMERA_SDCARD_STATE_CARD_PROTECT;
                } else if (SDCardState.NO_CARD == sDCardStatus) {
                    autelError = AutelError.CAMERA_SDCARD_STATE_NO_CARD;
                }
                if (autelError == null || (callbackWithNoParam = callbackWithNoParam) == null) {
                    BaseCamera10PreconditionProxy.this.baseCameraService.formatSDCard(callbackWithNoParam);
                } else {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void resetDefaults(final CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.getWorkState(new CallbackWithOneParam<WorkState>() {
            public void onSuccess(WorkState workState) {
                if (WorkState.IDLE != workState) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_RESET_NOT_ON_IDLE_MODE);
                        return;
                    }
                    return;
                }
                BaseCamera10PreconditionProxy.this.baseCameraService.resetDefaults(callbackWithNoParam);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
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

    public void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        this.baseCameraService.setMediaMode(mediaMode, callbackWithNoParam);
    }

    public void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.baseCameraService.getMediaMode(callbackWithOneParam);
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

    public void init(IAutelStateManager iAutelStateManager) {
        this.baseCameraService.init(iAutelStateManager);
    }

    public void destroy() {
        this.baseCameraService.destroy();
    }
}
