package com.autel.internal.battery;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.battery.p004rx.RxAutelBattery;
import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Battery10 implements BatteryService {
    private BatteryParameterRangeManager batteryParameterRangeManager;
    /* access modifiers changed from: private */
    public AtomicInteger getDischargeState = new AtomicInteger(0);

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

    public void setLowBatteryNotifyThreshold(float f, final CallbackWithNoParam callbackWithNoParam) {
        BatteryManager.getAutelBatteryRequestManager().setLowBatteryWarning(f, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getLowBatteryNotifyThreshold(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryManager.getAutelBatteryRequestManager().queryLowBatteryWarning(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    callbackWithOneParam.onSuccess(f);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setCriticalBatteryNotifyThreshold(float f, final CallbackWithNoParam callbackWithNoParam) {
        BatteryManager.getAutelBatteryRequestManager().setCriticalBatteryWarning(f, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getCriticalBatteryNotifyThreshold(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryManager.getAutelBatteryRequestManager().queryCriticalBatteryWarning(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(f);
                    }
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                }
            });
        }
    }

    public void setDischargeDay(int i, final CallbackWithNoParam callbackWithNoParam) {
        BatteryManager.getAutelBatteryRequestManager().setBatteryDischargeDay(i, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getDischargeDay(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryManager.getAutelBatteryRequestManager().queryBatteryDischargeDay(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
                public void onResult(Integer num) {
                    callbackWithOneParam.onSuccess(num);
                }

                public void onFailure(AutelError autelError) {
                    if (AutelError.COMMON_TIMEOUT != autelError) {
                        Battery10.this.getDischargeState.compareAndSet(1, 0);
                        callbackWithOneParam.onFailure(autelError);
                    } else if (Battery10.this.getDischargeState.compareAndSet(0, 1)) {
                        Battery10.this.getDischargeDay(callbackWithOneParam);
                    } else if (Battery10.this.getDischargeState.compareAndSet(1, 0)) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                }
            });
        }
    }

    public BatteryParameterRangeManager getParameterSupportManager() {
        if (this.batteryParameterRangeManager == null) {
            this.batteryParameterRangeManager = new BatteryParameterRangeManagerImpl();
        }
        return this.batteryParameterRangeManager;
    }
}
