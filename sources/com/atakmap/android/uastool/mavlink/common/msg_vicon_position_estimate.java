package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_vicon_position_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE = 104;
    public static final int MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE_CRC = 56;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 104;
    public float pitch;
    public float roll;
    public long usec;

    /* renamed from: x */
    public float f8355x;

    /* renamed from: y */
    public float f8356y;
    public float yaw;

    /* renamed from: z */
    public float f8357z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(32);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 104;
        mAVLinkPacket.crc_extra = 56;
        mAVLinkPacket.payload.putUnsignedLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8355x);
        mAVLinkPacket.payload.putFloat(this.f8356y);
        mAVLinkPacket.payload.putFloat(this.f8357z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getUnsignedLong();
        this.f8355x = mAVLinkPayload.getFloat();
        this.f8356y = mAVLinkPayload.getFloat();
        this.f8357z = mAVLinkPayload.getFloat();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
    }

    public msg_vicon_position_estimate() {
        this.msgid = 104;
    }

    public msg_vicon_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 104;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE - sysid:" + this.sysid + " compid:" + this.compid + " usec:" + this.usec + " x:" + this.f8355x + " y:" + this.f8356y + " z:" + this.f8357z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
