package com.autel.internal.sdk.flycontroller;

import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.gimbal.GimbalState;

public class AutelWarningInternal {
    public static final int AIRPORT_HEIGHT_RESTRICTED_AREAS = 2;
    public static final int AIRPORT_HEIGHT_RESTRICT_MAXHEIGHT = 3;
    public static final int AIRPORT_NORMAL = 0;
    public static final int AIRPORT_NO_FLY_ZONES = 4;
    public static final int AIRPORT_VICINITY = 1;
    protected FlyLimitAreaWarning airportWarning = FlyLimitAreaWarning.UNKNOWN;
    protected ARMWarning armErrorCode = ARMWarning.UNKNOWN;
    protected BatteryWarning batteryWarning = BatteryWarning.UNKNOWN;
    protected CalibrateCompassStatus compassStatus;
    protected GimbalState gimbalErrorCode = GimbalState.UNKNOWN;
    protected boolean isBatHot;
    protected boolean isCompassValid;
    protected boolean isFCHot;
    protected boolean isGPSWeak;
    protected boolean isGpsValid;
    protected boolean isHeartBeatNormal = false;
    protected boolean isHomePointValid;
    protected boolean isOneClickTakeOffValid = true;
    /* access modifiers changed from: protected */
    public boolean isRCConnected = false;
    protected boolean isRcDisconnection;
    protected boolean isReachMaxHeight;
    protected boolean isReachMaxRange;
    protected boolean isTakeOffAble = true;
    protected boolean isTooFar;
    protected boolean isWarmingUp;
    protected long lastGimbalErrorCodeRefreshTime;
    protected MagnetometerState magState = MagnetometerState.UNKNOWN;

    public float getBatteryTemperature() {
        return 0.0f;
    }

    public GimbalState getGimbalErrorCode() {
        if (System.currentTimeMillis() - this.lastGimbalErrorCodeRefreshTime >= 3000) {
            this.gimbalErrorCode = GimbalState.NORMAL;
        }
        return this.gimbalErrorCode;
    }

    public ARMWarning getArmErrorCode() {
        return this.armErrorCode;
    }

    public MagnetometerState getMagnetometerState() {
        return this.magState;
    }

    public BatteryWarning getBatteryWarning() {
        return this.batteryWarning;
    }

    public FlyLimitAreaWarning getAirportWarning() {
        return this.airportWarning;
    }

    public boolean isReachMaxHeight() {
        return this.isReachMaxHeight;
    }

    public boolean isReachMaxRange() {
        return this.isReachMaxRange;
    }

    public boolean isGpsValid() {
        return this.isGpsValid;
    }

    public boolean isHomePointValid() {
        return this.isHomePointValid;
    }

    public boolean isCompassValid() {
        return this.isCompassValid;
    }

    public boolean isFCLostRCSignal() {
        return this.isRcDisconnection;
    }

    public boolean isBatteryOverHeated() {
        return this.isBatHot;
    }

    public boolean isFCOverHeated() {
        return this.isFCHot;
    }

    public boolean isOneClickTakeOffValid() {
        return this.isOneClickTakeOffValid;
    }

    public boolean isTakeOffAble() {
        return this.isTakeOffAble;
    }

    public boolean isWarmingUp() {
        return this.isWarmingUp;
    }

    public boolean isGPSWeak() {
        return this.isGPSWeak;
    }

    public boolean isTooFar() {
        return this.isTooFar;
    }

    public boolean isHeartBeatNormal() {
        return this.isHeartBeatNormal;
    }

    public boolean isRCConnected() {
        return this.isRCConnected;
    }

    public CalibrateCompassStatus getCompassStatus() {
        return this.compassStatus;
    }

    public String toString() {
        return "AutelErrorWarning:  电池:" + this.batteryWarning + ",  Arm:" + this.armErrorCode + ",  磁力计:" + this.magState + ",  最大高度:" + this.isReachMaxHeight + ",  最远距离:" + this.isReachMaxRange + ",  \nGPS:" + this.isGpsValid + ",  HOME:" + this.isHomePointValid + ",   指南针:" + this.isCompassValid + ",  遥控器信号丢失:" + this.isRcDisconnection + ",  禁飞区:" + this.airportWarning + ",  \n电池过热:" + this.isBatHot + ",  飞控过热:" + this.isFCHot + ",  一键起飞:" + this.isOneClickTakeOffValid + ",  起飞:" + this.isTakeOffAble + ",  预热:" + this.isWarmingUp + ",  云台警报:" + getGimbalErrorCode() + ",   指南针校准状态:" + this.compassStatus;
    }
}
