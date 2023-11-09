package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_named_value_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_NAMED_VALUE_INT = 252;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 252;
    public byte[] name = new byte[10];
    public int time_boot_ms;
    public int value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 252;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putInt(this.value);
        for (byte putByte : this.name) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.value = mAVLinkPayload.getInt();
        int i = 0;
        while (true) {
            byte[] bArr = this.name;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_named_value_int() {
        this.msgid = 252;
    }

    public msg_named_value_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 252;
        unpack(mAVLinkPacket.payload);
    }

    public void setName(String str) {
        int min = Math.min(str.length(), 10);
        for (int i = 0; i < min; i++) {
            this.name[i] = (byte) str.charAt(i);
        }
        while (min < 10) {
            this.name[min] = 0;
            min++;
        }
    }

    public String getName() {
        String str = "";
        int i = 0;
        while (i < 10 && this.name[i] != 0) {
            str = str + ((char) this.name[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_INT - time_boot_ms:" + this.time_boot_ms + " value:" + this.value + " name:" + this.name + "";
    }
}
