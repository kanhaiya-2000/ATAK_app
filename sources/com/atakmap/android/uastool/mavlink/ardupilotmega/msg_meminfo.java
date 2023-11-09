package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_meminfo extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MEMINFO = 152;
    public static final int MAVLINK_MSG_ID_MEMINFO_CRC = 208;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 152;
    public int brkval;
    public int freemem;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 152;
        mAVLinkPacket.crc_extra = 208;
        mAVLinkPacket.payload.putUnsignedShort(this.brkval);
        mAVLinkPacket.payload.putUnsignedShort(this.freemem);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.brkval = mAVLinkPayload.getUnsignedShort();
        this.freemem = mAVLinkPayload.getUnsignedShort();
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
        return "MAVLINK_MSG_ID_MEMINFO - sysid:" + this.sysid + " compid:" + this.compid + " brkval:" + this.brkval + " freemem:" + this.freemem + "";
    }
}
