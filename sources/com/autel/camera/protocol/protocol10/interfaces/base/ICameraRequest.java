package com.autel.camera.protocol.protocol10.interfaces.base;

import com.autel.camera.protocol.protocol10.engine.CameraCommandMessage;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;

public interface ICameraRequest {
    void request(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam);

    void requestSetting(CameraCommandMessage cameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam);
}
