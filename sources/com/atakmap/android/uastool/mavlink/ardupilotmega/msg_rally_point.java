package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_rally_point extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RALLY_POINT = 175;
    public static final int MAVLINK_MSG_ID_RALLY_POINT_CRC = 138;
    public static final int MAVLINK_MSG_LENGTH = 19;
    private static final long serialVersionUID = 175;
    public short alt;
    public short break_alt;
    public short count;
    public short flags;
    public short idx;
    public int land_dir;
    public int lat;
    public int lng;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(19);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 175;
        mAVLinkPacket.crc_extra = 138;
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        mAVLinkPacket.payload.putShort(this.alt);
        mAVLinkPacket.payload.putShort(this.break_alt);
        mAVLinkPacket.payload.putUnsignedShort(this.land_dir);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.idx);
        mAVLinkPacket.payload.putUnsignedByte(this.count);
        mAVLinkPacket.payload.putUnsignedByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getInt();
        this.lng = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getShort();
        this.break_alt = mAVLinkPayload.getShort();
        this.land_dir = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.idx = mAVLinkPayload.getUnsignedByte();
        this.count = mAVLinkPayload.getUnsignedByte();
        this.flags = mAVLinkPayload.getUnsignedByte();
    }

    public msg_rally_point() {
        this.msgid = 175;
    }

    public msg_rally_point(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 175;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RALLY_POINT - sysid:" + this.sysid + " compid:" + this.compid + " lat:" + this.lat + " lng:" + this.lng + " alt:" + this.alt + " break_alt:" + this.break_alt + " land_dir:" + this.land_dir + " target_system:" + this.target_system + " target_component:" + this.target_component + " idx:" + this.idx + " count:" + this.count + " flags:" + this.flags + "";
    }
}
