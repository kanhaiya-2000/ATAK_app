package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_named_value_float extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 251;
    public byte[] name = new byte[10];
    public int time_boot_ms;
    public float value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 18;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 251;
        mAVLinkPacket.payload.putInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.value);
        for (byte putByte : this.name) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getInt();
        this.value = mAVLinkPayload.getFloat();
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

    public msg_named_value_float() {
        this.msgid = 251;
    }

    public msg_named_value_float(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 251;
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
        return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT - time_boot_ms:" + this.time_boot_ms + " value:" + this.value + " name:" + this.name + "";
    }
}
