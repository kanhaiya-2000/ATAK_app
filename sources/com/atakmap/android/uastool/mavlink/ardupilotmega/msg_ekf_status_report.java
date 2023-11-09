package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_ekf_status_report extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_EKF_STATUS_REPORT = 193;
    public static final int MAVLINK_MSG_ID_EKF_STATUS_REPORT_CRC = 71;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 193;
    public float compass_variance;
    public int flags;
    public float pos_horiz_variance;
    public float pos_vert_variance;
    public float terrain_alt_variance;
    public float velocity_variance;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(22);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 193;
        mAVLinkPacket.crc_extra = 71;
        mAVLinkPacket.payload.putFloat(this.velocity_variance);
        mAVLinkPacket.payload.putFloat(this.pos_horiz_variance);
        mAVLinkPacket.payload.putFloat(this.pos_vert_variance);
        mAVLinkPacket.payload.putFloat(this.compass_variance);
        mAVLinkPacket.payload.putFloat(this.terrain_alt_variance);
        mAVLinkPacket.payload.putUnsignedShort(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.velocity_variance = mAVLinkPayload.getFloat();
        this.pos_horiz_variance = mAVLinkPayload.getFloat();
        this.pos_vert_variance = mAVLinkPayload.getFloat();
        this.compass_variance = mAVLinkPayload.getFloat();
        this.terrain_alt_variance = mAVLinkPayload.getFloat();
        this.flags = mAVLinkPayload.getUnsignedShort();
    }

    public msg_ekf_status_report() {
        this.msgid = 193;
    }

    public msg_ekf_status_report(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 193;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_EKF_STATUS_REPORT - sysid:" + this.sysid + " compid:" + this.compid + " velocity_variance:" + this.velocity_variance + " pos_horiz_variance:" + this.pos_horiz_variance + " pos_vert_variance:" + this.pos_vert_variance + " compass_variance:" + this.compass_variance + " terrain_alt_variance:" + this.terrain_alt_variance + " flags:" + this.flags + "";
    }
}
