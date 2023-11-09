package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_ptz_frame_cmd;
import com.autel.AutelNet2.aircraft.battery.utils.BatteryUtils;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk10.utils.BytesUtils;

public final class GimbalMAVLinkPacketFactory {
    private GimbalMAVLinkPacketFactory() {
    }

    public static MAVLinkPacket createQueryBatteryDischargeDayPacket() {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.device_id = 3;
        msg_ptz_frame_cmd.fram_id = BatteryUtils.GET_DISCHARGET_DAYS_ID;
        msg_ptz_frame_cmd.frame_date = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
        return msg_ptz_frame_cmd.pack();
    }

    public static MAVLinkPacket createSetBatteryDischargeDayPacket(byte b) {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.device_id = 3;
        msg_ptz_frame_cmd.fram_id = BatteryUtils.SET_DISCHARGET_DAYS_ID;
        msg_ptz_frame_cmd.frame_date = new byte[]{b, 0, 0, 0, 0, 0, 0, 0};
        return msg_ptz_frame_cmd.pack();
    }

    public static MAVLinkPacket createQueryBatteryHistoryPacket(int i) {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.device_id = 3;
        msg_ptz_frame_cmd.fram_id = i | 251658240;
        msg_ptz_frame_cmd.frame_date = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
        return msg_ptz_frame_cmd.pack();
    }

    public static MAVLinkPacket createSetRollAdjustDataPacket(int i, int i2) {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.fram_id = 256;
        byte[] bytes = BytesUtils.getBytes(i);
        byte[] bytes2 = BytesUtils.getBytes(i2);
        msg_ptz_frame_cmd.frame_date = new byte[]{bytes2[3], bytes2[2], bytes2[1], bytes2[0], bytes[3], bytes[2], bytes[1], bytes[0]};
        return msg_ptz_frame_cmd.pack();
    }

    public static MAVLinkPacket createSwitchToGimbalMsg() {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.fram_id = 897;
        msg_ptz_frame_cmd.frame_date = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
        return msg_ptz_frame_cmd.pack();
    }

    public static MAVLinkPacket createSendPztWorkModePacket(GimbalWorkMode gimbalWorkMode) {
        msg_ptz_frame_cmd msg_ptz_frame_cmd = new msg_ptz_frame_cmd();
        msg_ptz_frame_cmd.fram_id = 887;
        byte[] bArr = {0, 0, 85, 85, 0, 0, 0, 3};
        if (gimbalWorkMode == GimbalWorkMode.FPV) {
            bArr = new byte[]{0, 0, -86, -86, 0, 0, 0, 3};
        }
        msg_ptz_frame_cmd.frame_date = bArr;
        return msg_ptz_frame_cmd.pack();
    }
}
