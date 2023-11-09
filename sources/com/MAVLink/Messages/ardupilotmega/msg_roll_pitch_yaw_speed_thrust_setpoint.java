package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_roll_pitch_yaw_speed_thrust_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT = 59;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 59;
    public float pitch_speed;
    public float roll_speed;
    public float thrust;
    public int time_boot_ms;
    public float yaw_speed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 59;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll_speed);
        mAVLinkPacket.payload.putFloat(this.pitch_speed);
        mAVLinkPacket.payload.putFloat(this.yaw_speed);
        mAVLinkPacket.payload.putFloat(this.thrust);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.roll_speed = mAVLinkPayload.getFloat();
        this.pitch_speed = mAVLinkPayload.getFloat();
        this.yaw_speed = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
    }

    public msg_roll_pitch_yaw_speed_thrust_setpoint() {
        this.msgid = 59;
    }

    public msg_roll_pitch_yaw_speed_thrust_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 59;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT - time_boot_ms:" + this.time_boot_ms + " roll_speed:" + this.roll_speed + " pitch_speed:" + this.pitch_speed + " yaw_speed:" + this.yaw_speed + " thrust:" + this.thrust + "";
    }
}
