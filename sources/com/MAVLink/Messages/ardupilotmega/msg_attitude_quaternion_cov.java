package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_attitude_quaternion_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV = 61;
    public static final int MAVLINK_MSG_LENGTH = 68;
    private static final long serialVersionUID = 61;
    public float[] covariance = new float[9];
    public float pitchspeed;

    /* renamed from: q */
    public float[] f8124q = new float[4];
    public float rollspeed;
    public int time_boot_ms;
    public float yawspeed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 68;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 61;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        for (float putFloat : this.f8124q) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        for (float putFloat2 : this.covariance) {
            mAVLinkPacket.payload.putFloat(putFloat2);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.f8124q;
            if (i2 >= fArr.length) {
                break;
            }
            fArr[i2] = mAVLinkPayload.getFloat();
            i2++;
        }
        this.rollspeed = mAVLinkPayload.getFloat();
        this.pitchspeed = mAVLinkPayload.getFloat();
        this.yawspeed = mAVLinkPayload.getFloat();
        while (true) {
            float[] fArr2 = this.covariance;
            if (i < fArr2.length) {
                fArr2[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_attitude_quaternion_cov() {
        this.msgid = 61;
    }

    public msg_attitude_quaternion_cov(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 61;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV - time_boot_ms:" + this.time_boot_ms + " q:" + this.f8124q + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + " covariance:" + this.covariance + "";
    }
}
