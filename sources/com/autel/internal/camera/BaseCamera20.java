package com.autel.internal.camera;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.interfaces.base.BaseCameraService;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
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
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;

public abstract class BaseCamera20 implements BaseCameraService {
    private static final String MediaModeTag = "MediaModeTag";
    private static final String MediaStateTag = "MediaStatus";
    private static final String SdCardState = "SDCardState";
    private static final String UploadGoalArea = "UploadGoalArea";
    private static final String setCameraConnectStateListenerTAG = "setCameraConnectStateListenerTAG";
    public static final String setCameraInitTAG = "setCameraInitTAG";
    private BaseCameraService request = CameraFactory.getCameraProduct(com.autel.camera.protocol.protocol20.base.BaseCamera20.class);

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxAutelBaseCamera toRx() {
        return null;
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.request.setMediaModeListener(callbackWithOneParam);
    }

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.request.setSetSDCardStateListener(callbackWithOneParam);
    }

    public void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        this.request.setMediaStateListener(callbackWithTwoParams);
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        this.request.formatSDCard(callbackWithNoParam);
    }

    public void resetDefaults(CallbackWithNoParam callbackWithNoParam) {
        this.request.resetDefaults(callbackWithNoParam);
    }

    public void getWorkState(final CallbackWithOneParam<WorkState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getCameraSystemStatus(new CallbackWithOneParam<CameraAllSettings.SystemStatus>() {
                public void onSuccess(CameraAllSettings.SystemStatus systemStatus) {
                    WorkState workState = WorkState.UNKNOWN;
                    if (systemStatus != null) {
                        workState = WorkState.find(systemStatus.getSystemStatus());
                        if (WorkState.RECORD.equals(workState) && CameraConstant20.TAKING_PHOTO.equals(systemStatus.getPivState())) {
                            callbackWithOneParam.onSuccess(WorkState.RECORD_PHOTO_TAKING);
                            return;
                        }
                    }
                    callbackWithOneParam.onSuccess(workState);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getSDCardState(final CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                    callbackWithOneParam.onSuccess(SDCardState.find(sDCardStatus.getCardStatus()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getSDCardFreeSpace(final CallbackWithOneParam<Long> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
                this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                    public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                        callbackWithOneParam.onSuccess(Long.valueOf(sDCardStatus.getFreeSpace()));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            } else {
                this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                    public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                        callbackWithOneParam.onSuccess(Long.valueOf(sDCardStatus.getFreeSpace()));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            }
        }
    }

    public CameraProduct getProduct() {
        return this.request.getProduct();
    }

    public void getVersion(final CallbackWithOneParam<String> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getDeviceInformation(new CallbackWithOneParam<CameraAllSettings.DeviceInformation>() {
                public void onSuccess(CameraAllSettings.DeviceInformation deviceInformation) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    callbackWithOneParam.onSuccess(deviceInformation.getFirmwareVersion() + "");
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMediaMode(mediaMode, callbackWithNoParam);
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        this.request.startTakePhoto(callbackWithNoParam);
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        this.request.startRecordVideo(callbackWithNoParam);
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        this.request.stopRecordVideo(callbackWithNoParam);
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        this.request.stopTakePhoto(callbackWithNoParam);
    }

    public void getMediaMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getCameraSystemStatus(new CallbackWithOneParam<CameraAllSettings.SystemStatus>() {
                public void onSuccess(CameraAllSettings.SystemStatus systemStatus) {
                    callbackWithOneParam.onSuccess(MediaMode.find(systemStatus.getCurrentMode()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setCameraPattern(CameraPattern cameraPattern, final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setCameraPattern(cameraPattern, new CallbackWithNoParam() {
                public void onSuccess() {
                    callbackWithNoParam.onSuccess();
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                }
            });
        }
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, final CallbackWithNoParam callbackWithNoParam) {
        this.request.lockGimbalWhenTakePhoto(autelSwitchState, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setGpsCoordinateType(int i, final CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().setGpsCoordinateType(i, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getGpsCoordinateType(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        BaseCameraRequest.instance().getGpsCoordinateType(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                callbackWithOneParam.onSuccess(Integer.valueOf(baseCameraMsgParser.getIntParam(CameraParamsConfig.param_GPSMapDatum)));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}
