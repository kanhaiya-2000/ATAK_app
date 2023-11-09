package com.autel.internal.camera;

import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.CameraEvents;
import com.autel.camera.protocol.protocol10.interfaces.base.BaseCameraService;
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
import com.autel.internal.sdk.album.AlbumMediaItem;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;

public abstract class BaseCamera10 implements BaseCameraService {
    private static final String MediaModeTag = "MediaModeTag";
    private static final String MediaStateTag = "MediaStatus";
    private static final String SDCardState = "SDCardState";
    private static final String UploadGoalArea = "UploadGoalArea";
    private static final String setCameraConnectStateListenerTAG = "setCameraConnectStateListenerTAG";
    public static final String setCameraInitTAG = "setCameraInitTAG";
    protected BaseCameraService baseCamera10 = new com.autel.camera.protocol.protocol10.base.BaseCamera10();

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void getGpsCoordinateType(CallbackWithOneParam<Integer> callbackWithOneParam) {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
    }

    public void setGpsCoordinateType(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxAutelBaseCamera toRx() {
        return null;
    }

    public void setMediaModeListener(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.addCameraEventsListener(MediaModeTag, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if ("mode".equals(cameraEvents.getType())) {
                        callbackWithOneParam.onSuccess(MediaMode.find(cameraEvents.getParam()));
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.baseCamera10.addCameraEventsListener(MediaModeTag, (CallbackWithOneParam<CameraEvents>) null);
        }
    }

    public void setSDCardStateListener(final CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.addCameraEventsListener(SDCardState, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant10.CAMERA_TYPE_SDCARD_STATUS.equals(cameraEvents.getType())) {
                        callbackWithOneParam.onSuccess(SDCardState.find(cameraEvents.getParam()));
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.baseCamera10.addCameraEventsListener(SDCardState, (CallbackWithOneParam<CameraEvents>) null);
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.formatSDCard(callbackWithNoParam);
    }

    public void resetDefaults(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.resetDefaults(callbackWithNoParam);
    }

    public void getWorkState(CallbackWithOneParam<WorkState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.getWorkStatus(callbackWithOneParam);
        }
    }

    public void getSDCardState(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.getSDCardStatus(callbackWithOneParam);
        }
    }

    public void getSDCardFreeSpace(CallbackWithOneParam<Long> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.getSDCardFreeSpace(callbackWithOneParam);
        }
    }

    public CameraProduct getProduct() {
        return this.baseCamera10.getProduct();
    }

    public void getVersion(final CallbackWithOneParam<String> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
                public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                    callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getVersion());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMediaStateListener(final CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            this.baseCamera10.addCameraEventsListener(MediaStateTag, new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithTwoParams.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant10.CAMERA_TYPE_SINGLE_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.CAPTURE);
                        callbackWithTwoParams.onSuccess(MediaStatus.SINGLE_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_BURST_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.CAPTURE);
                        callbackWithTwoParams.onSuccess(MediaStatus.BURST_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_TIME_LAPSE_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.CAPTURE);
                        callbackWithTwoParams.onSuccess(MediaStatus.TIME_LAPSE_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_AEB_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.CAPTURE);
                        callbackWithTwoParams.onSuccess(MediaStatus.AUTO_EXPOSURE_BURST_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_BURST_STOP.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.BURST_STOP, null);
                    } else if (CameraConstant10.CAMERA_TYPE_AEB_STOP.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.AUTO_EXPOSURE_BURST_STOP, null);
                    } else if (CameraConstant10.CAMERA_TYPE_TIME_LAPSE_STOP.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.TIME_LAPSE_STOP, null);
                    } else if (CameraConstant10.CAMERA_TYPE_PHOTO_OK.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_CAT, null);
                    } else if (CameraConstant10.CAMERA_TYPE_SAVED_ONE.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_SAVE, new AlbumMediaItem(false, cameraEvents.getParam()).getSmallThumbnail());
                    } else if (CameraConstant10.CAMERA_TYPE_PHOTO_TAKEN.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_TAKEN_DONE, new AlbumMediaItem(false, cameraEvents.getParam()).getSmallThumbnail());
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.RECORD);
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_COMPLETE.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_STOP, new AlbumMediaItem(false, cameraEvents.getParam()).getSmallThumbnail());
                    } else if (CameraConstant10.CAMERA_TYPE_POWER_SHUTDOWN.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.SHUTDOWN, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_REPAIR_START.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.RECOVER_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_REPAIR_SUCCESS.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.RECOVER_COMPLETE, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_REPAIR_FAILED.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.RECOVER_FAILED, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_BUFFER_FULL.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_BUFFER_FULL, null);
                    } else if (CameraConstant10.CAMERA_TYPE_FWUPDATE.equals(cameraEvents.getType())) {
                        callbackWithTwoParams.onSuccess(MediaStatus.UPDATING, null);
                    }
                }
            });
        } else {
            this.baseCamera10.addCameraEventsListener(MediaStateTag, (CallbackWithOneParam<CameraEvents>) null);
        }
    }

    public void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.setMediaMode(mediaMode, callbackWithNoParam);
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.startTakePhoto(callbackWithNoParam);
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.startRecordVideo(callbackWithNoParam);
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.stopRecordVideo(callbackWithNoParam);
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        this.baseCamera10.stopTakePhoto(callbackWithNoParam);
    }

    public void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.baseCamera10.getMediaMode(callbackWithOneParam);
        }
    }

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.baseCamera10.setCameraPattern(cameraPattern, callbackWithNoParam);
        }
    }
}
