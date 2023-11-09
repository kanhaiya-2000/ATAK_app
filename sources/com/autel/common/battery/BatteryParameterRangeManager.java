package com.autel.common.battery;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;

public interface BatteryParameterRangeManager {
    void getBatteryCellVoltageRange(CallbackWithOneParam<RangePair<Integer>> callbackWithOneParam);

    RangePair<Float> getCriticalBattery();

    RangePair<Integer> getDischargeDay();

    RangePair<Float> getLowBattery();
}
