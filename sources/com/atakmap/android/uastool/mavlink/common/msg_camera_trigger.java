package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_camera_trigger extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CAMERA_TRIGGER = 112;
    public static final int MAVLINK_MSG_ID_CAMERA_TRIGGER_CRC = 174;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 112;
    public long seq;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 112;
        mAVLinkPacket.crc_extra = 174;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putUnsignedInt(this.seq);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.seq = mAVLinkPayload.getUnsignedInt();
    }

    public msg_camera_trigger() {
        this.msgid = 112;
    }

    public msg_camera_trigger(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 112;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_TRIGGER - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " seq:" + this.seq + "";
    }
}
