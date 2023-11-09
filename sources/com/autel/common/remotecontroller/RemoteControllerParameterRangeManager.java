package com.autel.common.remotecontroller;

import com.autel.common.RangePair;

public interface RemoteControllerParameterRangeManager {
    RangePair<Integer> getDialAdjustSpeed();

    RangePair<Float> getYawCoefficient();
}
