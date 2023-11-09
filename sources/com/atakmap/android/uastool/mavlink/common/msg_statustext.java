package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_statustext extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_STATUSTEXT = 253;
    public static final int MAVLINK_MSG_ID_STATUSTEXT_CRC = 83;
    public static final int MAVLINK_MSG_LENGTH = 51;
    private static final long serialVersionUID = 253;
    public short severity;
    public byte[] text = new byte[50];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(51);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 253;
        mAVLinkPacket.crc_extra = 83;
        mAVLinkPacket.payload.putUnsignedByte(this.severity);
        for (byte putByte : this.text) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.severity = mAVLinkPayload.getUnsignedByte();
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 50; i++) {
            byte[] bArr = this.text;
            if (bArr[i] == 0) {
                break;
            }
            stringBuffer.append((char) bArr[i]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_STATUSTEXT - sysid:" + this.sysid + " compid:" + this.compid + " severity:" + this.severity + " text:" + this.text + "";
    }
}
