package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_heartbeat extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HEARTBEAT = 0;
    public static final int MAVLINK_MSG_ID_HEARTBEAT_CRC = 50;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 0;
    public short autopilot;
    public short base_mode;
    public long custom_mode;
    public short mavlink_version;
    public short system_status;
    public short type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(9);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 0;
        mAVLinkPacket.crc_extra = 50;
        mAVLinkPacket.payload.putUnsignedInt(this.custom_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        mAVLinkPacket.payload.putUnsignedByte(this.autopilot);
        mAVLinkPacket.payload.putUnsignedByte(this.base_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.system_status);
        mAVLinkPacket.payload.putUnsignedByte(this.mavlink_version);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.custom_mode = mAVLinkPayload.getUnsignedInt();
        this.type = mAVLinkPayload.getUnsignedByte();
        this.autopilot = mAVLinkPayload.getUnsignedByte();
        this.base_mode = mAVLinkPayload.getUnsignedByte();
        this.system_status = mAVLinkPayload.getUnsignedByte();
        this.mavlink_version = mAVLinkPayload.getUnsignedByte();
    }

    public msg_heartbeat() {
        this.msgid = 0;
    }

    public msg_heartbeat(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 0;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HEARTBEAT - sysid:" + this.sysid + " compid:" + this.compid + " custom_mode:" + this.custom_mode + " type:" + this.type + " autopilot:" + this.autopilot + " base_mode:" + this.base_mode + " system_status:" + this.system_status + " mavlink_version:" + this.mavlink_version + "";
    }
}
