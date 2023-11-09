package com.autel.AutelNet2.aircraft.flycontroller.parser;

import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.aircraft.flycontroller.interfaces.FmuWarningStatus;
import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.common.product.AutelProductInfo;
import com.autel.common.product.AutelProductType;
import com.autel.internal.sdk.flycontroller.VirtualJoyStickMode;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeartBeatInfo implements FmuWarningStatus, FlyControllerStatus, AutelProductInfo {
    private int AlarmStatus1;
    private int AlarmStatus2;
    private int FlightMode;
    private int Type;
    AtomicBoolean hasCallback = new AtomicBoolean(false);

    public boolean isFlightControllerLostRemoteControllerSignal() {
        return false;
    }

    public boolean isFlightControllerOverHeated() {
        return false;
    }

    public int getAlarmStatus1() {
        return this.AlarmStatus1;
    }

    public void setAlarmStatus1(int i) {
        this.AlarmStatus1 = i;
    }

    public int getAlarmStatus2() {
        return this.AlarmStatus2;
    }

    public void setAlarmStatus2(int i) {
        this.AlarmStatus2 = i;
    }

    public int getType() {
        return this.Type;
    }

    public void setType(int i) {
        this.Type = i;
    }

    public int getFlightMode() {
        return this.FlightMode;
    }

    public void setFlightMode(int i) {
        this.FlightMode = i;
    }

    public String toString() {
        return "AlarmStatus1:" + this.AlarmStatus1 + ",Type:" + this.Type + ",AlarmStatus2:" + this.AlarmStatus2 + ",FlightMode:" + this.FlightMode;
    }

    public BatteryWarning getBatteryWarning() {
        return BatteryWarning.find(this.AlarmStatus1 & 3);
    }

    public ARMWarning getArmErrorCode() {
        return ARMWarning.find((this.AlarmStatus2 >> 8) & 127);
    }

    public MagnetometerState getMagState() {
        return MagnetometerState.find((this.AlarmStatus1 >> 12) & 15);
    }

    public int getAirportWarning() {
        return (this.AlarmStatus1 >> 8) & 15;
    }

    public boolean isReachMaxHeight() {
        return ((this.AlarmStatus1 >> 2) & 1) == 1;
    }

    public boolean isReachMaxRange() {
        return ((this.AlarmStatus1 >> 3) & 1) == 1;
    }

    public boolean isGpsValid() {
        return ((this.AlarmStatus1 >> 4) & 1) == 1;
    }

    public boolean isHomePointValid() {
        return ((this.AlarmStatus1 >> 5) & 1) == 1;
    }

    public boolean isCompassValid() {
        return ((this.AlarmStatus1 >> 6) & 1) == 1;
    }

    public boolean isRcDisconnection() {
        return ((this.AlarmStatus1 >> 7) & 1) == 1;
    }

    public boolean isBatteryHot() {
        return ((this.AlarmStatus1 >> 23) & 1) == 1;
    }

    public boolean isFCHot() {
        return ((this.AlarmStatus1 >> 22) & 1) == 1;
    }

    public boolean isOneClickTakeOffValid() {
        return ((this.AlarmStatus1 >> 18) & 1) == 0;
    }

    public boolean isTakeOffAble() {
        return ((this.AlarmStatus1 >> 19) & 1) == 0;
    }

    public boolean isTakeOffValid() {
        return ((this.AlarmStatus1 >> 19) & 1) == 0;
    }

    public boolean isWarmingUp() {
        return ((this.AlarmStatus1 >> 31) & 1) == 0;
    }

    public boolean isHomePointLocationAccurate() {
        return ((this.AlarmStatus1 >> 30) & 1) == 0;
    }

    public boolean isGoHomePending() {
        return ((this.AlarmStatus1 >> 16) & 1) == 1;
    }

    public FlyLimitAreaWarning getFlyLimitAreaWarning() {
        return FlyLimitAreaWarning.find((this.AlarmStatus1 >> 8) & 15);
    }

    public boolean isStickLimited() {
        return ((this.AlarmStatus1 >> 17) & 1) == 1;
    }

    public boolean isNearRangeLimit() {
        return ((this.AlarmStatus1 >> 29) & 1) == 1;
    }

    public boolean isWindTooHigh() {
        return ((this.AlarmStatus1 >> 28) & 1) == 1;
    }

    public boolean isSupportRtk() {
        return ((this.AlarmStatus2 >> 19) & 1) == 1;
    }

    public CalibrateCompassStatus getCompassStatus() {
        int i = (this.AlarmStatus1 >> 24) & 7;
        if (5 == i) {
            i = 4;
        } else if (7 == i) {
            i = 5;
        }
        if ((i == 3 || i == 4) && AircraftHeatBeatManager2.isStepThird) {
            i = 9;
        }
        if (i == 3 && AircraftHeatBeatManager2.compassStatus == CalibrateCompassStatus.VERTICAL_CALCULATE) {
            AircraftHeatBeatManager2.isStepThird = true;
        } else if (i == 5 || i == 6 || i == 0) {
            AircraftHeatBeatManager2.isStepThird = false;
        }
        CalibrateCompassStatus find = CalibrateCompassStatus.find(i);
        AircraftHeatBeatManager2.compassStatus = find;
        return find;
    }

    public VirtualJoyStickMode getVirtualJoyStickMode() {
        return VirtualJoyStickMode.find((this.AlarmStatus2 >> 4) & 15);
    }

    public LedPilotLamp getLedPilotLampStatus() {
        return LedPilotLamp.find((this.AlarmStatus1 >> 20) & 3);
    }

    public MainFlyState getMainFlyState() {
        return MainFlyState.find(this.AlarmStatus2 & 15);
    }

    public FlyMode getFlyMode() {
        return FlyMode.find(getFlightMode());
    }

    public AutelProductType getProduct() {
        return AutelProductType.find(getType());
    }

    public int getVersionId() {
        return (this.AlarmStatus2 >> 24) & 127;
    }
}
