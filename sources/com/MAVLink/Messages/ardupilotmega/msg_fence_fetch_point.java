package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_fence_fetch_point extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FENCE_FETCH_POINT = 161;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 161;
    public byte idx;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 3;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 161;
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.idx);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.idx = mAVLinkPayload.getByte();
    }

    public msg_fence_fetch_point() {
        this.msgid = 161;
    }

    public msg_fence_fetch_point(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 161;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_FETCH_POINT - target_system:" + this.target_system + " target_component:" + this.target_component + " idx:" + this.idx + "";
    }
}
