package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_request_partial_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST = 37;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 37;
    public short end_index;
    public short start_index;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 37;
        mAVLinkPacket.payload.putShort(this.start_index);
        mAVLinkPacket.payload.putShort(this.end_index);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.start_index = mAVLinkPayload.getShort();
        this.end_index = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_mission_request_partial_list() {
        this.msgid = 37;
    }

    public msg_mission_request_partial_list(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 37;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST - start_index:" + this.start_index + " end_index:" + this.end_index + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
