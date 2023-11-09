package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_STATE = 90;
    public static final int MAVLINK_MSG_ID_HIL_STATE_CRC = 183;
    public static final int MAVLINK_MSG_LENGTH = 56;
    private static final long serialVersionUID = 90;
    public int alt;
    public int lat;
    public int lon;
    public float pitch;
    public float pitchspeed;
    public float roll;
    public float rollspeed;
    public long time_usec;

    /* renamed from: vx */
    public short f8284vx;

    /* renamed from: vy */
    public short f8285vy;

    /* renamed from: vz */
    public short f8286vz;
    public short xacc;
    public short yacc;
    public float yaw;
    public float yawspeed;
    public short zacc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(56);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 90;
        mAVLinkPacket.crc_extra = 183;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putShort(this.f8284vx);
        mAVLinkPacket.payload.putShort(this.f8285vy);
        mAVLinkPacket.payload.putShort(this.f8286vz);
        mAVLinkPacket.payload.putShort(this.xacc);
        mAVLinkPacket.payload.putShort(this.yacc);
        mAVLinkPacket.payload.putShort(this.zacc);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.rollspeed = mAVLinkPayload.getFloat();
        this.pitchspeed = mAVLinkPayload.getFloat();
        this.yawspeed = mAVLinkPayload.getFloat();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.f8284vx = mAVLinkPayload.getShort();
        this.f8285vy = mAVLinkPayload.getShort();
        this.f8286vz = mAVLinkPayload.getShort();
        this.xacc = mAVLinkPayload.getShort();
        this.yacc = mAVLinkPayload.getShort();
        this.zacc = mAVLinkPayload.getShort();
    }

    public msg_hil_state() {
        this.msgid = 90;
    }

    public msg_hil_state(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 90;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_STATE - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " vx:" + this.f8284vx + " vy:" + this.f8285vy + " vz:" + this.f8286vz + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + "";
    }
}
