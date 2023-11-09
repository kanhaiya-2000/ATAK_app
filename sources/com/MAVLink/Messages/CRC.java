package com.MAVLink.Messages;

import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ap_adc;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtcm_data;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;

public class CRC {
    private static final int CRC_INIT_VALUE = 65535;
    private static final int[] MAVLINK_MESSAGE_CRCS = {50, 187, 137, 0, 237, 217, 104, 119, 0, 0, 0, 89, 0, 0, 0, 0, 0, 0, 0, 0, 214, 159, 220, 168, 185, 23, 170, 144, 67, 115, 39, 246, 185, 104, 237, 244, 222, 212, 9, 254, 230, 28, 28, 132, 221, 232, 11, 153, 41, 39, 0, 0, 0, 0, 15, 3, 0, 0, 0, 0, 0, 153, 183, 51, 82, 118, 148, 21, 0, 243, 124, 0, 0, 38, 20, 158, 152, 226, 0, 0, 0, 106, 49, 22, 29, 12, 241, msg_gps_rtcm_data.MAVLINK_MSG_ID_GPS_RTCM_DATA, 0, 231, 183, 63, 54, 0, 0, 0, 0, 0, 0, 0, 175, 102, 158, 208, 56, 10, MAV_CMD.MAV_CMD_DO_GRIPPER, 108, 32, 185, 84, 0, 0, 124, 119, 4, 76, 128, 56, 116, 134, 237, 203, 250, 87, 203, 220, 25, 226, 0, 29, 223, 85, 6, 229, 203, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 49, 0, 134, 219, 208, msg_ap_adc.MAVLINK_MSG_ID_AP_ADC_CRC, 84, 22, 19, 21, 134, 0, 78, 68, 189, 127, 154, 21, 21, 144, 1, 234, 73, 181, 22, 83, 167, 138, 234, 240, 47, 189, 52, 174, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 0, 226, 0, 0, 170, 238, 126, MAV_CMD.MAV_CMD_DO_SET_ROI_NONE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 204, 49, 170, 44, 83, 46, 0};
    private int CRCvalue;

    public void update_checksum(int i) {
        int i2 = this.CRCvalue;
        int i3 = (i & 255) ^ (i2 & 255);
        int i4 = i3 ^ ((i3 << 4) & 255);
        this.CRCvalue = ((i4 >> 4) & 15) ^ ((((i2 >> 8) & 255) ^ (i4 << 8)) ^ (i4 << 3));
    }

    public void finish_checksum(int i) {
        update_checksum(MAVLINK_MESSAGE_CRCS[i]);
    }

    public void start_checksum() {
        this.CRCvalue = CRC_INIT_VALUE;
    }

    public int getMSB() {
        return (this.CRCvalue >> 8) & 255;
    }

    public int getLSB() {
        return this.CRCvalue & 255;
    }

    public CRC() {
        start_checksum();
    }
}
