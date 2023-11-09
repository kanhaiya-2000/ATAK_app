package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_current;
import com.MAVLink.Messages.ardupilotmega.msg_ptz_frame_cmd;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.gimbal.GimbalState;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelFlyController.interfaces.IAutelFlyControllerInterfaces;
import com.autel.sdk10.interfaces.IAutelConnectionStatusListener;
import com.autel.sdk10.products.aircraft.AutelAircraftManager;
import java.util.concurrent.ConcurrentHashMap;

public class ErrorWarningInternalParser extends AutelWarningInternal {
    private static ErrorWarningInternalParser instance;
    private final String TAG = "ErrorWarningInternalParser";
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener> listenerMaps = new ConcurrentHashMap<>();

    public void addIFlyControllerErrorWarningListener(String str, IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener iFlyControllerErrorWarningListener) {
        this.listenerMaps.put(str, iFlyControllerErrorWarningListener);
        iFlyControllerErrorWarningListener.onErrorWarning(this);
    }

    public void removeIFlyControllerErrorWarningListener(String str) {
        this.listenerMaps.remove(str);
    }

    public void callback() {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (!ErrorWarningInternalParser.this.listenerMaps.isEmpty()) {
                    for (IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener onErrorWarning : ErrorWarningInternalParser.this.listenerMaps.values()) {
                        onErrorWarning.onErrorWarning(ErrorWarningInternalParser.this);
                    }
                }
            }
        });
    }

    public static ErrorWarningInternalParser getInstance() {
        if (instance == null) {
            instance = new ErrorWarningInternalParser();
        }
        return instance;
    }

    private ErrorWarningInternalParser() {
        AutelAircraftManager.getRCManager().removeIAutelConnectionStatusListener("ErrorWarningInternalParser");
        AutelAircraftManager.getRCManager().addIAutelConnectionStatusListener("ErrorWarningInternalParser", new IAutelConnectionStatusListener() {
            public void onReconnect() {
            }

            public void onConnect() {
                boolean unused = ErrorWarningInternalParser.this.isRCConnected = true;
                ErrorWarningInternalParser.this.callback();
            }

            public void onDisconnect() {
                boolean unused = ErrorWarningInternalParser.this.isRCConnected = false;
                ErrorWarningInternalParser.this.callback();
            }
        });
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_sys_status msg_sys_status = (msg_sys_status) mAVLinkMessage;
        parseArmErrorCode(msg_sys_status);
        parseBetteryWarningCode(msg_sys_status.flight_warning);
        parseReachMaxHeightWarningCode(msg_sys_status.flight_warning);
        parseReachMaxRangeWarningCode(msg_sys_status.flight_warning);
        parseGpsAbleWarningCode(msg_sys_status.flight_warning);
        parseHomeAbleWarningCode(msg_sys_status.flight_warning);
        parseCompassAbleWarningCode(msg_sys_status.flight_warning);
        parseRcDisconnectionWarningCode(msg_sys_status.flight_warning);
        parseAirportWarningWarningCode(msg_sys_status.flight_warning);
        parseMagStateWarningCode(msg_sys_status.flight_warning);
        parseBatterytHotWarningCode(msg_sys_status.flight_warning);
        parseFCHotWarningCode(msg_sys_status.flight_warning);
        parseOneKeyHopOffAbleWarningCode(msg_sys_status.flight_warning);
        parseHopOffAbleWarningCode(msg_sys_status.flight_warning);
        parseWarmUpingWarningCode(msg_sys_status.flight_warning);
        parseResultForCalibrateCompassStatus(mAVLinkMessage);
        callback();
    }

    private void parseArmErrorCode(msg_sys_status msg_sys_status) {
        this.armErrorCode = ARMWarning.find((msg_sys_status.exflags >> 8) & 255);
    }

    public void parseGPSandDistanceErrorCode(MAVLinkMessage mAVLinkMessage) {
        mavlink_msg_mission_new_current mavlink_msg_mission_new_current = (mavlink_msg_mission_new_current) mAVLinkMessage;
        boolean z = true;
        this.isGPSWeak = mavlink_msg_mission_new_current.wp_mode == 4;
        if (mavlink_msg_mission_new_current.wp_mode != 5) {
            z = false;
        }
        this.isTooFar = z;
    }

    public void parseGimbalErrorCode(msg_ptz_frame_cmd msg_ptz_frame_cmd) {
        this.gimbalErrorCode = GimbalState.find((int) msg_ptz_frame_cmd.index);
        this.lastGimbalErrorCodeRefreshTime = System.currentTimeMillis();
    }

    public void parseConnectStatus(boolean z) {
        this.isHeartBeatNormal = z;
        callback();
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

    private void parseResultForCalibrateCompassStatus(MAVLinkMessage mAVLinkMessage) {
        switch ((((msg_sys_status) mAVLinkMessage).flight_warning >> 24) & 7) {
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
}
