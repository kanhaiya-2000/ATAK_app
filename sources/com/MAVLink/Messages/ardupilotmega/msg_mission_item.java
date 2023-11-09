package com.MAVLink.Messages.ardupilotmega;

import android.util.Log;
import com.MAVLink.BytesUtil;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;
import com.atakmap.android.uastool.PD100.UasC2Event;

public class msg_mission_item extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM = 39;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 39;
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
    public float f8185x;

    /* renamed from: y */
    public float f8186y;

    /* renamed from: z */
    public float f8187z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 37;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 0;
        mAVLinkPacket.msgid = 39;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putFloat(this.f8185x);
        mAVLinkPacket.payload.putFloat(this.f8186y);
        mAVLinkPacket.payload.putFloat(this.f8187z);
        mAVLinkPacket.payload.putShort(this.seq);
        mAVLinkPacket.payload.putShort(this.command);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.frame);
        mAVLinkPacket.payload.putByte(this.current);
        mAVLinkPacket.payload.putByte(this.autocontinue);
        Log.e(UasC2Event.WaypointDetail.detailName, BytesUtil.byte2hex(mAVLinkPacket.encodePacket()));
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param1 = mAVLinkPayload.getFloat();
        this.param2 = mAVLinkPayload.getFloat();
        this.param3 = mAVLinkPayload.getFloat();
        this.param4 = mAVLinkPayload.getFloat();
        this.f8185x = mAVLinkPayload.getFloat();
        this.f8186y = mAVLinkPayload.getFloat();
        this.f8187z = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getShort();
        this.command = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.frame = mAVLinkPayload.getByte();
        this.current = mAVLinkPayload.getByte();
        this.autocontinue = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_MISSION_ITEM - param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " x:" + this.f8185x + " y:" + this.f8186y + " z:" + this.f8187z + " seq:" + this.seq + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " frame:" + this.frame + " current:" + this.current + " autocontinue:" + this.autocontinue + "";
    }
}
