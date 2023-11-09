package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_data96 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA96 = 172;
    public static final int MAVLINK_MSG_ID_DATA96_CRC = 22;
    public static final int MAVLINK_MSG_LENGTH = 98;
    private static final long serialVersionUID = 172;
    public short[] data = new short[96];
    public short len;
    public short type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(98);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 172;
        mAVLinkPacket.crc_extra = 22;
        mAVLinkPacket.payload.putUnsignedByte(this.type);
        mAVLinkPacket.payload.putUnsignedByte(this.len);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.type = mAVLinkPayload.getUnsignedByte();
        this.len = mAVLinkPayload.getUnsignedByte();
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

    public msg_data96() {
        this.msgid = 172;
    }

    public msg_data96(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 172;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA96 - sysid:" + this.sysid + " compid:" + this.compid + " type:" + this.type + " len:" + this.len + " data:" + this.data + "";
    }
}
