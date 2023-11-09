package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_state_quaternion extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_STATE_QUATERNION = 115;
    public static final int MAVLINK_MSG_ID_HIL_STATE_QUATERNION_CRC = 4;
    public static final int MAVLINK_MSG_LENGTH = 64;
    private static final long serialVersionUID = 115;
    public int alt;
    public float[] attitude_quaternion = new float[4];
    public int ind_airspeed;
    public int lat;
    public int lon;
    public float pitchspeed;
    public float rollspeed;
    public long time_usec;
    public int true_airspeed;

    /* renamed from: vx */
    public short f8287vx;

    /* renamed from: vy */
    public short f8288vy;

    /* renamed from: vz */
    public short f8289vz;
    public short xacc;
    public short yacc;
    public float yawspeed;
    public short zacc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(64);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 115;
        mAVLinkPacket.crc_extra = 4;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        for (float putFloat : this.attitude_quaternion) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putShort(this.f8287vx);
        mAVLinkPacket.payload.putShort(this.f8288vy);
        mAVLinkPacket.payload.putShort(this.f8289vz);
        mAVLinkPacket.payload.putUnsignedShort(this.ind_airspeed);
        mAVLinkPacket.payload.putUnsignedShort(this.true_airspeed);
        mAVLinkPacket.payload.putShort(this.xacc);
        mAVLinkPacket.payload.putShort(this.yacc);
        mAVLinkPacket.payload.putShort(this.zacc);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        int i = 0;
        while (true) {
            float[] fArr = this.attitude_quaternion;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.rollspeed = mAVLinkPayload.getFloat();
                this.pitchspeed = mAVLinkPayload.getFloat();
                this.yawspeed = mAVLinkPayload.getFloat();
                this.lat = mAVLinkPayload.getInt();
                this.lon = mAVLinkPayload.getInt();
                this.alt = mAVLinkPayload.getInt();
                this.f8287vx = mAVLinkPayload.getShort();
                this.f8288vy = mAVLinkPayload.getShort();
                this.f8289vz = mAVLinkPayload.getShort();
                this.ind_airspeed = mAVLinkPayload.getUnsignedShort();
                this.true_airspeed = mAVLinkPayload.getUnsignedShort();
                this.xacc = mAVLinkPayload.getShort();
                this.yacc = mAVLinkPayload.getShort();
                this.zacc = mAVLinkPayload.getShort();
                return;
            }
        }
    }

    public msg_hil_state_quaternion() {
        this.msgid = 115;
    }

    public msg_hil_state_quaternion(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 115;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_STATE_QUATERNION - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " attitude_quaternion:" + this.attitude_quaternion + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " vx:" + this.f8287vx + " vy:" + this.f8288vy + " vz:" + this.f8289vz + " ind_airspeed:" + this.ind_airspeed + " true_airspeed:" + this.true_airspeed + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + "";
    }
}
