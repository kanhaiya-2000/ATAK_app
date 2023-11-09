package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_data_transmission_handshake extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE = 130;
    public static final int MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE_CRC = 29;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 130;
    public int height;
    public short jpg_quality;
    public int packets;
    public short payload;
    public long size;
    public short type;
    public int width;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(13);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 130;
        mAVLinkPacket.crc_extra = 29;
        mAVLinkPacket.payload.putUnsignedInt(this.size);
        mAVLinkPacket.payload.putUnsignedShort(this.width);
        mAVLinkPacket.payload.putUnsignedShort(this.height);
        mAVLinkPacket.payload.putUnsignedShort(this.packets);
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        mAVLinkPacket.payload.putUnsignedByte(this.payload);
        mAVLinkPacket.payload.putUnsignedByte(this.jpg_quality);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.size = mAVLinkPayload.getUnsignedInt();
        this.width = mAVLinkPayload.getUnsignedShort();
        this.height = mAVLinkPayload.getUnsignedShort();
        this.packets = mAVLinkPayload.getUnsignedShort();
        this.type = mAVLinkPayload.getUnsignedByte();
        this.payload = mAVLinkPayload.getUnsignedByte();
        this.jpg_quality = mAVLinkPayload.getUnsignedByte();
    }

    public msg_data_transmission_handshake() {
        this.msgid = 130;
    }

    public msg_data_transmission_handshake(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 130;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE - sysid:" + this.sysid + " compid:" + this.compid + " size:" + this.size + " width:" + this.width + " height:" + this.height + " packets:" + this.packets + " type:" + this.type + " payload:" + this.payload + " jpg_quality:" + this.jpg_quality + "";
    }
}
