package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_power_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_POWER_STATUS = 125;
    public static final int MAVLINK_MSG_ID_POWER_STATUS_CRC = 203;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 125;
    public int Vcc;
    public int Vservo;
    public int flags;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 125;
        mAVLinkPacket.crc_extra = 203;
        mAVLinkPacket.payload.putUnsignedShort(this.Vcc);
        mAVLinkPacket.payload.putUnsignedShort(this.Vservo);
        mAVLinkPacket.payload.putUnsignedShort(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.Vcc = mAVLinkPayload.getUnsignedShort();
        this.Vservo = mAVLinkPayload.getUnsignedShort();
        this.flags = mAVLinkPayload.getUnsignedShort();
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
        return "MAVLINK_MSG_ID_POWER_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " Vcc:" + this.Vcc + " Vservo:" + this.Vservo + " flags:" + this.flags + "";
    }
}
