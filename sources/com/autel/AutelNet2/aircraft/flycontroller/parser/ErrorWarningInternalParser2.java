package com.autel.AutelNet2.aircraft.flycontroller.parser;

import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.gimbal.GimbalState;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;

public class ErrorWarningInternalParser2 extends AutelWarningInternal {
    private static ErrorWarningInternalParser2 mInstance;
    private final String TAG = "ErrorWarningInternalParser";

    public void parseGPSandDistanceErrorCode() {
    }

    private ErrorWarningInternalParser2() {
    }

    public static ErrorWarningInternalParser2 getInstance() {
        if (mInstance == null) {
            mInstance = new ErrorWarningInternalParser2();
        }
        return mInstance;
    }

    public AutelWarningInternal parseErrorWarning(int i, int i2) {
        parseArmErrorCode(i2);
        parseBetteryWarningCode(i);
        parseReachMaxHeightWarningCode(i);
        parseReachMaxRangeWarningCode(i);
        parseGpsAbleWarningCode(i);
        parseHomeAbleWarningCode(i);
        parseCompassAbleWarningCode(i);
        parseRcDisconnectionWarningCode(i);
        parseAirportWarningWarningCode(i);
        parseMagStateWarningCode(i);
        parseBatterytHotWarningCode(i);
        parseFCHotWarningCode(i);
        parseOneKeyHopOffAbleWarningCode(i);
        parseHopOffAbleWarningCode(i);
        parseWarmUpingWarningCode(i);
        parseResultForCalibrateCompassStatus(i);
        return this;
    }

    private void parseArmErrorCode(int i) {
        this.armErrorCode = ARMWarning.find((i >> 8) & 255);
    }

    private void parseBetteryWarningCode(int i) {
        int i2 = i & 3;
        if (this.batteryWarning != BatteryWarning.find(i2)) {
            this.batteryWarning = BatteryWarning.find(i2);
            if (this.batteryWarning.getValue() != 0 && this.batteryWarning.getValue() != 1 && this.batteryWarning.getValue() != 2) {
                this.batteryWarning.getValue();
            }
        }
    }

    private void parseReachMaxHeightWarningCode(int i) {
        boolean z = true;
        if (((i >> 2) & 1) != 1) {
            z = false;
        }
        if (this.isReachMaxHeight != z) {
            this.isReachMaxHeight = z;
        }
    }

    private void parseReachMaxRangeWarningCode(int i) {
        boolean z = true;
        if (((i >> 3) & 1) != 1) {
            z = false;
        }
        if (this.isReachMaxRange != z) {
            this.isReachMaxRange = z;
        }
    }

    private void parseGpsAbleWarningCode(int i) {
        boolean z = true;
        if (((i >> 4) & 1) != 1) {
            z = false;
        }
        if (this.isGpsValid != z) {
            this.isGpsValid = z;
        }
    }

    private void parseHomeAbleWarningCode(int i) {
        boolean z = true;
        if (((i >> 5) & 1) != 1) {
            z = false;
        }
        if (this.isHomePointValid != z) {
            this.isHomePointValid = z;
        }
    }

    private void parseCompassAbleWarningCode(int i) {
        boolean z = true;
        if (((i >> 6) & 1) != 1) {
            z = false;
        }
        if (this.isCompassValid != z) {
            this.isCompassValid = z;
        }
    }

    private void parseRcDisconnectionWarningCode(int i) {
        boolean z = true;
        if (((i >> 7) & 1) != 1) {
            z = false;
        }
        if (this.isRcDisconnection != z) {
            this.isRcDisconnection = z;
        }
    }

    private void parseAirportWarningWarningCode(int i) {
        int i2 = (i >> 8) & 15;
        if (this.airportWarning != FlyLimitAreaWarning.find(i2)) {
            this.airportWarning = FlyLimitAreaWarning.find(i2);
        }
    }

    private void parseMagStateWarningCode(int i) {
        int i2 = (i >> 12) & 15;
        if (i2 == 0) {
            this.magState = MagnetometerState.CORRECT;
        } else if (i2 == 1) {
            this.magState = MagnetometerState.INTERFERENCE_CAN_KEEP_RIGHT_DIRECTION;
        } else if (i2 == 2) {
            this.magState = MagnetometerState.INTERFERENCE_WARN_FIRST;
        } else if (i2 == 3) {
            this.magState = MagnetometerState.INTERFERENCE_WARN_SECOND;
        } else if (i2 == 15) {
            this.magState = MagnetometerState.INTERFERENCE_ATTI;
        }
    }

    private void parseBatterytHotWarningCode(int i) {
        boolean z = true;
        if (((i >> 23) & 1) != 1) {
            z = false;
        }
        this.isBatHot = z;
    }

    private void parseFCHotWarningCode(int i) {
        boolean z = true;
        if (((i >> 22) & 1) != 1) {
            z = false;
        }
        this.isFCHot = z;
    }

    private void parseOneKeyHopOffAbleWarningCode(int i) {
        boolean z = true;
        if (((i >> 18) & 1) != 0) {
            z = false;
        }
        if (this.isOneClickTakeOffValid != z) {
            this.isOneClickTakeOffValid = z;
        }
    }

    private void parseHopOffAbleWarningCode(int i) {
        boolean z = true;
        if (((i >> 19) & 1) != 0) {
            z = false;
        }
        if (this.isTakeOffAble != z) {
            this.isTakeOffAble = z;
        }
    }

    private void parseWarmUpingWarningCode(int i) {
        boolean z = true;
        if (((i >> 31) & 1) != 0) {
            z = false;
        }
        if (this.isWarmingUp != z) {
            this.isWarmingUp = z;
        }
    }

    private void parseResultForCalibrateCompassStatus(int i) {
        switch ((i >> 24) & 7) {
            case 0:
                this.compassStatus = CalibrateCompassStatus.NORMAL;
                return;
            case 1:
                this.compassStatus = CalibrateCompassStatus.START_HORIZONTAL;
                return;
            case 2:
                this.compassStatus = CalibrateCompassStatus.HORIZONTAL_CALCULATE;
                return;
            case 3:
                this.compassStatus = CalibrateCompassStatus.START_VERTICAL;
                return;
            case 4:
                this.compassStatus = CalibrateCompassStatus.VERTICAL_CALCULATE;
                return;
            case 5:
                this.compassStatus = CalibrateCompassStatus.SUCCESS;
                return;
            case 6:
                this.compassStatus = CalibrateCompassStatus.FAILED;
                return;
            default:
                return;
        }
    }

    public void parseGimbalErrorCode(int i) {
        this.gimbalErrorCode = GimbalState.find(i);
        this.lastGimbalErrorCodeRefreshTime = System.currentTimeMillis();
    }
}
