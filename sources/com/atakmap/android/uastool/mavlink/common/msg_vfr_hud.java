package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_vfr_hud extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_VFR_HUD = 74;
    public static final int MAVLINK_MSG_ID_VFR_HUD_CRC = 20;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 74;
    public float airspeed;
    public float alt;
    public float climb;
    public float groundspeed;
    public short heading;
    public int throttle;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(20);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 74;
        mAVLinkPacket.crc_extra = 20;
        mAVLinkPacket.payload.putFloat(this.airspeed);
        mAVLinkPacket.payload.putFloat(this.groundspeed);
        mAVLinkPacket.payload.putFloat(this.alt);
        mAVLinkPacket.payload.putFloat(this.climb);
        mAVLinkPacket.payload.putShort(this.heading);
        mAVLinkPacket.payload.putUnsignedShort(this.throttle);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.airspeed = mAVLinkPayload.getFloat();
        this.groundspeed = mAVLinkPayload.getFloat();
        this.alt = mAVLinkPayload.getFloat();
        this.climb = mAVLinkPayload.getFloat();
        this.heading = mAVLinkPayload.getShort();
        this.throttle = mAVLinkPayload.getUnsignedShort();
    }

    public msg_vfr_hud() {
        this.msgid = 74;
    }

    public msg_vfr_hud(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 74;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VFR_HUD - sysid:" + this.sysid + " compid:" + this.compid + " airspeed:" + this.airspeed + " groundspeed:" + this.groundspeed + " alt:" + this.alt + " climb:" + this.climb + " heading:" + this.heading + " throttle:" + this.throttle + "";
    }
}
