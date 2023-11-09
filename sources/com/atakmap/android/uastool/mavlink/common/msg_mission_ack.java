package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_ack extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ACK = 47;
    public static final int MAVLINK_MSG_ID_MISSION_ACK_CRC = 153;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 47;
    public short target_component;
    public short target_system;
    public short type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 47;
        mAVLinkPacket.crc_extra = 153;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.type = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_ack() {
        this.msgid = 47;
    }

    public msg_mission_ack(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 47;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ACK - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " type:" + this.type + "";
    }
}
