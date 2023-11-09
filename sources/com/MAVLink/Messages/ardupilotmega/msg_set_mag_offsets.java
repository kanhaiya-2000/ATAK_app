package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_mag_offsets extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS = 151;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 151;
    public short mag_ofs_x;
    public short mag_ofs_y;
    public short mag_ofs_z;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 8;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 151;
        mAVLinkPacket.payload.putShort(this.mag_ofs_x);
        mAVLinkPacket.payload.putShort(this.mag_ofs_y);
        mAVLinkPacket.payload.putShort(this.mag_ofs_z);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.mag_ofs_x = mAVLinkPayload.getShort();
        this.mag_ofs_y = mAVLinkPayload.getShort();
        this.mag_ofs_z = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_set_mag_offsets() {
        this.msgid = 151;
    }

    public msg_set_mag_offsets(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 151;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_MAG_OFFSETS - mag_ofs_x:" + this.mag_ofs_x + " mag_ofs_y:" + this.mag_ofs_y + " mag_ofs_z:" + this.mag_ofs_z + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
