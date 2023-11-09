package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_STATUS = 158;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 158;
    public int pointing_a;
    public int pointing_b;
    public int pointing_c;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 14;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 158;
        mAVLinkPacket.payload.putInt(this.pointing_a);
        mAVLinkPacket.payload.putInt(this.pointing_b);
        mAVLinkPacket.payload.putInt(this.pointing_c);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.pointing_a = mAVLinkPayload.getInt();
        this.pointing_b = mAVLinkPayload.getInt();
        this.pointing_c = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_mount_status() {
        this.msgid = 158;
    }

    public msg_mount_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 158;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_STATUS - pointing_a:" + this.pointing_a + " pointing_b:" + this.pointing_b + " pointing_c:" + this.pointing_c + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
