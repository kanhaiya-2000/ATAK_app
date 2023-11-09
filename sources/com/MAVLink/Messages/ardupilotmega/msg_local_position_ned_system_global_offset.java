package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned_system_global_offset extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET = 89;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 89;
    public float pitch;
    public float roll;
    public int time_boot_ms;

    /* renamed from: x */
    public float f8172x;

    /* renamed from: y */
    public float f8173y;
    public float yaw;

    /* renamed from: z */
    public float f8174z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 89;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8172x);
        mAVLinkPacket.payload.putFloat(this.f8173y);
        mAVLinkPacket.payload.putFloat(this.f8174z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.f8172x = mAVLinkPayload.getFloat();
        this.f8173y = mAVLinkPayload.getFloat();
        this.f8174z = mAVLinkPayload.getFloat();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
    }

    public msg_local_position_ned_system_global_offset() {
        this.msgid = 89;
    }

    public msg_local_position_ned_system_global_offset(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 89;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET - time_boot_ms:" + this.time_boot_ms + " x:" + this.f8172x + " y:" + this.f8173y + " z:" + this.f8174z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
