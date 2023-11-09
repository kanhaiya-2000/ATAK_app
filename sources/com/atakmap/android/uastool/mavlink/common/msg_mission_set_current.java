package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_set_current extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_SET_CURRENT = 41;
    public static final int MAVLINK_MSG_ID_MISSION_SET_CURRENT_CRC = 28;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 41;
    public int seq;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 41;
        mAVLinkPacket.crc_extra = 28;
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

    public msg_mission_set_current() {
        this.msgid = 41;
    }

    public msg_mission_set_current(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 41;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_SET_CURRENT - sysid:" + this.sysid + " compid:" + this.compid + " seq:" + this.seq + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
