package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_attitude_quaternion_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV = 61;
    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV_CRC = 167;
    public static final int MAVLINK_MSG_LENGTH = 72;
    private static final long serialVersionUID = 61;
    public float[] covariance = new float[9];
    public float pitchspeed;

    /* renamed from: q */
    public float[] f8255q = new float[4];
    public float rollspeed;
    public long time_usec;
    public float yawspeed;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(72);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 61;
        mAVLinkPacket.crc_extra = 167;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        for (float putFloat : this.f8255q) {
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
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.f8255q;
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
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " q:" + this.f8255q + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + " covariance:" + this.covariance + "";
    }
}
