package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_item_reached extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_REACHED = 46;
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_REACHED_CRC = 11;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = 46;
    public int seq;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(2);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 46;
        mAVLinkPacket.crc_extra = 11;
        mAVLinkPacket.payload.putUnsignedShort(this.seq);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seq = mAVLinkPayload.getUnsignedShort();
    }

    public msg_mission_item_reached() {
        this.msgid = 46;
    }

    public msg_mission_item_reached(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 46;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM_REACHED - sysid:" + this.sysid + " compid:" + this.compid + " seq:" + this.seq + "";
    }
}
