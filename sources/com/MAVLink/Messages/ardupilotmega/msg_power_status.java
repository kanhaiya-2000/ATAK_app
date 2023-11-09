package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_power_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POWER_STATUS = 125;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 125;
    public short Vcc;
    public short Vservo;
    public short flags;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 125;
        mAVLinkPacket.payload.putShort(this.Vcc);
        mAVLinkPacket.payload.putShort(this.Vservo);
        mAVLinkPacket.payload.putShort(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.Vcc = mAVLinkPayload.getShort();
        this.Vservo = mAVLinkPayload.getShort();
        this.flags = mAVLinkPayload.getShort();
    }

    public msg_power_status() {
        this.msgid = 125;
    }

    public msg_power_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 125;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POWER_STATUS - Vcc:" + this.Vcc + " Vservo:" + this.Vservo + " flags:" + this.flags + "";
    }
}
