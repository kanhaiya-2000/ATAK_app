package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_auth_key extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AUTH_KEY = 7;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = 7;
    public byte[] key = new byte[32];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 32;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 7;
        for (byte putByte : this.key) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        int i = 0;
        while (true) {
            byte[] bArr = this.key;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_auth_key() {
        this.msgid = 7;
    }

    public msg_auth_key(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 7;
        unpack(mAVLinkPacket.payload);
    }

    public void setKey(String str) {
        int min = Math.min(str.length(), 32);
        for (int i = 0; i < min; i++) {
            this.key[i] = (byte) str.charAt(i);
        }
        while (min < 32) {
            this.key[min] = 0;
            min++;
        }
    }

    public String getKey() {
        String str = "";
        int i = 0;
        while (i < 32 && this.key[i] != 0) {
            str = str + ((char) this.key[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AUTH_KEY - key:" + this.key + "";
    }
}
