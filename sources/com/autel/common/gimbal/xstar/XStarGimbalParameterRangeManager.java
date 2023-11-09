package com.autel.common.gimbal.xstar;

import com.autel.common.RangePair;
import com.autel.common.gimbal.GimbalParameterRangeManager;

public interface XStarGimbalParameterRangeManager extends GimbalParameterRangeManager {
    RangePair<Integer> getAngle();

    RangePair<Integer> getAngleWithSpeed();
}
