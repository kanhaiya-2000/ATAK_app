package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_remote_log_block_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS = 185;
    public static final int MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS_CRC = 186;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = 185;
    public long seqno;
    public short status;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(7);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 185;
        mAVLinkPacket.crc_extra = 186;
        mAVLinkPacket.payload.putUnsignedInt(this.seqno);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.status);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seqno = mAVLinkPayload.getUnsignedInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.status = mAVLinkPayload.getUnsignedByte();
    }

    public msg_remote_log_block_status() {
        this.msgid = 185;
    }

    public msg_remote_log_block_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 185;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " seqno:" + this.seqno + " target_system:" + this.target_system + " target_component:" + this.target_component + " status:" + this.status + "";
    }
}
