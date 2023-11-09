package com.autel.sdk10.AutelNet.AutelDsp.wifi.info;

import com.MAVLink.Messages.MAVLinkPayload;

public class BindSsidInfo {
    protected final int MACMAXLEN = 19;
    protected final int SSIDMAXLEN = 100;
    protected byte flag;
    protected byte[] mac = new byte[19];
    protected MAVLinkPayload payload = new MAVLinkPayload();
    protected byte[] ssid = new byte[100];

    public MAVLinkPayload pack() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.ssid;
            if (i2 >= bArr.length) {
                break;
            }
            this.payload.putByte(bArr[i2]);
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.mac;
            if (i < bArr2.length) {
                this.payload.putByte(bArr2[i]);
                i++;
            } else {
                this.payload.putByte(this.flag);
                return this.payload;
            }
        }
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.ssid;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = mAVLinkPayload.getByte();
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.mac;
            if (i < bArr2.length) {
                bArr2[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.flag = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public void setSsid(String str) {
        int min = Math.min(str.length(), 100);
        for (int i = 0; i < min; i++) {
            this.ssid[i] = (byte) str.charAt(i);
        }
        while (min < 100) {
            this.ssid[min] = 0;
            min++;
        }
    }

    public void setSSIDandPsw(String str, String str2) {
        int min = Math.min(str.length(), 50);
        for (int i = 0; i < min; i++) {
            this.ssid[i] = (byte) str.charAt(i);
        }
        while (min < 50) {
            this.ssid[min] = 0;
            min++;
        }
        int min2 = Math.min(str2.length(), 50);
        for (int i2 = 0; i2 < min2; i2++) {
            this.ssid[i2 + 50] = (byte) str2.charAt(i2);
        }
        for (int i3 = min2 + 50; i3 < 100; i3++) {
            this.ssid[i3] = 0;
        }
    }

    public String getRepeatSsid() {
        String str = "";
        int i = 0;
        while (i < 50 && this.ssid[i] != 0) {
            str = str + ((char) this.ssid[i]);
            i++;
        }
        return str;
    }

    public String getPwdString() {
        String str = "";
        int i = 50;
        while (i < 100 && this.ssid[i] != 0) {
            str = str + ((char) this.ssid[i]);
            i++;
        }
        return str;
    }

    public void setMac(String str) {
        for (int i = 0; i < 17; i++) {
            this.mac[i] = (byte) str.charAt(i);
        }
    }

    public byte getFlag() {
        return this.flag;
    }

    public void setFlag(byte b) {
        this.flag = b;
    }

    public byte[] encodeInfo() {
        byte[] bArr = new byte[this.payload.size()];
        for (int i = 0; i < this.payload.size(); i++) {
            bArr[i] = this.payload.payload.get(i);
        }
        return bArr;
    }
}
