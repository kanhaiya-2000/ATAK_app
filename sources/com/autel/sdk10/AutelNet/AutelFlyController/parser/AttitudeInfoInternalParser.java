package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.autel.internal.sdk.flycontroller.AutelAttitudeInfoInternal;

public class AttitudeInfoInternalParser extends AutelAttitudeInfoInternal {
    private static AttitudeInfoInternalParser instance_;

    public static AttitudeInfoInternalParser getInstance_() {
        if (instance_ == null) {
            instance_ = new AttitudeInfoInternalParser();
        }
        return instance_;
    }

    private AttitudeInfoInternalParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_attitude msg_attitude = (msg_attitude) mAVLinkMessage;
        setRoll((double) msg_attitude.roll);
        setPitch((double) msg_attitude.pitch);
        setYaw((double) msg_attitude.yaw);
    }
}
