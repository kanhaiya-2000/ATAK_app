package com.autel.internal.sdk.warning;

import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;

public interface AutelWarningInfo {
    int getAirportWarning();

    ARMWarning getArmErrorCode();

    BatteryWarning getBatteryWarning();

    CalibrateCompassStatus getCompassStatus();

    int getGimbalErrorCode();

    int getMagnetometerState();

    float getTemperature();

    boolean isBatteryHot();

    boolean isCompassValid();

    boolean isFCHot();

    boolean isGPSWeak();

    boolean isGpsValid();

    boolean isHeartBeatNormal();

    boolean isHomePointValid();

    boolean isOneClickTakeOffValid();

    boolean isRCConnected();

    boolean isRcDisconnection();

    boolean isReachMaxHeight();

    boolean isReachMaxRange();

    boolean isTakeOffAble();

    boolean isTooFar();

    boolean isWarmingUp();
}
