package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_command_ack extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COMMAND_ACK = 77;
    public static final int MAVLINK_MSG_ID_COMMAND_ACK_CRC = 143;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 77;
    public int command;
    public short result;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 77;
        mAVLinkPacket.crc_extra = 143;
        mAVLinkPacket.payload.putUnsignedShort(this.command);
        mAVLinkPacket.payload.putUnsignedByte(this.result);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.command = mAVLinkPayload.getUnsignedShort();
        this.result = mAVLinkPayload.getUnsignedByte();
    }

    public msg_command_ack() {
        this.msgid = 77;
    }

    public msg_command_ack(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 77;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_ACK - sysid:" + this.sysid + " compid:" + this.compid + " command:" + this.command + " result:" + this.result + "";
    }
}
