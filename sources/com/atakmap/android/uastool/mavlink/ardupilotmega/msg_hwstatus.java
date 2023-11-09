package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hwstatus extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HWSTATUS = 165;
    public static final int MAVLINK_MSG_ID_HWSTATUS_CRC = 21;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 165;
    public short I2Cerr;
    public int Vcc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 165;
        mAVLinkPacket.crc_extra = 21;
        mAVLinkPacket.payload.putUnsignedShort(this.Vcc);
        mAVLinkPacket.payload.putUnsignedByte(this.I2Cerr);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.Vcc = mAVLinkPayload.getUnsignedShort();
        this.I2Cerr = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_HWSTATUS - sysid:" + this.sysid + " compid:" + this.compid + " Vcc:" + this.Vcc + " I2Cerr:" + this.I2Cerr + "";
    }
}
