package com.autel.internal.gimbal.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.xstar.XStarGimbalParameterRangeManager;
import com.autel.internal.gimbal.RxGimbalImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.gimbal.XStarGimbal;
import com.autel.sdk.gimbal.p008rx.RxXStarGimbal;
import io.reactivex.Observable;

public class RxXStarImpl extends RxGimbalImpl implements RxXStarGimbal {
    /* access modifiers changed from: private */
    public XStarGimbal mAutelGimbal;

    public RxXStarImpl(XStarGimbal xStarGimbal) {
        super(xStarGimbal);
        this.mAutelGimbal = xStarGimbal;
    }

    public void setAngleListener(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.mAutelGimbal.setAngleListener(callbackWithOneParam);
    }

    public void setGimbalStateListener(CallbackWithOneParam<GimbalState> callbackWithOneParam) {
        this.mAutelGimbal.setGimbalStateListener(callbackWithOneParam);
    }

    public void setGimbalAngle(float f) {
        this.mAutelGimbal.setGimbalAngle(f);
    }

    public void setGimbalAngleWithSpeed(int i) {
        this.mAutelGimbal.setGimbalAngleWithSpeed(i);
    }

    public Observable<XStarGimbalParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XStarGimbalParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XStarGimbalParameterRangeManager parameterRangeManager = RxXStarImpl.this.mAutelGimbal.getParameterRangeManager();
                if (parameterRangeManager == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }

    public Observable<Double> setRollAdjustData(final GimbalRollAngleAdjust gimbalRollAngleAdjust) {
        return new RxLock<Double>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxXStarImpl.this.mAutelGimbal.setRollAdjustData(gimbalRollAngleAdjust, new CallbackWithOneParam<Double>() {
                    public void onSuccess(Double d) {
                        C46222.this.setData(d);
                    }

                    public void onFailure(AutelError autelError) {
                        C46222.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
