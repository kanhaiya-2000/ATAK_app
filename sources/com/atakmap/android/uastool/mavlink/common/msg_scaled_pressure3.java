package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_scaled_pressure3 extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SCALED_PRESSURE3 = 143;
    public static final int MAVLINK_MSG_ID_SCALED_PRESSURE3_CRC = 131;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = 143;
    public float press_abs;
    public float press_diff;
    public short temperature;
    public long time_boot_ms;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(14);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 143;
        mAVLinkPacket.crc_extra = 131;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.press_abs);
        mAVLinkPacket.payload.putFloat(this.press_diff);
        mAVLinkPacket.payload.putShort(this.temperature);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
        this.press_abs = mAVLinkPayload.getFloat();
        this.press_diff = mAVLinkPayload.getFloat();
        this.temperature = mAVLinkPayload.getShort();
    }

    public msg_scaled_pressure3() {
        this.msgid = 143;
    }

    public msg_scaled_pressure3(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 143;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SCALED_PRESSURE3 - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " press_abs:" + this.press_abs + " press_diff:" + this.press_diff + " temperature:" + this.temperature + "";
    }
}
