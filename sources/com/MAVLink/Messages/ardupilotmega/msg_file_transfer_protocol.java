package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_file_transfer_protocol extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL = 110;
    public static final int MAVLINK_MSG_LENGTH = 254;
    private static final long serialVersionUID = 110;
    public byte[] payload = new byte[251];
    public byte target_component;
    public byte target_network;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 254;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 110;
        mAVLinkPacket.payload.putByte(this.target_network);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        for (byte putByte : this.payload) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_network = mAVLinkPayload.getByte();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_file_transfer_protocol() {
        this.msgid = 110;
    }

    public msg_file_transfer_protocol(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 110;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL - target_network:" + this.target_network + " target_system:" + this.target_system + " target_component:" + this.target_component + " payload:" + this.payload + "";
    }
}
