package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_clear_all extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_CLEAR_ALL = 45;
    public static final int MAVLINK_MSG_ID_MISSION_CLEAR_ALL_CRC = 232;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = 45;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(2);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 45;
        mAVLinkPacket.crc_extra = 232;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_clear_all() {
        this.msgid = 45;
    }

    public msg_mission_clear_all(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 45;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_CLEAR_ALL - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
