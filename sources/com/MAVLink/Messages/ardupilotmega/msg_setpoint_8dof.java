package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_setpoint_8dof extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SETPOINT_8DOF = 148;
    public static final int MAVLINK_MSG_LENGTH = 33;
    private static final long serialVersionUID = 148;
    public byte target_system;
    public float val1;
    public float val2;
    public float val3;
    public float val4;
    public float val5;
    public float val6;
    public float val7;
    public float val8;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 33;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 148;
        mAVLinkPacket.payload.putFloat(this.val1);
        mAVLinkPacket.payload.putFloat(this.val2);
        mAVLinkPacket.payload.putFloat(this.val3);
        mAVLinkPacket.payload.putFloat(this.val4);
        mAVLinkPacket.payload.putFloat(this.val5);
        mAVLinkPacket.payload.putFloat(this.val6);
        mAVLinkPacket.payload.putFloat(this.val7);
        mAVLinkPacket.payload.putFloat(this.val8);
        mAVLinkPacket.payload.putByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.val1 = mAVLinkPayload.getFloat();
        this.val2 = mAVLinkPayload.getFloat();
        this.val3 = mAVLinkPayload.getFloat();
        this.val4 = mAVLinkPayload.getFloat();
        this.val5 = mAVLinkPayload.getFloat();
        this.val6 = mAVLinkPayload.getFloat();
        this.val7 = mAVLinkPayload.getFloat();
        this.val8 = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
    }

    public msg_setpoint_8dof() {
        this.msgid = 148;
    }

    public msg_setpoint_8dof(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 148;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SETPOINT_8DOF - val1:" + this.val1 + " val2:" + this.val2 + " val3:" + this.val3 + " val4:" + this.val4 + " val5:" + this.val5 + " val6:" + this.val6 + " val7:" + this.val7 + " val8:" + this.val8 + " target_system:" + this.target_system + "";
    }
}
