package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_rc_channels extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RC_CHANNELS = 65;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = 65;
    public short chan10_raw;
    public short chan11_raw;
    public short chan12_raw;
    public short chan13_raw;
    public short chan14_raw;
    public short chan15_raw;
    public short chan16_raw;
    public short chan17_raw;
    public short chan18_raw;
    public short chan1_raw;
    public short chan2_raw;
    public short chan3_raw;
    public short chan4_raw;
    public short chan5_raw;
    public short chan6_raw;
    public short chan7_raw;
    public short chan8_raw;
    public short chan9_raw;
    public byte chancount;
    public byte rssi;
    public int time_boot_ms;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 42;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 65;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putShort(this.chan1_raw);
        mAVLinkPacket.payload.putShort(this.chan2_raw);
        mAVLinkPacket.payload.putShort(this.chan3_raw);
        mAVLinkPacket.payload.putShort(this.chan4_raw);
        mAVLinkPacket.payload.putShort(this.chan5_raw);
        mAVLinkPacket.payload.putShort(this.chan6_raw);
        mAVLinkPacket.payload.putShort(this.chan7_raw);
        mAVLinkPacket.payload.putShort(this.chan8_raw);
        mAVLinkPacket.payload.putShort(this.chan9_raw);
        mAVLinkPacket.payload.putShort(this.chan10_raw);
        mAVLinkPacket.payload.putShort(this.chan11_raw);
        mAVLinkPacket.payload.putShort(this.chan12_raw);
        mAVLinkPacket.payload.putShort(this.chan13_raw);
        mAVLinkPacket.payload.putShort(this.chan14_raw);
        mAVLinkPacket.payload.putShort(this.chan15_raw);
        mAVLinkPacket.payload.putShort(this.chan16_raw);
        mAVLinkPacket.payload.putShort(this.chan17_raw);
        mAVLinkPacket.payload.putShort(this.chan18_raw);
        mAVLinkPacket.payload.putByte(this.chancount);
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
        this.chan9_raw = mAVLinkPayload.getShort();
        this.chan10_raw = mAVLinkPayload.getShort();
        this.chan11_raw = mAVLinkPayload.getShort();
        this.chan12_raw = mAVLinkPayload.getShort();
        this.chan13_raw = mAVLinkPayload.getShort();
        this.chan14_raw = mAVLinkPayload.getShort();
        this.chan15_raw = mAVLinkPayload.getShort();
        this.chan16_raw = mAVLinkPayload.getShort();
        this.chan17_raw = mAVLinkPayload.getShort();
        this.chan18_raw = mAVLinkPayload.getShort();
        this.chancount = mAVLinkPayload.getByte();
        this.rssi = mAVLinkPayload.getByte();
    }

    public msg_rc_channels() {
        this.msgid = 65;
    }

    public msg_rc_channels(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 65;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS - time_boot_ms:" + this.time_boot_ms + " chan1_raw:" + this.chan1_raw + " chan2_raw:" + this.chan2_raw + " chan3_raw:" + this.chan3_raw + " chan4_raw:" + this.chan4_raw + " chan5_raw:" + this.chan5_raw + " chan6_raw:" + this.chan6_raw + " chan7_raw:" + this.chan7_raw + " chan8_raw:" + this.chan8_raw + " chan9_raw:" + this.chan9_raw + " chan10_raw:" + this.chan10_raw + " chan11_raw:" + this.chan11_raw + " chan12_raw:" + this.chan12_raw + " chan13_raw:" + this.chan13_raw + " chan14_raw:" + this.chan14_raw + " chan15_raw:" + this.chan15_raw + " chan16_raw:" + this.chan16_raw + " chan17_raw:" + this.chan17_raw + " chan18_raw:" + this.chan18_raw + " chancount:" + this.chancount + " rssi:" + this.rssi + "";
    }
}
