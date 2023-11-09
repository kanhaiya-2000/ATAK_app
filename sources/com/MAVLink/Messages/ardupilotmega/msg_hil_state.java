package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_STATE = 90;
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
    public short f8154vx;

    /* renamed from: vy */
    public short f8155vy;

    /* renamed from: vz */
    public short f8156vz;
    public short xacc;
    public short yacc;
    public float yaw;
    public float yawspeed;
    public short zacc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 56;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 90;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.rollspeed);
        mAVLinkPacket.payload.putFloat(this.pitchspeed);
        mAVLinkPacket.payload.putFloat(this.yawspeed);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putShort(this.f8154vx);
        mAVLinkPacket.payload.putShort(this.f8155vy);
        mAVLinkPacket.payload.putShort(this.f8156vz);
        mAVLinkPacket.payload.putShort(this.xacc);
        mAVLinkPacket.payload.putShort(this.yacc);
        mAVLinkPacket.payload.putShort(this.zacc);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.rollspeed = mAVLinkPayload.getFloat();
        this.pitchspeed = mAVLinkPayload.getFloat();
        this.yawspeed = mAVLinkPayload.getFloat();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.f8154vx = mAVLinkPayload.getShort();
        this.f8155vy = mAVLinkPayload.getShort();
        this.f8156vz = mAVLinkPayload.getShort();
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
        return "MAVLINK_MSG_ID_HIL_STATE - time_usec:" + this.time_usec + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " rollspeed:" + this.rollspeed + " pitchspeed:" + this.pitchspeed + " yawspeed:" + this.yawspeed + " latitude:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " vx:" + this.f8154vx + " vy:" + this.f8155vy + " vz:" + this.f8156vz + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + "";
    }
}
