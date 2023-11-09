package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_debug extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DEBUG = 254;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 254;
    public byte ind;
    public int time_boot_ms;
    public float value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 9;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 254;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.value);
        mAVLinkPacket.payload.putByte(this.ind);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.value = mAVLinkPayload.getFloat();
        this.ind = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_DEBUG - time_boot_ms:" + this.time_boot_ms + " value:" + this.value + " ind:" + this.ind + "";
    }
}
