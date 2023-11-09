package com.autel.sdk.gimbal.p008rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalAdjustmentAngle;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.gimbal.evo.EvoGimbalParameterRangeManager;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.gimbal.rx.RxEvoGimbal */
public interface RxEvoGimbal extends RxAutelGimbal {
    Observable<GimbalAdjustmentAngle> getAdjustGimbalAngelData();

    Observable<EvoGimbalParameterRangeManager> getParameterRangeManager();

    Observable<Boolean> resetGimbalAngle(GimbalAxisType gimbalAxisType);

    void setAngleListener(CallbackWithOneParam<EvoAngleInfo> callbackWithOneParam);

    void setGimbalAngle(float f, float f2, float f3);

    void setGimbalAngleWithSpeed(float f);

    Observable<Boolean> setGimbalCalibration();

    void setPitchAdjustData(float f);

    void setRollAdjustData(float f);

    Observable<Boolean> setSaveParams();

    void setYawAdjustData(float f);
}
