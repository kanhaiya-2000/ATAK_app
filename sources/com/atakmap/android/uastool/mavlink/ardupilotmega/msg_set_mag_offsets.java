package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_mag_offsets extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS = 151;
    public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS_CRC = 219;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 151;
    public short mag_ofs_x;
    public short mag_ofs_y;
    public short mag_ofs_z;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 151;
        mAVLinkPacket.crc_extra = 219;
        mAVLinkPacket.payload.putShort(this.mag_ofs_x);
        mAVLinkPacket.payload.putShort(this.mag_ofs_y);
        mAVLinkPacket.payload.putShort(this.mag_ofs_z);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.mag_ofs_x = mAVLinkPayload.getShort();
        this.mag_ofs_y = mAVLinkPayload.getShort();
        this.mag_ofs_z = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_SET_MAG_OFFSETS - sysid:" + this.sysid + " compid:" + this.compid + " mag_ofs_x:" + this.mag_ofs_x + " mag_ofs_y:" + this.mag_ofs_y + " mag_ofs_z:" + this.mag_ofs_z + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
