package com.autel.sdk.gimbal;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.xstar.XStarGimbalParameterRangeManager;
import com.autel.sdk.gimbal.p008rx.RxXStarGimbal;

public interface XStarGimbal extends C4931AutelGimbal {
    XStarGimbalParameterRangeManager getParameterRangeManager();

    void setAngleListener(CallbackWithOneParam<Integer> callbackWithOneParam);

    void setGimbalAngle(float f);

    void setGimbalAngleWithSpeed(int i);

    void setGimbalStateListener(CallbackWithOneParam<GimbalState> callbackWithOneParam);

    void setRollAdjustData(GimbalRollAngleAdjust gimbalRollAngleAdjust, CallbackWithOneParam<Double> callbackWithOneParam);

    RxXStarGimbal toRx();
}
