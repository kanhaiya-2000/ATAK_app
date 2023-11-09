package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV = 64;
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV_CRC = 191;
    public static final int MAVLINK_MSG_LENGTH = 225;
    private static final long serialVersionUID = 64;

    /* renamed from: ax */
    public float f8300ax;

    /* renamed from: ay */
    public float f8301ay;

    /* renamed from: az */
    public float f8302az;
    public float[] covariance = new float[45];
    public short estimator_type;
    public long time_usec;

    /* renamed from: vx */
    public float f8303vx;

    /* renamed from: vy */
    public float f8304vy;

    /* renamed from: vz */
    public float f8305vz;

    /* renamed from: x */
    public float f8306x;

    /* renamed from: y */
    public float f8307y;

    /* renamed from: z */
    public float f8308z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 64;
        mAVLinkPacket.crc_extra = 191;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.f8306x);
        mAVLinkPacket.payload.putFloat(this.f8307y);
        mAVLinkPacket.payload.putFloat(this.f8308z);
        mAVLinkPacket.payload.putFloat(this.f8303vx);
        mAVLinkPacket.payload.putFloat(this.f8304vy);
        mAVLinkPacket.payload.putFloat(this.f8305vz);
        mAVLinkPacket.payload.putFloat(this.f8300ax);
        mAVLinkPacket.payload.putFloat(this.f8301ay);
        mAVLinkPacket.payload.putFloat(this.f8302az);
        for (float putFloat : this.covariance) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.estimator_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.f8306x = mAVLinkPayload.getFloat();
        this.f8307y = mAVLinkPayload.getFloat();
        this.f8308z = mAVLinkPayload.getFloat();
        this.f8303vx = mAVLinkPayload.getFloat();
        this.f8304vy = mAVLinkPayload.getFloat();
        this.f8305vz = mAVLinkPayload.getFloat();
        this.f8300ax = mAVLinkPayload.getFloat();
        this.f8301ay = mAVLinkPayload.getFloat();
        this.f8302az = mAVLinkPayload.getFloat();
        int i = 0;
        while (true) {
            float[] fArr = this.covariance;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.estimator_type = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_local_position_ned_cov() {
        this.msgid = 64;
    }

    public msg_local_position_ned_cov(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 64;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " x:" + this.f8306x + " y:" + this.f8307y + " z:" + this.f8308z + " vx:" + this.f8303vx + " vy:" + this.f8304vy + " vz:" + this.f8305vz + " ax:" + this.f8300ax + " ay:" + this.f8301ay + " az:" + this.f8302az + " covariance:" + this.covariance + " estimator_type:" + this.estimator_type + "";
    }
}
