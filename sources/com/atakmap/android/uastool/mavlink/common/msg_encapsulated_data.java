package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_encapsulated_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ENCAPSULATED_DATA = 131;
    public static final int MAVLINK_MSG_ID_ENCAPSULATED_DATA_CRC = 223;
    public static final int MAVLINK_MSG_LENGTH = 255;
    private static final long serialVersionUID = 131;
    public short[] data = new short[253];
    public int seqnr;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(255);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 131;
        mAVLinkPacket.crc_extra = 223;
        mAVLinkPacket.payload.putUnsignedShort(this.seqnr);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seqnr = mAVLinkPayload.getUnsignedShort();
        int i = 0;
        while (true) {
            short[] sArr = this.data;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_ENCAPSULATED_DATA - sysid:" + this.sysid + " compid:" + this.compid + " seqnr:" + this.seqnr + " data:" + this.data + "";
    }
}
