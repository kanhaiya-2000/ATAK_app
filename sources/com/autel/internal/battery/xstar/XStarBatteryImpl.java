package com.autel.internal.battery.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.battery.BatteryState;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.battery.Battery10;
import com.autel.internal.battery.BatteryParameterRangeManagerImpl;
import com.autel.sdk.battery.p004rx.RxAutelBattery;
import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.concurrent.atomic.AtomicInteger;

public class XStarBatteryImpl extends Battery10 implements XStarBatteryService {
    private static final String batteryRealTimeDataListenerTag = "batteryRealTimeDataListener";
    private static final String batteryWarningListenerTag = "batteryWarningListener";
    private BatteryParameterRangeManager batteryParameterRangeManager;
    private AtomicInteger getDischargeState = new AtomicInteger(0);

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxAutelBattery toRx() {
        return null;
    }

    public void getVoltageCells(CallbackWithOneParam<int[]> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(AutelAircraftInfoManager.getAutelBatteryInfo().getVoltageCells());
    }

    public void getVoltage(CallbackWithOneParam<Float> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Float.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getVoltage()));
    }

    public void getCapacity(CallbackWithOneParam<Float> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Float.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getCapacity()));
    }

    public void getCurrent(CallbackWithOneParam<Float> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Float.valueOf(Math.abs(AutelAircraftInfoManager.getAutelBatteryInfo().getCurrent())));
    }

    public void getTemperature(CallbackWithOneParam<Float> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Float.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getTemperature()));
    }

    public void getDischargeCount(CallbackWithOneParam<Integer> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Integer.valueOf((int) AutelAircraftInfoManager.getAutelBatteryInfo().getNumberOfDischarges()));
    }

    public void getFullChargeCapacity(CallbackWithOneParam<Integer> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Integer.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getFullChargeCapacity()));
    }

    public void getRemainingPercent(CallbackWithOneParam<Integer> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Integer.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getRemainingPercent()));
    }

    public void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(AutelAircraftInfoManager.getAutelBatteryInfo().getSerialNumber());
    }

    public void getVersion(CallbackWithOneParam<String> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(AutelAircraftInfoManager.getAutelBatteryInfo().getVersion());
    }

    public void getDesignCapacity(CallbackWithOneParam<Float> callbackWithOneParam) {
        callbackWithOneParam.onSuccess(Float.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getDesignedCapacity()));
    }

    public BatteryParameterRangeManager getParameterSupportManager() {
        if (this.batteryParameterRangeManager == null) {
            this.batteryParameterRangeManager = new BatteryParameterRangeManagerImpl();
        }
        return this.batteryParameterRangeManager;
    }

    public void setBatteryStateListener(final CallbackWithOneParam<BatteryState> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            BatteryManager.getAutelBatteryRequestManager().removeBatteryRealTimeDataListener(batteryRealTimeDataListenerTag);
        } else {
            BatteryManager.getAutelBatteryRequestManager().addBatteryRealTimeDataListener(batteryRealTimeDataListenerTag, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<BatteryState>() {
                public void onReceiveMsg(BatteryState batteryState) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(batteryState);
                    }
                }
            });
        }
    }
}
