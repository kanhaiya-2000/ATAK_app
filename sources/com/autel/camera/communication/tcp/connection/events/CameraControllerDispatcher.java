package com.autel.camera.communication.tcp.connection.events;

import android.os.Handler;
import android.os.HandlerThread;
import com.autel.camera.communication.tcp.CameraController;
import com.autel.camera.communication.tcp.CameraHeartBeat;
import com.autel.camera.protocol.protocol10.base.BaseCamera10;
import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.interfaces.base.BaseCameraService;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.util.concurrent.ConcurrentHashMap;

public class CameraControllerDispatcher {
    private static final String TAG = "MessageDisPatcher";
    private BaseCameraService baseCameraService;
    private ConcurrentHashMap<String, CallbackWithOneParam<BaseCameraMsgParser>> listenerManager;
    private final ConcurrentHashMap<String, IConnectionListener> mConnectionListeners;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    private CameraControllerDispatcher() {
        this.listenerManager = new ConcurrentHashMap<>();
        this.mConnectionListeners = new ConcurrentHashMap<>();
        this.baseCameraService = new BaseCamera10();
        initHandler();
    }

    public static CameraControllerDispatcher instance() {
        return CameraControllerDispatcherHolder.s_instance;
    }

    private static class CameraControllerDispatcherHolder {
        /* access modifiers changed from: private */
        public static final CameraControllerDispatcher s_instance = new CameraControllerDispatcher();

        private CameraControllerDispatcherHolder() {
        }
    }

    public void registerConnectListener(String str, IConnectionListener iConnectionListener) {
        if (!this.mConnectionListeners.containsKey(str) && iConnectionListener != null) {
            this.mConnectionListeners.put(str, iConnectionListener);
        }
    }

    public void unRegisterConnectListener(String str) {
        this.mConnectionListeners.remove(str);
    }

    private void initHandler() {
        if (this.mHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("camera1.0 message parser Thread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
    }

    public void onDisPatchPacket(String str) {
        if (this.mHandler == null) {
            initHandler();
        }
        this.mHandler.post(new ProcessPacketTask(str));
    }

    public void registerReceiveListener(String str, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        this.listenerManager.put(str, callbackWithOneParam);
    }

    public void unRegisterReceiveListener(String str) {
        this.listenerManager.remove(str);
    }

    private class ProcessPacketTask implements Runnable {
        private BaseCameraMsgParser mMessageParser = new BaseCameraMsgParser();
        private String msg;

        public ProcessPacketTask(String str) {
            this.msg = str;
        }

        public void run() {
            try {
                this.mMessageParser.parserData(this.msg);
                int msg_Id = this.mMessageParser.getMsg_Id();
                String str = CameraConstant10.CameraListener;
                if (msg_Id == 257) {
                    CameraController.instance().setTcpCameraToken(this.mMessageParser.getIntParam("param"));
                    CameraHeartBeat.instance().connect();
                    CameraControllerDispatcher.this.requestCamera10();
                    return;
                }
                if (msg_Id == 7) {
                    str = CameraConstant10.setCameraNotificationListener;
                }
                CameraControllerDispatcher.this.dispatchPacket(str, this.mMessageParser);
            } catch (Exception e) {
                e.printStackTrace();
                AutelLog.m15084e(CameraControllerDispatcher.TAG, "ProcessPacketTask Exception----->>> " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchPacket(String str, Object obj) {
        CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam;
        if (obj != null && (callbackWithOneParam = this.listenerManager.get(str)) != null && (callbackWithOneParam instanceof CallbackWithOneParam)) {
            callbackWithOneParam.onSuccess(obj);
        }
    }

    /* access modifiers changed from: private */
    public void notifyConnected(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
        for (IConnectionListener onConnectStatus : this.mConnectionListeners.values()) {
            onConnectStatus.onConnectStatus(ConnectConnectStatus.CONNECTED);
        }
    }

    /* access modifiers changed from: private */
    public void requestCamera10() {
        setCameraCurrentData();
        getAllSetting();
    }

    /* access modifiers changed from: private */
    public void getAllSetting() {
        this.baseCameraService.getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
            public void onSuccess(AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                CameraControllerDispatcher.this.notifyConnected(autelCameraSettingWithParser10);
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "requestCamera10 queryCameraSetting success");
                CameraControllerDispatcher.this.getCameraStatus();
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "requestCamera10 getCameraSettings onFailure");
                CameraControllerDispatcher.this.getAllSetting();
            }
        });
    }

    /* access modifiers changed from: private */
    public void getCameraStatus() {
        this.baseCameraService.getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
            public void onSuccess(AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "requestCamera10 getCameraStatus success");
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "requestCamera10 getCameraStatus onFailure");
                CameraControllerDispatcher.this.getCameraStatus();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setCameraCurrentData() {
        this.baseCameraService.setCameraCurrentDate(new CallbackWithNoParam() {
            public void onSuccess() {
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "setCameraCurrentDate success");
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "setCameraCurrentDate onFailure");
                CameraControllerDispatcher.this.setCameraCurrentData();
            }
        });
    }
}
