package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_mission_item_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM_INT = 73;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 73;
    public byte autocontinue;
    public short command;
    public byte current;
    public byte frame;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public short seq;
    public byte target_component;
    public byte target_system;

    /* renamed from: x */
    public int f8188x;

    /* renamed from: y */
    public int f8189y;

    /* renamed from: z */
    public float f8190z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 37;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 73;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putInt(this.f8188x);
        mAVLinkPacket.payload.putInt(this.f8189y);
        mAVLinkPacket.payload.putFloat(this.f8190z);
        mAVLinkPacket.payload.putShort(this.seq);
        mAVLinkPacket.payload.putShort(this.command);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.frame);
        mAVLinkPacket.payload.putByte(this.current);
        mAVLinkPacket.payload.putByte(this.autocontinue);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param1 = mAVLinkPayload.getFloat();
        this.param2 = mAVLinkPayload.getFloat();
        this.param3 = mAVLinkPayload.getFloat();
        this.param4 = mAVLinkPayload.getFloat();
        this.f8188x = mAVLinkPayload.getInt();
        this.f8189y = mAVLinkPayload.getInt();
        this.f8190z = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getShort();
        this.command = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.frame = mAVLinkPayload.getByte();
        this.current = mAVLinkPayload.getByte();
        this.autocontinue = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_MISSION_ITEM_INT - param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8188x + " y:" + this.f8189y + " z:" + this.f8190z + " seq:" + this.seq + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
