package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_log_entry extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_ENTRY = 118;
    public static final int MAVLINK_MSG_ID_LOG_ENTRY_CRC = 56;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 118;

    /* renamed from: id */
    public int f8313id;
    public int last_log_num;
    public int num_logs;
    public long size;
    public long time_utc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 118;
        mAVLinkPacket.crc_extra = 56;
        mAVLinkPacket.payload.putUnsignedInt(this.time_utc);
        mAVLinkPacket.payload.putUnsignedInt(this.size);
        mAVLinkPacket.payload.putUnsignedShort(this.f8313id);
        mAVLinkPacket.payload.putUnsignedShort(this.num_logs);
        mAVLinkPacket.payload.putUnsignedShort(this.last_log_num);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_utc = mAVLinkPayload.getUnsignedInt();
        this.size = mAVLinkPayload.getUnsignedInt();
        this.f8313id = mAVLinkPayload.getUnsignedShort();
        this.num_logs = mAVLinkPayload.getUnsignedShort();
        this.last_log_num = mAVLinkPayload.getUnsignedShort();
    }

    public msg_log_entry() {
        this.msgid = 118;
    }

    public msg_log_entry(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 118;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_ENTRY - sysid:" + this.sysid + " compid:" + this.compid + " time_utc:" + this.time_utc + " size:" + this.size + " id:" + this.f8313id + " num_logs:" + this.num_logs + " last_log_num:" + this.last_log_num + "";
    }
}
