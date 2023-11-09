package com.autel.camera.protocol.protocol10.request;

import com.autel.camera.communication.tcp.connection.events.CameraControllerDispatcher;
import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.engine.CameraCommandMsgFactory;
import com.autel.camera.protocol.protocol10.engine.CameraEvents;
import com.autel.camera.protocol.protocol10.parser.BaseRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import java.util.concurrent.ConcurrentHashMap;

public class CameraBase10Request extends BaseRequest {
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, CallbackWithOneParam<CameraEvents>> mEventListener;

    private CameraBase10Request() {
        this.mEventListener = new ConcurrentHashMap<>();
        initRegisterListener();
    }

    public void getCameraAllSetting(final CallbackWithOneParam<AutelCameraSettingWithParser10> callbackWithOneParam) {
        querySetting(CameraCommandMsgFactory.createCameraSetting(), new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                AutelCameraSettingWithParser10.instance().parserParams(baseCameraMsgParser);
                callbackWithOneParam.onSuccess(AutelCameraSettingWithParser10.instance());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraStatus(final CallbackWithOneParam<AutelCameraStatusWithParser10> callbackWithOneParam) {
        query(CameraCommandMsgFactory.createCameraStatus(), new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                AutelCameraStatusWithParser10.instance().parserParams(baseCameraMsgParser);
                callbackWithOneParam.onSuccess(AutelCameraStatusWithParser10.instance());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraCurrentDate(), callbackWithNoParam);
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createFormatSDcard(), callbackWithNoParam);
    }

    public void resetCamera(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraReset(), callbackWithNoParam);
    }

    public void setCameraMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraMode(mediaMode.getValue10()), callbackWithNoParam);
    }

    public void takePhoto(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraTakenPhoto(), callbackWithNoParam);
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraStartVideo(), callbackWithNoParam);
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraStopVideo(), callbackWithNoParam);
    }

    public void stopTimelapse(CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraStopTimplase(), callbackWithNoParam);
    }

    private static class CameraBase10RequestHolder {
        /* access modifiers changed from: private */
        public static final CameraBase10Request s_instance = new CameraBase10Request();

        private CameraBase10RequestHolder() {
        }
    }

    public static CameraBase10Request instance() {
        return CameraBase10RequestHolder.s_instance;
    }

    public void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam) {
        if (!this.mEventListener.contains(str)) {
            this.mEventListener.put(str, callbackWithOneParam);
        }
    }

    public void removeCameraEventsListener(String str) {
        this.mEventListener.remove(str);
    }

    private void initRegisterListener() {
        CameraControllerDispatcher.instance().registerReceiveListener(CameraConstant10.setCameraNotificationListener, new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                CameraEvents cameraEvents = new CameraEvents();
                String param = baseCameraMsgParser.getParam("type");
                String param2 = baseCameraMsgParser.getParam("param");
                cameraEvents.setType(param);
                cameraEvents.setParam(param2);
                if (CameraConstant10.CAMERA_TYPE_SDCARD_STATUS.equals(param)) {
                    AutelCameraStatusInternal.instance().setCardStatus(param2);
                } else if ("mode".equals(param)) {
                    AutelCameraStatusInternal.instance().setCurrentMode(param2);
                } else if (CameraConstant10.KEY_CAMERA_LUMABIAS.equals(param)) {
                    AutelCameraSettingInternal.instance().setAeLock(param2);
                }
                CameraBase10Request cameraBase10Request = CameraBase10Request.this;
                cameraBase10Request.callbackListener(cameraBase10Request.mEventListener, cameraEvents);
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> void callbackListener(ConcurrentHashMap<String, CallbackWithOneParam<T>> concurrentHashMap, T t) {
        if (!concurrentHashMap.isEmpty()) {
            for (CallbackWithOneParam<T> onSuccess : concurrentHashMap.values()) {
                onSuccess.onSuccess(t);
            }
        }
    }
}
