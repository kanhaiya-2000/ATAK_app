package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_log_request_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_DATA = 119;
    public static final int MAVLINK_MSG_LENGTH = 12;
    private static final long serialVersionUID = 119;
    public int count;

    /* renamed from: id */
    public short f8180id;
    public int ofs;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 12;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 119;
        mAVLinkPacket.payload.putInt(this.ofs);
        mAVLinkPacket.payload.putInt(this.count);
        mAVLinkPacket.payload.putShort(this.f8180id);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.ofs = mAVLinkPayload.getInt();
        this.count = mAVLinkPayload.getInt();
        this.f8180id = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
    }

    public msg_log_request_data() {
        this.msgid = 119;
    }

    public msg_log_request_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 119;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_DATA - ofs:" + this.ofs + " count:" + this.count + " id:" + this.f8180id + " target_system:" + this.target_system + " target_component:" + this.target_component + "";
    }
}
