package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_gps_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS_STATUS = 25;
    public static final int MAVLINK_MSG_LENGTH = 101;
    private static final long serialVersionUID = 25;
    public byte[] satellite_azimuth = new byte[20];
    public byte[] satellite_elevation = new byte[20];
    public byte[] satellite_prn = new byte[20];
    public byte[] satellite_snr = new byte[20];
    public byte[] satellite_used = new byte[20];
    public byte satellites_visible;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 101;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 25;
        mAVLinkPacket.payload.putByte(this.satellites_visible);
        for (byte putByte : this.satellite_prn) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        for (byte putByte2 : this.satellite_used) {
            mAVLinkPacket.payload.putByte(putByte2);
        }
        for (byte putByte3 : this.satellite_elevation) {
            mAVLinkPacket.payload.putByte(putByte3);
        }
        for (byte putByte4 : this.satellite_azimuth) {
            mAVLinkPacket.payload.putByte(putByte4);
        }
        for (byte putByte5 : this.satellite_snr) {
            mAVLinkPacket.payload.putByte(putByte5);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.satellites_visible = mAVLinkPayload.getByte();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.satellite_prn;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = mAVLinkPayload.getByte();
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.satellite_used;
            if (i3 >= bArr2.length) {
                break;
            }
            bArr2[i3] = mAVLinkPayload.getByte();
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr3 = this.satellite_elevation;
            if (i4 >= bArr3.length) {
                break;
            }
            bArr3[i4] = mAVLinkPayload.getByte();
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr4 = this.satellite_azimuth;
            if (i5 >= bArr4.length) {
                break;
            }
            bArr4[i5] = mAVLinkPayload.getByte();
            i5++;
        }
        while (true) {
            byte[] bArr5 = this.satellite_snr;
            if (i < bArr5.length) {
                bArr5[i] = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_GPS_STATUS - satellites_visible:" + this.satellites_visible + " satellite_prn:" + this.satellite_prn + " satellite_used:" + this.satellite_used + " satellite_elevation:" + this.satellite_elevation + " satellite_azimuth:" + this.satellite_azimuth + " satellite_snr:" + this.satellite_snr + "";
    }
}
