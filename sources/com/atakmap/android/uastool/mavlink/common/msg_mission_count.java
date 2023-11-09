package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_count extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_COUNT = 44;
    public static final int MAVLINK_MSG_ID_MISSION_COUNT_CRC = 221;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 44;
    public int count;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 44;
        mAVLinkPacket.crc_extra = 221;
        mAVLinkPacket.payload.putUnsignedShort(this.count);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.count = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_count() {
        this.msgid = 44;
    }

    public msg_mission_count(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 44;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_COUNT - sysid:" + this.sysid + " compid:" + this.compid + " count:" + this.count + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
