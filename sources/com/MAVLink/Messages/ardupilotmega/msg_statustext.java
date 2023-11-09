package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_statustext extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_STATUSTEXT = 253;
    public static final int MAVLINK_MSG_LENGTH = 51;
    private static final long serialVersionUID = 253;
    public byte severity;
    public byte[] text = new byte[50];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 51;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 253;
        mAVLinkPacket.payload.putByte(this.severity);
        for (byte putByte : this.text) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.severity = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.text;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_statustext() {
        this.msgid = 253;
    }

    public msg_statustext(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 253;
        unpack(mAVLinkPacket.payload);
    }

    public void setText(String str) {
        int min = Math.min(str.length(), 50);
        for (int i = 0; i < min; i++) {
            this.text[i] = (byte) str.charAt(i);
        }
        while (min < 50) {
            this.text[min] = 0;
            min++;
        }
    }

    public String getText() {
        String str = "";
        int i = 0;
        while (i < 50 && this.text[i] != 0) {
            str = str + ((char) this.text[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_STATUSTEXT - severity:" + this.severity + " text:" + this.text + "";
    }
}
