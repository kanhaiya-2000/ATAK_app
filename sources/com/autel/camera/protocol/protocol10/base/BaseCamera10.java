package com.autel.camera.protocol.protocol10.base;

import android.text.TextUtils;
import android.util.Log;
import com.autel.camera.communication.CameraConnection;
import com.autel.camera.heartbeat.heartbeat10.CameraHeartBeat10;
import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.engine.CameraEvents;
import com.autel.camera.protocol.protocol10.interfaces.base.BaseCameraService;
import com.autel.camera.protocol.protocol10.request.CameraBase10Request;
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
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;

public class BaseCamera10 implements BaseCameraService {
    private static final String TAG = "BaseCamera10";

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
    }

    public void setConnectStateListener(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            CameraHeartBeat10.instance().unRegisterConnectListener(TAG);
        } else {
            CameraHeartBeat10.instance().registerConnectListener(TAG, new IConnectionListener() {
                public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                    int i = C229813.f8459xf111a7b7[connectConnectStatus.ordinal()];
                    if (i == 1) {
                        callbackWithOneParam.onSuccess(true);
                    } else if (i == 2 || i == 3) {
                        callbackWithOneParam.onSuccess(false);
                    }
                }
            });
        }
    }

    /* renamed from: com.autel.camera.protocol.protocol10.base.BaseCamera10$13 */
    /* synthetic */ class C229813 {

        /* renamed from: $SwitchMap$com$autel$internal$sdk$camera$base$ConnectConnectStatus */
        static final /* synthetic */ int[] f8459xf111a7b7;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.internal.sdk.camera.base.ConnectConnectStatus[] r0 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8459xf111a7b7 = r0
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8459xf111a7b7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8459xf111a7b7     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.protocol.protocol10.base.BaseCamera10.C229813.<clinit>():void");
        }
    }

    public void setSDCardStateListener(final CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            addCameraEventsListener("setSetSDCardStateListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant10.CAMERA_TYPE_SDCARD_STATUS.equals(cameraEvents.getType())) {
                        callbackWithOneParam.onSuccess(SDCardState.find(cameraEvents.getParam()));
                    }
                }
            });
        } else {
            CameraBase10Request.instance().removeCameraEventsListener("setSetSDCardStateListener");
        }
    }

    public void setMediaModeListener(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            addCameraEventsListener("setMediaModeListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if ("mode".equals(cameraEvents.getType())) {
                        callbackWithOneParam.onSuccess(MediaMode.find(cameraEvents.getParam()));
                    }
                }
            });
        } else {
            CameraBase10Request.instance().removeCameraEventsListener("setMediaModeListener");
        }
    }

    public void setMediaStateListener(final CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            addCameraEventsListener("setMediaStateListener", new CallbackWithOneParam<CameraEvents>() {
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
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_SAVE, cameraEvents.getParam());
                    } else if (CameraConstant10.CAMERA_TYPE_PHOTO_TAKEN.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.PHOTO_TAKEN_DONE, cameraEvents.getParam());
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_START.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.RECORD);
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_START, null);
                    } else if (CameraConstant10.CAMERA_TYPE_RECORD_COMPLETE.equals(cameraEvents.getType())) {
                        AutelCameraStatusInternal.instance().setCameraStatus(CameraConstant10.IDLE);
                        callbackWithTwoParams.onSuccess(MediaStatus.RECORD_STOP, cameraEvents.getParam());
                    }
                }
            });
        } else {
            CameraBase10Request.instance().removeCameraEventsListener("setMediaStateListener");
        }
    }

    public void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            CameraBase10Request.instance().removeCameraEventsListener(str);
        } else {
            CameraBase10Request.instance().addCameraEventsListener(str, callbackWithOneParam);
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().formatSDCard(callbackWithNoParam);
    }

    public void resetDefaults(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().resetCamera(callbackWithNoParam);
        MsgPostManager.instance().postDelayed(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                Log.d("AbsTcpConnection", "resetdefaults---------");
                CameraConnection.instance().disconnect();
                MsgPostManager.instance().postDelayed(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        CameraConnection.instance().connect();
                    }
                }, 8000);
            }
        }, 2000);
    }

    public void getWorkStatus(final CallbackWithOneParam<WorkState> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraStatusWithParser10.getCameraStatus());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getSDCardStatus(final CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraStatusWithParser10.getSDCardStatus());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getSDCardFreeSpace(final CallbackWithOneParam<Long> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(Long.valueOf(autelCameraStatusWithParser10.getSdFreeSpace()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public CameraProduct getProduct() {
        String cameraModel = AutelCameraSettingWithParser10.instance().getCameraModel();
        CameraProduct cameraProduct = CameraProduct.UNKNOWN;
        if (!TextUtils.isEmpty(cameraModel)) {
            cameraModel.hashCode();
            if (cameraModel.equals("XB004")) {
                cameraProduct = CameraProduct.R12;
            }
        }
        AutelLog.m15084e(AutelLogTags.CAMERA_STATUS, "10 getProduct----->>> " + cameraProduct);
        return cameraProduct;
    }

    public void getTimeStamp(final CallbackWithOneParam<Long> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                callbackWithOneParam.onSuccess(Long.valueOf(autelCameraStatusWithParser10.getCurrentRecordTime()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVersion(final CallbackWithOneParam<String> callbackWithOneParam) {
        getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                callbackWithOneParam.onSuccess(autelCameraSettingWithParser10.getVersion());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setMediaMode(MediaMode mediaMode, final CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().setCameraMode(mediaMode, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getMediaMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                AutelCameraStatusInternal.instance().setCurrentMode(autelCameraStatusWithParser10.getCurrentMode().getValue10());
                callbackWithOneParam.onSuccess(autelCameraStatusWithParser10.getCurrentMode());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().takePhoto(callbackWithNoParam);
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().startRecordVideo(callbackWithNoParam);
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().stopRecordVideo(callbackWithNoParam);
    }

    public void stopTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().stopTimelapse(callbackWithNoParam);
    }

    public void getCameraSettings(CallbackWithOneParam<AutelCameraSettingWithParser10> callbackWithOneParam) {
        CameraBase10Request.instance().getCameraAllSetting(callbackWithOneParam);
    }

    public void getCameraStatus(CallbackWithOneParam<AutelCameraStatusWithParser10> callbackWithOneParam) {
        CameraBase10Request.instance().getCameraStatus(callbackWithOneParam);
    }

    public void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam) {
        CameraBase10Request.instance().setCameraCurrentDate(callbackWithNoParam);
    }
}
