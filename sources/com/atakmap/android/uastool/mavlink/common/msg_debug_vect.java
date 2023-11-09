package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_debug_vect extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DEBUG_VECT = 250;
    public static final int MAVLINK_MSG_ID_DEBUG_VECT_CRC = 49;
    public static final int MAVLINK_MSG_LENGTH = 30;
    private static final long serialVersionUID = 250;
    public byte[] name = new byte[10];
    public long time_usec;

    /* renamed from: x */
    public float f8263x;

    /* renamed from: y */
    public float f8264y;

    /* renamed from: z */
    public float f8265z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(30);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 250;
        mAVLinkPacket.crc_extra = 49;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.f8263x);
        mAVLinkPacket.payload.putFloat(this.f8264y);
        mAVLinkPacket.payload.putFloat(this.f8265z);
        for (byte putByte : this.name) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.f8263x = mAVLinkPayload.getFloat();
        this.f8264y = mAVLinkPayload.getFloat();
        this.f8265z = mAVLinkPayload.getFloat();
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

    public msg_debug_vect() {
        this.msgid = 250;
    }

    public msg_debug_vect(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 250;
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
        return "MAVLINK_MSG_ID_DEBUG_VECT - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " x:" + this.f8263x + " y:" + this.f8264y + " z:" + this.f8265z + " name:" + this.name + "";
    }
}
