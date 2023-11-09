package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_follow_target extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FOLLOW_TARGET = 144;
    public static final int MAVLINK_MSG_ID_FOLLOW_TARGET_CRC = 127;
    public static final int MAVLINK_MSG_LENGTH = 93;
    private static final long serialVersionUID = 144;
    public float[] acc = new float[3];
    public float alt;
    public float[] attitude_q = new float[4];
    public long custom_state;
    public short est_capabilities;
    public int lat;
    public int lon;
    public float[] position_cov = new float[3];
    public float[] rates = new float[3];
    public long timestamp;
    public float[] vel = new float[3];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(93);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 144;
        mAVLinkPacket.crc_extra = 127;
        mAVLinkPacket.payload.putUnsignedLong(this.timestamp);
        mAVLinkPacket.payload.putUnsignedLong(this.custom_state);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putFloat(this.alt);
        for (float putFloat : this.vel) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        for (float putFloat2 : this.acc) {
            mAVLinkPacket.payload.putFloat(putFloat2);
        }
        for (float putFloat3 : this.attitude_q) {
            mAVLinkPacket.payload.putFloat(putFloat3);
        }
        for (float putFloat4 : this.rates) {
            mAVLinkPacket.payload.putFloat(putFloat4);
        }
        for (float putFloat5 : this.position_cov) {
            mAVLinkPacket.payload.putFloat(putFloat5);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.est_capabilities);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.timestamp = mAVLinkPayload.getUnsignedLong();
        this.custom_state = mAVLinkPayload.getUnsignedLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getFloat();
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.vel;
            if (i2 >= fArr.length) {
                break;
            }
            fArr[i2] = mAVLinkPayload.getFloat();
            i2++;
        }
        int i3 = 0;
        while (true) {
            float[] fArr2 = this.acc;
            if (i3 >= fArr2.length) {
                break;
            }
            fArr2[i3] = mAVLinkPayload.getFloat();
            i3++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr3 = this.attitude_q;
            if (i4 >= fArr3.length) {
                break;
            }
            fArr3[i4] = mAVLinkPayload.getFloat();
            i4++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr4 = this.rates;
            if (i5 >= fArr4.length) {
                break;
            }
            fArr4[i5] = mAVLinkPayload.getFloat();
            i5++;
        }
        while (true) {
            float[] fArr5 = this.position_cov;
            if (i < fArr5.length) {
                fArr5[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.est_capabilities = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_follow_target() {
        this.msgid = 144;
    }

    public msg_follow_target(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 144;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FOLLOW_TARGET - sysid:" + this.sysid + " compid:" + this.compid + " timestamp:" + this.timestamp + " custom_state:" + this.custom_state + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " vel:" + this.vel + " acc:" + this.acc + " attitude_q:" + this.attitude_q + " rates:" + this.rates + " position_cov:" + this.position_cov + " est_capabilities:" + this.est_capabilities + "";
    }
}
