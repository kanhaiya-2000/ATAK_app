package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_pid_tuning extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PID_TUNING = 194;
    public static final int MAVLINK_MSG_ID_PID_TUNING_CRC = 98;
    public static final int MAVLINK_MSG_LENGTH = 25;
    private static final long serialVersionUID = 194;

    /* renamed from: D */
    public float f8243D;

    /* renamed from: FF */
    public float f8244FF;

    /* renamed from: I */
    public float f8245I;

    /* renamed from: P */
    public float f8246P;
    public float achieved;
    public short axis;
    public float desired;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(25);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 194;
        mAVLinkPacket.crc_extra = 98;
        mAVLinkPacket.payload.putFloat(this.desired);
        mAVLinkPacket.payload.putFloat(this.achieved);
        mAVLinkPacket.payload.putFloat(this.f8244FF);
        mAVLinkPacket.payload.putFloat(this.f8246P);
        mAVLinkPacket.payload.putFloat(this.f8245I);
        mAVLinkPacket.payload.putFloat(this.f8243D);
        mAVLinkPacket.payload.putUnsignedByte(this.axis);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.desired = mAVLinkPayload.getFloat();
        this.achieved = mAVLinkPayload.getFloat();
        this.f8244FF = mAVLinkPayload.getFloat();
        this.f8246P = mAVLinkPayload.getFloat();
        this.f8245I = mAVLinkPayload.getFloat();
        this.f8243D = mAVLinkPayload.getFloat();
        this.axis = mAVLinkPayload.getUnsignedByte();
    }

    public msg_pid_tuning() {
        this.msgid = 194;
    }

    public msg_pid_tuning(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 194;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PID_TUNING - sysid:" + this.sysid + " compid:" + this.compid + " desired:" + this.desired + " achieved:" + this.achieved + " FF:" + this.f8244FF + " P:" + this.f8246P + " I:" + this.f8245I + " D:" + this.f8243D + " axis:" + this.axis + "";
    }
}
