package com.autel.internal.battery;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.battery.C4928AutelBattery;
import com.autel.sdk.battery.p004rx.RxAutelBattery;
import io.reactivex.Observable;

public class RxAutelBatteryImpl implements RxAutelBattery {
    C4928AutelBattery mAutelBattery;

    public RxAutelBatteryImpl(C4928AutelBattery autelBattery) {
        this.mAutelBattery = autelBattery;
    }

    public Observable<Boolean> setLowBatteryNotifyThreshold(final float f) {
        return new RxLock<Boolean>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.setLowBatteryNotifyThreshold(f, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C27711.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C27711.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getLowBatteryNotifyThreshold() {
        return new RxLock<Float>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getLowBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C27772.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C27772.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setCriticalBatteryNotifyThreshold(final float f) {
        return new RxLock<Boolean>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.setCriticalBatteryNotifyThreshold(f, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C27793.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C27793.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getCriticalBatteryNotifyThreshold() {
        return new RxLock<Float>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getCriticalBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C27814.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C27814.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setDischargeDay(final int i) {
        return new RxLock<Boolean>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.setDischargeDay(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C27835.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C27835.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getDischargeDay() {
        return new RxLock<Integer>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getDischargeDay(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C27856.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C27856.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<BatteryParameterRangeManager> getParameterSupportManager() {
        return new RxLock<BatteryParameterRangeManager>() {
            public void run() {
                BatteryParameterRangeManager parameterSupportManager = RxAutelBatteryImpl.this.mAutelBattery.getParameterSupportManager();
                if (parameterSupportManager == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterSupportManager);
                }
            }
        }.fire();
    }

    public Observable<Integer> getDischargeCount() {
        return new RxLock<Integer>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getDischargeCount(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C27888.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C27888.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<String> getSerialNumber() {
        return new RxLock<String>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getSerialNumber(new CallbackWithOneParam<String>() {
                    public void onSuccess(String str) {
                        C27909.this.setData(str);
                    }

                    public void onFailure(AutelError autelError) {
                        C27909.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<String> getVersion() {
        return new RxLock<String>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getVersion(new CallbackWithOneParam<String>() {
                    public void onSuccess(String str) {
                        C277310.this.setData(str);
                    }

                    public void onFailure(AutelError autelError) {
                        C277310.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getFullChargeCapacity() {
        return new RxLock<Integer>() {
            public void run() {
                RxAutelBatteryImpl.this.mAutelBattery.getFullChargeCapacity(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C277511.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C277511.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
