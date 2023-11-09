package com.autel.internal.gimbal.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.gimbal.GimbalAdjustmentAngle;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.gimbal.evo.EvoGimbalParameterRangeManager;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.gimbal.GimbalFactory;
import com.autel.internal.gimbal.GimbalInitializeProxy;
import com.autel.sdk.gimbal.p008rx.RxEvoGimbal;

public class EvoGimbalInitializeProxy extends GimbalInitializeProxy implements EvoGimbalService4Initialize {
    protected EvoGimbalService mG2GimbalService;
    private RxEvoGimbal mRxAutelGimbal;

    public void setAngleListener(CallbackWithOneParam<EvoAngleInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.GimbalAngleListener, callbackWithOneParam);
        EvoGimbalService evoGimbalService = this.mG2GimbalService;
        if (evoGimbalService != null) {
            evoGimbalService.setAngleListener(callbackWithOneParam);
        }
    }

    public void setGimbalAngleWithSpeed(float f) {
        if (checkStateEnable((FailedCallback) null)) {
            this.mG2GimbalService.setGimbalAngleWithSpeed(f);
        }
    }

    public void setGimbalAngle(float f, float f2, float f3) {
        if (checkStateEnable((FailedCallback) null)) {
            this.mG2GimbalService.setGimbalAngle(f, f2, f3);
        }
    }

    public EvoGimbalParameterRangeManager getParameterRangeManager() {
        return this.mG2GimbalService.getParameterRangeManager();
    }

    public void resetGimbalAngle(GimbalAxisType gimbalAxisType, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.resetGimbalAngle(gimbalAxisType, callbackWithNoParam);
        }
    }

    public void setRollAdjustData(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.setRollAdjustData(f, callbackWithNoParam);
        }
    }

    public void getRollAdjustData(CallbackWithOneParam<Double> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.mG2GimbalService.getRollAdjustData(callbackWithOneParam);
        }
    }

    public void getAdjustGimbalAngelData(CallbackWithOneParam<GimbalAdjustmentAngle> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.mG2GimbalService.getAdjustGimbalAngelData(callbackWithOneParam);
        }
    }

    public void setYawAdjustData(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.setYawAdjustData(f, callbackWithNoParam);
        }
    }

    public void getYawAdjustData(CallbackWithOneParam<Double> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.mG2GimbalService.getYawAdjustData(callbackWithOneParam);
        }
    }

    public void setPitchAdjustData(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.setPitchAdjustData(f, callbackWithNoParam);
        }
    }

    public void getPitchAdjustData(CallbackWithOneParam<Double> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.mG2GimbalService.getPitchAdjustData(callbackWithOneParam);
        }
    }

    public void setSaveParams(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.setSaveParams(callbackWithNoParam);
        }
    }

    public RxEvoGimbal toRx() {
        if (this.mRxAutelGimbal == null) {
            this.mRxAutelGimbal = new RxEvoImpl(this);
        }
        return this.mRxAutelGimbal;
    }

    public void setGimbalCalibration(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2GimbalService.setGimbalCalibration(callbackWithNoParam);
        }
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        EvoGimbalService createG2Gimbal = GimbalFactory.createG2Gimbal(autelServiceVersion);
        this.mG2GimbalService = createG2Gimbal;
        this.gimbalService = createG2Gimbal;
        return this.mG2GimbalService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.mG2GimbalService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.GimbalAngleListener);
            if (obj instanceof CallbackWithOneParam) {
                this.mG2GimbalService.setAngleListener((CallbackWithOneParam) obj);
            }
        }
    }
}
