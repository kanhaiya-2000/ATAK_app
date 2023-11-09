package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_heartbeat extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HEARTBEAT = 0;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 0;
    public byte autopilot;
    public byte base_mode;
    public int custom_mode;
    public byte mavlink_version;
    public byte system_status;
    public byte type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 9;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 0;
        mAVLinkPacket.payload.putInt(this.custom_mode);
        mAVLinkPacket.payload.putByte(this.type);
        mAVLinkPacket.payload.putByte(this.autopilot);
        mAVLinkPacket.payload.putByte(this.base_mode);
        mAVLinkPacket.payload.putByte(this.system_status);
        mAVLinkPacket.payload.putByte(this.mavlink_version);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.custom_mode = mAVLinkPayload.getInt();
        this.type = mAVLinkPayload.getByte();
        this.autopilot = mAVLinkPayload.getByte();
        this.base_mode = mAVLinkPayload.getByte();
        this.system_status = mAVLinkPayload.getByte();
        this.mavlink_version = mAVLinkPayload.getByte();
    }

    public msg_heartbeat() {
        this.msgid = 0;
    }

    public msg_heartbeat(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 0;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HEARTBEAT - 用户自定义模式:" + this.custom_mode + " 飞行器类型:" + this.autopilot + " 系统当前模式:" + this.base_mode + " 系统状态:" + this.system_status + " mavlink_version:" + this.mavlink_version + "";
    }
}
