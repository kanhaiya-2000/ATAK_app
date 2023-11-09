package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_custom_flight_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CUSTOM_FLIGHT_STATUS = 216;
    public static final int MAVLINK_MSG_LENGTH = 1;
    private static final long serialVersionUID = 216;
    public byte uflight_status;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 1;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 216;
        mAVLinkPacket.payload.putByte(this.uflight_status);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.uflight_status = mAVLinkPayload.getByte();
    }

    public msg_custom_flight_status() {
        this.msgid = 216;
    }

    public msg_custom_flight_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 216;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "CUSTOM_FLIGHT_STATUS : uflight_status:" + this.uflight_status;
    }
}
