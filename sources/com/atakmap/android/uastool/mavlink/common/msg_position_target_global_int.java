package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_position_target_global_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT = 87;
    public static final int MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT_CRC = 150;
    public static final int MAVLINK_MSG_LENGTH = 51;
    private static final long serialVersionUID = 87;
    public float afx;
    public float afy;
    public float afz;
    public float alt;
    public short coordinate_frame;
    public int lat_int;
    public int lon_int;
    public long time_boot_ms;
    public int type_mask;

    /* renamed from: vx */
    public float f8325vx;

    /* renamed from: vy */
    public float f8326vy;

    /* renamed from: vz */
    public float f8327vz;
    public float yaw;
    public float yaw_rate;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(51);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 87;
        mAVLinkPacket.crc_extra = 150;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat_int);
        mAVLinkPacket.payload.putInt(this.lon_int);
        mAVLinkPacket.payload.putFloat(this.alt);
        mAVLinkPacket.payload.putFloat(this.f8325vx);
        mAVLinkPacket.payload.putFloat(this.f8326vy);
        mAVLinkPacket.payload.putFloat(this.f8327vz);
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
        this.lat_int = mAVLinkPayload.getInt();
        this.lon_int = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getFloat();
        this.f8325vx = mAVLinkPayload.getFloat();
        this.f8326vy = mAVLinkPayload.getFloat();
        this.f8327vz = mAVLinkPayload.getFloat();
        this.afx = mAVLinkPayload.getFloat();
        this.afy = mAVLinkPayload.getFloat();
        this.afz = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.yaw_rate = mAVLinkPayload.getFloat();
        this.type_mask = mAVLinkPayload.getUnsignedShort();
        this.coordinate_frame = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " lat_int:" + this.lat_int + " lon_int:" + this.lon_int + " alt:" + this.alt + " vx:" + this.f8325vx + " vy:" + this.f8326vy + " vz:" + this.f8327vz + " afx:" + this.afx + " afy:" + this.afy + " afz:" + this.afz + " yaw:" + this.yaw + " yaw_rate:" + this.yaw_rate + " type_mask:" + this.type_mask + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
