package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_item_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_INT = 73;
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_INT_CRC = 38;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 73;
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
    public int f8322x;

    /* renamed from: y */
    public int f8323y;

    /* renamed from: z */
    public float f8324z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(37);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 73;
        mAVLinkPacket.crc_extra = 38;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putInt(this.f8322x);
        mAVLinkPacket.payload.putInt(this.f8323y);
        mAVLinkPacket.payload.putFloat(this.f8324z);
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
        this.f8322x = mAVLinkPayload.getInt();
        this.f8323y = mAVLinkPayload.getInt();
        this.f8324z = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getUnsignedShort();
        this.command = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.frame = mAVLinkPayload.getUnsignedByte();
        this.current = mAVLinkPayload.getUnsignedByte();
        this.autocontinue = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mission_item_int() {
        this.msgid = 73;
    }

    public msg_mission_item_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 73;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM_INT - sysid:" + this.sysid + " compid:" + this.compid + " param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8322x + " y:" + this.f8323y + " z:" + this.f8324z + " seq:" + this.seq + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
