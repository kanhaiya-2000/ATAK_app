package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_attitude_quaternion extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION = 31;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 31;
    public float pitchspeed;

    /* renamed from: q1 */
    public float f8120q1;

    /* renamed from: q2 */
    public float f8121q2;

    /* renamed from: q3 */
    public float f8122q3;

    /* renamed from: q4 */
    public float f8123q4;
    public float rollspeed;
    public int time_boot_ms;
    public float yawspeed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 32;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 31;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8120q1);
        mAVLinkPacket.payload.putFloat(this.f8121q2);
        mAVLinkPacket.payload.putFloat(this.f8122q3);
        mAVLinkPacket.payload.putFloat(this.f8123q4);
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.f8120q1 = mAVLinkPayload.getFloat();
        this.f8121q2 = mAVLinkPayload.getFloat();
        this.f8122q3 = mAVLinkPayload.getFloat();
        this.f8123q4 = mAVLinkPayload.getFloat();
        this.rollspeed = mAVLinkPayload.getFloat();
        this.pitchspeed = mAVLinkPayload.getFloat();
        this.yawspeed = mAVLinkPayload.getFloat();
    }

    public msg_attitude_quaternion() {
        this.msgid = 31;
    }

    public msg_attitude_quaternion(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 31;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION - time_boot_ms:" + this.time_boot_ms + " q1:" + this.f8120q1 + " q2:" + this.f8121q2 + " q3:" + this.f8122q3 + " q4:" + this.f8123q4 + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + "";
    }
}
