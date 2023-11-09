package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gps_rtcm_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS_RTCM_DATA = 233;
    public static final int MAVLINK_MSG_ID_GPS_RTCM_DATA_CRC = 35;
    public static final int MAVLINK_MSG_LENGTH = 182;
    private static final long serialVersionUID = 233;
    public short[] data = new short[180];
    public short flags;
    public short len;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(182);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_GPS_RTCM_DATA;
        mAVLinkPacket.crc_extra = 35;
        mAVLinkPacket.payload.putUnsignedByte(this.flags);
        mAVLinkPacket.payload.putUnsignedByte(this.len);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.flags = mAVLinkPayload.getUnsignedByte();
        this.len = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.data;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_gps_rtcm_data() {
        this.msgid = MAVLINK_MSG_ID_GPS_RTCM_DATA;
    }

    public msg_gps_rtcm_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GPS_RTCM_DATA;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_RTCM_DATA - sysid:" + this.sysid + " compid:" + this.compid + " flags:" + this.flags + " len:" + this.len + " data:" + this.data + "";
    }
}
