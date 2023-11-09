package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_data_transmission_handshake extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE = 130;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 130;
    public short height;
    public byte jpg_quality;
    public short packets;
    public byte payload;
    public int size;
    public byte type;
    public short width;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 13;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 130;
        mAVLinkPacket.payload.putInt(this.size);
        mAVLinkPacket.payload.putShort(this.width);
        mAVLinkPacket.payload.putShort(this.height);
        mAVLinkPacket.payload.putShort(this.packets);
        mAVLinkPacket.payload.putByte(this.type);
        mAVLinkPacket.payload.putByte(this.payload);
        mAVLinkPacket.payload.putByte(this.jpg_quality);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.size = mAVLinkPayload.getInt();
        this.width = mAVLinkPayload.getShort();
        this.height = mAVLinkPayload.getShort();
        this.packets = mAVLinkPayload.getShort();
        this.type = mAVLinkPayload.getByte();
        this.jpg_quality = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE - size:" + this.size + " width:" + this.width + " height:" + this.height + " packets:" + this.packets + " type:" + this.type + " payload:" + this.payload + " jpg_quality:" + this.jpg_quality + "";
    }
}
