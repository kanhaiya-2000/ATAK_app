package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_ping extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PING = 4;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 4;
    public int seq;
    public byte target_component;
    public byte target_system;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 14;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 4;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.seq);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.seq = mAVLinkPayload.getInt();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_PING - time_usec:" + this.time_usec + " seq:" + this.seq + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
