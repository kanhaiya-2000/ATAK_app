package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV = 64;
    public static final int MAVLINK_MSG_LENGTH = 181;
    private static final long serialVersionUID = 64;
    public float[] covariance = new float[36];
    public byte estimator_type;
    public int time_boot_ms;
    public long time_utc;

    /* renamed from: vx */
    public float f8166vx;

    /* renamed from: vy */
    public float f8167vy;

    /* renamed from: vz */
    public float f8168vz;

    /* renamed from: x */
    public float f8169x;

    /* renamed from: y */
    public float f8170y;

    /* renamed from: z */
    public float f8171z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 181;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 64;
        mAVLinkPacket.payload.putLong(this.time_utc);
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8169x);
        mAVLinkPacket.payload.putFloat(this.f8170y);
        mAVLinkPacket.payload.putFloat(this.f8171z);
        mAVLinkPacket.payload.putFloat(this.f8166vx);
        mAVLinkPacket.payload.putFloat(this.f8167vy);
        mAVLinkPacket.payload.putFloat(this.f8168vz);
        for (float putFloat : this.covariance) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putByte(this.estimator_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_utc = mAVLinkPayload.getLong();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.f8169x = mAVLinkPayload.getFloat();
        this.f8170y = mAVLinkPayload.getFloat();
        this.f8171z = mAVLinkPayload.getFloat();
        this.f8166vx = mAVLinkPayload.getFloat();
        this.f8167vy = mAVLinkPayload.getFloat();
        this.f8168vz = mAVLinkPayload.getFloat();
        int i = 0;
        while (true) {
            float[] fArr = this.covariance;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.estimator_type = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV - time_utc:" + this.time_utc + " time_boot_ms:" + this.time_boot_ms + " x:" + this.f8169x + " y:" + this.f8170y + " z:" + this.f8171z + " vx:" + this.f8166vx + " vy:" + this.f8167vy + " vz:" + this.f8168vz + " covariance:" + this.covariance + " estimator_type:" + this.estimator_type + "";
    }
}
