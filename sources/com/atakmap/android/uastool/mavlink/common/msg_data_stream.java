package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_data_stream extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA_STREAM = 67;
    public static final int MAVLINK_MSG_ID_DATA_STREAM_CRC = 21;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = 67;
    public int message_rate;
    public short on_off;
    public short stream_id;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(4);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 67;
        mAVLinkPacket.crc_extra = 21;
        mAVLinkPacket.payload.putUnsignedShort(this.message_rate);
        mAVLinkPacket.payload.putUnsignedByte(this.stream_id);
        mAVLinkPacket.payload.putUnsignedByte(this.on_off);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.message_rate = mAVLinkPayload.getUnsignedShort();
        this.stream_id = mAVLinkPayload.getUnsignedByte();
        this.on_off = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_DATA_STREAM - sysid:" + this.sysid + " compid:" + this.compid + " message_rate:" + this.message_rate + " stream_id:" + this.stream_id + " on_off:" + this.on_off + "";
    }
}
