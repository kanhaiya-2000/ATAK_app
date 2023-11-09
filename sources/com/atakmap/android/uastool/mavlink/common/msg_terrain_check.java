package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_terrain_check extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_TERRAIN_CHECK = 135;
    public static final int MAVLINK_MSG_ID_TERRAIN_CHECK_CRC = 203;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 135;
    public int lat;
    public int lon;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 135;
        mAVLinkPacket.crc_extra = 203;
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
    }

    public msg_terrain_check() {
        this.msgid = 135;
    }

    public msg_terrain_check(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 135;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_CHECK - sysid:" + this.sysid + " compid:" + this.compid + " lat:" + this.lat + " lon:" + this.lon + "";
    }
}
