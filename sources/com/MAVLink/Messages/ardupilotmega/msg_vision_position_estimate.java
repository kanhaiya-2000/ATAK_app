package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_vision_position_estimate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VISION_POSITION_ESTIMATE = 102;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 102;
    public float pitch;
    public float roll;
    public long usec;

    /* renamed from: x */
    public float f8223x;

    /* renamed from: y */
    public float f8224y;
    public float yaw;

    /* renamed from: z */
    public float f8225z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 32;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 102;
        mAVLinkPacket.payload.putLong(this.usec);
        mAVLinkPacket.payload.putFloat(this.f8223x);
        mAVLinkPacket.payload.putFloat(this.f8224y);
        mAVLinkPacket.payload.putFloat(this.f8225z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.usec = mAVLinkPayload.getLong();
        this.f8223x = mAVLinkPayload.getFloat();
        this.f8224y = mAVLinkPayload.getFloat();
        this.f8225z = mAVLinkPayload.getFloat();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
    }

    public msg_vision_position_estimate() {
        this.msgid = 102;
    }

    public msg_vision_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 102;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VISION_POSITION_ESTIMATE - usec:" + this.usec + " x:" + this.f8223x + " y:" + this.f8224y + " z:" + this.f8225z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
