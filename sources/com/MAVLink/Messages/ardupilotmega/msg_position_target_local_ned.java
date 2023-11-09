package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_position_target_local_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED = 85;
    public static final int MAVLINK_MSG_LENGTH = 43;
    private static final long serialVersionUID = 85;
    public float afx;
    public float afy;
    public float afz;
    public byte coordinate_frame;
    public int time_boot_ms;
    public short type_mask;

    /* renamed from: vx */
    public float f8194vx;

    /* renamed from: vy */
    public float f8195vy;

    /* renamed from: vz */
    public float f8196vz;

    /* renamed from: x */
    public float f8197x;

    /* renamed from: y */
    public float f8198y;

    /* renamed from: z */
    public float f8199z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 43;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 85;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8197x);
        mAVLinkPacket.payload.putFloat(this.f8198y);
        mAVLinkPacket.payload.putFloat(this.f8199z);
        mAVLinkPacket.payload.putFloat(this.f8194vx);
        mAVLinkPacket.payload.putFloat(this.f8195vy);
        mAVLinkPacket.payload.putFloat(this.f8196vz);
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
        this.f8197x = mAVLinkPayload.getFloat();
        this.f8198y = mAVLinkPayload.getFloat();
        this.f8199z = mAVLinkPayload.getFloat();
        this.f8194vx = mAVLinkPayload.getFloat();
        this.f8195vy = mAVLinkPayload.getFloat();
        this.f8196vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getShort();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_position_target_local_ned() {
        this.msgid = 85;
    }

    public msg_position_target_local_ned(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 85;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED - time_boot_ms:" + this.time_boot_ms + " x:" + this.f8197x + " y:" + this.f8198y + " z:" + this.f8199z + " vx:" + this.f8194vx + " vy:" + this.f8195vy + " vz:" + this.f8196vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " type_mask:" + this.type_mask + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
