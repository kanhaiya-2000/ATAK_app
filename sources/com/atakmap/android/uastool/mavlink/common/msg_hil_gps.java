package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_gps extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_GPS = 113;
    public static final int MAVLINK_MSG_ID_HIL_GPS_CRC = 124;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 113;
    public int alt;
    public int cog;
    public int eph;
    public int epv;
    public short fix_type;
    public int lat;
    public int lon;
    public short satellites_visible;
    public long time_usec;

    /* renamed from: vd */
    public short f8281vd;

    /* renamed from: ve */
    public short f8282ve;
    public int vel;

    /* renamed from: vn */
    public short f8283vn;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(36);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 113;
        mAVLinkPacket.crc_extra = 124;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putUnsignedShort(this.eph);
        mAVLinkPacket.payload.putUnsignedShort(this.epv);
        mAVLinkPacket.payload.putUnsignedShort(this.vel);
        mAVLinkPacket.payload.putShort(this.f8283vn);
        mAVLinkPacket.payload.putShort(this.f8282ve);
        mAVLinkPacket.payload.putShort(this.f8281vd);
        mAVLinkPacket.payload.putUnsignedShort(this.cog);
        mAVLinkPacket.payload.putUnsignedByte(this.fix_type);
        mAVLinkPacket.payload.putUnsignedByte(this.satellites_visible);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.eph = mAVLinkPayload.getUnsignedShort();
        this.epv = mAVLinkPayload.getUnsignedShort();
        this.vel = mAVLinkPayload.getUnsignedShort();
        this.f8283vn = mAVLinkPayload.getShort();
        this.f8282ve = mAVLinkPayload.getShort();
        this.f8281vd = mAVLinkPayload.getShort();
        this.cog = mAVLinkPayload.getUnsignedShort();
        this.fix_type = mAVLinkPayload.getUnsignedByte();
        this.satellites_visible = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_HIL_GPS - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " eph:" + this.eph + " epv:" + this.epv + " vel:" + this.vel + " vn:" + this.f8283vn + " ve:" + this.f8282ve + " vd:" + this.f8281vd + " cog:" + this.cog + " fix_type:" + this.fix_type + " satellites_visible:" + this.satellites_visible + "";
    }
}
