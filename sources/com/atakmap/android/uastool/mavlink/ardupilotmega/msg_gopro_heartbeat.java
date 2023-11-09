package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gopro_heartbeat extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GOPRO_HEARTBEAT = 215;
    public static final int MAVLINK_MSG_ID_GOPRO_HEARTBEAT_CRC = 101;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 215;
    public short capture_mode;
    public short flags;
    public short status;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
        mAVLinkPacket.crc_extra = 101;
        mAVLinkPacket.payload.putUnsignedByte(this.status);
        mAVLinkPacket.payload.putUnsignedByte(this.capture_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.status = mAVLinkPayload.getUnsignedByte();
        this.capture_mode = mAVLinkPayload.getUnsignedByte();
        this.flags = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gopro_heartbeat() {
        this.msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
    }

    public msg_gopro_heartbeat(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GOPRO_HEARTBEAT - sysid:" + this.sysid + " compid:" + this.compid + " status:" + this.status + " capture_mode:" + this.capture_mode + " flags:" + this.flags + "";
    }
}
