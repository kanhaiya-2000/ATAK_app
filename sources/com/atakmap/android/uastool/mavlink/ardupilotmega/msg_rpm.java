package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_rpm extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RPM = 226;
    public static final int MAVLINK_MSG_ID_RPM_CRC = 207;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 226;
    public float rpm1;
    public float rpm2;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 226;
        mAVLinkPacket.crc_extra = 207;
        mAVLinkPacket.payload.putFloat(this.rpm1);
        mAVLinkPacket.payload.putFloat(this.rpm2);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.rpm1 = mAVLinkPayload.getFloat();
        this.rpm2 = mAVLinkPayload.getFloat();
    }

    public msg_rpm() {
        this.msgid = 226;
    }

    public msg_rpm(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 226;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RPM - sysid:" + this.sysid + " compid:" + this.compid + " rpm1:" + this.rpm1 + " rpm2:" + this.rpm2 + "";
    }
}
