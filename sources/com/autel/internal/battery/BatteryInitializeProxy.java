package com.autel.internal.battery;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.RangePair;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.sdk.battery.p004rx.RxAutelBattery;

public abstract class BatteryInitializeProxy extends AutelInitializeProxy implements BatteryService4Initialize {
    protected BatteryService batteryService;
    protected BatteryParameterRangeManager parameterRangeManager;
    private RxAutelBattery rxAutelBattery;

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void setLowBatteryNotifyThreshold(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            if (this.parameterRangeManager == null) {
                this.parameterRangeManager = getParameterSupportManager();
            }
            RangePair<Float> lowBattery = this.parameterRangeManager.getLowBattery();
            if (f >= lowBattery.getValueFrom().floatValue() && f <= lowBattery.getValueTo().floatValue()) {
                this.batteryService.setLowBatteryNotifyThreshold(f, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getLowBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getLowBatteryNotifyThreshold(callbackWithOneParam);
        }
    }

    public void getFullChargeCapacity(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getFullChargeCapacity(callbackWithOneParam);
        }
    }

    public void setCriticalBatteryNotifyThreshold(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            if (this.parameterRangeManager == null) {
                this.parameterRangeManager = getParameterSupportManager();
            }
            RangePair<Float> criticalBattery = this.parameterRangeManager.getCriticalBattery();
            if (f >= criticalBattery.getValueFrom().floatValue() && f <= criticalBattery.getValueTo().floatValue()) {
                this.batteryService.setCriticalBatteryNotifyThreshold(f, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getCriticalBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getCriticalBatteryNotifyThreshold(callbackWithOneParam);
        }
    }

    public void setDischargeDay(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            if (this.parameterRangeManager == null) {
                this.parameterRangeManager = getParameterSupportManager();
            }
            RangePair<Integer> dischargeDay = this.parameterRangeManager.getDischargeDay();
            if (i >= dischargeDay.getValueFrom().intValue() && i <= dischargeDay.getValueTo().intValue()) {
                this.batteryService.setDischargeDay(i, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getDischargeDay(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getDischargeDay(callbackWithOneParam);
        }
    }

    public void getDischargeCount(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getDischargeCount(callbackWithOneParam);
        }
    }

    public void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getSerialNumber(callbackWithOneParam);
        }
    }

    public void getVersion(CallbackWithOneParam<String> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.batteryService.getVersion(callbackWithOneParam);
        }
    }

    public BatteryParameterRangeManager getParameterSupportManager() {
        return this.batteryService.getParameterSupportManager();
    }

    public void destroy() {
        if (this.batteryService != null) {
            this.hasInit = false;
            this.batteryService.destroy();
            this.listenerManager.clear();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isProductConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }
}
