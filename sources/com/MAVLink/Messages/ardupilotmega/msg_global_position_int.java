package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_global_position_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT = 33;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 33;
    public int alt;
    public short hdg;
    public int lat;
    public int lon;
    public int relative_alt;
    public int time_boot_ms;

    /* renamed from: vx */
    public short f8140vx;

    /* renamed from: vy */
    public short f8141vy;

    /* renamed from: vz */
    public short f8142vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 33;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putInt(this.relative_alt);
        mAVLinkPacket.payload.putShort(this.f8140vx);
        mAVLinkPacket.payload.putShort(this.f8141vy);
        mAVLinkPacket.payload.putShort(this.f8142vz);
        mAVLinkPacket.payload.putShort(this.hdg);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.relative_alt = mAVLinkPayload.getInt();
        this.f8140vx = mAVLinkPayload.getShort();
        this.f8141vy = mAVLinkPayload.getShort();
        this.f8142vz = mAVLinkPayload.getShort();
        this.hdg = mAVLinkPayload.getShort();
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
        return "整型数据表示的全球定位数据 - time_boot_ms:" + this.time_boot_ms + " latitude:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " relative_alt:" + this.relative_alt + " vx:" + this.f8140vx + " vy:" + this.f8141vy + " vz:" + this.f8142vz + " hdg:" + this.hdg + "";
    }
}
