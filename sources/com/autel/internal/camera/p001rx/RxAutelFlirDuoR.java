package com.autel.internal.camera.p001rx;

import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;
import io.reactivex.Observable;

/* renamed from: com.autel.internal.camera.rx.RxAutelFlirDuoR */
public interface RxAutelFlirDuoR extends RxAutelFlirDuo {
    Observable<FLIRRadiometrySetting> getRadiometrySetting();

    Observable<Boolean> setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting);
}
