package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_vision_speed_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE = 103;
    public static final int MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE_CRC = 208;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 103;
    public long usec;

    /* renamed from: x */
    public float f8361x;

    /* renamed from: y */
    public float f8362y;

    /* renamed from: z */
    public float f8363z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(20);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 103;
        mAVLinkPacket.crc_extra = 208;
        mAVLinkPacket.payload.putUnsignedLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8361x);
        mAVLinkPacket.payload.putFloat(this.f8362y);
        mAVLinkPacket.payload.putFloat(this.f8363z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getUnsignedLong();
        this.f8361x = mAVLinkPayload.getFloat();
        this.f8362y = mAVLinkPayload.getFloat();
        this.f8363z = mAVLinkPayload.getFloat();
    }

    public msg_vision_speed_estimate() {
        this.msgid = 103;
    }

    public msg_vision_speed_estimate(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 103;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE - sysid:" + this.sysid + " compid:" + this.compid + " usec:" + this.usec + " x:" + this.f8361x + " y:" + this.f8362y + " z:" + this.f8363z + "";
    }
}
