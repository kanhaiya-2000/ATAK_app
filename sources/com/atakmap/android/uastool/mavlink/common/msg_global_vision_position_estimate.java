package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_global_vision_position_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE = 101;
    public static final int MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE_CRC = 102;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 101;
    public float pitch;
    public float roll;
    public long usec;

    /* renamed from: x */
    public float f8273x;

    /* renamed from: y */
    public float f8274y;
    public float yaw;

    /* renamed from: z */
    public float f8275z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(32);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 101;
        mAVLinkPacket.crc_extra = 102;
        mAVLinkPacket.payload.putUnsignedLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8273x);
        mAVLinkPacket.payload.putFloat(this.f8274y);
        mAVLinkPacket.payload.putFloat(this.f8275z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getUnsignedLong();
        this.f8273x = mAVLinkPayload.getFloat();
        this.f8274y = mAVLinkPayload.getFloat();
        this.f8275z = mAVLinkPayload.getFloat();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
    }

    public msg_global_vision_position_estimate() {
        this.msgid = 101;
    }

    public msg_global_vision_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 101;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE - sysid:" + this.sysid + " compid:" + this.compid + " usec:" + this.usec + " x:" + this.f8273x + " y:" + this.f8274y + " z:" + this.f8275z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
