package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_command_ack extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COMMAND_ACK = 77;
    public static final int MAVLINK_MSG_LENGTH = 38;
    private static final long serialVersionUID = 77;
    public short command;
    public float param1;
    public float param2;
    public float param3;
    public float param4;
    public float param5;
    public float param6;
    public float param7;
    public float param8;
    public short result;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 38;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 77;
        mAVLinkPacket.payload.putFloat(this.param1);
        mAVLinkPacket.payload.putFloat(this.param2);
        mAVLinkPacket.payload.putFloat(this.param3);
        mAVLinkPacket.payload.putFloat(this.param4);
        mAVLinkPacket.payload.putFloat(this.param5);
        mAVLinkPacket.payload.putFloat(this.param6);
        mAVLinkPacket.payload.putFloat(this.param7);
        mAVLinkPacket.payload.putFloat(this.param8);
        mAVLinkPacket.payload.putShort(this.command);
        mAVLinkPacket.payload.putShort(this.result);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
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
        this.param8 = mAVLinkPayload.getFloat();
        this.command = mAVLinkPayload.getShort();
        this.result = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_command_ack() {
        this.msgid = 77;
    }

    public msg_command_ack(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 77;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_ACK - command:" + this.command + " result:" + this.result + "";
    }
}
