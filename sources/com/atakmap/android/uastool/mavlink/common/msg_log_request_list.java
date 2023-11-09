package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_log_request_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_LIST = 117;
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_LIST_CRC = 128;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 117;
    public int end;
    public int start;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 117;
        mAVLinkPacket.crc_extra = 128;
        mAVLinkPacket.payload.putUnsignedShort(this.start);
        mAVLinkPacket.payload.putUnsignedShort(this.end);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.start = mAVLinkPayload.getUnsignedShort();
        this.end = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_log_request_list() {
        this.msgid = 117;
    }

    public msg_log_request_list(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 117;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_LIST - sysid:" + this.sysid + " compid:" + this.compid + " start:" + this.start + " end:" + this.end + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
