package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mount_orientation extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MOUNT_ORIENTATION = 265;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 265;
    public float pitch;
    public float roll;
    public long time_boot_ms;
    public float yaw;
    public float yaw_absolute;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(20);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_MOUNT_ORIENTATION;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.yaw_absolute);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.yaw_absolute = mAVLinkPayload.getFloat();
    }

    public msg_mount_orientation() {
        this.msgid = MAVLINK_MSG_ID_MOUNT_ORIENTATION;
    }

    public msg_mount_orientation(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_MOUNT_ORIENTATION;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_ORIENTATION - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " yaw_abs:" + this.yaw_absolute + "";
    }
}
