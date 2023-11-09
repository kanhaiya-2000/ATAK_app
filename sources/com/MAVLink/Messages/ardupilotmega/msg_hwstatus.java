package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_hwstatus extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HWSTATUS = 165;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 165;
    public byte I2Cerr;
    public short Vcc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 3;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 165;
        mAVLinkPacket.payload.putShort(this.Vcc);
        mAVLinkPacket.payload.putByte(this.I2Cerr);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.Vcc = mAVLinkPayload.getShort();
        this.I2Cerr = mAVLinkPayload.getByte();
    }

    public msg_hwstatus() {
        this.msgid = 165;
    }

    public msg_hwstatus(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 165;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HWSTATUS - Vcc:" + this.Vcc + " I2Cerr:" + this.I2Cerr + "";
    }
}
