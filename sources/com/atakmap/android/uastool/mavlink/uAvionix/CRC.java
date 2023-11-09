package com.atakmap.android.uastool.MAVLink.uAvionix;

public class CRC {
    private static final int CRC_INIT_VALUE = 65535;
    private static final int[] MAVLINK_MESSAGE_CRCS = new int[0];
    private static final int[] MAVLINK_MESSAGE_IDS = new int[0];
    private int crcValue;

    public void update_checksum(int i) {
        int i2 = this.crcValue;
        int i3 = (i & 255) ^ (i2 & 255);
        int i4 = i3 ^ ((i3 << 4) & 255);
        this.crcValue = ((i4 >> 4) & 15) ^ ((((i2 >> 8) & 255) ^ (i4 << 8)) ^ (i4 << 3));
    }

    public int finish_checksum(int i) {
        int i2 = 0;
        if (i != 0) {
            int length = MAVLINK_MESSAGE_IDS.length - 1;
            int i3 = 0;
            while (true) {
                if (i3 > length) {
                    break;
                }
                int i4 = (i3 + length) / 2;
                int[] iArr = MAVLINK_MESSAGE_IDS;
                if (i == iArr[i4]) {
                    i2 = MAVLINK_MESSAGE_CRCS[i4];
                    break;
                } else if (i < iArr[i4]) {
                    length = i4 - 1;
                } else {
                    i3 = i4 + 1;
                }
            }
        } else {
            i2 = MAVLINK_MESSAGE_CRCS[0];
        }
        update_checksum(i2);
        return i2;
    }

    public void start_checksum() {
        this.crcValue = CRC_INIT_VALUE;
    }

    public int getMSB() {
        return (this.crcValue >> 8) & 255;
    }

    public int getLSB() {
        return this.crcValue & 255;
    }

    public CRC() {
        start_checksum();
    }
}
