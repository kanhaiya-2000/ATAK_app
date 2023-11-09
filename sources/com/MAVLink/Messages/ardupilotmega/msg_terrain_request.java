package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_terrain_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_TERRAIN_REQUEST = 133;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 133;
    public short grid_spacing;
    public int lat;
    public int lon;
    public long mask;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 133;
        mAVLinkPacket.payload.putLong(this.mask);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putShort(this.grid_spacing);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.mask = mAVLinkPayload.getLong();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.grid_spacing = mAVLinkPayload.getShort();
    }

    public msg_terrain_request() {
        this.msgid = 133;
    }

    public msg_terrain_request(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 133;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_REQUEST - mask:" + this.mask + " latitude:" + this.lat + " lon:" + this.lon + " grid_spacing:" + this.grid_spacing + "";
    }
}
