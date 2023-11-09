package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_ahrs2 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AHRS2 = 178;
    public static final int MAVLINK_MSG_ID_AHRS2_CRC = 47;
    public static final int MAVLINK_MSG_LENGTH = 24;
    private static final long serialVersionUID = 178;
    public float altitude;
    public int lat;
    public int lng;
    public float pitch;
    public float roll;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(24);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 178;
        mAVLinkPacket.crc_extra = 47;
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.altitude);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.altitude = mAVLinkPayload.getFloat();
        this.lat = mAVLinkPayload.getInt();
        this.lng = mAVLinkPayload.getInt();
    }

    public msg_ahrs2() {
        this.msgid = 178;
    }

    public msg_ahrs2(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 178;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AHRS2 - sysid:" + this.sysid + " compid:" + this.compid + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " altitude:" + this.altitude + " lat:" + this.lat + " lng:" + this.lng + "";
    }
}
