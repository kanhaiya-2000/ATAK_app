package com.autel.camera.protocol.protocol10.parser;

import com.autel.camera.protocol.protocol10.engine.CameraCommandMessage;
import com.autel.camera.protocol.protocol10.request.RequestManager;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;

public class BaseRequest {
    public void query(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        RequestManager.instance().request(cameraCommandMessage, callbackWithOneParam);
    }

    public void querySetting(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        RequestManager.instance().requestSetting(cameraCommandMessage, callbackWithOneParam);
    }

    public void request(CameraCommandMessage cameraCommandMessage, final CallbackWithNoParam callbackWithNoParam) {
        RequestManager.instance().request(cameraCommandMessage, new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
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
}
