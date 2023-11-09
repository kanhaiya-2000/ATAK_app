package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_ping extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PING = 4;
    public static final int MAVLINK_MSG_ID_PING_CRC = 237;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 4;
    public long seq;
    public short target_component;
    public short target_system;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 4;
        mAVLinkPacket.crc_extra = 237;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putUnsignedInt(this.seq);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.seq = mAVLinkPayload.getUnsignedInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_ping() {
        this.msgid = 4;
    }

    public msg_ping(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 4;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PING - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " seq:" + this.seq + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
