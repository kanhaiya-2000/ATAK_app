package com.autel.sdk.battery;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.sdk.battery.p004rx.RxAutelBattery;

/* renamed from: com.autel.sdk.battery.AutelBattery */
public interface C4928AutelBattery {
    void getCriticalBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam);

    void getDischargeCount(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getDischargeDay(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getFullChargeCapacity(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getLowBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam);

    BatteryParameterRangeManager getParameterSupportManager();

    void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam);

    void getVersion(CallbackWithOneParam<String> callbackWithOneParam);

    void setCriticalBatteryNotifyThreshold(float f, CallbackWithNoParam callbackWithNoParam);

    void setDischargeDay(int i, CallbackWithNoParam callbackWithNoParam);

    void setLowBatteryNotifyThreshold(float f, CallbackWithNoParam callbackWithNoParam);

    RxAutelBattery toRx();
}
