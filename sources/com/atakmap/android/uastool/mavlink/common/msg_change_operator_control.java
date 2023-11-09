package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_change_operator_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL = 5;
    public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_CRC = 217;
    public static final int MAVLINK_MSG_LENGTH = 28;
    private static final long serialVersionUID = 5;
    public short control_request;
    public byte[] passkey = new byte[25];
    public short target_system;
    public short version;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(28);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 5;
        mAVLinkPacket.crc_extra = 217;
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.control_request);
        mAVLinkPacket.payload.putUnsignedByte(this.version);
        for (byte putByte : this.passkey) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.control_request = mAVLinkPayload.getUnsignedByte();
        this.version = mAVLinkPayload.getUnsignedByte();
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 25; i++) {
            byte[] bArr = this.passkey;
            if (bArr[i] == 0) {
                break;
            }
            stringBuffer.append((char) bArr[i]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " target_system:" + this.target_system + " control_request:" + this.control_request + " version:" + this.version + " passkey:" + this.passkey + "";
    }
}
