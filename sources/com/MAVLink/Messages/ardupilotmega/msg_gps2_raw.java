package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_gps2_raw extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS2_RAW = 124;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = 124;
    public int alt;
    public short cog;
    public int dgps_age;
    public byte dgps_numch;
    public short eph;
    public short epv;
    public byte fix_type;
    public int lat;
    public int lon;
    public byte satellites_visible;
    public long time_usec;
    public short vel;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 35;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 124;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putInt(this.dgps_age);
        mAVLinkPacket.payload.putShort(this.eph);
        mAVLinkPacket.payload.putShort(this.epv);
        mAVLinkPacket.payload.putShort(this.vel);
        mAVLinkPacket.payload.putShort(this.cog);
        mAVLinkPacket.payload.putByte(this.fix_type);
        mAVLinkPacket.payload.putByte(this.satellites_visible);
        mAVLinkPacket.payload.putByte(this.dgps_numch);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.dgps_age = mAVLinkPayload.getInt();
        this.eph = mAVLinkPayload.getShort();
        this.epv = mAVLinkPayload.getShort();
        this.vel = mAVLinkPayload.getShort();
        this.cog = mAVLinkPayload.getShort();
        this.fix_type = mAVLinkPayload.getByte();
        this.satellites_visible = mAVLinkPayload.getByte();
        this.dgps_numch = mAVLinkPayload.getByte();
    }

    public msg_gps2_raw() {
        this.msgid = 124;
    }

    public msg_gps2_raw(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 124;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS2_RAW - time_usec:" + this.time_usec + " latitude:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " dgps_age:" + this.dgps_age + " eph:" + this.eph + " epv:" + this.epv + " vel:" + this.vel + " cog:" + this.cog + " fix_type:" + this.fix_type + " satellites_visible:" + this.satellites_visible + " dgps_numch:" + this.dgps_numch + "";
    }
}
