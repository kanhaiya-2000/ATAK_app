package com.autel.sdk.gimbal.p008rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.xstar.XStarGimbalParameterRangeManager;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.gimbal.rx.RxXStarGimbal */
public interface RxXStarGimbal extends RxAutelGimbal {
    Observable<XStarGimbalParameterRangeManager> getParameterRangeManager();

    void setAngleListener(CallbackWithOneParam<Integer> callbackWithOneParam);

    void setGimbalAngle(float f);

    void setGimbalAngleWithSpeed(int i);

    void setGimbalStateListener(CallbackWithOneParam<GimbalState> callbackWithOneParam);

    Observable<Double> setRollAdjustData(GimbalRollAngleAdjust gimbalRollAngleAdjust);
}
