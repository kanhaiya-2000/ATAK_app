package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED = 32;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 32;
    public int time_boot_ms;

    /* renamed from: vx */
    public float f8160vx;

    /* renamed from: vy */
    public float f8161vy;

    /* renamed from: vz */
    public float f8162vz;

    /* renamed from: x */
    public float f8163x;

    /* renamed from: y */
    public float f8164y;

    /* renamed from: z */
    public float f8165z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 32;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8163x);
        mAVLinkPacket.payload.putFloat(this.f8164y);
        mAVLinkPacket.payload.putFloat(this.f8165z);
        mAVLinkPacket.payload.putFloat(this.f8160vx);
        mAVLinkPacket.payload.putFloat(this.f8161vy);
        mAVLinkPacket.payload.putFloat(this.f8162vz);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.f8163x = mAVLinkPayload.getFloat();
        this.f8164y = mAVLinkPayload.getFloat();
        this.f8165z = mAVLinkPayload.getFloat();
        this.f8160vx = mAVLinkPayload.getFloat();
        this.f8161vy = mAVLinkPayload.getFloat();
        this.f8162vz = mAVLinkPayload.getFloat();
    }

    public msg_local_position_ned() {
        this.msgid = 32;
    }

    public msg_local_position_ned(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 32;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED - time_boot_ms:" + this.time_boot_ms + " x:" + this.f8163x + " y:" + this.f8164y + " z:" + this.f8165z + " vx:" + this.f8160vx + " vy:" + this.f8161vy + " vz:" + this.f8162vz + "";
    }
}
