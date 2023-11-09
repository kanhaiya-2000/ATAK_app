package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_manual_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT = 81;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 81;
    public byte manual_override_switch;
    public byte mode_switch;
    public float pitch;
    public float roll;
    public float thrust;
    public int time_boot_ms;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 22;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 81;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.thrust);
        mAVLinkPacket.payload.putByte(this.mode_switch);
        mAVLinkPacket.payload.putByte(this.manual_override_switch);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
        this.mode_switch = mAVLinkPayload.getByte();
        this.manual_override_switch = mAVLinkPayload.getByte();
    }

    public msg_manual_setpoint() {
        this.msgid = 81;
    }

    public msg_manual_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 81;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MANUAL_SETPOINT - time_boot_ms:" + this.time_boot_ms + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + " mode_switch:" + this.mode_switch + " manual_override_switch:" + this.manual_override_switch + "";
    }
}
