package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gopro_get_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GOPRO_GET_REQUEST = 216;
    public static final int MAVLINK_MSG_ID_GOPRO_GET_REQUEST_CRC = 50;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = 216;
    public short cmd_id;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(3);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 216;
        mAVLinkPacket.crc_extra = 50;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.cmd_id);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.cmd_id = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gopro_get_request() {
        this.msgid = 216;
    }

    public msg_gopro_get_request(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 216;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GOPRO_GET_REQUEST - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " cmd_id:" + this.cmd_id + "";
    }
}
