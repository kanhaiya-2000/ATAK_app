package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_nav_followme extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_NAV_FOLLOWME = 220;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 220;
    public float alt;
    public short angler;
    public short eph;
    public short epv;
    public float lat;
    public float lon;
    public short vel;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 220;
        mAVLinkPacket.payload.putFloat(this.lat);
        mAVLinkPacket.payload.putFloat(this.lon);
        mAVLinkPacket.payload.putFloat(this.alt);
        mAVLinkPacket.payload.putShort(this.eph);
        mAVLinkPacket.payload.putShort(this.epv);
        mAVLinkPacket.payload.putShort(this.angler);
        mAVLinkPacket.payload.putShort(this.vel);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getFloat();
        this.lon = mAVLinkPayload.getFloat();
        this.alt = mAVLinkPayload.getFloat();
        this.eph = mAVLinkPayload.getShort();
        this.epv = mAVLinkPayload.getShort();
        this.angler = mAVLinkPayload.getShort();
        this.vel = mAVLinkPayload.getShort();
    }

    public msg_nav_followme() {
        this.msgid = 220;
    }

    public msg_nav_followme(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 220;
        unpack(mAVLinkPacket.payload);
    }
}
