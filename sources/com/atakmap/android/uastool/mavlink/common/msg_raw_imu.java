package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_raw_imu extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RAW_IMU = 27;
    public static final int MAVLINK_MSG_ID_RAW_IMU_CRC = 144;
    public static final int MAVLINK_MSG_LENGTH = 26;
    private static final long serialVersionUID = 27;
    public long time_usec;
    public short xacc;
    public short xgyro;
    public short xmag;
    public short yacc;
    public short ygyro;
    public short ymag;
    public short zacc;
    public short zgyro;
    public short zmag;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(26);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 27;
        mAVLinkPacket.crc_extra = 144;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putShort(this.xacc);
        mAVLinkPacket.payload.putShort(this.yacc);
        mAVLinkPacket.payload.putShort(this.zacc);
        mAVLinkPacket.payload.putShort(this.xgyro);
        mAVLinkPacket.payload.putShort(this.ygyro);
        mAVLinkPacket.payload.putShort(this.zgyro);
        mAVLinkPacket.payload.putShort(this.xmag);
        mAVLinkPacket.payload.putShort(this.ymag);
        mAVLinkPacket.payload.putShort(this.zmag);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.xacc = mAVLinkPayload.getShort();
        this.yacc = mAVLinkPayload.getShort();
        this.zacc = mAVLinkPayload.getShort();
        this.xgyro = mAVLinkPayload.getShort();
        this.ygyro = mAVLinkPayload.getShort();
        this.zgyro = mAVLinkPayload.getShort();
        this.xmag = mAVLinkPayload.getShort();
        this.ymag = mAVLinkPayload.getShort();
        this.zmag = mAVLinkPayload.getShort();
    }

    public msg_raw_imu() {
        this.msgid = 27;
    }

    public msg_raw_imu(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 27;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RAW_IMU - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + " xgyro:" + this.xgyro + " ygyro:" + this.ygyro + " zgyro:" + this.zgyro + " xmag:" + this.xmag + " ymag:" + this.ymag + " zmag:" + this.zmag + "";
    }
}
