package com.autel.camera.protocol.protocol20.interfaces.flir;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public interface CameraFlirDuoR extends CameraFlirDuoService {
    void getRadiometrySetting(CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam);

    void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam);
}
