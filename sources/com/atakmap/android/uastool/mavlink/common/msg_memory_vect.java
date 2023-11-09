package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_memory_vect extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MEMORY_VECT = 249;
    public static final int MAVLINK_MSG_ID_MEMORY_VECT_CRC = 204;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 249;
    public int address;
    public short type;
    public byte[] value = new byte[32];
    public short ver;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(36);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 249;
        mAVLinkPacket.crc_extra = 204;
        mAVLinkPacket.payload.putUnsignedShort(this.address);
        mAVLinkPacket.payload.putUnsignedByte(this.ver);
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        for (byte putByte : this.value) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.address = mAVLinkPayload.getUnsignedShort();
        this.ver = mAVLinkPayload.getUnsignedByte();
        this.type = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_MEMORY_VECT - sysid:" + this.sysid + " compid:" + this.compid + " address:" + this.address + " ver:" + this.ver + " type:" + this.type + " value:" + this.value + "";
    }
}
