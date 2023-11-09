package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_roll_pitch_yaw_thrust extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST = 56;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 56;
    public float pitch;
    public float roll;
    public byte target_component;
    public byte target_system;
    public float thrust;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 56;
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.thrust);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_set_roll_pitch_yaw_thrust() {
        this.msgid = 56;
    }

    public msg_set_roll_pitch_yaw_thrust(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 56;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST - roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
