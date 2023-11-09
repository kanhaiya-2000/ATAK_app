package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_manual_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MANUAL_CONTROL = 69;
    public static final int MAVLINK_MSG_ID_MANUAL_CONTROL_CRC = 243;
    public static final int MAVLINK_MSG_LENGTH = 11;
    private static final long serialVersionUID = 69;
    public int buttons;

    /* renamed from: r */
    public short f8315r;
    public short target;

    /* renamed from: x */
    public short f8316x;

    /* renamed from: y */
    public short f8317y;

    /* renamed from: z */
    public short f8318z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(11);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 69;
        mAVLinkPacket.crc_extra = 243;
        mAVLinkPacket.payload.putShort(this.f8316x);
        mAVLinkPacket.payload.putShort(this.f8317y);
        mAVLinkPacket.payload.putShort(this.f8318z);
        mAVLinkPacket.payload.putShort(this.f8315r);
        mAVLinkPacket.payload.putUnsignedShort(this.buttons);
        mAVLinkPacket.payload.putUnsignedByte(this.target);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8316x = mAVLinkPayload.getShort();
        this.f8317y = mAVLinkPayload.getShort();
        this.f8318z = mAVLinkPayload.getShort();
        this.f8315r = mAVLinkPayload.getShort();
        this.buttons = mAVLinkPayload.getUnsignedShort();
        this.target = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_MANUAL_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " x:" + this.f8316x + " y:" + this.f8317y + " z:" + this.f8318z + " r:" + this.f8315r + " buttons:" + this.buttons + " target:" + this.target + "";
    }
}
