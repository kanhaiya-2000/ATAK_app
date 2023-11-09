package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_named_value_float extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;
    public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT_CRC = 170;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = 251;
    public byte[] name = new byte[10];
    public long time_boot_ms;
    public float value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(18);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 251;
        mAVLinkPacket.crc_extra = 170;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
        mAVLinkPacket.payload.putFloat(this.value);
        for (byte putByte : this.name) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            byte[] bArr = this.name;
            if (bArr[i] == 0) {
                break;
            }
            stringBuffer.append((char) bArr[i]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " value:" + this.value + " name:" + this.name + "";
    }
}
