package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_vision_speed_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE = 103;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 103;
    public long usec;

    /* renamed from: x */
    public float f8226x;

    /* renamed from: y */
    public float f8227y;

    /* renamed from: z */
    public float f8228z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 103;
        mAVLinkPacket.payload.putLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8226x);
        mAVLinkPacket.payload.putFloat(this.f8227y);
        mAVLinkPacket.payload.putFloat(this.f8228z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getLong();
        this.f8226x = mAVLinkPayload.getFloat();
        this.f8227y = mAVLinkPayload.getFloat();
        this.f8228z = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE - usec:" + this.usec + " x:" + this.f8226x + " y:" + this.f8227y + " z:" + this.f8228z + "";
    }
}
