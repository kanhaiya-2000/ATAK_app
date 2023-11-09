package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_actuator_control_target extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET = 139;
    public static final int MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET_CRC = 168;
    public static final int MAVLINK_MSG_LENGTH = 43;
    private static final long serialVersionUID = 139;
    public float[] controls = new float[8];
    public short group_mlx;
    public short target_component;
    public short target_system;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(43);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;
        mAVLinkPacket.crc_extra = 168;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        for (float putFloat : this.controls) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.group_mlx);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        int i = 0;
        while (true) {
            float[] fArr = this.controls;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.group_mlx = mAVLinkPayload.getUnsignedByte();
                this.target_system = mAVLinkPayload.getUnsignedByte();
                this.target_component = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_set_actuator_control_target() {
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;
    }

    public msg_set_actuator_control_target(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " controls:" + this.controls + " group_mlx:" + this.group_mlx + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
