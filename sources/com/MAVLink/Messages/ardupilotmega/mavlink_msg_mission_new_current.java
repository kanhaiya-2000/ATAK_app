package com.MAVLink.Messages.ardupilotmega;

import android.util.Log;
import com.MAVLink.BytesUtil;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class mavlink_msg_mission_new_current extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_ITEM = 221;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 221;
    public int hotpoint_lat;
    public int hotpoint_lng;
    public float radius;
    public short seq;
    public float velocity_sp;
    public byte wp_mode;
    public byte yaw_centered;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 0;
        mAVLinkPacket.msgid = 221;
        mAVLinkPacket.payload.putFloat(this.velocity_sp);
        mAVLinkPacket.payload.putInt(this.hotpoint_lat);
        mAVLinkPacket.payload.putInt(this.hotpoint_lng);
        mAVLinkPacket.payload.putFloat(this.radius);
        mAVLinkPacket.payload.putShort(this.seq);
        mAVLinkPacket.payload.putByte(this.wp_mode);
        mAVLinkPacket.payload.putByte(this.yaw_centered);
        Log.e("favorpoint", BytesUtil.byte2hex(mAVLinkPacket.encodePacket()));
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.velocity_sp = mAVLinkPayload.getFloat();
        this.hotpoint_lat = mAVLinkPayload.getInt();
        this.hotpoint_lng = mAVLinkPayload.getInt();
        this.radius = mAVLinkPayload.getFloat();
        this.seq = mAVLinkPayload.getShort();
        this.wp_mode = mAVLinkPayload.getByte();
        this.yaw_centered = mAVLinkPayload.getByte();
    }

    public mavlink_msg_mission_new_current() {
        this.msgid = 221;
    }

    public mavlink_msg_mission_new_current(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 221;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM - velocity_sp:" + this.velocity_sp + " seq:" + this.seq + " wp_mode:" + this.wp_mode + " yaw_centered:" + this.yaw_centered + "";
    }
}
