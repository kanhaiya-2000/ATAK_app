package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_rc_inputs_raw extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW = 92;
    public static final int MAVLINK_MSG_LENGTH = 33;
    private static final long serialVersionUID = 92;
    public short chan10_raw;
    public short chan11_raw;
    public short chan12_raw;
    public short chan1_raw;
    public short chan2_raw;
    public short chan3_raw;
    public short chan4_raw;
    public short chan5_raw;
    public short chan6_raw;
    public short chan7_raw;
    public short chan8_raw;
    public short chan9_raw;
    public byte rssi;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 33;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 92;
        mAVLinkPacket.payload.putLong(this.time_usec);
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
        mAVLinkPacket.payload.putByte(this.rssi);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
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
        this.rssi = mAVLinkPayload.getByte();
    }

    public msg_hil_rc_inputs_raw() {
        this.msgid = 92;
    }

    public msg_hil_rc_inputs_raw(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 92;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW - time_usec:" + this.time_usec + " chan1_raw:" + this.chan1_raw + " chan2_raw:" + this.chan2_raw + " chan3_raw:" + this.chan3_raw + " chan4_raw:" + this.chan4_raw + " chan5_raw:" + this.chan5_raw + " chan6_raw:" + this.chan6_raw + " chan7_raw:" + this.chan7_raw + " chan8_raw:" + this.chan8_raw + " chan9_raw:" + this.chan9_raw + " chan10_raw:" + this.chan10_raw + " chan11_raw:" + this.chan11_raw + " chan12_raw:" + this.chan12_raw + " rssi:" + this.rssi + "";
    }
}
