package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_distance_sensor extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DISTANCE_SENSOR = 132;
    public static final int MAVLINK_MSG_ID_DISTANCE_SENSOR_CRC = 85;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 132;
    public short covariance;
    public int current_distance;

    /* renamed from: id */
    public short f8266id;
    public int max_distance;
    public int min_distance;
    public short orientation;
    public long time_boot_ms;
    public short type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 132;
        mAVLinkPacket.crc_extra = 85;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putUnsignedShort(this.min_distance);
        mAVLinkPacket.payload.putUnsignedShort(this.max_distance);
        mAVLinkPacket.payload.putUnsignedShort(this.current_distance);
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        mAVLinkPacket.payload.putUnsignedByte(this.f8266id);
        mAVLinkPacket.payload.putUnsignedByte(this.orientation);
        mAVLinkPacket.payload.putUnsignedByte(this.covariance);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.min_distance = mAVLinkPayload.getUnsignedShort();
        this.max_distance = mAVLinkPayload.getUnsignedShort();
        this.current_distance = mAVLinkPayload.getUnsignedShort();
        this.type = mAVLinkPayload.getUnsignedByte();
        this.f8266id = mAVLinkPayload.getUnsignedByte();
        this.orientation = mAVLinkPayload.getUnsignedByte();
        this.covariance = mAVLinkPayload.getUnsignedByte();
    }

    public msg_distance_sensor() {
        this.msgid = 132;
    }

    public msg_distance_sensor(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 132;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DISTANCE_SENSOR - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " min_distance:" + this.min_distance + " max_distance:" + this.max_distance + " current_distance:" + this.current_distance + " type:" + this.type + " id:" + this.f8266id + " orientation:" + this.orientation + " covariance:" + this.covariance + "";
    }
}
