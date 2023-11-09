package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gimbal_report extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GIMBAL_REPORT = 200;
    public static final int MAVLINK_MSG_ID_GIMBAL_REPORT_CRC = 134;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = 200;
    public float delta_angle_x;
    public float delta_angle_y;
    public float delta_angle_z;
    public float delta_time;
    public float delta_velocity_x;
    public float delta_velocity_y;
    public float delta_velocity_z;
    public float joint_az;
    public float joint_el;
    public float joint_roll;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(42);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 200;
        mAVLinkPacket.crc_extra = 134;
        mAVLinkPacket.payload.putFloat(this.delta_time);
        mAVLinkPacket.payload.putFloat(this.delta_angle_x);
        mAVLinkPacket.payload.putFloat(this.delta_angle_y);
        mAVLinkPacket.payload.putFloat(this.delta_angle_z);
        mAVLinkPacket.payload.putFloat(this.delta_velocity_x);
        mAVLinkPacket.payload.putFloat(this.delta_velocity_y);
        mAVLinkPacket.payload.putFloat(this.delta_velocity_z);
        mAVLinkPacket.payload.putFloat(this.joint_roll);
        mAVLinkPacket.payload.putFloat(this.joint_el);
        mAVLinkPacket.payload.putFloat(this.joint_az);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.delta_time = mAVLinkPayload.getFloat();
        this.delta_angle_x = mAVLinkPayload.getFloat();
        this.delta_angle_y = mAVLinkPayload.getFloat();
        this.delta_angle_z = mAVLinkPayload.getFloat();
        this.delta_velocity_x = mAVLinkPayload.getFloat();
        this.delta_velocity_y = mAVLinkPayload.getFloat();
        this.delta_velocity_z = mAVLinkPayload.getFloat();
        this.joint_roll = mAVLinkPayload.getFloat();
        this.joint_el = mAVLinkPayload.getFloat();
        this.joint_az = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gimbal_report() {
        this.msgid = 200;
    }

    public msg_gimbal_report(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 200;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GIMBAL_REPORT - sysid:" + this.sysid + " compid:" + this.compid + " delta_time:" + this.delta_time + " delta_angle_x:" + this.delta_angle_x + " delta_angle_y:" + this.delta_angle_y + " delta_angle_z:" + this.delta_angle_z + " delta_velocity_x:" + this.delta_velocity_x + " delta_velocity_y:" + this.delta_velocity_y + " delta_velocity_z:" + this.delta_velocity_z + " joint_roll:" + this.joint_roll + " joint_el:" + this.joint_el + " joint_az:" + this.joint_az + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
