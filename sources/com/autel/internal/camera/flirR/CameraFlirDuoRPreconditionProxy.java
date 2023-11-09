package com.autel.internal.camera.flirR;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.flir.CameraFlirDuoPreconditionProxy;
import com.autel.internal.camera.p001rx.RxAutelFlirDuoR;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public class CameraFlirDuoRPreconditionProxy extends CameraFlirDuoPreconditionProxy implements CameraFlirDuoRService {
    private CameraFlirDuoRService cameraFlirRService;

    public RxAutelFlirDuoR toRx() {
        return null;
    }

    public CameraFlirDuoRPreconditionProxy(CameraFlirDuoRService cameraFlirDuoRService) {
        super(cameraFlirDuoRService);
        this.cameraFlirRService = cameraFlirDuoRService;
    }

    public void getRadiometrySetting(CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam) {
        this.cameraFlirRService.getRadiometrySetting(callbackWithOneParam);
    }

    public void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam) {
        if (fLIRRadiometrySetting != null) {
            this.cameraFlirRService.setRadiometrySetting(fLIRRadiometrySetting, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }
}
