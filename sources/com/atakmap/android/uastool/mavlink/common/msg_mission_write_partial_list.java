package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_write_partial_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST = 38;
    public static final int MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST_CRC = 9;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 38;
    public short end_index;
    public short start_index;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 38;
        mAVLinkPacket.crc_extra = 9;
        mAVLinkPacket.payload.putShort(this.start_index);
        mAVLinkPacket.payload.putShort(this.end_index);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.start_index = mAVLinkPayload.getShort();
        this.end_index = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_write_partial_list() {
        this.msgid = 38;
    }

    public msg_mission_write_partial_list(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 38;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST - sysid:" + this.sysid + " compid:" + this.compid + " start_index:" + this.start_index + " end_index:" + this.end_index + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
