package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_ap_adc extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AP_ADC = 153;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 153;
    public short adc1;
    public short adc2;
    public short adc3;
    public short adc4;
    public short adc5;
    public short adc6;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 12;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 153;
        mAVLinkPacket.payload.putShort(this.adc1);
        mAVLinkPacket.payload.putShort(this.adc2);
        mAVLinkPacket.payload.putShort(this.adc3);
        mAVLinkPacket.payload.putShort(this.adc4);
        mAVLinkPacket.payload.putShort(this.adc5);
        mAVLinkPacket.payload.putShort(this.adc6);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.adc1 = mAVLinkPayload.getShort();
        this.adc2 = mAVLinkPayload.getShort();
        this.adc3 = mAVLinkPayload.getShort();
        this.adc4 = mAVLinkPayload.getShort();
        this.adc5 = mAVLinkPayload.getShort();
        this.adc6 = mAVLinkPayload.getShort();
    }

    public msg_ap_adc() {
        this.msgid = 153;
    }

    public msg_ap_adc(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 153;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AP_ADC - adc1:" + this.adc1 + " adc2:" + this.adc2 + " adc3:" + this.adc3 + " adc4:" + this.adc4 + " adc5:" + this.adc5 + " adc6:" + this.adc6 + "";
    }
}
