package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_debug_vect extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DEBUG_VECT = 250;
    public static final int MAVLINK_MSG_LENGTH = 30;
    private static final long serialVersionUID = 250;
    public byte[] name = new byte[10];
    public long time_usec;

    /* renamed from: x */
    public float f8136x;

    /* renamed from: y */
    public float f8137y;

    /* renamed from: z */
    public float f8138z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 30;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 250;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.f8136x);
        mAVLinkPacket.payload.putFloat(this.f8137y);
        mAVLinkPacket.payload.putFloat(this.f8138z);
        for (byte putByte : this.name) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.f8136x = mAVLinkPayload.getFloat();
        this.f8137y = mAVLinkPayload.getFloat();
        this.f8138z = mAVLinkPayload.getFloat();
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
        String str = "";
        int i = 0;
        while (i < 10 && this.name[i] != 0) {
            str = str + ((char) this.name[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DEBUG_VECT - time_usec:" + this.time_usec + " x:" + this.f8136x + " y:" + this.f8137y + " z:" + this.f8138z + " name:" + this.name + "";
    }
}
