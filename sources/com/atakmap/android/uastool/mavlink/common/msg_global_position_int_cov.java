package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_global_position_int_cov extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV = 63;
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV_CRC = 119;
    public static final int MAVLINK_MSG_LENGTH = 181;
    private static final long serialVersionUID = 63;
    public int alt;
    public float[] covariance = new float[36];
    public short estimator_type;
    public int lat;
    public int lon;
    public int relative_alt;
    public long time_usec;

    /* renamed from: vx */
    public float f8270vx;

    /* renamed from: vy */
    public float f8271vy;

    /* renamed from: vz */
    public float f8272vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(181);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 63;
        mAVLinkPacket.crc_extra = 119;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putInt(this.relative_alt);
        mAVLinkPacket.payload.putFloat(this.f8270vx);
        mAVLinkPacket.payload.putFloat(this.f8271vy);
        mAVLinkPacket.payload.putFloat(this.f8272vz);
        for (float putFloat : this.covariance) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.estimator_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.relative_alt = mAVLinkPayload.getInt();
        this.f8270vx = mAVLinkPayload.getFloat();
        this.f8271vy = mAVLinkPayload.getFloat();
        this.f8272vz = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " relative_alt:" + this.relative_alt + " vx:" + this.f8270vx + " vy:" + this.f8271vy + " vz:" + this.f8272vz + " covariance:" + this.covariance + " estimator_type:" + this.estimator_type + "";
    }
}
