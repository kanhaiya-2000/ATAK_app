package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_safety_set_allowed_area extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA = 54;
    public static final int MAVLINK_MSG_LENGTH = 27;
    private static final long serialVersionUID = 54;
    public byte frame;
    public float p1x;
    public float p1y;
    public float p1z;
    public float p2x;
    public float p2y;
    public float p2z;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 27;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 54;
        mAVLinkPacket.payload.putFloat(this.p1x);
        mAVLinkPacket.payload.putFloat(this.p1y);
        mAVLinkPacket.payload.putFloat(this.p1z);
        mAVLinkPacket.payload.putFloat(this.p2x);
        mAVLinkPacket.payload.putFloat(this.p2y);
        mAVLinkPacket.payload.putFloat(this.p2z);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.p1x = mAVLinkPayload.getFloat();
        this.p1y = mAVLinkPayload.getFloat();
        this.p1z = mAVLinkPayload.getFloat();
        this.p2x = mAVLinkPayload.getFloat();
        this.p2y = mAVLinkPayload.getFloat();
        this.p2z = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.frame = mAVLinkPayload.getByte();
    }

    public msg_safety_set_allowed_area() {
        this.msgid = 54;
    }

    public msg_safety_set_allowed_area(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 54;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA - p1x:" + this.p1x + " p1y:" + this.p1y + " p1z:" + this.p1z + " p2x:" + this.p2x + " p2y:" + this.p2y + " p2z:" + this.p2z + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + "";
    }
}
