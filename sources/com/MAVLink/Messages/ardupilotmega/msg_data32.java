package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_data32 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA32 = 170;
    public static final int MAVLINK_MSG_LENGTH = 34;
    private static final long serialVersionUID = 170;
    public byte[] data = new byte[32];
    public byte len;
    public byte type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 34;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 170;
        mAVLinkPacket.payload.putByte(this.type);
        mAVLinkPacket.payload.putByte(this.len);
        for (byte putByte : this.data) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.type = mAVLinkPayload.getByte();
        this.len = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_data32() {
        this.msgid = 170;
    }

    public msg_data32(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 170;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA32 - type:" + this.type + " len:" + this.len + " data:" + this.data + "";
    }
}
