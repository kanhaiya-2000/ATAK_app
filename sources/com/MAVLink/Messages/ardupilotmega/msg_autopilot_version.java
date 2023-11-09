package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_autopilot_version extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AUTOPILOT_VERSION = 148;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 148;
    public long capabilities;
    public byte[] custom_version = new byte[8];
    public int version;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 148;
        mAVLinkPacket.payload.putLong(this.capabilities);
        mAVLinkPacket.payload.putInt(this.version);
        for (byte putByte : this.custom_version) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.capabilities = mAVLinkPayload.getLong();
        this.version = mAVLinkPayload.getInt();
        int i = 0;
        while (true) {
            byte[] bArr = this.custom_version;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_autopilot_version() {
        this.msgid = 148;
    }

    public msg_autopilot_version(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 148;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AUTOPILOT_VERSION - capabilities:" + this.capabilities + " version:" + this.version + " custom_version:" + this.custom_version + "";
    }
}
