package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_fence_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FENCE_STATUS = 162;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 162;
    public short breach_count;
    public byte breach_status;
    public int breach_time;
    public byte breach_type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 8;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 162;
        mAVLinkPacket.payload.putInt(this.breach_time);
        mAVLinkPacket.payload.putShort(this.breach_count);
        mAVLinkPacket.payload.putByte(this.breach_status);
        mAVLinkPacket.payload.putByte(this.breach_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.breach_time = mAVLinkPayload.getInt();
        this.breach_count = mAVLinkPayload.getShort();
        this.breach_status = mAVLinkPayload.getByte();
        this.breach_type = mAVLinkPayload.getByte();
    }

    public msg_fence_status() {
        this.msgid = 162;
    }

    public msg_fence_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 162;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_STATUS - breach_time:" + this.breach_time + " breach_count:" + this.breach_count + " breach_status:" + this.breach_status + " breach_type:" + this.breach_type + "";
    }
}
