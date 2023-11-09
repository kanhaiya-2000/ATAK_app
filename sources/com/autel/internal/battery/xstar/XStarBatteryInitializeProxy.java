package com.autel.internal.battery.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryState;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.battery.BatteryFactory;
import com.autel.internal.battery.BatteryInitializeProxy;
import com.autel.sdk.battery.p004rx.RxXStarBattery;

public class XStarBatteryInitializeProxy extends BatteryInitializeProxy implements XStarBatteryService4Initialize {
    private RxXStarBattery rxAutelBattery;
    private XStarBatteryService xStarBatteryService;

    public void getVoltageCells(CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getVoltageCells(callbackWithOneParam);
        }
    }

    public void getVoltage(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getVoltage(callbackWithOneParam);
        }
    }

    public void getCapacity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getCapacity(callbackWithOneParam);
        }
    }

    public void getCurrent(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getCurrent(callbackWithOneParam);
        }
    }

    public void getTemperature(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getTemperature(callbackWithOneParam);
        }
    }

    public void getRemainingPercent(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getRemainingPercent(callbackWithOneParam);
        }
    }

    public void getDesignCapacity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.xStarBatteryService.getDesignCapacity(callbackWithOneParam);
        }
    }

    public void setBatteryStateListener(CallbackWithOneParam<BatteryState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.BatteryRealTimeDataListener, callbackWithOneParam);
        XStarBatteryService xStarBatteryService2 = this.xStarBatteryService;
        if (xStarBatteryService2 != null) {
            xStarBatteryService2.setBatteryStateListener(callbackWithOneParam);
        }
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.xStarBatteryService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.BatteryRealTimeDataListener);
            if (obj instanceof CallbackWithOneParam) {
                this.xStarBatteryService.setBatteryStateListener((CallbackWithOneParam) obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        XStarBatteryService createXStarBattery = BatteryFactory.createXStarBattery(autelServiceVersion);
        this.xStarBatteryService = createXStarBattery;
        this.batteryService = createXStarBattery;
        return this.xStarBatteryService;
    }

    public RxXStarBattery toRx() {
        if (this.rxAutelBattery == null) {
            this.rxAutelBattery = new RxXStarBatteryImpl(this);
        }
        return this.rxAutelBattery;
    }
}
