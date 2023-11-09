package com.autel.internal.battery.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryState;
import com.autel.common.error.AutelError;
import com.autel.internal.battery.RxAutelBatteryImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.battery.XStarBattery;
import com.autel.sdk.battery.p004rx.RxXStarBattery;
import io.reactivex.Observable;

public class RxXStarBatteryImpl extends RxAutelBatteryImpl implements RxXStarBattery {
    XStarBattery mAutelBattery;

    public RxXStarBatteryImpl(XStarBattery xStarBattery) {
        super(xStarBattery);
        this.mAutelBattery = xStarBattery;
    }

    public void setBatteryStateListener(CallbackWithOneParam<BatteryState> callbackWithOneParam) {
        this.mAutelBattery.setBatteryStateListener(callbackWithOneParam);
    }

    public Observable<int[]> getCells() {
        return new RxLock<int[]>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getVoltageCells(new CallbackWithOneParam<int[]>() {
                    public void onSuccess(int[] iArr) {
                        C28061.this.setData(iArr);
                    }

                    public void onFailure(AutelError autelError) {
                        C28061.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getVoltage() {
        return new RxLock<Float>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getVoltage(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C28082.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C28082.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getCapacity() {
        return new RxLock<Float>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getCapacity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C28103.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C28103.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getCurrent() {
        return new RxLock<Float>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getCurrent(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C28124.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C28124.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getTemperature() {
        return new RxLock<Float>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getTemperature(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C28145.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C28145.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getRemainingPercent() {
        return new RxLock<Integer>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getRemainingPercent(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C28166.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C28166.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getDesignCapacity() {
        return new RxLock<Float>() {
            public void run() {
                RxXStarBatteryImpl.this.mAutelBattery.getDesignCapacity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C28187.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C28187.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
