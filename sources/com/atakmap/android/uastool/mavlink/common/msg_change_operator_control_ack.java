package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_change_operator_control_ack extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK = 6;
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK_CRC = 104;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 6;
    public short ack;
    public short control_request;
    public short gcs_system_id;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 6;
        mAVLinkPacket.crc_extra = 104;
        mAVLinkPacket.payload.putUnsignedByte(this.gcs_system_id);
        mAVLinkPacket.payload.putUnsignedByte(this.control_request);
        mAVLinkPacket.payload.putUnsignedByte(this.ack);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.gcs_system_id = mAVLinkPayload.getUnsignedByte();
        this.control_request = mAVLinkPayload.getUnsignedByte();
        this.ack = mAVLinkPayload.getUnsignedByte();
    }

    public msg_change_operator_control_ack() {
        this.msgid = 6;
    }

    public msg_change_operator_control_ack(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 6;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK - sysid:" + this.sysid + " compid:" + this.compid + " gcs_system_id:" + this.gcs_system_id + " control_request:" + this.control_request + " ack:" + this.ack + "";
    }
}
