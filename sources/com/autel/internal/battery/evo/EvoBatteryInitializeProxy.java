package com.autel.internal.battery.evo;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.evo.EvoBatteryInfo;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.battery.BatteryFactory;
import com.autel.internal.battery.BatteryInitializeProxy;
import com.autel.sdk.battery.p004rx.RxEvoBattery;

public class EvoBatteryInitializeProxy extends BatteryInitializeProxy implements EvoBatteryService4Initialize {
    private EvoBatteryService mG2BatteryService;
    private RxEvoBattery rxAutelBattery;

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.mG2BatteryService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.BatteryRealTimeDataListener);
            if (obj instanceof CallbackWithOneParam) {
                this.mG2BatteryService.setBatteryStateListener((CallbackWithOneParam) obj);
            }
        }
    }

    public void setBatteryStateListener(CallbackWithOneParam<EvoBatteryInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.BatteryRealTimeDataListener, callbackWithOneParam);
        EvoBatteryService evoBatteryService = this.mG2BatteryService;
        if (evoBatteryService != null) {
            evoBatteryService.setBatteryStateListener(callbackWithOneParam);
        }
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        EvoBatteryService createG2Battery = BatteryFactory.createG2Battery(autelServiceVersion);
        this.mG2BatteryService = createG2Battery;
        this.batteryService = createG2Battery;
        return this.mG2BatteryService;
    }

    public RxEvoBattery toRx() {
        if (this.rxAutelBattery == null) {
            this.rxAutelBattery = new RxG2BatteryImpl(this);
        }
        return this.rxAutelBattery;
    }
}
