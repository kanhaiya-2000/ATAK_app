package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.ComponentID */
class ComponentID extends GCSMessage {
    private int componentResponse;
    private int deviceIndex;
    private String deviceInfo;
    private String deviceSpecific;
    private int deviceTotal;
    private int deviceType;
    private int hobbsTimer;
    private int numberOfFlights;
    private String softwareVersion;
    private String tailNumber = "";
    private final int xID;

    public String getTailNumber() {
        return this.tailNumber;
    }

    public ComponentID(byte[] bArr) {
        byte b = bArr[0];
        this.xID = b;
        if (b == 1) {
            this.deviceIndex = bArr[1];
            this.deviceTotal = bArr[2];
            this.deviceType = bArr[3];
            this.componentResponse = getShort(bArr[4], bArr[5]);
            this.hobbsTimer = getInt((byte) 0, bArr[6], bArr[7], bArr[8]);
            this.numberOfFlights = getShort(bArr[9], bArr[10]);
            StringBuilder sb = new StringBuilder();
            int i = 11;
            while (bArr[i] != 0) {
                sb.append((char) bArr[i]);
                i++;
            }
            this.softwareVersion = sb.toString();
            int i2 = i + 1;
            StringBuilder sb2 = new StringBuilder();
            while (i2 < bArr.length && bArr[i2] != 0) {
                sb2.append((char) bArr[i2]);
                i2++;
            }
            String sb3 = sb2.toString();
            this.deviceInfo = sb3;
            if (sb3.contains("AVXID")) {
                this.tailNumber = "RB" + this.deviceInfo.replaceAll(".*AVXID=(\\d+).*", "$1");
            } else if (this.deviceInfo.contains("AIR VEH ID")) {
                this.tailNumber = "PA" + this.deviceInfo.replaceAll(".*AIR VEH ID:\\s+(\\d+).*", "$1");
            }
            this.deviceSpecific = null;
        }
    }
}
