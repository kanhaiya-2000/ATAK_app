package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT = 51;
    public static final int MAVLINK_MSG_LENGTH = 17;
    private static final long serialVersionUID = 51;
    public byte coordinate_frame;

    /* renamed from: x */
    public float f8175x;

    /* renamed from: y */
    public float f8176y;
    public float yaw;

    /* renamed from: z */
    public float f8177z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 17;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 51;
        mAVLinkPacket.payload.putFloat(this.f8175x);
        mAVLinkPacket.payload.putFloat(this.f8176y);
        mAVLinkPacket.payload.putFloat(this.f8177z);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8175x = mAVLinkPayload.getFloat();
        this.f8176y = mAVLinkPayload.getFloat();
        this.f8177z = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_local_position_setpoint() {
        this.msgid = 51;
    }

    public msg_local_position_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 51;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT - x:" + this.f8175x + " y:" + this.f8176y + " z:" + this.f8177z + " yaw:" + this.yaw + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
