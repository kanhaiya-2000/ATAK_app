package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_system_time extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SYSTEM_TIME = 2;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 2;
    public int time_boot_ms;
    public long time_unix_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 12;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 2;
        mAVLinkPacket.payload.putLong(this.time_unix_usec);
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_unix_usec = mAVLinkPayload.getLong();
        this.time_boot_ms = mAVLinkPayload.getInt();
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
        return "MAVLINK_MSG_ID_SYSTEM_TIME - time_unix_usec:" + this.time_unix_usec + " time_boot_ms:" + this.time_boot_ms + "";
    }
}
