package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_STATUS = 158;
    public static final int MAVLINK_MSG_ID_MOUNT_STATUS_CRC = 134;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 158;
    public int pointing_a;
    public int pointing_b;
    public int pointing_c;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 158;
        mAVLinkPacket.crc_extra = 134;
        mAVLinkPacket.payload.putInt(this.pointing_a);
        mAVLinkPacket.payload.putInt(this.pointing_b);
        mAVLinkPacket.payload.putInt(this.pointing_c);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.pointing_a = mAVLinkPayload.getInt();
        this.pointing_b = mAVLinkPayload.getInt();
        this.pointing_c = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_MOUNT_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " pointing_a:" + this.pointing_a + " pointing_b:" + this.pointing_b + " pointing_c:" + this.pointing_c + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
