package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_log_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_DATA = 120;
    public static final int MAVLINK_MSG_ID_LOG_DATA_CRC = 134;
    public static final int MAVLINK_MSG_LENGTH = 97;
    private static final long serialVersionUID = 120;
    public short count;
    public short[] data = new short[90];

    /* renamed from: id */
    public int f8312id;
    public long ofs;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(97);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 120;
        mAVLinkPacket.crc_extra = 134;
        mAVLinkPacket.payload.putUnsignedInt(this.ofs);
        mAVLinkPacket.payload.putUnsignedShort(this.f8312id);
        mAVLinkPacket.payload.putUnsignedByte(this.count);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.ofs = mAVLinkPayload.getUnsignedInt();
        this.f8312id = mAVLinkPayload.getUnsignedShort();
        this.count = mAVLinkPayload.getUnsignedByte();
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

    public msg_log_data() {
        this.msgid = 120;
    }

    public msg_log_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 120;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_DATA - sysid:" + this.sysid + " compid:" + this.compid + " ofs:" + this.ofs + " id:" + this.f8312id + " count:" + this.count + " data:" + this.data + "";
    }
}
