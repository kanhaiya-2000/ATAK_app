package com.autel.internal.gimbal.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.xstar.XStarGimbalParameterRangeManager;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.gimbal.GimbalFactory;
import com.autel.internal.gimbal.GimbalInitializeProxy;
import com.autel.sdk.gimbal.p008rx.RxXStarGimbal;

public class XStarGimbalInitializeProxy extends GimbalInitializeProxy implements XStarGimbalService4Initialize {
    private RxXStarGimbal mRxAutelGimbal;
    protected XStarGimbalService mXStarGimbalService;

    public void setGimbalStateListener(CallbackWithOneParam<GimbalState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.GimbalStateListener, callbackWithOneParam);
        XStarGimbalService xStarGimbalService = this.mXStarGimbalService;
        if (xStarGimbalService != null) {
            xStarGimbalService.setGimbalStateListener(callbackWithOneParam);
        }
    }

    public void setAngleListener(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.GimbalAngleListener, callbackWithOneParam);
        XStarGimbalService xStarGimbalService = this.mXStarGimbalService;
        if (xStarGimbalService != null) {
            xStarGimbalService.setAngleListener(callbackWithOneParam);
        }
    }

    public RxXStarGimbal toRx() {
        if (this.mRxAutelGimbal == null) {
            this.mRxAutelGimbal = new RxXStarImpl(this);
        }
        return this.mRxAutelGimbal;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        XStarGimbalService createXStarGimbal = GimbalFactory.createXStarGimbal(autelServiceVersion);
        this.mXStarGimbalService = createXStarGimbal;
        this.gimbalService = createXStarGimbal;
        return this.mXStarGimbalService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.mXStarGimbalService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.GimbalAngleListener);
            if (obj instanceof CallbackWithOneParam) {
                this.mXStarGimbalService.setAngleListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.GimbalStateListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.mXStarGimbalService.setGimbalStateListener((CallbackWithOneParam) obj2);
            }
        }
    }

    public void setGimbalAngle(float f) {
        if (checkStateEnable((FailedCallback) null)) {
            this.mXStarGimbalService.setGimbalAngle(f);
        }
    }

    public void setGimbalAngleWithSpeed(int i) {
        if (checkStateEnable((FailedCallback) null)) {
            this.mXStarGimbalService.setGimbalAngleWithSpeed(i);
        }
    }

    public void setRollAdjustData(GimbalRollAngleAdjust gimbalRollAngleAdjust, CallbackWithOneParam<Double> callbackWithOneParam) {
        if (!checkStateEnable(callbackWithOneParam)) {
            return;
        }
        if (GimbalRollAngleAdjust.UNKNOWN != gimbalRollAngleAdjust) {
            this.mXStarGimbalService.setRollAdjustData(gimbalRollAngleAdjust, callbackWithOneParam);
        } else if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public XStarGimbalParameterRangeManager getParameterRangeManager() {
        return this.mXStarGimbalService.getParameterRangeManager();
    }
}
