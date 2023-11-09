package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_command_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COMMAND_INT = 75;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = 75;
    public byte autocontinue;
    public short command;
    public byte current;
    public byte frame;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public byte target_component;
    public byte target_system;

    /* renamed from: x */
    public int f8131x;

    /* renamed from: y */
    public int f8132y;

    /* renamed from: z */
    public float f8133z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 35;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 75;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putInt(this.f8131x);
        mAVLinkPacket.payload.putInt(this.f8132y);
        mAVLinkPacket.payload.putFloat(this.f8133z);
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
        this.f8131x = mAVLinkPayload.getInt();
        this.f8132y = mAVLinkPayload.getInt();
        this.f8133z = mAVLinkPayload.getFloat();
        this.command = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.frame = mAVLinkPayload.getByte();
        this.current = mAVLinkPayload.getByte();
        this.autocontinue = mAVLinkPayload.getByte();
    }

    public msg_command_int() {
        this.msgid = 75;
    }

    public msg_command_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 75;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_INT - param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8131x + " y:" + this.f8132y + " z:" + this.f8133z + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
