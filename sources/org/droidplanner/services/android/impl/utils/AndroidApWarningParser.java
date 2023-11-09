package org.droidplanner.services.android.impl.utils;

import android.text.TextUtils;
import atakplugin.UASTool.bpg;
import com.o3dr.services.android.lib.drone.attribute.error.ErrorType;
import java.util.Locale;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;

public class AndroidApWarningParser implements AutopilotWarningParser {
    public String getDefaultWarning() {
        return ErrorType.NO_ERROR.name();
    }

    public String parseWarning(MavLinkDrone mavLinkDrone, String str) {
        ErrorType errorType;
        if (!TextUtils.isEmpty(str) && (errorType = getErrorType(str)) != null) {
            return errorType.name();
        }
        return null;
    }

    private ErrorType getErrorType(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -2146798630:
                if (lowerCase.equals("prearm: rc not calibrated")) {
                    c = 0;
                    break;
                }
                break;
            case -2134847744:
                if (lowerCase.equals("low battery!")) {
                    c = 1;
                    break;
                }
                break;
            case -1917352489:
                if (lowerCase.equals("prearm: bad velocity")) {
                    c = 2;
                    break;
                }
                break;
            case -1917010206:
                if (lowerCase.equals("arm: throttle too high")) {
                    c = 3;
                    break;
                }
                break;
            case -1895854554:
                if (lowerCase.equals("prearm: ekf-home variance")) {
                    c = 4;
                    break;
                }
                break;
            case -1853641503:
                if (lowerCase.equals("prearm: acro_bal_roll/pitch")) {
                    c = 5;
                    break;
                }
                break;
            case -1747114902:
                if (lowerCase.equals("prearm: gps glitch")) {
                    c = 6;
                    break;
                }
                break;
            case -1625561707:
                if (lowerCase.equals("prearm: check fs_thr_value")) {
                    c = 7;
                    break;
                }
                break;
            case -1593520933:
                if (lowerCase.equals("prearm: compass offsets too high")) {
                    c = 8;
                    break;
                }
                break;
            case -1571186002:
                if (lowerCase.equals("prearm: inconsistent accelerometers")) {
                    c = 9;
                    break;
                }
                break;
            case -1461541630:
                if (lowerCase.equals("prearm: duplicate aux switch options")) {
                    c = 10;
                    break;
                }
                break;
            case -1378061513:
                if (lowerCase.equals("prearm: compass not calibrated")) {
                    c = 11;
                    break;
                }
                break;
            case -1009630669:
                if (lowerCase.equals("prearm: accelerometers not healthy")) {
                    c = 12;
                    break;
                }
                break;
            case -981159495:
                if (lowerCase.equals("arm: compass calibration running")) {
                    c = 13;
                    break;
                }
                break;
            case -890353939:
                if (lowerCase.equals("prearm: check board voltage")) {
                    c = 14;
                    break;
                }
                break;
            case -770169350:
                if (lowerCase.equals("arm: leaning")) {
                    c = 15;
                    break;
                }
                break;
            case -741249030:
                if (lowerCase.equals("prearm: check fence")) {
                    c = 16;
                    break;
                }
                break;
            case -690748289:
                if (lowerCase.equals("arm: altitude disparity")) {
                    c = 17;
                    break;
                }
                break;
            case -670898671:
                if (lowerCase.equals("ekf variance")) {
                    c = 18;
                    break;
                }
                break;
            case -341963069:
                if (lowerCase.equals("arm: waiting for navigation alignment")) {
                    c = 19;
                    break;
                }
                break;
            case -301097893:
                if (lowerCase.equals("prearm: ins not calibrated")) {
                    c = 20;
                    break;
                }
                break;
            case -290507776:
                if (lowerCase.equals("arm: thr below fs")) {
                    c = 21;
                    break;
                }
                break;
            case -267908484:
                if (lowerCase.equals("prearm: altitude disparity")) {
                    c = 22;
                    break;
                }
                break;
            case -256027136:
                if (lowerCase.equals("prearm: waiting for navigation alignment")) {
                    c = 23;
                    break;
                }
                break;
            case -106768767:
                if (lowerCase.equals("parachute: too low")) {
                    c = 24;
                    break;
                }
                break;
            case 202776385:
                if (lowerCase.equals("prearm: check angle_max")) {
                    c = 25;
                    break;
                }
                break;
            case 332862197:
                if (lowerCase.equals("prearm: gyros not healthy")) {
                    c = 26;
                    break;
                }
                break;
            case 634453514:
                if (lowerCase.equals("autotune: failed")) {
                    c = 27;
                    break;
                }
                break;
            case 926827318:
                if (lowerCase.equals("prearm: check mag field")) {
                    c = 28;
                    break;
                }
                break;
            case 1052822102:
                if (lowerCase.equals("prearm: inconsistent compasses")) {
                    c = 29;
                    break;
                }
                break;
            case 1158740235:
                if (lowerCase.equals("arm: rotor not spinning")) {
                    c = 30;
                    break;
                }
                break;
            case 1219426034:
                if (lowerCase.equals("prearm: high gps hdop")) {
                    c = 31;
                    break;
                }
                break;
            case 1227069314:
                if (lowerCase.equals("arm: gyro calibration failed")) {
                    c = ' ';
                    break;
                }
                break;
            case 1289348334:
                if (lowerCase.equals("arm: mode not armable")) {
                    c = '!';
                    break;
                }
                break;
            case 1404064679:
                if (lowerCase.equals("crash: disarming")) {
                    c = bpg.f3093a;
                    break;
                }
                break;
            case 1419503395:
                if (lowerCase.equals("prearm: compass not healthy")) {
                    c = '#';
                    break;
                }
                break;
            case 1701250481:
                if (lowerCase.equals("prearm: need 3d fix")) {
                    c = bpg.f3094b;
                    break;
                }
                break;
            case 1772005306:
                if (lowerCase.equals("prearm: inconsistent gyros")) {
                    c = '%';
                    break;
                }
                break;
            case 1787342750:
                if (lowerCase.equals("prearm: barometer not healthy")) {
                    c = bpg.f3095c;
                    break;
                }
                break;
            case 1957693870:
                if (lowerCase.equals("arm: throttle below failsafe")) {
                    c = '\'';
                    break;
                }
                break;
            case 1997869242:
                if (lowerCase.equals("rc failsafe")) {
                    c = '(';
                    break;
                }
                break;
            case 2066139697:
                if (lowerCase.equals("no dataflash inserted")) {
                    c = ')';
                    break;
                }
                break;
            case 2095995136:
                if (lowerCase.equals("arm: safety switch")) {
                    c = '*';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ErrorType.PRE_ARM_RC_NOT_CALIBRATED;
            case 1:
                return ErrorType.LOW_BATTERY;
            case 2:
            case 6:
                return ErrorType.PRE_ARM_GPS_GLITCH;
            case 3:
                return ErrorType.ARM_THROTTLE_TOO_HIGH;
            case 4:
                return ErrorType.PRE_ARM_EKF_HOME_VARIANCE;
            case 5:
                return ErrorType.PRE_ARM_ACRO_BAL_ROLL_PITCH;
            case 7:
                return ErrorType.PRE_ARM_CHECK_FAILSAFE_THRESHOLD_VALUE;
            case 8:
                return ErrorType.PRE_ARM_COMPASS_OFFSETS_TOO_HIGH;
            case 9:
                return ErrorType.PRE_ARM_INCONSISTENT_ACCELEROMETERS;
            case 10:
                return ErrorType.PRE_ARM_DUPLICATE_AUX_SWITCH_OPTIONS;
            case 11:
                return ErrorType.PRE_ARM_COMPASS_NOT_CALIBRATED;
            case 12:
                return ErrorType.PRE_ARM_ACCELEROMETERS_NOT_HEALTHY;
            case 13:
                return ErrorType.ARM_COMPASS_CALIBRATION_RUNNING;
            case 14:
                return ErrorType.PRE_ARM_CHECK_BOARD_VOLTAGE;
            case 15:
                return ErrorType.ARM_LEANING;
            case 16:
                return ErrorType.PRE_ARM_CHECK_FENCE;
            case 17:
            case 22:
                return ErrorType.ALTITUDE_DISPARITY;
            case 18:
                return ErrorType.EKF_VARIANCE;
            case 19:
            case 23:
                return ErrorType.WAITING_FOR_NAVIGATION_ALIGNMENT;
            case 20:
                return ErrorType.PRE_ARM_INS_NOT_CALIBRATED;
            case 21:
            case '\'':
                return ErrorType.ARM_THROTTLE_BELOW_FAILSAFE;
            case 24:
                return ErrorType.PARACHUTE_TOO_LOW;
            case 25:
                return ErrorType.PRE_ARM_CHECK_ANGLE_MAX;
            case 26:
                return ErrorType.PRE_ARM_GYROS_NOT_HEALTHY;
            case 27:
                return ErrorType.AUTO_TUNE_FAILED;
            case 28:
                return ErrorType.PRE_ARM_CHECK_MAGNETIC_FIELD;
            case 29:
                return ErrorType.PRE_ARM_INCONSISTENT_COMPASSES;
            case 30:
                return ErrorType.ARM_ROTOR_NOT_SPINNING;
            case 31:
                return ErrorType.PRE_ARM_HIGH_GPS_HDOP;
            case ' ':
                return ErrorType.ARM_GYRO_CALIBRATION_FAILED;
            case '!':
                return ErrorType.ARM_MODE_NOT_ARMABLE;
            case '\"':
                return ErrorType.CRASH_DISARMING;
            case '#':
                return ErrorType.PRE_ARM_COMPASS_NOT_HEALTHY;
            case '$':
                return ErrorType.PRE_ARM_NEED_GPS_LOCK;
            case '%':
                return ErrorType.PRE_ARM_INCONSISTENT_GYROS;
            case '&':
                return ErrorType.PRE_ARM_BAROMETER_NOT_HEALTHY;
            case '(':
                return ErrorType.RC_FAILSAFE;
            case ')':
                return ErrorType.NO_DATAFLASH_INSERTED;
            case '*':
                return ErrorType.ARM_SAFETY_SWITCH;
            default:
                return null;
        }
    }
}
