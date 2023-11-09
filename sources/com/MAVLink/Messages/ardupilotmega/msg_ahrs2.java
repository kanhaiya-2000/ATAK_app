package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_ahrs2 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AHRS2 = 178;
    public static final int MAVLINK_MSG_LENGTH = 24;
    private static final long serialVersionUID = 178;
    public float altitude;
    public int lat;
    public int lng;
    public float pitch;
    public float roll;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 24;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 178;
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
        return "MAVLINK_MSG_ID_AHRS2 - roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " altitude:" + this.altitude + " latitude:" + this.lat + " longitude:" + this.lng + "";
    }
}
