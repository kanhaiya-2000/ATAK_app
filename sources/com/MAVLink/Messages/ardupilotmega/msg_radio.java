package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_radio extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RADIO = 166;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 166;
    public short fixed;
    public byte noise;
    public byte remnoise;
    public byte remrssi;
    public byte rssi;
    public short rxerrors;
    public byte txbuf;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 9;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 166;
        mAVLinkPacket.payload.putShort(this.rxerrors);
        mAVLinkPacket.payload.putShort(this.fixed);
        mAVLinkPacket.payload.putByte(this.rssi);
        mAVLinkPacket.payload.putByte(this.remrssi);
        mAVLinkPacket.payload.putByte(this.txbuf);
        mAVLinkPacket.payload.putByte(this.noise);
        mAVLinkPacket.payload.putByte(this.remnoise);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.rxerrors = mAVLinkPayload.getShort();
        this.fixed = mAVLinkPayload.getShort();
        this.rssi = mAVLinkPayload.getByte();
        this.remrssi = mAVLinkPayload.getByte();
        this.txbuf = mAVLinkPayload.getByte();
        this.noise = mAVLinkPayload.getByte();
        this.remnoise = mAVLinkPayload.getByte();
    }

    public msg_radio() {
        this.msgid = 166;
    }

    public msg_radio(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 166;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RADIO - rxerrors:" + this.rxerrors + " fixed:" + this.fixed + " rssi:" + this.rssi + " remrssi:" + this.remrssi + " txbuf:" + this.txbuf + " noise:" + this.noise + " remnoise:" + this.remnoise + "";
    }
}
