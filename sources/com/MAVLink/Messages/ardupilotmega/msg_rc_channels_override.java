package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_rc_channels_override extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE = 70;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 70;
    public short chan1_raw;
    public short chan2_raw;
    public short chan3_raw;
    public short chan4_raw;
    public short chan5_raw;
    public short chan6_raw;
    public short chan7_raw;
    public short chan8_raw;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 70;
        mAVLinkPacket.payload.putShort(this.chan1_raw);
        mAVLinkPacket.payload.putShort(this.chan2_raw);
        mAVLinkPacket.payload.putShort(this.chan3_raw);
        mAVLinkPacket.payload.putShort(this.chan4_raw);
        mAVLinkPacket.payload.putShort(this.chan5_raw);
        mAVLinkPacket.payload.putShort(this.chan6_raw);
        mAVLinkPacket.payload.putShort(this.chan7_raw);
        mAVLinkPacket.payload.putShort(this.chan8_raw);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.chan1_raw = mAVLinkPayload.getShort();
        this.chan2_raw = mAVLinkPayload.getShort();
        this.chan3_raw = mAVLinkPayload.getShort();
        this.chan4_raw = mAVLinkPayload.getShort();
        this.chan5_raw = mAVLinkPayload.getShort();
        this.chan6_raw = mAVLinkPayload.getShort();
        this.chan7_raw = mAVLinkPayload.getShort();
        this.chan8_raw = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_rc_channels_override() {
        this.msgid = 70;
    }

    public msg_rc_channels_override(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 70;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE - chan1_raw:" + this.chan1_raw + " chan2_raw:" + this.chan2_raw + " chan3_raw:" + this.chan3_raw + " chan4_raw:" + this.chan4_raw + " chan5_raw:" + this.chan5_raw + " chan6_raw:" + this.chan6_raw + " chan7_raw:" + this.chan7_raw + " chan8_raw:" + this.chan8_raw + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
