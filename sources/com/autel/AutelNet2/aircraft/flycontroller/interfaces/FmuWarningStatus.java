package com.autel.AutelNet2.aircraft.flycontroller.interfaces;

import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.internal.sdk.flycontroller.VirtualJoyStickMode;

public interface FmuWarningStatus {
    int getAirportWarning();

    ARMWarning getArmErrorCode();

    BatteryWarning getBatteryWarning();

    CalibrateCompassStatus getCompassStatus();

    LedPilotLamp getLedPilotLampStatus();

    MagnetometerState getMagState();

    MainFlyState getMainFlyState();

    VirtualJoyStickMode getVirtualJoyStickMode();

    boolean isBatteryHot();

    boolean isCompassValid();

    boolean isFCHot();

    boolean isGpsValid();

    boolean isHomePointValid();

    boolean isOneClickTakeOffValid();

    boolean isRcDisconnection();

    boolean isReachMaxHeight();

    boolean isReachMaxRange();

    boolean isTakeOffAble();

    boolean isWarmingUp();
}
