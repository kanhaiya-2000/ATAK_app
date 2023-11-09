package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_mode extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_MODE = 11;
    public static final int MAVLINK_MSG_ID_SET_MODE_CRC = 89;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 11;
    public short base_mode;
    public long custom_mode;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 11;
        mAVLinkPacket.crc_extra = 89;
        mAVLinkPacket.payload.putUnsignedInt(this.custom_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.base_mode);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.custom_mode = mAVLinkPayload.getUnsignedInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.base_mode = mAVLinkPayload.getUnsignedByte();
    }

    public msg_set_mode() {
        this.msgid = 11;
    }

    public msg_set_mode(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 11;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_MODE - sysid:" + this.sysid + " compid:" + this.compid + " custom_mode:" + this.custom_mode + " target_system:" + this.target_system + " base_mode:" + this.base_mode + "";
    }
}
