package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.common.msg_collision;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtcm_data;
import com.atakmap.android.uastool.MAVLink.common.msg_set_actuator_control_target;

public class CRC {
    private static final int CRC_INIT_VALUE = 65535;
    private static final int[] MAVLINK_MESSAGE_CRCS = {50, 124, 137, 237, 217, 104, 119, 89, 214, 159, 220, 168, 24, 23, 170, 144, 67, 115, 39, 246, 185, 104, 237, 244, 222, 212, 9, 254, 230, 28, 28, 132, 221, 232, 11, 153, 41, 39, 78, 196, 15, 3, 167, 183, 119, 191, 118, 148, 21, 243, 124, 38, 20, 158, 152, 143, 106, 49, 22, 143, 140, 5, 150, 231, 183, 63, 54, 47, 175, 102, 158, 208, 56, 93, 138, 108, 32, 185, 84, 34, 174, 124, 237, 4, 76, 128, 56, 116, 134, 237, 203, 250, 87, 203, 220, 25, 226, 46, 29, 223, 85, 6, 229, 203, 1, 195, 109, 168, 181, 47, 72, 131, 127, 103, 154, 178, 200, 134, 219, 208, msg_ap_adc.MAVLINK_MSG_ID_AP_ADC_CRC, 84, 22, 19, 21, 134, 78, 68, 189, 127, 154, 21, 21, 144, 1, 234, 73, 181, 22, 83, 167, 138, 234, 240, 47, 189, 52, 174, 229, 85, 159, 186, 72, 92, 36, 71, 98, 120, 134, 205, 69, 101, 50, 202, 17, 162, 207, 163, 105, 151, 35, 150, 90, 104, 85, 95, 130, 184, 81, 8, 204, 49, 170, 44, 83, 46};
    private static final int[] MAVLINK_MESSAGE_IDS = {0, 1, 2, 4, 5, 6, 7, 11, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 54, 55, 61, 62, 63, 64, 65, 66, 67, 69, 70, 73, 74, 75, 76, 77, 81, 82, 83, 84, 85, 86, 87, 89, 90, 91, 92, 93, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, msg_set_actuator_control_target.MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET, 140, 141, 142, 143, 144, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 191, 192, 193, 194, 195, 200, 201, 214, msg_gopro_heartbeat.MAVLINK_MSG_ID_GOPRO_HEARTBEAT, 216, 217, msg_gopro_set_request.MAVLINK_MSG_ID_GOPRO_SET_REQUEST, 219, 226, 230, 231, 232, msg_gps_rtcm_data.MAVLINK_MSG_ID_GPS_RTCM_DATA, 234, 241, 242, 243, 244, 245, 246, msg_collision.MAVLINK_MSG_ID_COLLISION, 248, 249, 250, 251, 252, 253, 254};
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
