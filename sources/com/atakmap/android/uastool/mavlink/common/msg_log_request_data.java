package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_log_request_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_DATA = 119;
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_DATA_CRC = 116;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 119;
    public long count;

    /* renamed from: id */
    public int f8314id;
    public long ofs;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 119;
        mAVLinkPacket.crc_extra = 116;
        mAVLinkPacket.payload.putUnsignedInt(this.ofs);
        mAVLinkPacket.payload.putUnsignedInt(this.count);
        mAVLinkPacket.payload.putUnsignedShort(this.f8314id);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.ofs = mAVLinkPayload.getUnsignedInt();
        this.count = mAVLinkPayload.getUnsignedInt();
        this.f8314id = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_log_request_data() {
        this.msgid = 119;
    }

    public msg_log_request_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 119;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_DATA - sysid:" + this.sysid + " compid:" + this.compid + " ofs:" + this.ofs + " count:" + this.count + " id:" + this.f8314id + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
