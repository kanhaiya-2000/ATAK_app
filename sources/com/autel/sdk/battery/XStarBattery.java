package com.autel.sdk.battery;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryState;

public interface XStarBattery extends C4928AutelBattery {
    void getCapacity(CallbackWithOneParam<Float> callbackWithOneParam);

    void getCurrent(CallbackWithOneParam<Float> callbackWithOneParam);

    void getDesignCapacity(CallbackWithOneParam<Float> callbackWithOneParam);

    void getRemainingPercent(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getTemperature(CallbackWithOneParam<Float> callbackWithOneParam);

    void getVoltage(CallbackWithOneParam<Float> callbackWithOneParam);

    void getVoltageCells(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setBatteryStateListener(CallbackWithOneParam<BatteryState> callbackWithOneParam);
}
