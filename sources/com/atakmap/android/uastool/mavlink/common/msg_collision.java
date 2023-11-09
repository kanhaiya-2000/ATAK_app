package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_collision extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COLLISION = 247;
    public static final int MAVLINK_MSG_ID_COLLISION_CRC = 81;
    public static final int MAVLINK_MSG_LENGTH = 19;
    private static final long serialVersionUID = 247;
    public short action;
    public float altitude_minimum_delta;
    public float horizontal_minimum_delta;

    /* renamed from: id */
    public long f8258id;
    public short src;
    public short threat_level;
    public float time_to_minimum_delta;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(19);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_COLLISION;
        mAVLinkPacket.crc_extra = 81;
        mAVLinkPacket.payload.putUnsignedInt(this.f8258id);
        mAVLinkPacket.payload.putFloat(this.time_to_minimum_delta);
        mAVLinkPacket.payload.putFloat(this.altitude_minimum_delta);
        mAVLinkPacket.payload.putFloat(this.horizontal_minimum_delta);
        mAVLinkPacket.payload.putUnsignedByte(this.src);
        mAVLinkPacket.payload.putUnsignedByte(this.action);
        mAVLinkPacket.payload.putUnsignedByte(this.threat_level);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8258id = mAVLinkPayload.getUnsignedInt();
        this.time_to_minimum_delta = mAVLinkPayload.getFloat();
        this.altitude_minimum_delta = mAVLinkPayload.getFloat();
        this.horizontal_minimum_delta = mAVLinkPayload.getFloat();
        this.src = mAVLinkPayload.getUnsignedByte();
        this.action = mAVLinkPayload.getUnsignedByte();
        this.threat_level = mAVLinkPayload.getUnsignedByte();
    }

    public msg_collision() {
        this.msgid = MAVLINK_MSG_ID_COLLISION;
    }

    public msg_collision(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_COLLISION;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COLLISION - sysid:" + this.sysid + " compid:" + this.compid + " id:" + this.f8258id + " time_to_minimum_delta:" + this.time_to_minimum_delta + " altitude_minimum_delta:" + this.altitude_minimum_delta + " horizontal_minimum_delta:" + this.horizontal_minimum_delta + " src:" + this.src + " action:" + this.action + " threat_level:" + this.threat_level + "";
    }
}
