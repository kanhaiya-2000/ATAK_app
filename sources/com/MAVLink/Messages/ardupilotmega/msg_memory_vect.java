package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_memory_vect extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MEMORY_VECT = 249;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 249;
    public short address;
    public byte type;
    public byte[] value = new byte[32];
    public byte ver;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 36;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 249;
        mAVLinkPacket.payload.putShort(this.address);
        mAVLinkPacket.payload.putByte(this.ver);
        mAVLinkPacket.payload.putByte(this.type);
        for (byte putByte : this.value) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.address = mAVLinkPayload.getShort();
        this.ver = mAVLinkPayload.getByte();
        this.type = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.value;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_memory_vect() {
        this.msgid = 249;
    }

    public msg_memory_vect(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 249;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MEMORY_VECT - address:" + this.address + " ver:" + this.ver + " type:" + this.type + " value:" + this.value + "";
    }
}
