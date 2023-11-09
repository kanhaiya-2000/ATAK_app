package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.sdk.flycontroller.p007rx.RxEvoFlyController;

public interface EvoFlyController extends C4930AutelFlyController, AutelVisual {
    void cancelMission(int i, CallbackWithNoParam callbackWithNoParam);

    void droneArmed(CallbackWithNoParam callbackWithNoParam);

    void droneDisarmed(CallbackWithNoParam callbackWithNoParam);

    void getBoatMode(CallbackWithOneParam<BoatMode> callbackWithOneParam);

    EvoFlyControllerParameterRangeManager getParameterRangeManager();

    boolean isSupportBoatMode();

    void setAircraftHeadingDirection(int i, CallbackWithNoParam callbackWithNoParam);

    void setBoatMode(BoatMode boatMode, CallbackWithNoParam callbackWithNoParam);

    void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam);

    RxEvoFlyController toRx();
}
