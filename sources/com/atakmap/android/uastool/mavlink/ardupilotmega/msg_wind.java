package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_wind extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_WIND = 168;
    public static final int MAVLINK_MSG_ID_WIND_CRC = 1;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 168;
    public float direction;
    public float speed;
    public float speed_z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 168;
        mAVLinkPacket.crc_extra = 1;
        mAVLinkPacket.payload.putFloat(this.direction);
        mAVLinkPacket.payload.putFloat(this.speed);
        mAVLinkPacket.payload.putFloat(this.speed_z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.direction = mAVLinkPayload.getFloat();
        this.speed = mAVLinkPayload.getFloat();
        this.speed_z = mAVLinkPayload.getFloat();
    }

    public msg_wind() {
        this.msgid = 168;
    }

    public msg_wind(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 168;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_WIND - sysid:" + this.sysid + " compid:" + this.compid + " direction:" + this.direction + " speed:" + this.speed + " speed_z:" + this.speed_z + "";
    }
}
