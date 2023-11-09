package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_configure extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE = 156;
    public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE_CRC = 19;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 156;
    public short mount_mode;
    public short stab_pitch;
    public short stab_roll;
    public short stab_yaw;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 156;
        mAVLinkPacket.crc_extra = 19;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.mount_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.stab_roll);
        mAVLinkPacket.payload.putUnsignedByte(this.stab_pitch);
        mAVLinkPacket.payload.putUnsignedByte(this.stab_yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.mount_mode = mAVLinkPayload.getUnsignedByte();
        this.stab_roll = mAVLinkPayload.getUnsignedByte();
        this.stab_pitch = mAVLinkPayload.getUnsignedByte();
        this.stab_yaw = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_MOUNT_CONFIGURE - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " mount_mode:" + this.mount_mode + " stab_roll:" + this.stab_roll + " stab_pitch:" + this.stab_pitch + " stab_yaw:" + this.stab_yaw + "";
    }
}
