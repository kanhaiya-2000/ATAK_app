package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned;
import com.autel.internal.sdk.flycontroller.AutelAltitudeAndSpeedInfoInternal;

public class AltitudeAndSpeedInfoInternalParser extends AutelAltitudeAndSpeedInfoInternal {
    private static AltitudeAndSpeedInfoInternalParser instance_;

    public static AltitudeAndSpeedInfoInternalParser getInstance_() {
        if (instance_ == null) {
            instance_ = new AltitudeAndSpeedInfoInternalParser();
        }
        return instance_;
    }

    private AltitudeAndSpeedInfoInternalParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_local_position_ned msg_local_position_ned = (msg_local_position_ned) mAVLinkMessage;
        setAltitude(msg_local_position_ned.f8165z);
        setXSpeed(msg_local_position_ned.f8160vx);
        setYSpeed(msg_local_position_ned.f8161vy);
        setZSpeed(msg_local_position_ned.f8162vz);
    }
}
