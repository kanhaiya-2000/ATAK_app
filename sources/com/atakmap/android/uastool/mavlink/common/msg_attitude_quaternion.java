package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_attitude_quaternion extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION = 31;
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION_CRC = 246;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 31;
    public float pitchspeed;

    /* renamed from: q1 */
    public float f8251q1;

    /* renamed from: q2 */
    public float f8252q2;

    /* renamed from: q3 */
    public float f8253q3;

    /* renamed from: q4 */
    public float f8254q4;
    public float rollspeed;
    public long time_boot_ms;
    public float yawspeed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(32);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 31;
        mAVLinkPacket.crc_extra = 246;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8251q1);
        mAVLinkPacket.payload.putFloat(this.f8252q2);
        mAVLinkPacket.payload.putFloat(this.f8253q3);
        mAVLinkPacket.payload.putFloat(this.f8254q4);
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.f8251q1 = mAVLinkPayload.getFloat();
        this.f8252q2 = mAVLinkPayload.getFloat();
        this.f8253q3 = mAVLinkPayload.getFloat();
        this.f8254q4 = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " q1:" + this.f8251q1 + " q2:" + this.f8252q2 + " q3:" + this.f8253q3 + " q4:" + this.f8254q4 + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + "";
    }
}
