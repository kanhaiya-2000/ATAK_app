package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_v2_extension extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_V2_EXTENSION = 248;
    public static final int MAVLINK_MSG_ID_V2_EXTENSION_CRC = 8;
    public static final int MAVLINK_MSG_LENGTH = 254;
    private static final long serialVersionUID = 248;
    public int message_type;
    public short[] payload = new short[249];
    public short target_component;
    public short target_network;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(254);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 248;
        mAVLinkPacket.crc_extra = 8;
        mAVLinkPacket.payload.putUnsignedShort(this.message_type);
        mAVLinkPacket.payload.putUnsignedByte(this.target_network);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        for (short putUnsignedByte : this.payload) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.message_type = mAVLinkPayload.getUnsignedShort();
        this.target_network = mAVLinkPayload.getUnsignedByte();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.payload;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_v2_extension() {
        this.msgid = 248;
    }

    public msg_v2_extension(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 248;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_V2_EXTENSION - sysid:" + this.sysid + " compid:" + this.compid + " message_type:" + this.message_type + " target_network:" + this.target_network + " target_system:" + this.target_system + " target_component:" + this.target_component + " payload:" + this.payload + "";
    }
}
