package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_battery2 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_BATTERY2 = 181;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 181;
    public short current_battery;
    public short voltage;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 4;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 181;
        mAVLinkPacket.payload.putShort(this.voltage);
        mAVLinkPacket.payload.putShort(this.current_battery);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.voltage = mAVLinkPayload.getShort();
        this.current_battery = mAVLinkPayload.getShort();
    }

    public msg_battery2() {
        this.msgid = 181;
    }

    public msg_battery2(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 181;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_BATTERY2 - voltage:" + this.voltage + " current_battery:" + this.current_battery + "";
    }
}
