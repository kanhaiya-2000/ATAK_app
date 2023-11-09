package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gps_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS_STATUS = 25;
    public static final int MAVLINK_MSG_ID_GPS_STATUS_CRC = 23;
    public static final int MAVLINK_MSG_LENGTH = 101;
    private static final long serialVersionUID = 25;
    public short[] satellite_azimuth = new short[20];
    public short[] satellite_elevation = new short[20];
    public short[] satellite_prn = new short[20];
    public short[] satellite_snr = new short[20];
    public short[] satellite_used = new short[20];
    public short satellites_visible;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(101);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 25;
        mAVLinkPacket.crc_extra = 23;
        mAVLinkPacket.payload.putUnsignedByte(this.satellites_visible);
        for (short putUnsignedByte : this.satellite_prn) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        for (short putUnsignedByte2 : this.satellite_used) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte2);
        }
        for (short putUnsignedByte3 : this.satellite_elevation) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte3);
        }
        for (short putUnsignedByte4 : this.satellite_azimuth) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte4);
        }
        for (short putUnsignedByte5 : this.satellite_snr) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte5);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.satellites_visible = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.satellite_prn;
            if (i2 >= sArr.length) {
                break;
            }
            sArr[i2] = mAVLinkPayload.getUnsignedByte();
            i2++;
        }
        int i3 = 0;
        while (true) {
            short[] sArr2 = this.satellite_used;
            if (i3 >= sArr2.length) {
                break;
            }
            sArr2[i3] = mAVLinkPayload.getUnsignedByte();
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[] sArr3 = this.satellite_elevation;
            if (i4 >= sArr3.length) {
                break;
            }
            sArr3[i4] = mAVLinkPayload.getUnsignedByte();
            i4++;
        }
        int i5 = 0;
        while (true) {
            short[] sArr4 = this.satellite_azimuth;
            if (i5 >= sArr4.length) {
                break;
            }
            sArr4[i5] = mAVLinkPayload.getUnsignedByte();
            i5++;
        }
        while (true) {
            short[] sArr5 = this.satellite_snr;
            if (i < sArr5.length) {
                sArr5[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_gps_status() {
        this.msgid = 25;
    }

    public msg_gps_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 25;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " satellites_visible:" + this.satellites_visible + " satellite_prn:" + this.satellite_prn + " satellite_used:" + this.satellite_used + " satellite_elevation:" + this.satellite_elevation + " satellite_azimuth:" + this.satellite_azimuth + " satellite_snr:" + this.satellite_snr + "";
    }
}
