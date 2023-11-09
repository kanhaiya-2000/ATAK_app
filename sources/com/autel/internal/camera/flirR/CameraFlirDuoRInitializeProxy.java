package com.autel.internal.camera.flirR;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.CameraFactory;
import com.autel.internal.camera.flir.CameraFlirDuoInitializeProxy;
import com.autel.internal.camera.p001rx.RxAutelFlirDuoR;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public class CameraFlirDuoRInitializeProxy extends CameraFlirDuoInitializeProxy implements CameraFlirDuoRService4Initialize {
    CameraFlirDuoRService cameraFlirRService;
    RxAutelFlirDuoR mRxAutelFlirDuoR;

    public CameraFlirDuoRInitializeProxy(AutelListenerManager autelListenerManager) {
        super(autelListenerManager);
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraFlirDuoRService createFlirR = CameraFactory.createFlirR(autelServiceVersion);
        this.cameraFlirRService = createFlirR;
        this.cameraFlirService = createFlirR;
        this.cameraService = this.cameraFlirRService;
        return this.cameraFlirRService;
    }

    public void getRadiometrySetting(CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirRService.getRadiometrySetting(callbackWithOneParam);
        }
    }

    public void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirRService.setRadiometrySetting(fLIRRadiometrySetting, callbackWithNoParam);
        }
    }

    public RxAutelFlirDuoR toRx() {
        if (this.mRxAutelFlirDuoR == null) {
            this.mRxAutelFlirDuoR = new RxAutelFlirDuoRImpl(this);
        }
        return this.mRxAutelFlirDuoR;
    }
}
