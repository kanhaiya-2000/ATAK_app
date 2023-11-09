package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gimbal_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GIMBAL_CONTROL = 201;
    public static final int MAVLINK_MSG_ID_GIMBAL_CONTROL_CRC = 205;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 201;
    public float demanded_rate_x;
    public float demanded_rate_y;
    public float demanded_rate_z;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 201;
        mAVLinkPacket.crc_extra = 205;
        mAVLinkPacket.payload.putFloat(this.demanded_rate_x);
        mAVLinkPacket.payload.putFloat(this.demanded_rate_y);
        mAVLinkPacket.payload.putFloat(this.demanded_rate_z);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.demanded_rate_x = mAVLinkPayload.getFloat();
        this.demanded_rate_y = mAVLinkPayload.getFloat();
        this.demanded_rate_z = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gimbal_control() {
        this.msgid = 201;
    }

    public msg_gimbal_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 201;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GIMBAL_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " demanded_rate_x:" + this.demanded_rate_x + " demanded_rate_y:" + this.demanded_rate_y + " demanded_rate_z:" + this.demanded_rate_z + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
