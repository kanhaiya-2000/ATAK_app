package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_ahrs extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AHRS = 163;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 163;
    public float accel_weight;
    public float error_rp;
    public float error_yaw;
    public float omegaIx;
    public float omegaIy;
    public float omegaIz;
    public float renorm_val;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 163;
        mAVLinkPacket.payload.putFloat(this.omegaIx);
        mAVLinkPacket.payload.putFloat(this.omegaIy);
        mAVLinkPacket.payload.putFloat(this.omegaIz);
        mAVLinkPacket.payload.putFloat(this.accel_weight);
        mAVLinkPacket.payload.putFloat(this.renorm_val);
        mAVLinkPacket.payload.putFloat(this.error_rp);
        mAVLinkPacket.payload.putFloat(this.error_yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.omegaIx = mAVLinkPayload.getFloat();
        this.omegaIy = mAVLinkPayload.getFloat();
        this.omegaIz = mAVLinkPayload.getFloat();
        this.accel_weight = mAVLinkPayload.getFloat();
        this.renorm_val = mAVLinkPayload.getFloat();
        this.error_rp = mAVLinkPayload.getFloat();
        this.error_yaw = mAVLinkPayload.getFloat();
    }

    public msg_ahrs() {
        this.msgid = 163;
    }

    public msg_ahrs(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 163;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AHRS - omegaIx:" + this.omegaIx + " omegaIy:" + this.omegaIy + " omegaIz:" + this.omegaIz + " accel_weight:" + this.accel_weight + " renorm_val:" + this.renorm_val + " error_rp:" + this.error_rp + " error_yaw:" + this.error_yaw + "";
    }
}
