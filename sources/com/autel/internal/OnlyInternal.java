package com.autel.internal;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.flycontroller.AircraftActivateState;

public interface OnlyInternal {
    void getAircraftActivateState(CallbackWithOneParam<AircraftActivateState> callbackWithOneParam);

    void getCameraToken(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getTimeStamp(CallbackWithOneParam<Long> callbackWithOneParam);

    int getWarningState();

    void restoreSDLogFrequency(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setAircraftActivateState(AircraftActivateState aircraftActivateState, CallbackWithOneParam<AircraftActivateState> callbackWithOneParam);

    void setflyDataReadable();
}
