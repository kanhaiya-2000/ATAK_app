package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_distance_sensor extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DISTANCE_SENSOR = 132;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 132;
    public byte covariance;
    public short current_distance;

    /* renamed from: id */
    public byte f8139id;
    public short max_distance;
    public short min_distance;
    public byte orientation;
    public int time_boot_ms;
    public byte type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 14;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 132;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putShort(this.min_distance);
        mAVLinkPacket.payload.putShort(this.max_distance);
        mAVLinkPacket.payload.putShort(this.current_distance);
        mAVLinkPacket.payload.putByte(this.type);
        mAVLinkPacket.payload.putByte(this.f8139id);
        mAVLinkPacket.payload.putByte(this.orientation);
        mAVLinkPacket.payload.putByte(this.covariance);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.min_distance = mAVLinkPayload.getShort();
        this.max_distance = mAVLinkPayload.getShort();
        this.current_distance = mAVLinkPayload.getShort();
        this.type = mAVLinkPayload.getByte();
        this.f8139id = mAVLinkPayload.getByte();
        this.orientation = mAVLinkPayload.getByte();
        this.covariance = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_DISTANCE_SENSOR - time_boot_ms:" + this.time_boot_ms + " min_distance:" + this.min_distance + " max_distance:" + this.max_distance + " current_distance:" + this.current_distance + " type:" + this.type + " id:" + this.f8139id + " orientation:" + this.orientation + " covariance:" + this.covariance + "";
    }
}
