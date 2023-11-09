package com.autel.internal.gimbal.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalAdjustmentAngle;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.gimbal.evo.EvoGimbalParameterRangeManager;
import com.autel.internal.gimbal.RxGimbalImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.gimbal.EvoGimbal;
import com.autel.sdk.gimbal.p008rx.RxEvoGimbal;
import io.reactivex.Observable;

public class RxEvoImpl extends RxGimbalImpl implements RxEvoGimbal {
    /* access modifiers changed from: private */
    public EvoGimbal mAutelGimbal;

    public RxEvoImpl(EvoGimbal evoGimbal) {
        super(evoGimbal);
        this.mAutelGimbal = evoGimbal;
    }

    public void setAngleListener(CallbackWithOneParam<EvoAngleInfo> callbackWithOneParam) {
        this.mAutelGimbal.setAngleListener(callbackWithOneParam);
    }

    public void setGimbalAngleWithSpeed(float f) {
        this.mAutelGimbal.setGimbalAngleWithSpeed(f);
    }

    public void setGimbalAngle(float f, float f2, float f3) {
        this.mAutelGimbal.setGimbalAngle(f, f2, f3);
    }

    public void setRollAdjustData(float f) {
        this.mAutelGimbal.setRollAdjustData(f, (CallbackWithNoParam) null);
    }

    public Observable<GimbalAdjustmentAngle> getAdjustGimbalAngelData() {
        return new RxLock<GimbalAdjustmentAngle>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoImpl.this.mAutelGimbal.getAdjustGimbalAngelData(new CallbackWithOneParam<GimbalAdjustmentAngle>() {
                    public void onSuccess(GimbalAdjustmentAngle gimbalAdjustmentAngle) {
                        C46121.this.setData(gimbalAdjustmentAngle);
                    }

                    public void onFailure(AutelError autelError) {
                        C46121.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public void setYawAdjustData(float f) {
        this.mAutelGimbal.setYawAdjustData(f, (CallbackWithNoParam) null);
    }

    public void setPitchAdjustData(float f) {
        this.mAutelGimbal.setPitchAdjustData(f, (CallbackWithNoParam) null);
    }

    public Observable<Boolean> resetGimbalAngle(final GimbalAxisType gimbalAxisType) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoImpl.this.mAutelGimbal.resetGimbalAngle(gimbalAxisType, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46142.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46142.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<EvoGimbalParameterRangeManager> getParameterRangeManager() {
        return new RxLock<EvoGimbalParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                EvoGimbalParameterRangeManager parameterRangeManager = RxEvoImpl.this.mAutelGimbal.getParameterRangeManager();
                if (parameterRangeManager == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }

    public Observable<Boolean> setGimbalCalibration() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoImpl.this.mAutelGimbal.setGimbalCalibration(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46174.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46174.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setSaveParams() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoImpl.this.mAutelGimbal.setSaveParams(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46195.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46195.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
