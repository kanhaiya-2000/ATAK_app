package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_led_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LED_CONTROL = 186;
    public static final int MAVLINK_MSG_ID_LED_CONTROL_CRC = 72;
    public static final int MAVLINK_MSG_LENGTH = 29;
    private static final long serialVersionUID = 186;
    public short[] custom_bytes = new short[24];
    public short custom_len;
    public short instance;
    public short pattern;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(29);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 186;
        mAVLinkPacket.crc_extra = 72;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.instance);
        mAVLinkPacket.payload.putUnsignedByte(this.pattern);
        mAVLinkPacket.payload.putUnsignedByte(this.custom_len);
        for (short putUnsignedByte : this.custom_bytes) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.instance = mAVLinkPayload.getUnsignedByte();
        this.pattern = mAVLinkPayload.getUnsignedByte();
        this.custom_len = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.custom_bytes;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_led_control() {
        this.msgid = 186;
    }

    public msg_led_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 186;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LED_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " instance:" + this.instance + " pattern:" + this.pattern + " custom_len:" + this.custom_len + " custom_bytes:" + this.custom_bytes + "";
    }
}
