package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_local_position_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT = 50;
    public static final int MAVLINK_MSG_LENGTH = 19;
    private static final long serialVersionUID = 50;
    public byte coordinate_frame;
    public byte target_component;
    public byte target_system;

    /* renamed from: x */
    public float f8201x;

    /* renamed from: y */
    public float f8202y;
    public float yaw;

    /* renamed from: z */
    public float f8203z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 19;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 50;
        mAVLinkPacket.payload.putFloat(this.f8201x);
        mAVLinkPacket.payload.putFloat(this.f8202y);
        mAVLinkPacket.payload.putFloat(this.f8203z);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8201x = mAVLinkPayload.getFloat();
        this.f8202y = mAVLinkPayload.getFloat();
        this.f8203z = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_set_local_position_setpoint() {
        this.msgid = 50;
    }

    public msg_set_local_position_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 50;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT - x:" + this.f8201x + " y:" + this.f8202y + " z:" + this.f8203z + " yaw:" + this.yaw + " target_system:" + this.target_system + " target_component:" + this.target_component + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
