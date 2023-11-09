package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_gps_global_origin extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN = 48;
    public static final int MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN_CRC = 41;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 48;
    public int altitude;
    public int latitude;
    public int longitude;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(13);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 48;
        mAVLinkPacket.crc_extra = 41;
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN - sysid:" + this.sysid + " compid:" + this.compid + " latitude:" + this.latitude + " longitude:" + this.longitude + " altitude:" + this.altitude + " target_system:" + this.target_system + "";
    }
}
