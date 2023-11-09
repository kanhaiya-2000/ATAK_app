package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gps_inject_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS_INJECT_DATA = 123;
    public static final int MAVLINK_MSG_ID_GPS_INJECT_DATA_CRC = 250;
    public static final int MAVLINK_MSG_LENGTH = 113;
    private static final long serialVersionUID = 123;
    public short[] data = new short[110];
    public short len;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(113);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 123;
        mAVLinkPacket.crc_extra = 250;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.len);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
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

    public msg_gps_inject_data() {
        this.msgid = 123;
    }

    public msg_gps_inject_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 123;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_INJECT_DATA - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " len:" + this.len + " data:" + this.data + "";
    }
}
