package com.autel.sdk.battery.p004rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.evo.EvoBatteryInfo;

/* renamed from: com.autel.sdk.battery.rx.RxEvoBattery */
public interface RxEvoBattery extends RxAutelBattery {
    void setBatteryStateListener(CallbackWithOneParam<EvoBatteryInfo> callbackWithOneParam);
}
