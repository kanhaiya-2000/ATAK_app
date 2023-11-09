package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_terrain_report extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_TERRAIN_REPORT = 136;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 136;
    public float current_height;
    public int lat;
    public short loaded;
    public int lon;
    public short pending;
    public short spacing;
    public float terrain_height;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 22;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 136;
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putFloat(this.terrain_height);
        mAVLinkPacket.payload.putFloat(this.current_height);
        mAVLinkPacket.payload.putShort(this.spacing);
        mAVLinkPacket.payload.putShort(this.pending);
        mAVLinkPacket.payload.putShort(this.loaded);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.terrain_height = mAVLinkPayload.getFloat();
        this.current_height = mAVLinkPayload.getFloat();
        this.spacing = mAVLinkPayload.getShort();
        this.pending = mAVLinkPayload.getShort();
        this.loaded = mAVLinkPayload.getShort();
    }

    public msg_terrain_report() {
        this.msgid = 136;
    }

    public msg_terrain_report(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 136;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_REPORT - latitude:" + this.lat + " lon:" + this.lon + " terrain_height:" + this.terrain_height + " current_height:" + this.current_height + " spacing:" + this.spacing + " pending:" + this.pending + " loaded:" + this.loaded + "";
    }
}
