package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_rc_channels_raw extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RC_CHANNELS_RAW = 35;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 35;
    public short chan1_raw;
    public short chan2_raw;
    public short chan3_raw;
    public short chan4_raw;
    public short chan5_raw;
    public short chan6_raw;
    public short chan7_raw;
    public short chan8_raw;
    public byte port;
    public byte rssi;
    public int time_boot_ms;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 22;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 35;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putShort(this.chan1_raw);
        mAVLinkPacket.payload.putShort(this.chan2_raw);
        mAVLinkPacket.payload.putShort(this.chan3_raw);
        mAVLinkPacket.payload.putShort(this.chan4_raw);
        mAVLinkPacket.payload.putShort(this.chan5_raw);
        mAVLinkPacket.payload.putShort(this.chan6_raw);
        mAVLinkPacket.payload.putShort(this.chan7_raw);
        mAVLinkPacket.payload.putShort(this.chan8_raw);
        mAVLinkPacket.payload.putByte(this.port);
        mAVLinkPacket.payload.putByte(this.rssi);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.chan1_raw = mAVLinkPayload.getShort();
        this.chan2_raw = mAVLinkPayload.getShort();
        this.chan3_raw = mAVLinkPayload.getShort();
        this.chan4_raw = mAVLinkPayload.getShort();
        this.chan5_raw = mAVLinkPayload.getShort();
        this.chan6_raw = mAVLinkPayload.getShort();
        this.chan7_raw = mAVLinkPayload.getShort();
        this.chan8_raw = mAVLinkPayload.getShort();
        this.port = mAVLinkPayload.getByte();
        this.rssi = mAVLinkPayload.getByte();
    }

    public msg_rc_channels_raw() {
        this.msgid = 35;
    }

    public msg_rc_channels_raw(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 35;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS_RAW - time_boot_ms:" + this.time_boot_ms + " chan1_raw:" + this.chan1_raw + " chan2_raw:" + this.chan2_raw + " chan3_raw:" + this.chan3_raw + " chan4_raw:" + this.chan4_raw + " chan5_raw:" + this.chan5_raw + " chan6_raw:" + this.chan6_raw + " chan7_raw:" + this.chan7_raw + " chan8_raw:" + this.chan8_raw + " port:" + this.port + " rssi:" + this.rssi + "";
    }
}
