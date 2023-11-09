package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_fence_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FENCE_STATUS = 162;
    public static final int MAVLINK_MSG_ID_FENCE_STATUS_CRC = 189;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 162;
    public int breach_count;
    public short breach_status;
    public long breach_time;
    public short breach_type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 162;
        mAVLinkPacket.crc_extra = 189;
        mAVLinkPacket.payload.putUnsignedInt(this.breach_time);
        mAVLinkPacket.payload.putUnsignedShort(this.breach_count);
        mAVLinkPacket.payload.putUnsignedByte(this.breach_status);
        mAVLinkPacket.payload.putUnsignedByte(this.breach_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.breach_time = mAVLinkPayload.getUnsignedInt();
        this.breach_count = mAVLinkPayload.getUnsignedShort();
        this.breach_status = mAVLinkPayload.getUnsignedByte();
        this.breach_type = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_FENCE_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " breach_time:" + this.breach_time + " breach_count:" + this.breach_count + " breach_status:" + this.breach_status + " breach_type:" + this.breach_type + "";
    }
}
