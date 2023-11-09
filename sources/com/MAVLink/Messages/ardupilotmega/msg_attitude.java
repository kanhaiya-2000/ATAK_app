package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_attitude extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE = 30;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 30;
    public float pitch;
    public float pitchspeed;
    public float roll;
    public float rollspeed;
    public int time_boot_ms;
    public float yaw;
    public float yawspeed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 30;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.rollspeed = mAVLinkPayload.getFloat();
        this.pitchspeed = mAVLinkPayload.getFloat();
        this.yawspeed = mAVLinkPayload.getFloat();
    }

    public msg_attitude() {
        this.msgid = 30;
    }

    public msg_attitude(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 30;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE -姿态数据 - time_boot_ms:" + this.time_boot_ms + " 滚转角:" + this.roll + " 府仰角:" + this.pitch + " 偏航角:" + this.yaw + " 滚转角速度:" + this.rollspeed + " 府仰角速度:" + this.pitchspeed + " 偏航角速度:" + this.yawspeed + "";
    }
}
