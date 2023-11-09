package com.autel.common.flycontroller;

import com.autel.common.RangePair;

public interface FlyControllerParameterRangeManager {
    RangePair<Float> getHeightRange();

    RangePair<Float> getHorizontalSpeedRange();

    RangePair<Float> getRangeOfMaxRange();

    RangePair<Float> getReturnHeightRange();
}
