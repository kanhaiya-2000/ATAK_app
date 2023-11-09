package com.autel.sdk10.AutelNet.AutelDsp.wifi.info;

import com.MAVLink.Messages.MAVLinkPayload;

public class AskBindSsidInfo extends BindSsidInfo {
    protected byte[] mac = new byte[20];
    private byte[] repeatMac = new byte[19];
    private byte[] repeatSsid = new byte[100];

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        int i = 0;
        for (int i2 = 0; i2 < this.ssid.length; i2++) {
            this.ssid[i2] = mAVLinkPayload.getByte();
        }
        int i3 = 0;
        while (true) {
            byte[] bArr = this.mac;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = mAVLinkPayload.getByte();
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr2 = this.repeatSsid;
            if (i4 >= bArr2.length) {
                break;
            }
            bArr2[i4] = mAVLinkPayload.getByte();
            i4++;
        }
        while (true) {
            byte[] bArr3 = this.repeatMac;
            if (i < bArr3.length) {
                bArr3[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.flag = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public String getSsid() {
        String str = "";
        int i = 0;
        while (i < this.ssid.length && this.ssid[i] != 0) {
            str = str + ((char) this.ssid[i]);
            i++;
        }
        return str;
    }

    public String getRepeatSsid() {
        String str = "";
        int i = 0;
        while (i < 50 && this.repeatSsid[i] != 0) {
            str = str + ((char) this.repeatSsid[i]);
            i++;
        }
        return str;
    }

    public String getPwdString() {
        String str = "";
        int i = 50;
        while (i < 100 && this.repeatSsid[i] != 0) {
            str = str + ((char) this.repeatSsid[i]);
            i++;
        }
        return str;
    }

    public String getMac() {
        String str = "";
        for (int i = 0; i < 17; i++) {
            str = str + ((char) this.mac[i]);
        }
        return str;
    }

    public String getRepeatMac() {
        String str = "";
        for (int i = 0; i < 17; i++) {
            str = str + ((char) this.repeatMac[i]);
        }
        return str;
    }
}
