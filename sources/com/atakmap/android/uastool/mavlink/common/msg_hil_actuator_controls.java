package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_actuator_controls extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS = 93;
    public static final int MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS_CRC = 47;
    public static final int MAVLINK_MSG_LENGTH = 81;
    private static final long serialVersionUID = 93;
    public float[] controls = new float[16];
    public long flags;
    public short mode;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(81);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 93;
        mAVLinkPacket.crc_extra = 47;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putUnsignedLong(this.flags);
        for (float putFloat : this.controls) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.mode);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.flags = mAVLinkPayload.getUnsignedLong();
        int i = 0;
        while (true) {
            float[] fArr = this.controls;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.mode = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_hil_actuator_controls() {
        this.msgid = 93;
    }

    public msg_hil_actuator_controls(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 93;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " flags:" + this.flags + " controls:" + this.controls + " mode:" + this.mode + "";
    }
}
