package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.google.common.base.Ascii;

public class msg_ptz_frame_cmd extends MAVLinkMessage {
    public static final int MAVLINK_MSG_LENGTH = 13;
    public static final int MAVLINK_MSG_PTZ_FRAME_CMD = 200;
    private static final long serialVersionUID = 200;
    public String[] DtVer = new String[3];
    public int adjustProgress;
    public byte batteryDischargeDay;
    public int[] batteryHistorylogs;
    public float data;
    public byte device_id = 1;
    public byte flag;
    public int fram_id;
    public byte[] frame_date = new byte[8];
    public float index;
    private boolean isSetDischargeDaySucc;
    public String ptzBootLoaderVer;
    public String ptzDTVer;
    public String ptzVersion;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 13;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 200;
        mAVLinkPacket.payload.putInt(this.fram_id);
        mAVLinkPacket.payload.putByte(this.device_id);
        for (byte putByte : this.frame_date) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.fram_id = mAVLinkPayload.getInt();
        this.device_id = mAVLinkPayload.getByte();
        if (this.fram_id == 888) {
            this.index = mAVLinkPayload.getFloat();
            this.data = mAVLinkPayload.getFloat();
            return;
        }
        this.flag = mAVLinkPayload.getByte();
        byte b = mAVLinkPayload.getByte();
        byte b2 = mAVLinkPayload.getByte();
        byte b3 = mAVLinkPayload.getByte();
        byte b4 = mAVLinkPayload.getByte();
        byte b5 = mAVLinkPayload.getByte();
        byte b6 = mAVLinkPayload.getByte();
        byte b7 = mAVLinkPayload.getByte();
        if (this.fram_id == 886) {
            String format = String.format("V%X.%X.%X.%X", new Object[]{Byte.valueOf(b7), Byte.valueOf(b6), Byte.valueOf(b5), Byte.valueOf(b4)});
            byte b8 = this.flag;
            if (b8 == 7) {
                this.ptzVersion = format;
            } else if (b8 == 8) {
                this.ptzBootLoaderVer = format;
            }
        }
        if (this.fram_id == 513) {
            this.DtVer[0] = getVer(b5, b4);
        }
        if (this.fram_id == 514) {
            this.DtVer[1] = getVer(b5, b4);
        }
        if (this.fram_id == 515) {
            this.DtVer[2] = getVer(b5, b4);
        }
        int i = this.fram_id;
        if (i == 769) {
            this.adjustProgress = b2;
        }
        if ((i & -16776961) == 251658493) {
            switch (b) {
                case -31:
                    this.batteryDischargeDay = b3;
                    break;
                case -30:
                    this.batteryDischargeDay = b3;
                    break;
                case -29:
                    if (!BatteryInfoParser.getInstance_().isBatteryVersionAboveV522()) {
                        praseBatteryHistory(0, new byte[]{b3, b4, b5, b6, b7});
                        break;
                    } else {
                        praseBatteryHistoryAboveV522(0, new byte[]{b3, b4, b5, b6, b7});
                        break;
                    }
                case -28:
                    if (!BatteryInfoParser.getInstance_().isBatteryVersionAboveV522()) {
                        praseBatteryHistory(1, new byte[]{b3, b4, b5, b6, b7});
                        break;
                    } else {
                        praseBatteryHistoryAboveV522(1, new byte[]{b3, b4, b5, b6, b7});
                        break;
                    }
                case -27:
                    praseBatteryHistory(2, new byte[]{b3, b4, b5, b6, b7});
                    break;
                case -26:
                    praseBatteryHistory(3, new byte[]{b3, b4, b5, b6, b7});
                    break;
                case -25:
                    praseBatteryHistory(4, new byte[]{b3, b4, b5, b6, b7});
                    break;
                case -24:
                    praseBatteryHistory(5, new byte[]{b3, b4, b5, b6, b7});
                    break;
                case -23:
                    praseBatteryHistory(6, new byte[]{b3, b4, b5, b6, b7});
                    break;
            }
        }
        int i2 = this.fram_id;
        if ((-16776961 & i2) == 251658494) {
            this.batteryDischargeDay = -1;
        }
        if (i2 == 890) {
            byte[] bArr = this.frame_date;
            bArr[0] = this.flag;
            bArr[1] = b;
            bArr[2] = b2;
            bArr[3] = b3;
            bArr[4] = b4;
            bArr[5] = b5;
            bArr[6] = b6;
            bArr[7] = b7;
        }
    }

    private void praseBatteryHistory(int i, byte[] bArr) {
        if (i == 0) {
            int[] iArr = new int[4];
            this.batteryHistorylogs = iArr;
            iArr[1] = bArr[0];
            iArr[2] = bArr[3];
            iArr[3] = bArr[4];
        } else {
            this.batteryHistorylogs = new int[6];
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = i2 + 1;
                this.batteryHistorylogs[i3] = bArr[i2];
                i2 = i3;
            }
        }
        this.batteryHistorylogs[0] = i;
    }

    private void praseBatteryHistoryAboveV522(int i, byte[] bArr) {
        int[] iArr = new int[11];
        this.batteryHistorylogs = iArr;
        iArr[0] = i;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int[] iArr2 = this.batteryHistorylogs;
            int i3 = i2 * 2;
            iArr2[i3 + 1] = bArr[i2] & Ascii.f8523SI;
            iArr2[i3 + 2] = (bArr[i2] >> 4) & 15;
        }
    }

    private String getVer(byte b, byte b2) {
        return String.format("V%d.%d.%d", new Object[]{Byte.valueOf(b), Byte.valueOf((byte) (b2 >> 4)), Byte.valueOf((byte) (b2 & Ascii.f8523SI))});
    }

    public msg_ptz_frame_cmd() {
        this.msgid = 200;
    }

    public msg_ptz_frame_cmd(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 200;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MSG_PTZ_FRAME_CMD :fram_id  " + this.fram_id + "device_id" + this.device_id + " frame_date[0] " + this.frame_date[0] + " frame_date[1] " + this.frame_date[1] + " frame_date[2] " + this.frame_date[2] + " frame_date[3] " + this.frame_date[3] + " adjustProgress = " + this.adjustProgress;
    }
}
