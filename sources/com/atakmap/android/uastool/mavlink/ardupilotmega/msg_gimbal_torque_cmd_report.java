package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gimbal_torque_cmd_report extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GIMBAL_TORQUE_CMD_REPORT = 214;
    public static final int MAVLINK_MSG_ID_GIMBAL_TORQUE_CMD_REPORT_CRC = 69;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = 214;
    public short az_torque_cmd;
    public short el_torque_cmd;
    public short rl_torque_cmd;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(8);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 214;
        mAVLinkPacket.crc_extra = 69;
        mAVLinkPacket.payload.putShort(this.rl_torque_cmd);
        mAVLinkPacket.payload.putShort(this.el_torque_cmd);
        mAVLinkPacket.payload.putShort(this.az_torque_cmd);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.rl_torque_cmd = mAVLinkPayload.getShort();
        this.el_torque_cmd = mAVLinkPayload.getShort();
        this.az_torque_cmd = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gimbal_torque_cmd_report() {
        this.msgid = 214;
    }

    public msg_gimbal_torque_cmd_report(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 214;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GIMBAL_TORQUE_CMD_REPORT - sysid:" + this.sysid + " compid:" + this.compid + " rl_torque_cmd:" + this.rl_torque_cmd + " el_torque_cmd:" + this.el_torque_cmd + " az_torque_cmd:" + this.az_torque_cmd + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
