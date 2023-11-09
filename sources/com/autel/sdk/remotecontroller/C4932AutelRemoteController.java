package com.autel.sdk.remotecontroller;

import android.util.Pair;
import com.autel.common.CallbackWithNoParam;
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
import com.autel.sdk.remotecontroller.p010rx.RxAutelRemoteController;

/* renamed from: com.autel.sdk.remotecontroller.AutelRemoteController */
public interface C4932AutelRemoteController {
    void enterPairing(CallbackWithNoParam callbackWithNoParam);

    void exitPairing();

    void getCommandStickMode(CallbackWithOneParam<RemoteControllerCommandStickMode> callbackWithOneParam);

    void getGimbalDialAdjustSpeed(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getLanguage(CallbackWithOneParam<RemoteControllerLanguage> callbackWithOneParam);

    void getLengthUnit(CallbackWithOneParam<RemoteControllerParameterUnit> callbackWithOneParam);

    RemoteControllerParameterRangeManager getParameterRangeManager();

    void getRFPower(CallbackWithOneParam<RFPower> callbackWithOneParam);

    void getRcCustomKey(CallbackWithOneParam<Pair<CustomFunction, CustomFunction>> callbackWithOneParam);

    void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam);

    void getTeachingMode(CallbackWithOneParam<TeachingMode> callbackWithOneParam);

    void getVersionInfo(CallbackWithOneParam<RemoteControllerVersionInfo> callbackWithOneParam);

    void getYawCoefficient(CallbackWithOneParam<Float> callbackWithOneParam);

    void setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode, CallbackWithNoParam callbackWithNoParam);

    void setConnectStateListener(CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam);

    void setControlMenuListener(CallbackWithOneParam<int[]> callbackWithOneParam);

    void setGimbalDialAdjustSpeed(int i, CallbackWithNoParam callbackWithNoParam);

    void setInfoDataListener(CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam);

    void setLanguage(RemoteControllerLanguage remoteControllerLanguage, CallbackWithNoParam callbackWithNoParam);

    void setParameterUnit(RemoteControllerParameterUnit remoteControllerParameterUnit, CallbackWithNoParam callbackWithNoParam);

    void setRFPower(RFPower rFPower, CallbackWithNoParam callbackWithNoParam);

    void setRcCustomKey(CustomKey customKey, CustomFunction customFunction, CallbackWithNoParam callbackWithNoParam);

    void setRemoteButtonControllerListener(CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam);

    void setStickCalibration(RemoteControllerStickCalibration remoteControllerStickCalibration, CallbackWithNoParam callbackWithNoParam);

    void setTeachingMode(TeachingMode teachingMode, CallbackWithNoParam callbackWithNoParam);

    void setYawCoefficient(float f, CallbackWithNoParam callbackWithNoParam);

    RxAutelRemoteController toRx();
}
