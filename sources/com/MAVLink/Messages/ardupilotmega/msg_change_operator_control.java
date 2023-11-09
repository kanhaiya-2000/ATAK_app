package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_change_operator_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL = 5;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 5;
    public byte control_request;
    public byte[] passkey = new byte[25];
    public byte target_system;
    public byte version;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 28;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 5;
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.control_request);
        mAVLinkPacket.payload.putByte(this.version);
        for (byte putByte : this.passkey) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getByte();
        this.control_request = mAVLinkPayload.getByte();
        this.version = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.passkey;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_change_operator_control() {
        this.msgid = 5;
    }

    public msg_change_operator_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 5;
        unpack(mAVLinkPacket.payload);
    }

    public void setPasskey(String str) {
        int min = Math.min(str.length(), 25);
        for (int i = 0; i < min; i++) {
            this.passkey[i] = (byte) str.charAt(i);
        }
        while (min < 25) {
            this.passkey[min] = 0;
            min++;
        }
    }

    public String getPasskey() {
        String str = "";
        int i = 0;
        while (i < 25 && this.passkey[i] != 0) {
            str = str + ((char) this.passkey[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL - target_system:" + this.target_system + " control_request:" + this.control_request + " version:" + this.version + " passkey:" + this.passkey + "";
    }
}
