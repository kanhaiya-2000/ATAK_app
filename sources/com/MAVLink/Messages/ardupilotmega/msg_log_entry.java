package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_log_entry extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_ENTRY = 118;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 118;

    /* renamed from: id */
    public short f8179id;
    public short last_log_num;
    public short num_logs;
    public int size;
    public int time_utc;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 14;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 118;
        mAVLinkPacket.payload.putInt(this.time_utc);
        mAVLinkPacket.payload.putInt(this.size);
        mAVLinkPacket.payload.putShort(this.f8179id);
        mAVLinkPacket.payload.putShort(this.num_logs);
        mAVLinkPacket.payload.putShort(this.last_log_num);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_utc = mAVLinkPayload.getInt();
        this.size = mAVLinkPayload.getInt();
        this.f8179id = mAVLinkPayload.getShort();
        this.num_logs = mAVLinkPayload.getShort();
        this.last_log_num = mAVLinkPayload.getShort();
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
        return "MAVLINK_MSG_ID_LOG_ENTRY - time_utc:" + this.time_utc + " size:" + this.size + " id:" + this.f8179id + " num_logs:" + this.num_logs + " last_log_num:" + this.last_log_num + "";
    }
}
