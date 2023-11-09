package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_configure extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE = 156;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 156;
    public byte mount_mode;
    public byte stab_pitch;
    public byte stab_roll;
    public byte stab_yaw;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 156;
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.mount_mode);
        mAVLinkPacket.payload.putByte(this.stab_roll);
        mAVLinkPacket.payload.putByte(this.stab_pitch);
        mAVLinkPacket.payload.putByte(this.stab_yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.mount_mode = mAVLinkPayload.getByte();
        this.stab_roll = mAVLinkPayload.getByte();
        this.stab_pitch = mAVLinkPayload.getByte();
        this.stab_yaw = mAVLinkPayload.getByte();
    }

    public msg_mount_configure() {
        this.msgid = 156;
    }

    public msg_mount_configure(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 156;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_CONFIGURE - target_system:" + this.target_system + " target_component:" + this.target_component + " mount_mode:" + this.mount_mode + " stab_roll:" + this.stab_roll + " stab_pitch:" + this.stab_pitch + " stab_yaw:" + this.stab_yaw + "";
    }
}
