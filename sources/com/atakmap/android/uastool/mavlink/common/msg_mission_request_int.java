package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_request_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_REQUEST_INT = 51;
    public static final int MAVLINK_MSG_ID_MISSION_REQUEST_INT_CRC = 196;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 51;
    public int seq;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 51;
        mAVLinkPacket.crc_extra = 196;
        mAVLinkPacket.payload.putUnsignedShort(this.seq);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seq = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_request_int() {
        this.msgid = 51;
    }

    public msg_mission_request_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 51;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST_INT - sysid:" + this.sysid + " compid:" + this.compid + " seq:" + this.seq + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
