package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_serial_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SERIAL_CONTROL = 126;
    public static final int MAVLINK_MSG_ID_SERIAL_CONTROL_CRC = 220;
    public static final int MAVLINK_MSG_LENGTH = 79;
    private static final long serialVersionUID = 126;
    public long baudrate;
    public short count;
    public short[] data = new short[70];
    public short device;
    public short flags;
    public int timeout;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(79);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 126;
        mAVLinkPacket.crc_extra = 220;
        mAVLinkPacket.payload.putUnsignedInt(this.baudrate);
        mAVLinkPacket.payload.putUnsignedShort(this.timeout);
        mAVLinkPacket.payload.putUnsignedByte(this.device);
        mAVLinkPacket.payload.putUnsignedByte(this.flags);
        mAVLinkPacket.payload.putUnsignedByte(this.count);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.baudrate = mAVLinkPayload.getUnsignedInt();
        this.timeout = mAVLinkPayload.getUnsignedShort();
        this.device = mAVLinkPayload.getUnsignedByte();
        this.flags = mAVLinkPayload.getUnsignedByte();
        this.count = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.data;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_serial_control() {
        this.msgid = 126;
    }

    public msg_serial_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 126;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SERIAL_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " baudrate:" + this.baudrate + " timeout:" + this.timeout + " device:" + this.device + " flags:" + this.flags + " count:" + this.count + " data:" + this.data + "";
    }
}
