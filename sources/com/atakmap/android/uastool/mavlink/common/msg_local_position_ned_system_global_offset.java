package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_local_position_ned_system_global_offset extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET = 89;
    public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET_CRC = 231;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 89;
    public float pitch;
    public float roll;
    public long time_boot_ms;

    /* renamed from: x */
    public float f8309x;

    /* renamed from: y */
    public float f8310y;
    public float yaw;

    /* renamed from: z */
    public float f8311z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(28);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 89;
        mAVLinkPacket.crc_extra = 231;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.f8309x);
        mAVLinkPacket.payload.putFloat(this.f8310y);
        mAVLinkPacket.payload.putFloat(this.f8311z);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.f8309x = mAVLinkPayload.getFloat();
        this.f8310y = mAVLinkPayload.getFloat();
        this.f8311z = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " x:" + this.f8309x + " y:" + this.f8310y + " z:" + this.f8311z + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + "";
    }
}
