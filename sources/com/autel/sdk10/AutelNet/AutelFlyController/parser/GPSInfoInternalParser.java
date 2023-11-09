package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_gps_raw_int;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.internal.sdk.flycontroller.AutelGPSInfoInternal;

public class GPSInfoInternalParser extends AutelGPSInfoInternal {
    private static GPSInfoInternalParser instance_;

    public static GPSInfoInternalParser getInstance_() {
        if (instance_ == null) {
            instance_ = new GPSInfoInternalParser();
        }
        return instance_;
    }

    private GPSInfoInternalParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        msg_gps_raw_int msg_gps_raw_int = (msg_gps_raw_int) mAVLinkMessage;
        setGpsCount(msg_gps_raw_int.satellites_visible);
        setFixType(msg_gps_raw_int.fix_type);
        setEph(msg_gps_raw_int.eph);
        setCoord(new AutelCoordinate3D(((double) msg_gps_raw_int.lat) / 1.0E7d, ((double) msg_gps_raw_int.lon) / 1.0E7d));
    }
}
