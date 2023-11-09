package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_global_vision_position_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE = 101;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 101;
    public float pitch;
    public float roll;
    public long usec;

    /* renamed from: x */
    public float f8146x;

    /* renamed from: y */
    public float f8147y;
    public float yaw;

    /* renamed from: z */
    public float f8148z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 32;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 101;
        mAVLinkPacket.payload.putLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8146x);
        mAVLinkPacket.payload.putFloat(this.f8147y);
        mAVLinkPacket.payload.putFloat(this.f8148z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getLong();
        this.f8146x = mAVLinkPayload.getFloat();
        this.f8147y = mAVLinkPayload.getFloat();
        this.f8148z = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE - usec:" + this.usec + " x:" + this.f8146x + " y:" + this.f8147y + " z:" + this.f8148z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
