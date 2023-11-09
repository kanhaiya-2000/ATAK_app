package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_gps_global_origin extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN = 48;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 48;
    public int altitude;
    public int latitude;
    public int longitude;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 13;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 48;
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getByte();
    }

    public msg_set_gps_global_origin() {
        this.msgid = 48;
    }

    public msg_set_gps_global_origin(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 48;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN - latitude:" + this.latitude + " longitude:" + this.longitude + " altitude:" + this.altitude + " target_system:" + this.target_system + "";
    }
}
