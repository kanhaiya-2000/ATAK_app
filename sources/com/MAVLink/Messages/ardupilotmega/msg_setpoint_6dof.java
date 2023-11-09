package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_setpoint_6dof extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SETPOINT_6DOF = 149;
    public static final int MAVLINK_MSG_LENGTH = 25;
    private static final long serialVersionUID = 149;
    public float rot_x;
    public float rot_y;
    public float rot_z;
    public byte target_system;
    public float trans_x;
    public float trans_y;
    public float trans_z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 25;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 149;
        mAVLinkPacket.payload.putFloat(this.trans_x);
        mAVLinkPacket.payload.putFloat(this.trans_y);
        mAVLinkPacket.payload.putFloat(this.trans_z);
        mAVLinkPacket.payload.putFloat(this.rot_x);
        mAVLinkPacket.payload.putFloat(this.rot_y);
        mAVLinkPacket.payload.putFloat(this.rot_z);
        mAVLinkPacket.payload.putByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.trans_x = mAVLinkPayload.getFloat();
        this.trans_y = mAVLinkPayload.getFloat();
        this.trans_z = mAVLinkPayload.getFloat();
        this.rot_x = mAVLinkPayload.getFloat();
        this.rot_y = mAVLinkPayload.getFloat();
        this.rot_z = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
    }

    public msg_setpoint_6dof() {
        this.msgid = 149;
    }

    public msg_setpoint_6dof(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 149;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SETPOINT_6DOF - trans_x:" + this.trans_x + " trans_y:" + this.trans_y + " trans_z:" + this.trans_z + " rot_x:" + this.rot_x + " rot_y:" + this.rot_y + " rot_z:" + this.rot_z + " target_system:" + this.target_system + "";
    }
}
