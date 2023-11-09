package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_battery2 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_BATTERY2 = 181;
    public static final int MAVLINK_MSG_ID_BATTERY2_CRC = 174;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 181;
    public short current_battery;
    public int voltage;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 181;
        mAVLinkPacket.crc_extra = 174;
        mAVLinkPacket.payload.putUnsignedShort(this.voltage);
        mAVLinkPacket.payload.putShort(this.current_battery);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.voltage = mAVLinkPayload.getUnsignedShort();
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
        return "MAVLINK_MSG_ID_BATTERY2 - sysid:" + this.sysid + " compid:" + this.compid + " voltage:" + this.voltage + " current_battery:" + this.current_battery + "";
    }
}
