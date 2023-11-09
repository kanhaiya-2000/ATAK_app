package com.autel.sdk.battery.p004rx;

import com.autel.common.battery.BatteryParameterRangeManager;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.battery.rx.RxAutelBattery */
public interface RxAutelBattery {
    Observable<Float> getCriticalBatteryNotifyThreshold();

    Observable<Integer> getDischargeCount();

    Observable<Integer> getDischargeDay();

    Observable<Integer> getFullChargeCapacity();

    Observable<Float> getLowBatteryNotifyThreshold();

    Observable<BatteryParameterRangeManager> getParameterSupportManager();

    Observable<String> getSerialNumber();

    Observable<String> getVersion();

    Observable<Boolean> setCriticalBatteryNotifyThreshold(float f);

    Observable<Boolean> setDischargeDay(int i);

    Observable<Boolean> setLowBatteryNotifyThreshold(float f);
}
