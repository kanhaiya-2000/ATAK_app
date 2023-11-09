package com.autel.sdk.camera;

import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;

public interface AutelCameraManager {
    void setCameraChangeListener(CallbackWithTwoParams<CameraProduct, AutelBaseCamera> callbackWithTwoParams);
}
