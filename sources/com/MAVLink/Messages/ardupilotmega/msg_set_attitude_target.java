package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_attitude_target extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_ATTITUDE_TARGET = 82;
    public static final int MAVLINK_MSG_LENGTH = 39;
    private static final long serialVersionUID = 82;
    public float body_pitch_rate;
    public float body_roll_rate;
    public float body_yaw_rate;

    /* renamed from: q */
    public float[] f8200q = new float[4];
    public byte target_component;
    public byte target_system;
    public float thrust;
    public int time_boot_ms;
    public byte type_mask;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 39;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 82;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        for (float putFloat : this.f8200q) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.body_roll_rate);
        mAVLinkPacket.payload.putFloat(this.body_pitch_rate);
        mAVLinkPacket.payload.putFloat(this.body_yaw_rate);
        mAVLinkPacket.payload.putFloat(this.thrust);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.type_mask);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        int i = 0;
        while (true) {
            float[] fArr = this.f8200q;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.body_roll_rate = mAVLinkPayload.getFloat();
                this.body_pitch_rate = mAVLinkPayload.getFloat();
                this.body_yaw_rate = mAVLinkPayload.getFloat();
                this.thrust = mAVLinkPayload.getFloat();
                this.target_system = mAVLinkPayload.getByte();
                this.target_component = mAVLinkPayload.getByte();
                this.type_mask = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_set_attitude_target() {
        this.msgid = 82;
    }

    public msg_set_attitude_target(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 82;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_ATTITUDE_TARGET - time_boot_ms:" + this.time_boot_ms + " q:" + this.f8200q + " body_roll_rate:" + this.body_roll_rate + " body_pitch_rate:" + this.body_pitch_rate + " body_yaw_rate:" + this.body_yaw_rate + " thrust:" + this.thrust + " target_system:" + this.target_system + " target_component:" + this.target_component + " type_mask:" + this.type_mask + "";
    }
}
