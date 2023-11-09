package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_gps_raw_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS_RAW_INT = 24;
    public static final int MAVLINK_MSG_LENGTH = 38;
    private static final long serialVersionUID = 24;
    public int alt;
    public short cog;
    public short eph;
    public short epv;
    public byte fix_type;
    public int lat;
    public int lon;
    public byte satellites_visible;
    public long time_gps_usec;
    public long time_usec;
    public short vel;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 38;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 24;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putLong(this.time_gps_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.alt);
        mAVLinkPacket.payload.putShort(this.eph);
        mAVLinkPacket.payload.putShort(this.epv);
        mAVLinkPacket.payload.putShort(this.vel);
        mAVLinkPacket.payload.putShort(this.cog);
        mAVLinkPacket.payload.putByte(this.fix_type);
        mAVLinkPacket.payload.putByte(this.satellites_visible);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.time_gps_usec = mAVLinkPayload.getLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.alt = mAVLinkPayload.getInt();
        this.eph = mAVLinkPayload.getShort();
        this.epv = mAVLinkPayload.getShort();
        this.vel = mAVLinkPayload.getShort();
        this.cog = mAVLinkPayload.getShort();
        this.fix_type = mAVLinkPayload.getByte();
        this.satellites_visible = mAVLinkPayload.getByte();
    }

    public msg_gps_raw_int() {
        this.msgid = 24;
    }

    public msg_gps_raw_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 24;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_RAW_INT -raw格式的gps数据 - unix格式时间戳:" + this.time_usec + " 1E7格式纬度:" + this.lat + " 1E7格式经度:" + this.lon + " 1E3格式海拔高度:" + this.alt + " 水平定位精度，如果不知道就设为65535:" + this.eph + " 水平定位精度，如果不知道就设为65535:" + this.epv + " 地速 :" + this.vel + " 方向:" + this.cog + " 0-1：尚未定位  2:2d定位 3：3d定位:" + this.fix_type + " 可见卫星数:" + this.satellites_visible + "";
    }
}
