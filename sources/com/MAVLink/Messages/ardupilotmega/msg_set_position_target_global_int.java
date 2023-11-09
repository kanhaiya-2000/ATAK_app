package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_position_target_global_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_POSITION_TARGET_GLOBAL_INT = 86;
    public static final int MAVLINK_MSG_LENGTH = 45;
    private static final long serialVersionUID = 86;
    public float afx;
    public float afy;
    public float afz;
    public float alt;
    public byte coordinate_frame;
    public int lat_int;
    public int lon_int;
    public byte target_component;
    public byte target_system;
    public int time_boot_ms;
    public short type_mask;

    /* renamed from: vx */
    public float f8204vx;

    /* renamed from: vy */
    public float f8205vy;

    /* renamed from: vz */
    public float f8206vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 45;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 86;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat_int);
        mAVLinkPacket.payload.putInt(this.lon_int);
        mAVLinkPacket.payload.putFloat(this.alt);
        mAVLinkPacket.payload.putFloat(this.f8204vx);
        mAVLinkPacket.payload.putFloat(this.f8205vy);
        mAVLinkPacket.payload.putFloat(this.f8206vz);
        mAVLinkPacket.payload.putFloat(this.afx);
        mAVLinkPacket.payload.putFloat(this.afy);
        mAVLinkPacket.payload.putFloat(this.afz);
        mAVLinkPacket.payload.putShort(this.type_mask);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.lat_int = mAVLinkPayload.getInt();
        this.lon_int = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getFloat();
        this.f8204vx = mAVLinkPayload.getFloat();
        this.f8205vy = mAVLinkPayload.getFloat();
        this.f8206vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_set_position_target_global_int() {
        this.msgid = 86;
    }

    public msg_set_position_target_global_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 86;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_POSITION_TARGET_GLOBAL_INT - time_boot_ms:" + this.time_boot_ms + " lat_int:" + this.lat_int + " lon_int:" + this.lon_int + " alt:" + this.alt + " vx:" + this.f8204vx + " vy:" + this.f8205vy + " vz:" + this.f8206vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " type_mask:" + this.type_mask + " target_system:" + this.target_system + " target_component:" + this.target_component + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
