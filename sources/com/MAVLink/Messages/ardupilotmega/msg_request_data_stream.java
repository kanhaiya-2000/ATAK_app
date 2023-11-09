package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_request_data_stream extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_REQUEST_DATA_STREAM = 66;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 66;
    public short req_message_rate;
    public byte req_stream_id;
    public byte start_stop;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 6;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 66;
        mAVLinkPacket.payload.putShort(this.req_message_rate);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.req_stream_id);
        mAVLinkPacket.payload.putByte(this.start_stop);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.req_message_rate = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.req_stream_id = mAVLinkPayload.getByte();
        this.start_stop = mAVLinkPayload.getByte();
    }

    public msg_request_data_stream() {
        this.msgid = 66;
    }

    public msg_request_data_stream(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 66;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REQUEST_DATA_STREAM - req_message_rate:" + this.req_message_rate + " target_system:" + this.target_system + " target_component:" + this.target_component + " req_stream_id:" + this.req_stream_id + " start_stop:" + this.start_stop + "";
    }
}
