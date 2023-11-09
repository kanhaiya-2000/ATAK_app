package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_request_data_stream extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_REQUEST_DATA_STREAM = 66;
    public static final int MAVLINK_MSG_ID_REQUEST_DATA_STREAM_CRC = 148;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 66;
    public int req_message_rate;
    public short req_stream_id;
    public short start_stop;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 66;
        mAVLinkPacket.crc_extra = 148;
        mAVLinkPacket.payload.putUnsignedShort(this.req_message_rate);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.req_stream_id);
        mAVLinkPacket.payload.putUnsignedByte(this.start_stop);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.req_message_rate = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.req_stream_id = mAVLinkPayload.getUnsignedByte();
        this.start_stop = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_REQUEST_DATA_STREAM - sysid:" + this.sysid + " compid:" + this.compid + " req_message_rate:" + this.req_message_rate + " target_system:" + this.target_system + " target_component:" + this.target_component + " req_stream_id:" + this.req_stream_id + " start_stop:" + this.start_stop + "";
    }
}
