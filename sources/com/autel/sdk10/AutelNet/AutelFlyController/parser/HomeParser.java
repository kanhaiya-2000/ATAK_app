package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_gps_global_origin;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;

public class HomeParser extends AutelHomeInternal {
    private static HomeParser instance_;

    public static HomeParser getInstance_() {
        if (instance_ == null) {
            instance_ = new HomeParser();
        }
        return instance_;
    }

    private HomeParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_gps_global_origin msg_gps_global_origin = (msg_gps_global_origin) mAVLinkMessage;
        if (msg_gps_global_origin.latitude != 0 && msg_gps_global_origin.longitude != 0) {
            getAutelCoord3D().setLatitude(((double) msg_gps_global_origin.latitude) / 1.0E7d);
            getAutelCoord3D().setLongitude(((double) msg_gps_global_origin.longitude) / 1.0E7d);
        }
    }
}
