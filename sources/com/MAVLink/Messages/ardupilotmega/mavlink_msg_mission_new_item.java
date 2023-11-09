package com.MAVLink.Messages.ardupilotmega;

import android.util.Log;
import com.MAVLink.BytesUtil;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class mavlink_msg_mission_new_item extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM = 222;
    public static final int MAVLINK_MSG_LENGTH = 41;
    private static final long serialVersionUID = 222;
    public byte autocontinue;
    public short command;
    public byte current;
    public byte frame;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public short param5;
    public short param6;
    public short seq;
    public byte target_component;
    public byte target_system;

    /* renamed from: x */
    public float f8114x;

    /* renamed from: y */
    public float f8115y;

    /* renamed from: z */
    public float f8116z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 41;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 0;
        mAVLinkPacket.msgid = 222;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putFloat(this.f8114x);
        mAVLinkPacket.payload.putFloat(this.f8115y);
        mAVLinkPacket.payload.putFloat(this.f8116z);
        mAVLinkPacket.payload.putShort(this.seq);
        mAVLinkPacket.payload.putShort(this.command);
        mAVLinkPacket.payload.putShort(this.param5);
        mAVLinkPacket.payload.putShort(this.param6);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.frame);
        mAVLinkPacket.payload.putByte(this.current);
        mAVLinkPacket.payload.putByte(this.autocontinue);
        Log.e("Autelorbit", BytesUtil.byte2hex(mAVLinkPacket.encodePacket()));
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param1 = mAVLinkPayload.getFloat();
        this.param2 = mAVLinkPayload.getFloat();
        this.param3 = mAVLinkPayload.getFloat();
        this.param4 = mAVLinkPayload.getFloat();
        this.f8114x = mAVLinkPayload.getFloat();
        this.f8115y = mAVLinkPayload.getFloat();
        this.f8116z = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getShort();
        this.command = mAVLinkPayload.getShort();
        this.param5 = mAVLinkPayload.getShort();
        this.param6 = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.frame = mAVLinkPayload.getByte();
        this.current = mAVLinkPayload.getByte();
        this.autocontinue = mAVLinkPayload.getByte();
    }

    public mavlink_msg_mission_new_item() {
        this.msgid = 222;
    }

    public mavlink_msg_mission_new_item(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 222;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM - param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8114x + " y:" + this.f8115y + " z:" + this.f8116z + " seq:" + this.seq + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
