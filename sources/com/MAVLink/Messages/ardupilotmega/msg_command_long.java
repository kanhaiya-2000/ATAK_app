package com.MAVLink.Messages.ardupilotmega;

import android.util.Log;
import com.MAVLink.BytesUtil;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;
import com.atakmap.android.uastool.flightlog.FlightLogger;

public class msg_command_long extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COMMAND_LONG = 76;
    public static final int MAVLINK_MSG_LENGTH = 33;
    private static final long serialVersionUID = 76;
    public short command;
    public byte confirmation;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public float param5;
    public float param6;
    public float param7;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 33;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 0;
        mAVLinkPacket.msgid = 76;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putFloat(this.param5);
        mAVLinkPacket.payload.putFloat(this.param6);
        mAVLinkPacket.payload.putFloat(this.param7);
        mAVLinkPacket.payload.putShort(this.command);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.confirmation);
        Log.e(FlightLogger.LOCS_COMMAND, BytesUtil.byte2hex(mAVLinkPacket.encodePacket()));
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param1 = mAVLinkPayload.getFloat();
        this.param2 = mAVLinkPayload.getFloat();
        this.param3 = mAVLinkPayload.getFloat();
        this.param4 = mAVLinkPayload.getFloat();
        this.param5 = mAVLinkPayload.getFloat();
        this.param6 = mAVLinkPayload.getFloat();
        this.param7 = mAVLinkPayload.getFloat();
        this.command = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.confirmation = mAVLinkPayload.getByte();
    }

    public msg_command_long() {
        this.msgid = 76;
    }

    public msg_command_long(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 76;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_LONG - param1:" + this.param1 + " param2:" + this.param2 + " param3:" + this.param3 + " param4:" + this.param4 + " param5:" + this.param5 + " param6:" + this.param6 + " param7:" + this.param7 + " command:" + this.command + " target_system:" + this.target_system + " target_component:" + this.target_component + " confirmation:" + this.confirmation + "";
    }
}
