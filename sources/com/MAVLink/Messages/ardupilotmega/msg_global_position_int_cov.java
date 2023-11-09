package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_global_position_int_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV = 63;
    public static final int MAVLINK_MSG_LENGTH = 185;
    private static final long serialVersionUID = 63;
    public int alt;
    public float[] covariance = new float[36];
    public byte estimator_type;
    public int lat;
    public int lon;
    public int relative_alt;
    public int time_boot_ms;
    public long time_utc;

    /* renamed from: vx */
    public float f8143vx;

    /* renamed from: vy */
    public float f8144vy;

    /* renamed from: vz */
    public float f8145vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 185;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 63;
        mAVLinkPacket.payload.putLong(this.time_utc);
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putInt(this.relative_alt);
        mAVLinkPacket.payload.putFloat(this.f8143vx);
        mAVLinkPacket.payload.putFloat(this.f8144vy);
        mAVLinkPacket.payload.putFloat(this.f8145vz);
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
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.relative_alt = mAVLinkPayload.getInt();
        this.f8143vx = mAVLinkPayload.getFloat();
        this.f8144vy = mAVLinkPayload.getFloat();
        this.f8145vz = mAVLinkPayload.getFloat();
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

    public msg_global_position_int_cov() {
        this.msgid = 63;
    }

    public msg_global_position_int_cov(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 63;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV - time_utc:" + this.time_utc + " time_boot_ms:" + this.time_boot_ms + " latitude:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " relative_alt:" + this.relative_alt + " vx:" + this.f8143vx + " vy:" + this.f8144vy + " vz:" + this.f8145vz + " covariance:" + this.covariance + " estimator_type:" + this.estimator_type + "";
    }
}
