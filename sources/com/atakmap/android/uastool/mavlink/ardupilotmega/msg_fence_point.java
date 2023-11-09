package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_fence_point extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FENCE_POINT = 160;
    public static final int MAVLINK_MSG_ID_FENCE_POINT_CRC = 78;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 160;
    public short count;
    public short idx;
    public float lat;
    public float lng;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(12);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 160;
        mAVLinkPacket.crc_extra = 78;
        mAVLinkPacket.payload.putFloat(this.lat);
        mAVLinkPacket.payload.putFloat(this.lng);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.idx);
        mAVLinkPacket.payload.putUnsignedByte(this.count);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getFloat();
        this.lng = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.idx = mAVLinkPayload.getUnsignedByte();
        this.count = mAVLinkPayload.getUnsignedByte();
    }

    public msg_fence_point() {
        this.msgid = 160;
    }

    public msg_fence_point(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 160;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_POINT - sysid:" + this.sysid + " compid:" + this.compid + " lat:" + this.lat + " lng:" + this.lng + " target_system:" + this.target_system + " target_component:" + this.target_component + " idx:" + this.idx + " count:" + this.count + "";
    }
}
