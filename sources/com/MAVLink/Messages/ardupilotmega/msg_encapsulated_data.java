package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_encapsulated_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ENCAPSULATED_DATA = 131;
    public static final int MAVLINK_MSG_LENGTH = 255;
    private static final long serialVersionUID = 131;
    public byte[] data = new byte[253];
    public short seqnr;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 255;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 131;
        mAVLinkPacket.payload.putShort(this.seqnr);
        for (byte putByte : this.data) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seqnr = mAVLinkPayload.getShort();
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

    public msg_encapsulated_data() {
        this.msgid = 131;
    }

    public msg_encapsulated_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 131;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ENCAPSULATED_DATA - seqnr:" + this.seqnr + " data:" + this.data + "";
    }
}
