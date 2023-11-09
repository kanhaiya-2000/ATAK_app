package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_data_stream extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA_STREAM = 67;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 67;
    public short message_rate;
    public byte on_off;
    public byte stream_id;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 4;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 67;
        mAVLinkPacket.payload.putShort(this.message_rate);
        mAVLinkPacket.payload.putByte(this.stream_id);
        mAVLinkPacket.payload.putByte(this.on_off);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.message_rate = mAVLinkPayload.getShort();
        this.stream_id = mAVLinkPayload.getByte();
        this.on_off = mAVLinkPayload.getByte();
    }

    public msg_data_stream() {
        this.msgid = 67;
    }

    public msg_data_stream(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 67;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_STREAM - message_rate:" + this.message_rate + " stream_id:" + this.stream_id + " on_off:" + this.on_off + "";
    }
}
