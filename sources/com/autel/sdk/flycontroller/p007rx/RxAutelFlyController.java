package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.flycontroller.rx.RxAutelFlyController */
public interface RxAutelFlyController {
    Observable<Boolean> cancelLand();

    Observable<Boolean> cancelReturn();

    Observable<LedPilotLamp> getLedPilotLamp();

    Observable<Float> getMaxHeight();

    Observable<Float> getMaxHorizontalSpeed();

    Observable<Float> getMaxRange();

    Observable<Float> getReturnHeight();

    Observable<String> getSerialNumber();

    Observable<FlyControllerVersionInfo> getVersionInfo();

    Observable<Boolean> goHome();

    Observable<Boolean> isAttitudeModeEnable();

    Observable<Boolean> isBeginnerModeEnable();

    Observable<Boolean> land();

    Observable<Boolean> setAircraftLocationAsHomePoint();

    Observable<Boolean> setAttitudeModeEnable(boolean z);

    Observable<Boolean> setBeginnerModeEnable(boolean z);

    void setCalibrateCompassListener(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam);

    Observable<Boolean> setLedPilotLamp(LedPilotLamp ledPilotLamp);

    Observable<Boolean> setLocationAsHomePoint(double d, double d2);

    Observable<Boolean> setMaxHeight(double d);

    Observable<Boolean> setMaxHorizontalSpeed(double d);

    Observable<Boolean> setMaxRange(double d);

    Observable<Boolean> setReturnHeight(double d);

    void setWarningListener(CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams);

    void startCalibrateCompass(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam);

    Observable<Boolean> takeOff();
}
