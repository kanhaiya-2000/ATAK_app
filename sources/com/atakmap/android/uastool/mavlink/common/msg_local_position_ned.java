package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED = 32;
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_CRC = 185;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 32;
    public long time_boot_ms;

    /* renamed from: vx */
    public float f8294vx;

    /* renamed from: vy */
    public float f8295vy;

    /* renamed from: vz */
    public float f8296vz;

    /* renamed from: x */
    public float f8297x;

    /* renamed from: y */
    public float f8298y;

    /* renamed from: z */
    public float f8299z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(28);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 32;
        mAVLinkPacket.crc_extra = 185;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8297x);
        mAVLinkPacket.payload.putFloat(this.f8298y);
        mAVLinkPacket.payload.putFloat(this.f8299z);
        mAVLinkPacket.payload.putFloat(this.f8294vx);
        mAVLinkPacket.payload.putFloat(this.f8295vy);
        mAVLinkPacket.payload.putFloat(this.f8296vz);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.f8297x = mAVLinkPayload.getFloat();
        this.f8298y = mAVLinkPayload.getFloat();
        this.f8299z = mAVLinkPayload.getFloat();
        this.f8294vx = mAVLinkPayload.getFloat();
        this.f8295vy = mAVLinkPayload.getFloat();
        this.f8296vz = mAVLinkPayload.getFloat();
    }

    public msg_local_position_ned() {
        this.msgid = 32;
    }

    public msg_local_position_ned(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 32;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " x:" + this.f8297x + " y:" + this.f8298y + " z:" + this.f8299z + " vx:" + this.f8294vx + " vy:" + this.f8295vy + " vz:" + this.f8296vz + "";
    }
}
