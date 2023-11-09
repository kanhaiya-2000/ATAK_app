package com.autel.common.flycontroller;

public interface FlyControllerStatus {
    ARMWarning getArmErrorCode();

    FlyLimitAreaWarning getFlyLimitAreaWarning();

    FlyMode getFlyMode();

    MainFlyState getMainFlyState();

    boolean isCompassValid();

    boolean isFlightControllerLostRemoteControllerSignal();

    boolean isFlightControllerOverHeated();

    boolean isGoHomePending();

    boolean isGpsValid();

    boolean isHomePointLocationAccurate();

    boolean isHomePointValid();

    boolean isNearRangeLimit();

    boolean isOneClickTakeOffValid();

    boolean isReachMaxHeight();

    boolean isReachMaxRange();

    boolean isStickLimited();

    boolean isSupportRtk();

    boolean isTakeOffValid();

    boolean isWarmingUp();

    boolean isWindTooHigh();
}
