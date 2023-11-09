package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_roll_pitch_yaw_thrust_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_THRUST_SETPOINT = 58;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 58;
    public float pitch;
    public float roll;
    public float thrust;
    public int time_boot_ms;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 58;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.thrust);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
    }

    public msg_roll_pitch_yaw_thrust_setpoint() {
        this.msgid = 58;
    }

    public msg_roll_pitch_yaw_thrust_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 58;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ROLL_PITCH_YAW_THRUST_SETPOINT - time_boot_ms:" + this.time_boot_ms + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + "";
    }
}
