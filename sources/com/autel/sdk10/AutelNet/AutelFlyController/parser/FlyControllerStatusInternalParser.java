package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal;

public class FlyControllerStatusInternalParser extends AutelFlyControllerStatusInternal {
    private static FlyControllerStatusInternalParser instance_;

    public ARMWarning getArmErrorCode() {
        return null;
    }

    public boolean isGoHomePending() {
        return false;
    }

    public boolean isHomePointLocationAccurate() {
        return false;
    }

    public boolean isNearRangeLimit() {
        return false;
    }

    public boolean isStickLimited() {
        return false;
    }

    public boolean isSupportRtk() {
        return false;
    }

    public boolean isWindTooHigh() {
        return false;
    }

    public static FlyControllerStatusInternalParser getInstance_() {
        if (instance_ == null) {
            instance_ = new FlyControllerStatusInternalParser();
        }
        return instance_;
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_sys_status msg_sys_status = (msg_sys_status) mAVLinkMessage;
        setState(msg_sys_status.flight_warning);
        setFlyMode(msg_sys_status.flight_status);
        setMainFlyState(msg_sys_status.exflags & 15);
    }

    public boolean isReachMaxHeight() {
        return ErrorWarningInternalParser.getInstance().isReachMaxHeight();
    }

    public boolean isReachMaxRange() {
        return ErrorWarningInternalParser.getInstance().isReachMaxRange();
    }

    public boolean isGpsValid() {
        return ErrorWarningInternalParser.getInstance().isGpsValid();
    }

    public boolean isHomePointValid() {
        return ErrorWarningInternalParser.getInstance().isHomePointValid();
    }

    public boolean isCompassValid() {
        return ErrorWarningInternalParser.getInstance().isCompassValid();
    }

    public boolean isFlightControllerLostRemoteControllerSignal() {
        return ErrorWarningInternalParser.getInstance().isFCLostRCSignal();
    }

    public boolean isFlightControllerOverHeated() {
        return ErrorWarningInternalParser.getInstance().isFCOverHeated();
    }

    public boolean isOneClickTakeOffValid() {
        return ErrorWarningInternalParser.getInstance().isOneClickTakeOffValid();
    }

    public boolean isTakeOffValid() {
        return ErrorWarningInternalParser.getInstance().isTakeOffAble();
    }

    public boolean isWarmingUp() {
        return ErrorWarningInternalParser.getInstance().isWarmingUp();
    }

    public FlyLimitAreaWarning getFlyLimitAreaWarning() {
        return ErrorWarningInternalParser.getInstance().getAirportWarning();
    }
}
