package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_message_interval extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MESSAGE_INTERVAL = 244;
    public static final int MAVLINK_MSG_ID_MESSAGE_INTERVAL_CRC = 95;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 244;
    public int interval_us;
    public int message_id;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 244;
        mAVLinkPacket.crc_extra = 95;
        mAVLinkPacket.payload.putInt(this.interval_us);
        mAVLinkPacket.payload.putUnsignedShort(this.message_id);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.interval_us = mAVLinkPayload.getInt();
        this.message_id = mAVLinkPayload.getUnsignedShort();
    }

    public msg_message_interval() {
        this.msgid = 244;
    }

    public msg_message_interval(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 244;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MESSAGE_INTERVAL - sysid:" + this.sysid + " compid:" + this.compid + " interval_us:" + this.interval_us + " message_id:" + this.message_id + "";
    }
}
