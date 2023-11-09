package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_meminfo extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MEMINFO = 152;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 152;
    public short brkval;
    public short freemem;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 4;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 152;
        mAVLinkPacket.payload.putShort(this.brkval);
        mAVLinkPacket.payload.putShort(this.freemem);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.brkval = mAVLinkPayload.getShort();
        this.freemem = mAVLinkPayload.getShort();
    }

    public msg_meminfo() {
        this.msgid = 152;
    }

    public msg_meminfo(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 152;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MEMINFO - brkval:" + this.brkval + " freemem:" + this.freemem + "";
    }
}
