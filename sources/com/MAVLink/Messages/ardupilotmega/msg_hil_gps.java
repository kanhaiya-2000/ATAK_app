package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_gps extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_GPS = 113;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 113;
    public int alt;
    public short cog;
    public short eph;
    public short epv;
    public byte fix_type;
    public int lat;
    public int lon;
    public byte satellites_visible;
    public long time_usec;

    /* renamed from: vd */
    public short f8151vd;

    /* renamed from: ve */
    public short f8152ve;
    public short vel;

    /* renamed from: vn */
    public short f8153vn;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 36;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 113;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putShort(this.eph);
        mAVLinkPacket.payload.putShort(this.epv);
        mAVLinkPacket.payload.putShort(this.vel);
        mAVLinkPacket.payload.putShort(this.f8153vn);
        mAVLinkPacket.payload.putShort(this.f8152ve);
        mAVLinkPacket.payload.putShort(this.f8151vd);
        mAVLinkPacket.payload.putShort(this.cog);
        mAVLinkPacket.payload.putByte(this.fix_type);
        mAVLinkPacket.payload.putByte(this.satellites_visible);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.eph = mAVLinkPayload.getShort();
        this.epv = mAVLinkPayload.getShort();
        this.vel = mAVLinkPayload.getShort();
        this.f8153vn = mAVLinkPayload.getShort();
        this.f8152ve = mAVLinkPayload.getShort();
        this.f8151vd = mAVLinkPayload.getShort();
        this.cog = mAVLinkPayload.getShort();
        this.fix_type = mAVLinkPayload.getByte();
        this.satellites_visible = mAVLinkPayload.getByte();
    }

    public msg_hil_gps() {
        this.msgid = 113;
    }

    public msg_hil_gps(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 113;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_GPS - time_usec:" + this.time_usec + " latitude:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " eph:" + this.eph + " epv:" + this.epv + " vel:" + this.vel + " vn:" + this.f8153vn + " ve:" + this.f8152ve + " vd:" + this.f8151vd + " cog:" + this.cog + " fix_type:" + this.fix_type + " satellites_visible:" + this.satellites_visible + "";
    }
}
