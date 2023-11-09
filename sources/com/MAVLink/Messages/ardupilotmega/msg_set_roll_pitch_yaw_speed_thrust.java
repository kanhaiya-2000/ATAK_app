package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_roll_pitch_yaw_speed_thrust extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST = 57;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 57;
    public float pitch_speed;
    public float roll_speed;
    public byte target_component;
    public byte target_system;
    public float thrust;
    public float yaw_speed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 57;
        mAVLinkPacket.payload.putFloat(this.roll_speed);
        mAVLinkPacket.payload.putFloat(this.pitch_speed);
        mAVLinkPacket.payload.putFloat(this.yaw_speed);
        mAVLinkPacket.payload.putFloat(this.thrust);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.roll_speed = mAVLinkPayload.getFloat();
        this.pitch_speed = mAVLinkPayload.getFloat();
        this.yaw_speed = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_set_roll_pitch_yaw_speed_thrust() {
        this.msgid = 57;
    }

    public msg_set_roll_pitch_yaw_speed_thrust(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 57;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST - roll_speed:" + this.roll_speed + " pitch_speed:" + this.pitch_speed + " yaw_speed:" + this.yaw_speed + " thrust:" + this.thrust + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
