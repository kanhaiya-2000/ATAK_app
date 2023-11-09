package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gopro_set_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GOPRO_SET_REQUEST = 218;
    public static final int MAVLINK_MSG_ID_GOPRO_SET_REQUEST_CRC = 17;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = 218;
    public short cmd_id;
    public short target_component;
    public short target_system;
    public short[] value = new short[4];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(7);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
        mAVLinkPacket.crc_extra = 17;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.cmd_id);
        for (short putUnsignedByte : this.value) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.cmd_id = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.value;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_gopro_set_request() {
        this.msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
    }

    public msg_gopro_set_request(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GOPRO_SET_REQUEST - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " target_component:" + this.target_component + " cmd_id:" + this.cmd_id + " value:" + this.value + "";
    }
}
