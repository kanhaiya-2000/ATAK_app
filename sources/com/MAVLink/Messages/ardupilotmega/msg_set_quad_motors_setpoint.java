package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_quad_motors_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_QUAD_MOTORS_SETPOINT = 60;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 60;
    public short motor_back_se;
    public short motor_front_nw;
    public short motor_left_sw;
    public short motor_right_ne;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 9;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 60;
        mAVLinkPacket.payload.putShort(this.motor_front_nw);
        mAVLinkPacket.payload.putShort(this.motor_right_ne);
        mAVLinkPacket.payload.putShort(this.motor_back_se);
        mAVLinkPacket.payload.putShort(this.motor_left_sw);
        mAVLinkPacket.payload.putByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.motor_front_nw = mAVLinkPayload.getShort();
        this.motor_right_ne = mAVLinkPayload.getShort();
        this.motor_back_se = mAVLinkPayload.getShort();
        this.motor_left_sw = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
    }

    public msg_set_quad_motors_setpoint() {
        this.msgid = 60;
    }

    public msg_set_quad_motors_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 60;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_QUAD_MOTORS_SETPOINT - motor_front_nw:" + this.motor_front_nw + " motor_right_ne:" + this.motor_right_ne + " motor_back_se:" + this.motor_back_se + " motor_left_sw:" + this.motor_left_sw + " target_system:" + this.target_system + "";
    }
}
