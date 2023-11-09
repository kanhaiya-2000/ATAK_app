package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_REQUEST = 40;
    public static final int MAVLINK_MSG_ID_MISSION_REQUEST_CRC = 230;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 40;
    public int seq;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 40;
        mAVLinkPacket.crc_extra = 230;
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

    public msg_mission_request() {
        this.msgid = 40;
    }

    public msg_mission_request(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 40;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST - sysid:" + this.sysid + " compid:" + this.compid + " seq:" + this.seq + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
