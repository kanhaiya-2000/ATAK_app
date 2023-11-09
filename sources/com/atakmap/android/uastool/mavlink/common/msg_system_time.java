package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_system_time extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SYSTEM_TIME = 2;
    public static final int MAVLINK_MSG_ID_SYSTEM_TIME_CRC = 137;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 2;
    public long time_boot_ms;
    public long time_unix_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 2;
        mAVLinkPacket.crc_extra = 137;
        mAVLinkPacket.payload.putUnsignedLong(this.time_unix_usec);
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_unix_usec = mAVLinkPayload.getUnsignedLong();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
    }

    public msg_system_time() {
        this.msgid = 2;
    }

    public msg_system_time(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 2;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SYSTEM_TIME - sysid:" + this.sysid + " compid:" + this.compid + " time_unix_usec:" + this.time_unix_usec + " time_boot_ms:" + this.time_boot_ms + "";
    }
}
