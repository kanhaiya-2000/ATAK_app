package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_file_transfer_protocol extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL = 110;
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL_CRC = 84;
    public static final int MAVLINK_MSG_LENGTH = 254;
    private static final long serialVersionUID = 110;
    public short[] payload = new short[251];
    public short target_component;
    public short target_network;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(254);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 110;
        mAVLinkPacket.crc_extra = 84;
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

    public msg_file_transfer_protocol() {
        this.msgid = 110;
    }

    public msg_file_transfer_protocol(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 110;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL - sysid:" + this.sysid + " compid:" + this.compid + " target_network:" + this.target_network + " target_system:" + this.target_system + " target_component:" + this.target_component + " payload:" + this.payload + "";
    }
}
