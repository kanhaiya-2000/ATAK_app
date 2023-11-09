package com.autel.sdk.battery.p004rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryState;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.battery.rx.RxXStarBattery */
public interface RxXStarBattery extends RxAutelBattery {
    Observable<Float> getCapacity();

    Observable<int[]> getCells();

    Observable<Float> getCurrent();

    Observable<Float> getDesignCapacity();

    Observable<Integer> getRemainingPercent();

    Observable<Float> getTemperature();

    Observable<Float> getVoltage();

    void setBatteryStateListener(CallbackWithOneParam<BatteryState> callbackWithOneParam);
}
