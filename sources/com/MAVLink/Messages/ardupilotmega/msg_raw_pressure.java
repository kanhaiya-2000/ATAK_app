package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_raw_pressure extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RAW_PRESSURE = 28;
    public static final int MAVLINK_MSG_LENGTH = 16;
    private static final long serialVersionUID = 28;
    public short press_abs;
    public short press_diff1;
    public short press_diff2;
    public short temperature;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 16;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 28;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putShort(this.press_abs);
        mAVLinkPacket.payload.putShort(this.press_diff1);
        mAVLinkPacket.payload.putShort(this.press_diff2);
        mAVLinkPacket.payload.putShort(this.temperature);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.press_abs = mAVLinkPayload.getShort();
        this.press_diff1 = mAVLinkPayload.getShort();
        this.press_diff2 = mAVLinkPayload.getShort();
        this.temperature = mAVLinkPayload.getShort();
    }

    public msg_raw_pressure() {
        this.msgid = 28;
    }

    public msg_raw_pressure(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 28;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RAW_PRESSURE - time_usec:" + this.time_usec + " press_abs:" + this.press_abs + " press_diff1:" + this.press_diff1 + " press_diff2:" + this.press_diff2 + " temperature:" + this.temperature + "";
    }
}
