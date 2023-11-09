package com.autel.sdk.gimbal;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalAdjustmentAngle;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.gimbal.evo.EvoGimbalParameterRangeManager;
import com.autel.sdk.gimbal.p008rx.RxEvoGimbal;

public interface EvoGimbal extends C4931AutelGimbal {
    void getAdjustGimbalAngelData(CallbackWithOneParam<GimbalAdjustmentAngle> callbackWithOneParam);

    EvoGimbalParameterRangeManager getParameterRangeManager();

    void getPitchAdjustData(CallbackWithOneParam<Double> callbackWithOneParam);

    void getRollAdjustData(CallbackWithOneParam<Double> callbackWithOneParam);

    void getYawAdjustData(CallbackWithOneParam<Double> callbackWithOneParam);

    void resetGimbalAngle(GimbalAxisType gimbalAxisType, CallbackWithNoParam callbackWithNoParam);

    void setAngleListener(CallbackWithOneParam<EvoAngleInfo> callbackWithOneParam);

    void setGimbalAngle(float f, float f2, float f3);

    void setGimbalAngleWithSpeed(float f);

    void setGimbalCalibration(CallbackWithNoParam callbackWithNoParam);

    void setPitchAdjustData(float f, CallbackWithNoParam callbackWithNoParam);

    void setRollAdjustData(float f, CallbackWithNoParam callbackWithNoParam);

    void setSaveParams(CallbackWithNoParam callbackWithNoParam);

    void setYawAdjustData(float f, CallbackWithNoParam callbackWithNoParam);

    RxEvoGimbal toRx();
}
