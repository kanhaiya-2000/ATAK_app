package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_change_operator_control_ack extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK = 6;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 6;
    public byte ack;
    public byte control_request;
    public byte gcs_system_id;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 3;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 6;
        mAVLinkPacket.payload.putByte(this.gcs_system_id);
        mAVLinkPacket.payload.putByte(this.control_request);
        mAVLinkPacket.payload.putByte(this.ack);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.gcs_system_id = mAVLinkPayload.getByte();
        this.control_request = mAVLinkPayload.getByte();
        this.ack = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK - gcs_system_id:" + this.gcs_system_id + " control_request:" + this.control_request + " ack:" + this.ack + "";
    }
}
