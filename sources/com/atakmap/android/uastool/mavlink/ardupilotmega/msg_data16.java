package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_data16 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DATA16 = 169;
    public static final int MAVLINK_MSG_ID_DATA16_CRC = 234;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 169;
    public short[] data = new short[16];
    public short len;
    public short type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(18);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 169;
        mAVLinkPacket.crc_extra = 234;
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

    public msg_data16() {
        this.msgid = 169;
    }

    public msg_data16(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 169;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA16 - sysid:" + this.sysid + " compid:" + this.compid + " type:" + this.type + " len:" + this.len + " data:" + this.data + "";
    }
}
