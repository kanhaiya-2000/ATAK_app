package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_roll_pitch_yaw_rates_thrust_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT = 80;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 80;
    public float pitch_rate;
    public float roll_rate;
    public float thrust;
    public int time_boot_ms;
    public float yaw_rate;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 80;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll_rate);
        mAVLinkPacket.payload.putFloat(this.pitch_rate);
        mAVLinkPacket.payload.putFloat(this.yaw_rate);
        mAVLinkPacket.payload.putFloat(this.thrust);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.roll_rate = mAVLinkPayload.getFloat();
        this.pitch_rate = mAVLinkPayload.getFloat();
        this.yaw_rate = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
    }

    public msg_roll_pitch_yaw_rates_thrust_setpoint() {
        this.msgid = 80;
    }

    public msg_roll_pitch_yaw_rates_thrust_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 80;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT - time_boot_ms:" + this.time_boot_ms + " roll_rate:" + this.roll_rate + " pitch_rate:" + this.pitch_rate + " yaw_rate:" + this.yaw_rate + " thrust:" + this.thrust + "";
    }
}
