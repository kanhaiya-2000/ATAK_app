package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_deepstall extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DEEPSTALL = 195;
    public static final int MAVLINK_MSG_ID_DEEPSTALL_CRC = 120;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 195;
    public float altitude;
    public int arc_entry_lat;
    public int arc_entry_lon;
    public float cross_track_error;
    public float expected_travel_distance;
    public int landing_lat;
    public int landing_lon;
    public int path_lat;
    public int path_lon;
    public short stage;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(37);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 195;
        mAVLinkPacket.crc_extra = 120;
        mAVLinkPacket.payload.putInt(this.landing_lat);
        mAVLinkPacket.payload.putInt(this.landing_lon);
        mAVLinkPacket.payload.putInt(this.path_lat);
        mAVLinkPacket.payload.putInt(this.path_lon);
        mAVLinkPacket.payload.putInt(this.arc_entry_lat);
        mAVLinkPacket.payload.putInt(this.arc_entry_lon);
        mAVLinkPacket.payload.putFloat(this.altitude);
        mAVLinkPacket.payload.putFloat(this.expected_travel_distance);
        mAVLinkPacket.payload.putFloat(this.cross_track_error);
        mAVLinkPacket.payload.putUnsignedByte(this.stage);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.landing_lat = mAVLinkPayload.getInt();
        this.landing_lon = mAVLinkPayload.getInt();
        this.path_lat = mAVLinkPayload.getInt();
        this.path_lon = mAVLinkPayload.getInt();
        this.arc_entry_lat = mAVLinkPayload.getInt();
        this.arc_entry_lon = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getFloat();
        this.expected_travel_distance = mAVLinkPayload.getFloat();
        this.cross_track_error = mAVLinkPayload.getFloat();
        this.stage = mAVLinkPayload.getUnsignedByte();
    }

    public msg_deepstall() {
        this.msgid = 195;
    }

    public msg_deepstall(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 195;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DEEPSTALL - sysid:" + this.sysid + " compid:" + this.compid + " landing_lat:" + this.landing_lat + " landing_lon:" + this.landing_lon + " path_lat:" + this.path_lat + " path_lon:" + this.path_lon + " arc_entry_lat:" + this.arc_entry_lat + " arc_entry_lon:" + this.arc_entry_lon + " altitude:" + this.altitude + " expected_travel_distance:" + this.expected_travel_distance + " cross_track_error:" + this.cross_track_error + " stage:" + this.stage + "";
    }
}
