package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_scaled_imu extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SCALED_IMU = 26;
    public static final int MAVLINK_MSG_ID_SCALED_IMU_CRC = 170;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 26;
    public long time_boot_ms;
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
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(22);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 26;
        mAVLinkPacket.crc_extra = 170;
        mAVLinkPacket.payload.putUnsignedInt(this.time_boot_ms);
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
        this.time_boot_ms = mAVLinkPayload.getUnsignedInt();
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

    public msg_scaled_imu() {
        this.msgid = 26;
    }

    public msg_scaled_imu(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 26;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SCALED_IMU - sysid:" + this.sysid + " compid:" + this.compid + " time_boot_ms:" + this.time_boot_ms + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + " xgyro:" + this.xgyro + " ygyro:" + this.ygyro + " zgyro:" + this.zgyro + " xmag:" + this.xmag + " ymag:" + this.ymag + " zmag:" + this.zmag + "";
    }
}
