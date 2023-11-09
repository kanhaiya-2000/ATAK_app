package com.autel.sdk.battery;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.evo.EvoBatteryInfo;
import com.autel.sdk.battery.p004rx.RxEvoBattery;

public interface EvoBattery extends C4928AutelBattery {
    void setBatteryStateListener(CallbackWithOneParam<EvoBatteryInfo> callbackWithOneParam);

    RxEvoBattery toRx();
}
