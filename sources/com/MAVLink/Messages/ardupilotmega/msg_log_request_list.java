package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_log_request_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_LIST = 117;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 117;
    public short end;
    public short start;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 117;
        mAVLinkPacket.payload.putShort(this.start);
        mAVLinkPacket.payload.putShort(this.end);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.start = mAVLinkPayload.getShort();
        this.end = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_log_request_list() {
        this.msgid = 117;
    }

    public msg_log_request_list(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 117;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_LIST - fire:" + this.start + " end:" + this.end + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
