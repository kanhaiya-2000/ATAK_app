package com.autel.camera.protocol.protocol10.request;

import com.autel.camera.communication.tcp.CameraController;
import com.autel.camera.communication.tcp.connection.events.CameraControllerDispatcher;
import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.CameraCommandMessage;
import com.autel.camera.protocol.protocol10.interfaces.base.ICameraRequest;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestManager implements ICameraRequest, CallbackWithOneParam<BaseCameraMsgParser> {
    private final String TAG;
    private ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> messageList;
    private ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> msgSettingList;

    public void onFailure(AutelError autelError) {
    }

    private RequestManager() {
        this.TAG = "RequestManager";
        this.messageList = new ConcurrentHashMap<>();
        this.msgSettingList = new ConcurrentHashMap<>();
        CameraControllerDispatcher.instance().registerReceiveListener(CameraConstant10.CameraListener, this);
    }

    public static ICameraRequest instance() {
        return RequestManagerHolder.s_instance;
    }

    private static class RequestManagerHolder {
        /* access modifiers changed from: private */
        public static final ICameraRequest s_instance = new RequestManager();

        private RequestManagerHolder() {
        }
    }

    public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
        if (baseCameraMsgParser.getMsg_Id() != 3) {
            callbackSuccess(this.messageList, baseCameraMsgParser);
        } else if (baseCameraMsgParser.parserParam(baseCameraMsgParser.getParam("param")).size() > 15) {
            callbackSuccess(this.msgSettingList, baseCameraMsgParser);
        } else {
            callbackSuccess(this.messageList, baseCameraMsgParser);
        }
    }

    public void request(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.messageList.put(cameraCommandMessage, callbackWithOneParam);
        }
        if (!CameraController.instance().sendMessage(cameraCommandMessage)) {
            this.messageList.remove(cameraCommandMessage);
        } else {
            CameraController.instance().setMessageList(this.messageList);
        }
    }

    public void requestSetting(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.msgSettingList.put(cameraCommandMessage, callbackWithOneParam);
        }
        if (!CameraController.instance().sendMessage(cameraCommandMessage)) {
            this.msgSettingList.remove(cameraCommandMessage);
        } else {
            CameraController.instance().setMessageList(this.msgSettingList);
        }
    }

    private void callbackSuccess(ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> concurrentHashMap, BaseCameraMsgParser baseCameraMsgParser) {
        for (Map.Entry<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> key : concurrentHashMap.entrySet()) {
            CameraCommandMessage cameraCommandMessage = (CameraCommandMessage) key.getKey();
            if (cameraCommandMessage != null && cameraCommandMessage.getMsgId() == baseCameraMsgParser.getMsg_Id()) {
                callback(concurrentHashMap, cameraCommandMessage, baseCameraMsgParser);
            }
        }
    }

    private void callback(final ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> concurrentHashMap, final CameraCommandMessage cameraCommandMessage, final BaseCameraMsgParser baseCameraMsgParser) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                CallbackWithOneParam callbackWithOneParam = (CallbackWithOneParam) concurrentHashMap.get(cameraCommandMessage);
                if (callbackWithOneParam != null) {
                    if (baseCameraMsgParser.getRval() == 0) {
                        callbackWithOneParam.onSuccess(baseCameraMsgParser);
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
                concurrentHashMap.remove(cameraCommandMessage);
            }
        });
    }
}
