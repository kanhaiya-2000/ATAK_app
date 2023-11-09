package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_control_system_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CONTROL_SYSTEM_STATE = 146;
    public static final int MAVLINK_MSG_ID_CONTROL_SYSTEM_STATE_CRC = 103;
    public static final int MAVLINK_MSG_LENGTH = 100;
    private static final long serialVersionUID = 146;
    public float airspeed;
    public float pitch_rate;
    public float[] pos_variance = new float[3];

    /* renamed from: q */
    public float[] f8262q = new float[4];
    public float roll_rate;
    public long time_usec;
    public float[] vel_variance = new float[3];
    public float x_acc;
    public float x_pos;
    public float x_vel;
    public float y_acc;
    public float y_pos;
    public float y_vel;
    public float yaw_rate;
    public float z_acc;
    public float z_pos;
    public float z_vel;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(100);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 146;
        mAVLinkPacket.crc_extra = 103;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.x_acc);
        mAVLinkPacket.payload.putFloat(this.y_acc);
        mAVLinkPacket.payload.putFloat(this.z_acc);
        mAVLinkPacket.payload.putFloat(this.x_vel);
        mAVLinkPacket.payload.putFloat(this.y_vel);
        mAVLinkPacket.payload.putFloat(this.z_vel);
        mAVLinkPacket.payload.putFloat(this.x_pos);
        mAVLinkPacket.payload.putFloat(this.y_pos);
        mAVLinkPacket.payload.putFloat(this.z_pos);
        mAVLinkPacket.payload.putFloat(this.airspeed);
        for (float putFloat : this.vel_variance) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        for (float putFloat2 : this.pos_variance) {
            mAVLinkPacket.payload.putFloat(putFloat2);
        }
        for (float putFloat3 : this.f8262q) {
            mAVLinkPacket.payload.putFloat(putFloat3);
        }
        mAVLinkPacket.payload.putFloat(this.roll_rate);
        mAVLinkPacket.payload.putFloat(this.pitch_rate);
        mAVLinkPacket.payload.putFloat(this.yaw_rate);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.x_acc = mAVLinkPayload.getFloat();
        this.y_acc = mAVLinkPayload.getFloat();
        this.z_acc = mAVLinkPayload.getFloat();
        this.x_vel = mAVLinkPayload.getFloat();
        this.y_vel = mAVLinkPayload.getFloat();
        this.z_vel = mAVLinkPayload.getFloat();
        this.x_pos = mAVLinkPayload.getFloat();
        this.y_pos = mAVLinkPayload.getFloat();
        this.z_pos = mAVLinkPayload.getFloat();
        this.airspeed = mAVLinkPayload.getFloat();
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.vel_variance;
            if (i2 >= fArr.length) {
                break;
            }
            fArr[i2] = mAVLinkPayload.getFloat();
            i2++;
        }
        int i3 = 0;
        while (true) {
            float[] fArr2 = this.pos_variance;
            if (i3 >= fArr2.length) {
                break;
            }
            fArr2[i3] = mAVLinkPayload.getFloat();
            i3++;
        }
        while (true) {
            float[] fArr3 = this.f8262q;
            if (i < fArr3.length) {
                fArr3[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.roll_rate = mAVLinkPayload.getFloat();
                this.pitch_rate = mAVLinkPayload.getFloat();
                this.yaw_rate = mAVLinkPayload.getFloat();
                return;
            }
        }
    }

    public msg_control_system_state() {
        this.msgid = 146;
    }

    public msg_control_system_state(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 146;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CONTROL_SYSTEM_STATE - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " x_acc:" + this.x_acc + " y_acc:" + this.y_acc + " z_acc:" + this.z_acc + " x_vel:" + this.x_vel + " y_vel:" + this.y_vel + " z_vel:" + this.z_vel + " x_pos:" + this.x_pos + " y_pos:" + this.y_pos + " z_pos:" + this.z_pos + " airspeed:" + this.airspeed + " vel_variance:" + this.vel_variance + " pos_variance:" + this.pos_variance + " q:" + this.f8262q + " roll_rate:" + this.roll_rate + " pitch_rate:" + this.pitch_rate + " yaw_rate:" + this.yaw_rate + "";
    }
}
