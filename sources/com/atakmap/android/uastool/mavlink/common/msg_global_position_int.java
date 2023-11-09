package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_global_position_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT = 33;
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT_CRC = 104;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 33;
    public int alt;
    public int hdg;
    public int lat;
    public int lon;
    public int relative_alt;
    public long time_boot_ms;

    /* renamed from: vx */
    public short f8267vx;

    /* renamed from: vy */
    public short f8268vy;

    /* renamed from: vz */
    public short f8269vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(28);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 33;
        mAVLinkPacket.crc_extra = 104;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putInt(this.relative_alt);
        mAVLinkPacket.payload.putShort(this.f8267vx);
        mAVLinkPacket.payload.putShort(this.f8268vy);
        mAVLinkPacket.payload.putShort(this.f8269vz);
        mAVLinkPacket.payload.putUnsignedShort(this.hdg);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.relative_alt = mAVLinkPayload.getInt();
        this.f8267vx = mAVLinkPayload.getShort();
        this.f8268vy = mAVLinkPayload.getShort();
        this.f8269vz = mAVLinkPayload.getShort();
        this.hdg = mAVLinkPayload.getUnsignedShort();
    }

    public msg_global_position_int() {
        this.msgid = 33;
    }

    public msg_global_position_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 33;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " relative_alt:" + this.relative_alt + " vx:" + this.f8267vx + " vy:" + this.f8268vy + " vz:" + this.f8269vz + " hdg:" + this.hdg + "";
    }
}
