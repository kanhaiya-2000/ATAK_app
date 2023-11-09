package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_position_target_local_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED = 84;
    public static final int MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED_CRC = 143;
    public static final int MAVLINK_MSG_LENGTH = 53;
    private static final long serialVersionUID = 84;
    public float afx;
    public float afy;
    public float afz;
    public short coordinate_frame;
    public short target_component;
    public short target_system;
    public long time_boot_ms;
    public int type_mask;

    /* renamed from: vx */
    public float f8342vx;

    /* renamed from: vy */
    public float f8343vy;

    /* renamed from: vz */
    public float f8344vz;

    /* renamed from: x */
    public float f8345x;

    /* renamed from: y */
    public float f8346y;
    public float yaw;
    public float yaw_rate;

    /* renamed from: z */
    public float f8347z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(53);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 84;
        mAVLinkPacket.crc_extra = 143;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8345x);
        mAVLinkPacket.payload.putFloat(this.f8346y);
        mAVLinkPacket.payload.putFloat(this.f8347z);
        mAVLinkPacket.payload.putFloat(this.f8342vx);
        mAVLinkPacket.payload.putFloat(this.f8343vy);
        mAVLinkPacket.payload.putFloat(this.f8344vz);
        mAVLinkPacket.payload.putFloat(this.afx);
        mAVLinkPacket.payload.putFloat(this.afy);
        mAVLinkPacket.payload.putFloat(this.afz);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.yaw_rate);
        mAVLinkPacket.payload.putUnsignedShort(this.type_mask);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.f8345x = mAVLinkPayload.getFloat();
        this.f8346y = mAVLinkPayload.getFloat();
        this.f8347z = mAVLinkPayload.getFloat();
        this.f8342vx = mAVLinkPayload.getFloat();
        this.f8343vy = mAVLinkPayload.getFloat();
        this.f8344vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.yaw_rate = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.coordinate_frame = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " x:" + this.f8345x + " y:" + this.f8346y + " z:" + this.f8347z + " vx:" + this.f8342vx + " vy:" + this.f8343vy + " vz:" + this.f8344vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " yaw:" + this.yaw + " yaw_rate:" + this.yaw_rate + " type_mask:" + this.type_mask + " target_system:" + this.target_system + " target_component:" + this.target_component + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
