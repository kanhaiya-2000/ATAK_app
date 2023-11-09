package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_serial_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SERIAL_CONTROL = 126;
    public static final int MAVLINK_MSG_LENGTH = 79;
    private static final long serialVersionUID = 126;
    public int baudrate;
    public byte count;
    public byte[] data = new byte[70];
    public byte device;
    public byte flags;
    public short timeout;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 79;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 126;
        mAVLinkPacket.payload.putInt(this.baudrate);
        mAVLinkPacket.payload.putShort(this.timeout);
        mAVLinkPacket.payload.putByte(this.device);
        mAVLinkPacket.payload.putByte(this.flags);
        mAVLinkPacket.payload.putByte(this.count);
        for (byte putByte : this.data) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.baudrate = mAVLinkPayload.getInt();
        this.timeout = mAVLinkPayload.getShort();
        this.device = mAVLinkPayload.getByte();
        this.flags = mAVLinkPayload.getByte();
        this.count = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_SERIAL_CONTROL - baudrate:" + this.baudrate + " timeout:" + this.timeout + " device:" + this.device + " flags:" + this.flags + " count:" + this.count + " data:" + this.data + "";
    }
}
