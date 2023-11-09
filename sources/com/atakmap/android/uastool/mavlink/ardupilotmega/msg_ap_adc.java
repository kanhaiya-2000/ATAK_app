package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_ap_adc extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AP_ADC = 153;
    public static final int MAVLINK_MSG_ID_AP_ADC_CRC = 188;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 153;
    public int adc1;
    public int adc2;
    public int adc3;
    public int adc4;
    public int adc5;
    public int adc6;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 153;
        mAVLinkPacket.crc_extra = MAVLINK_MSG_ID_AP_ADC_CRC;
        mAVLinkPacket.payload.putUnsignedShort(this.adc1);
        mAVLinkPacket.payload.putUnsignedShort(this.adc2);
        mAVLinkPacket.payload.putUnsignedShort(this.adc3);
        mAVLinkPacket.payload.putUnsignedShort(this.adc4);
        mAVLinkPacket.payload.putUnsignedShort(this.adc5);
        mAVLinkPacket.payload.putUnsignedShort(this.adc6);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.adc1 = mAVLinkPayload.getUnsignedShort();
        this.adc2 = mAVLinkPayload.getUnsignedShort();
        this.adc3 = mAVLinkPayload.getUnsignedShort();
        this.adc4 = mAVLinkPayload.getUnsignedShort();
        this.adc5 = mAVLinkPayload.getUnsignedShort();
        this.adc6 = mAVLinkPayload.getUnsignedShort();
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
        return "MAVLINK_MSG_ID_AP_ADC - sysid:" + this.sysid + " compid:" + this.compid + " adc1:" + this.adc1 + " adc2:" + this.adc2 + " adc3:" + this.adc3 + " adc4:" + this.adc4 + " adc5:" + this.adc5 + " adc6:" + this.adc6 + "";
    }
}
