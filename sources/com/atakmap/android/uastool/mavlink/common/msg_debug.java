package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_debug extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DEBUG = 254;
    public static final int MAVLINK_MSG_ID_DEBUG_CRC = 46;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 254;
    public short ind;
    public long time_boot_ms;
    public float value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(9);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 254;
        mAVLinkPacket.crc_extra = 46;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.value);
        mAVLinkPacket.payload.putUnsignedByte(this.ind);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.value = mAVLinkPayload.getFloat();
        this.ind = mAVLinkPayload.getUnsignedByte();
    }

    public msg_debug() {
        this.msgid = 254;
    }

    public msg_debug(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 254;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DEBUG - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " value:" + this.value + " ind:" + this.ind + "";
    }
}
