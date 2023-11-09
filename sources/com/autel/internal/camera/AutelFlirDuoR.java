package com.autel.internal.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.camera.p001rx.RxAutelFlirDuoR;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public interface AutelFlirDuoR extends AutelFlirDuo {
    void getRadiometrySetting(CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam);

    void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam);

    RxAutelFlirDuoR toRx();
}
