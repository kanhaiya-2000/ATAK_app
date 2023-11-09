package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_ahrs3 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AHRS3 = 182;
    public static final int MAVLINK_MSG_ID_AHRS3_CRC = 229;
    public static final int MAVLINK_MSG_LENGTH = 40;
    private static final long serialVersionUID = 182;
    public float altitude;
    public int lat;
    public int lng;
    public float pitch;
    public float roll;

    /* renamed from: v1 */
    public float f8232v1;

    /* renamed from: v2 */
    public float f8233v2;

    /* renamed from: v3 */
    public float f8234v3;

    /* renamed from: v4 */
    public float f8235v4;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(40);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 182;
        mAVLinkPacket.crc_extra = 229;
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.altitude);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        mAVLinkPacket.payload.putFloat(this.f8232v1);
        mAVLinkPacket.payload.putFloat(this.f8233v2);
        mAVLinkPacket.payload.putFloat(this.f8234v3);
        mAVLinkPacket.payload.putFloat(this.f8235v4);
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
        this.f8232v1 = mAVLinkPayload.getFloat();
        this.f8233v2 = mAVLinkPayload.getFloat();
        this.f8234v3 = mAVLinkPayload.getFloat();
        this.f8235v4 = mAVLinkPayload.getFloat();
    }

    public msg_ahrs3() {
        this.msgid = 182;
    }

    public msg_ahrs3(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 182;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AHRS3 - sysid:" + this.sysid + " compid:" + this.compid + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " altitude:" + this.altitude + " lat:" + this.lat + " lng:" + this.lng + " v1:" + this.f8232v1 + " v2:" + this.f8233v2 + " v3:" + this.f8234v3 + " v4:" + this.f8235v4 + "";
    }
}
