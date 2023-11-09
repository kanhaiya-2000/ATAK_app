package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_radio_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RADIO_STATUS = 109;
    public static final int MAVLINK_MSG_ID_RADIO_STATUS_CRC = 185;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 109;
    public int fixed;
    public short noise;
    public short remnoise;
    public short remrssi;
    public short rssi;
    public int rxerrors;
    public short txbuf;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(9);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 109;
        mAVLinkPacket.crc_extra = 185;
        mAVLinkPacket.payload.putUnsignedShort(this.rxerrors);
        mAVLinkPacket.payload.putUnsignedShort(this.fixed);
        mAVLinkPacket.payload.putUnsignedByte(this.rssi);
        mAVLinkPacket.payload.putUnsignedByte(this.remrssi);
        mAVLinkPacket.payload.putUnsignedByte(this.txbuf);
        mAVLinkPacket.payload.putUnsignedByte(this.noise);
        mAVLinkPacket.payload.putUnsignedByte(this.remnoise);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.rxerrors = mAVLinkPayload.getUnsignedShort();
        this.fixed = mAVLinkPayload.getUnsignedShort();
        this.rssi = mAVLinkPayload.getUnsignedByte();
        this.remrssi = mAVLinkPayload.getUnsignedByte();
        this.txbuf = mAVLinkPayload.getUnsignedByte();
        this.noise = mAVLinkPayload.getUnsignedByte();
        this.remnoise = mAVLinkPayload.getUnsignedByte();
    }

    public msg_radio_status() {
        this.msgid = 109;
    }

    public msg_radio_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 109;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RADIO_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " rxerrors:" + this.rxerrors + " fixed:" + this.fixed + " rssi:" + this.rssi + " remrssi:" + this.remrssi + " txbuf:" + this.txbuf + " noise:" + this.noise + " remnoise:" + this.remnoise + "";
    }
}
