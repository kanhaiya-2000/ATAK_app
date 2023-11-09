package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_rangefinder extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RANGEFINDER = 173;
    public static final int MAVLINK_MSG_ID_RANGEFINDER_CRC = 83;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 173;
    public float distance;
    public float voltage;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 173;
        mAVLinkPacket.crc_extra = 83;
        mAVLinkPacket.payload.putFloat(this.distance);
        mAVLinkPacket.payload.putFloat(this.voltage);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.distance = mAVLinkPayload.getFloat();
        this.voltage = mAVLinkPayload.getFloat();
    }

    public msg_rangefinder() {
        this.msgid = 173;
    }

    public msg_rangefinder(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 173;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RANGEFINDER - sysid:" + this.sysid + " compid:" + this.compid + " distance:" + this.distance + " voltage:" + this.voltage + "";
    }
}
