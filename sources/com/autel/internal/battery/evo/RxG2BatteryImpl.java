package com.autel.internal.battery.evo;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.evo.EvoBatteryInfo;
import com.autel.internal.battery.RxAutelBatteryImpl;
import com.autel.sdk.battery.EvoBattery;
import com.autel.sdk.battery.p004rx.RxEvoBattery;

public class RxG2BatteryImpl extends RxAutelBatteryImpl implements RxEvoBattery {
    EvoBattery mAutelBattery;

    public RxG2BatteryImpl(EvoBattery evoBattery) {
        super(evoBattery);
        this.mAutelBattery = evoBattery;
    }

    public void setBatteryStateListener(CallbackWithOneParam<EvoBatteryInfo> callbackWithOneParam) {
        this.mAutelBattery.setBatteryStateListener(callbackWithOneParam);
    }
}
