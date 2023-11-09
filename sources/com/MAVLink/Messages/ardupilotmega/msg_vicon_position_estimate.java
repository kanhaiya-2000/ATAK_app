package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_vicon_position_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE = 104;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 104;
    public float pitch;
    public float roll;
    public long usec;

    /* renamed from: x */
    public float f8220x;

    /* renamed from: y */
    public float f8221y;
    public float yaw;

    /* renamed from: z */
    public float f8222z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 32;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 104;
        mAVLinkPacket.payload.putLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8220x);
        mAVLinkPacket.payload.putFloat(this.f8221y);
        mAVLinkPacket.payload.putFloat(this.f8222z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getLong();
        this.f8220x = mAVLinkPayload.getFloat();
        this.f8221y = mAVLinkPayload.getFloat();
        this.f8222z = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE - usec:" + this.usec + " x:" + this.f8220x + " y:" + this.f8221y + " z:" + this.f8222z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
