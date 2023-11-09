package com.autel.internal.camera.flirR;

import com.autel.camera.protocol.protocol20.flir.FlirDuoR;
import com.autel.camera.protocol.protocol20.interfaces.flir.CameraFlirDuoRService;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.camera.flir.CameraFlirDuo;
import com.autel.internal.camera.p001rx.RxAutelFlirDuoR;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public class CameraFlirDuoR extends CameraFlirDuo implements CameraFlirDuoRService {
    private CameraFlirDuoRService request = ((CameraFlirDuoRService) CameraFactory.getCameraProduct(FlirDuoR.class));

    public RxAutelFlirDuoR toRx() {
        return null;
    }

    public void getRadiometrySetting(CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam) {
        this.request.getRadiometrySetting(callbackWithOneParam);
    }

    public void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setRadiometrySetting(fLIRRadiometrySetting, callbackWithNoParam);
    }
}
