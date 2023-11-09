package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_manual_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MANUAL_CONTROL = 69;
    public static final int MAVLINK_MSG_LENGTH = 11;
    private static final long serialVersionUID = 69;
    public short buttons;

    /* renamed from: r */
    public short f8181r;
    public byte target;

    /* renamed from: x */
    public short f8182x;

    /* renamed from: y */
    public short f8183y;

    /* renamed from: z */
    public short f8184z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 11;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 69;
        mAVLinkPacket.payload.putShort(this.f8182x);
        mAVLinkPacket.payload.putShort(this.f8183y);
        mAVLinkPacket.payload.putShort(this.f8184z);
        mAVLinkPacket.payload.putShort(this.f8181r);
        mAVLinkPacket.payload.putShort(this.buttons);
        mAVLinkPacket.payload.putByte(this.target);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8182x = mAVLinkPayload.getShort();
        this.f8183y = mAVLinkPayload.getShort();
        this.f8184z = mAVLinkPayload.getShort();
        this.f8181r = mAVLinkPayload.getShort();
        this.buttons = mAVLinkPayload.getShort();
        this.target = mAVLinkPayload.getByte();
    }

    public msg_manual_control() {
        this.msgid = 69;
    }

    public msg_manual_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 69;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MANUAL_CONTROL - x:" + this.f8182x + " y:" + this.f8183y + " z:" + this.f8184z + " r:" + this.f8181r + " buttons:" + this.buttons + " target:" + this.target + "";
    }
}
