package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_rally_point extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RALLY_POINT = 175;
    public static final int MAVLINK_MSG_LENGTH = 19;
    private static final long serialVersionUID = 175;
    public short alt;
    public short break_alt;
    public byte count;
    public byte flags;
    public byte idx;
    public short land_dir;
    public int lat;
    public int lng;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 19;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 175;
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        mAVLinkPacket.payload.putShort(this.alt);
        mAVLinkPacket.payload.putShort(this.break_alt);
        mAVLinkPacket.payload.putShort(this.land_dir);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.idx);
        mAVLinkPacket.payload.putByte(this.count);
        mAVLinkPacket.payload.putByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getInt();
        this.lng = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getShort();
        this.break_alt = mAVLinkPayload.getShort();
        this.land_dir = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.idx = mAVLinkPayload.getByte();
        this.count = mAVLinkPayload.getByte();
        this.flags = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_RALLY_POINT - latitude:" + this.lat + " longitude:" + this.lng + " alt:" + this.alt + " break_alt:" + this.break_alt + " land_dir:" + this.land_dir + " target_system:" + this.target_system + " target_component:" + this.target_component + " idx:" + this.idx + " count:" + this.count + " flags:" + this.flags + "";
    }
}
