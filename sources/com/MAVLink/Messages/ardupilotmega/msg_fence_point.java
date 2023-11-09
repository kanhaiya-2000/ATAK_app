package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_fence_point extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FENCE_POINT = 160;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 160;
    public byte count;
    public byte idx;
    public float lat;
    public float lng;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 12;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 160;
        mAVLinkPacket.payload.putFloat(this.lat);
        mAVLinkPacket.payload.putFloat(this.lng);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.idx);
        mAVLinkPacket.payload.putByte(this.count);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getFloat();
        this.lng = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.idx = mAVLinkPayload.getByte();
        this.count = mAVLinkPayload.getByte();
    }

    public msg_fence_point() {
        this.msgid = 160;
    }

    public msg_fence_point(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 160;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_POINT - latitude:" + this.lat + " longitude:" + this.lng + " target_system:" + this.target_system + " target_component:" + this.target_component + " idx:" + this.idx + " count:" + this.count + "";
    }
}
