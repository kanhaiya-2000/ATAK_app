package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.MainFlyState;

public abstract class AutelFlyControllerStatusInternal implements FlyControllerStatus {
    private FlyMode flyMode = FlyMode.UNKNOWN;
    private MainFlyState mainFlyState = MainFlyState.UNKNOWN;
    private int state;

    /* access modifiers changed from: protected */
    public void setState(int i) {
        this.state = i;
    }

    public int getWarningState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public void setMainFlyState(int i) {
        this.mainFlyState = MainFlyState.find(i);
    }

    public MainFlyState getMainFlyState() {
        return this.mainFlyState;
    }

    /* access modifiers changed from: protected */
    public void setFlyMode(int i) {
        this.flyMode = FlyMode.find(i);
    }

    public FlyMode getFlyMode() {
        return this.flyMode;
    }

    public String toString() {
        return "state : " + this.state + ", flyMode : " + this.flyMode + ", mainFlyState : " + this.mainFlyState + ", isReachMaxHeight : " + isReachMaxHeight() + ", isReachMaxRange : " + isReachMaxRange() + ", isGpsValid : " + isGpsValid() + ", isHomePointValid : " + isHomePointValid() + ", isCompassValid : " + isCompassValid() + ", isFlightControllerLostRemoteControllerSignal : " + isFlightControllerLostRemoteControllerSignal() + ", isFlightControllerOverHeated : " + isFlightControllerOverHeated() + ", isOneClickTakeOffValid : " + isOneClickTakeOffValid() + ", isTakeOffValid : " + isTakeOffValid() + ", isWarmingUp : " + isWarmingUp() + ", isHomePointLocationAccurate : " + isHomePointLocationAccurate();
    }
}
