package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_manual_setpoint extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT = 81;
    public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT_CRC = 106;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 81;
    public short manual_override_switch;
    public short mode_switch;
    public float pitch;
    public float roll;
    public float thrust;
    public long time_boot_ms;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(22);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 81;
        mAVLinkPacket.crc_extra = 106;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.thrust);
        mAVLinkPacket.payload.putUnsignedByte(this.mode_switch);
        mAVLinkPacket.payload.putUnsignedByte(this.manual_override_switch);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.thrust = mAVLinkPayload.getFloat();
        this.mode_switch = mAVLinkPayload.getUnsignedByte();
        this.manual_override_switch = mAVLinkPayload.getUnsignedByte();
    }

    public msg_manual_setpoint() {
        this.msgid = 81;
    }

    public msg_manual_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 81;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MANUAL_SETPOINT - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + " mode_switch:" + this.mode_switch + " manual_override_switch:" + this.manual_override_switch + "";
    }
}
