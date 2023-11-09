package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_position_target_global_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT = 87;
    public static final int MAVLINK_MSG_LENGTH = 43;
    private static final long serialVersionUID = 87;
    public float afx;
    public float afy;
    public float afz;
    public float alt;
    public byte coordinate_frame;
    public int lat_int;
    public int lon_int;
    public int time_boot_ms;
    public short type_mask;

    /* renamed from: vx */
    public float f8191vx;

    /* renamed from: vy */
    public float f8192vy;

    /* renamed from: vz */
    public float f8193vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 43;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 87;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat_int);
        mAVLinkPacket.payload.putInt(this.lon_int);
        mAVLinkPacket.payload.putFloat(this.alt);
        mAVLinkPacket.payload.putFloat(this.f8191vx);
        mAVLinkPacket.payload.putFloat(this.f8192vy);
        mAVLinkPacket.payload.putFloat(this.f8193vz);
        mAVLinkPacket.payload.putFloat(this.afx);
        mAVLinkPacket.payload.putFloat(this.afy);
        mAVLinkPacket.payload.putFloat(this.afz);
        mAVLinkPacket.payload.putShort(this.type_mask);
        mAVLinkPacket.payload.putByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.lat_int = mAVLinkPayload.getInt();
        this.lon_int = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getFloat();
        this.f8191vx = mAVLinkPayload.getFloat();
        this.f8192vy = mAVLinkPayload.getFloat();
        this.f8193vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getShort();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_position_target_global_int() {
        this.msgid = 87;
    }

    public msg_position_target_global_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 87;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT - time_boot_ms:" + this.time_boot_ms + " lat_int:" + this.lat_int + " lon_int:" + this.lon_int + " alt:" + this.alt + " vx:" + this.f8191vx + " vy:" + this.f8192vy + " vz:" + this.f8193vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " type_mask:" + this.type_mask + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
