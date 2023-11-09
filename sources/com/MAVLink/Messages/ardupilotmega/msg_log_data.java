package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_log_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_DATA = 120;
    public static final int MAVLINK_MSG_LENGTH = 97;
    private static final long serialVersionUID = 120;
    public byte count;
    public byte[] data = new byte[90];

    /* renamed from: id */
    public short f8178id;
    public int ofs;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 97;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 120;
        mAVLinkPacket.payload.putInt(this.ofs);
        mAVLinkPacket.payload.putShort(this.f8178id);
        mAVLinkPacket.payload.putByte(this.count);
        for (byte putByte : this.data) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.ofs = mAVLinkPayload.getInt();
        this.f8178id = mAVLinkPayload.getShort();
        this.count = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_LOG_DATA - ofs:" + this.ofs + " id:" + this.f8178id + " count:" + this.count + " data:" + this.data + "";
    }
}
