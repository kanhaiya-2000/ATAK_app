package com.autel.sdk.remotecontroller.p010rx;

import android.util.Pair;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.remotecontroller.CustomFunction;
import com.autel.common.remotecontroller.CustomKey;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerParameterRangeManager;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerVersionInfo;
import com.autel.common.remotecontroller.TeachingMode;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.remotecontroller.rx.RxAutelRemoteController */
public interface RxAutelRemoteController {
    Observable<Boolean> enterBinding();

    void exitBinding();

    Observable<RemoteControllerCommandStickMode> getCommandStickMode();

    Observable<Integer> getGimbalDialAdjustSpeed();

    Observable<RemoteControllerLanguage> getLanguage();

    Observable<RemoteControllerParameterUnit> getLengthUnit();

    Observable<RemoteControllerParameterRangeManager> getParameterSupport();

    Observable<RFPower> getRFPower();

    Observable<Pair<CustomFunction, CustomFunction>> getRcCustomKey();

    Observable<String> getSerialNumber();

    Observable<TeachingMode> getTeachingMode();

    Observable<RemoteControllerVersionInfo> getVersionInfo();

    Observable<Float> getYawCoefficient();

    Observable<Boolean> setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode);

    void setConnectStateListener(CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam);

    void setControlMenuListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    Observable<Boolean> setGimbalDialAdjustSpeed(int i);

    void setInfoDataListener(CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam);

    Observable<Boolean> setLanguage(RemoteControllerLanguage remoteControllerLanguage);

    Observable<Boolean> setParameterUnit(RemoteControllerParameterUnit remoteControllerParameterUnit);

    Observable<Boolean> setRFPower(RFPower rFPower);

    Observable<Boolean> setRcCustomKey(CustomKey customKey, CustomFunction customFunction);

    void setRemoteButtonControllerListener(CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam);

    Observable<Boolean> setStickCalibration(RemoteControllerStickCalibration remoteControllerStickCalibration);

    Observable<Boolean> setTeachingMode(TeachingMode teachingMode);

    Observable<Boolean> setYawCoefficient(float f);
}
