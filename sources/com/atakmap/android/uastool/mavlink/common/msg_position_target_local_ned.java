package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_position_target_local_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED = 85;
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED_CRC = 140;
    public static final int MAVLINK_MSG_LENGTH = 51;
    private static final long serialVersionUID = 85;
    public float afx;
    public float afy;
    public float afz;
    public short coordinate_frame;
    public long time_boot_ms;
    public int type_mask;

    /* renamed from: vx */
    public float f8328vx;

    /* renamed from: vy */
    public float f8329vy;

    /* renamed from: vz */
    public float f8330vz;

    /* renamed from: x */
    public float f8331x;

    /* renamed from: y */
    public float f8332y;
    public float yaw;
    public float yaw_rate;

    /* renamed from: z */
    public float f8333z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(51);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 85;
        mAVLinkPacket.crc_extra = 140;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8331x);
        mAVLinkPacket.payload.putFloat(this.f8332y);
        mAVLinkPacket.payload.putFloat(this.f8333z);
        mAVLinkPacket.payload.putFloat(this.f8328vx);
        mAVLinkPacket.payload.putFloat(this.f8329vy);
        mAVLinkPacket.payload.putFloat(this.f8330vz);
        mAVLinkPacket.payload.putFloat(this.afx);
        mAVLinkPacket.payload.putFloat(this.afy);
        mAVLinkPacket.payload.putFloat(this.afz);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.yaw_rate);
        mAVLinkPacket.payload.putUnsignedShort(this.type_mask);
        mAVLinkPacket.payload.putUnsignedByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.f8331x = mAVLinkPayload.getFloat();
        this.f8332y = mAVLinkPayload.getFloat();
        this.f8333z = mAVLinkPayload.getFloat();
        this.f8328vx = mAVLinkPayload.getFloat();
        this.f8329vy = mAVLinkPayload.getFloat();
        this.f8330vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.yaw_rate = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getUnsignedShort();
        this.coordinate_frame = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " x:" + this.f8331x + " y:" + this.f8332y + " z:" + this.f8333z + " vx:" + this.f8328vx + " vy:" + this.f8329vy + " vz:" + this.f8330vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " yaw:" + this.yaw + " yaw_rate:" + this.yaw_rate + " type_mask:" + this.type_mask + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
