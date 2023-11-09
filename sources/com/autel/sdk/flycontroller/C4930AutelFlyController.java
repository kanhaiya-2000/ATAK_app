package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerParameterRangeManager;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.sdk.flycontroller.p007rx.RxAutelFlyController;

/* renamed from: com.autel.sdk.flycontroller.AutelFlyController */
public interface C4930AutelFlyController {
    void cancelLand(CallbackWithNoParam callbackWithNoParam);

    void cancelReturn(CallbackWithNoParam callbackWithNoParam);

    void getLedPilotLamp(CallbackWithOneParam<LedPilotLamp> callbackWithOneParam);

    void getMaxHeight(CallbackWithOneParam<Float> callbackWithOneParam);

    void getMaxHorizontalSpeed(CallbackWithOneParam<Float> callbackWithOneParam);

    void getMaxRange(CallbackWithOneParam<Float> callbackWithOneParam);

    FlyControllerParameterRangeManager getParameterRangeManager();

    void getReturnHeight(CallbackWithOneParam<Float> callbackWithOneParam);

    void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam);

    void getVersionInfo(CallbackWithOneParam<FlyControllerVersionInfo> callbackWithOneParam);

    void goHome(CallbackWithNoParam callbackWithNoParam);

    void isAttitudeModeEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void isBeginnerModeEnable(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void land(CallbackWithNoParam callbackWithNoParam);

    void setAircraftLocationAsHomePoint(CallbackWithNoParam callbackWithNoParam);

    void setAttitudeModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setBeginnerModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setCalibrateCompassListener(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam);

    void setLedPilotLamp(LedPilotLamp ledPilotLamp, CallbackWithNoParam callbackWithNoParam);

    void setLocationAsHomePoint(double d, double d2, CallbackWithNoParam callbackWithNoParam);

    void setMaxHeight(double d, CallbackWithNoParam callbackWithNoParam);

    void setMaxHorizontalSpeed(double d, CallbackWithNoParam callbackWithNoParam);

    void setMaxRange(double d, CallbackWithNoParam callbackWithNoParam);

    void setReturnHeight(double d, CallbackWithNoParam callbackWithNoParam);

    void setWarningListener(CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams);

    void startCalibrateCompass(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam);

    void takeOff(CallbackWithNoParam callbackWithNoParam);

    RxAutelFlyController toRx();
}
