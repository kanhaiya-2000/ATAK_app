package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_mode extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_MODE = 11;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 11;
    public byte base_mode;
    public int custom_mode;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 11;
        mAVLinkPacket.payload.putInt(this.custom_mode);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.base_mode);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.custom_mode = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getByte();
        this.base_mode = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_SET_MODE - custom_mode:" + this.custom_mode + " target_system:" + this.target_system + " base_mode:" + this.base_mode + "";
    }
}
