package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_item extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM = 39;
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_CRC = 254;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 39;
    public short autocontinue;
    public int command;
    public short current;
    public short frame;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public int seq;
    public short target_component;
    public short target_system;

    /* renamed from: x */
    public float f8319x;

    /* renamed from: y */
    public float f8320y;

    /* renamed from: z */
    public float f8321z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(37);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 39;
        mAVLinkPacket.crc_extra = 254;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putFloat(this.f8319x);
        mAVLinkPacket.payload.putFloat(this.f8320y);
        mAVLinkPacket.payload.putFloat(this.f8321z);
        mAVLinkPacket.payload.putUnsignedShort(this.seq);
        mAVLinkPacket.payload.putUnsignedShort(this.command);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.frame);
        mAVLinkPacket.payload.putUnsignedByte(this.current);
        mAVLinkPacket.payload.putUnsignedByte(this.autocontinue);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param1 = mAVLinkPayload.getFloat();
        this.param2 = mAVLinkPayload.getFloat();
        this.param3 = mAVLinkPayload.getFloat();
        this.param4 = mAVLinkPayload.getFloat();
        this.f8319x = mAVLinkPayload.getFloat();
        this.f8320y = mAVLinkPayload.getFloat();
        this.f8321z = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getUnsignedShort();
        this.command = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.frame = mAVLinkPayload.getUnsignedByte();
        this.current = mAVLinkPayload.getUnsignedByte();
        this.autocontinue = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_item() {
        this.msgid = 39;
    }

    public msg_mission_item(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 39;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM - sysid:" + this.sysid + " compid:" + this.compid + " param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8319x + " y:" + this.f8320y + " z:" + this.f8321z + " seq:" + this.seq + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
