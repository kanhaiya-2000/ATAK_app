package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_CONTROL = 157;
    public static final int MAVLINK_MSG_LENGTH = 15;
    private static final long serialVersionUID = 157;
    public int input_a;
    public int input_b;
    public int input_c;
    public byte save_position;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 15;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 157;
        mAVLinkPacket.payload.putInt(this.input_a);
        mAVLinkPacket.payload.putInt(this.input_b);
        mAVLinkPacket.payload.putInt(this.input_c);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.save_position);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.input_a = mAVLinkPayload.getInt();
        this.input_b = mAVLinkPayload.getInt();
        this.input_c = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.save_position = mAVLinkPayload.getByte();
    }

    public msg_mount_control() {
        this.msgid = 157;
    }

    public msg_mount_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 157;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_CONTROL - input_a:" + this.input_a + " input_b:" + this.input_b + " input_c:" + this.input_c + " target_system:" + this.target_system + " target_component:" + this.target_component + " save_position:" + this.save_position + "";
    }
}
