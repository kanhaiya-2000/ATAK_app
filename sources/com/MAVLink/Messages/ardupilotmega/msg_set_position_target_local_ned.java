package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_position_target_local_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED = 84;
    public static final int MAVLINK_MSG_LENGTH = 45;
    private static final long serialVersionUID = 84;
    public float afx;
    public float afy;
    public float afz;
    public byte coordinate_frame;
    public byte target_component;
    public byte target_system;
    public int time_boot_ms;
    public short type_mask;

    /* renamed from: vx */
    public float f8207vx;

    /* renamed from: vy */
    public float f8208vy;

    /* renamed from: vz */
    public float f8209vz;

    /* renamed from: x */
    public float f8210x;

    /* renamed from: y */
    public float f8211y;

    /* renamed from: z */
    public float f8212z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 45;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 84;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8210x);
        mAVLinkPacket.payload.putFloat(this.f8211y);
        mAVLinkPacket.payload.putFloat(this.f8212z);
        mAVLinkPacket.payload.putFloat(this.f8207vx);
        mAVLinkPacket.payload.putFloat(this.f8208vy);
        mAVLinkPacket.payload.putFloat(this.f8209vz);
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
        this.f8210x = mAVLinkPayload.getFloat();
        this.f8211y = mAVLinkPayload.getFloat();
        this.f8212z = mAVLinkPayload.getFloat();
        this.f8207vx = mAVLinkPayload.getFloat();
        this.f8208vy = mAVLinkPayload.getFloat();
        this.f8209vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_set_position_target_local_ned() {
        this.msgid = 84;
    }

    public msg_set_position_target_local_ned(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 84;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED - time_boot_ms:" + this.time_boot_ms + " x:" + this.f8210x + " y:" + this.f8211y + " z:" + this.f8212z + " vx:" + this.f8207vx + " vy:" + this.f8208vy + " vz:" + this.f8209vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " type_mask:" + this.type_mask + " target_system:" + this.target_system + " target_component:" + this.target_component + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
