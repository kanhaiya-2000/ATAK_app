package com.autel.common.gimbal.evo;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.gimbal.GimbalParameterRangeManager;

public interface EvoGimbalParameterRangeManager extends GimbalParameterRangeManager {
    void getAngleRange(CallbackWithOneParam<GimbalAngleRange> callbackWithOneParam);

    RangePair<Integer> getAngleSpeedRange();
}
