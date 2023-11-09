package com.autel.sdk10.AutelNet.AutelBattery.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_custom_battery_status;
import com.MAVLink.Messages.ardupilotmega.msg_ptz_frame_cmd;
import com.autel.common.battery.BatteryWarning;
import com.autel.internal.sdk.battery.AutelBatteryStatusInternal;
import com.autel.sdk10.AutelNet.AutelBattery.enums.BatteryRequestCmdName;
import com.autel.sdk10.AutelNet.AutelBattery.info.AutelBatteryInfo;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class BatteryInfoParser extends AutelBatteryInfo {
    private static BatteryInfoParser instance_;
    private long updateTime_History;
    private long updateTime_criticalBatteryWarning;
    private long updateTime_dischargeDay;
    private long updateTime_lowBatteryWarning;

    public static BatteryInfoParser getInstance_() {
        if (instance_ == null) {
            instance_ = new BatteryInfoParser();
        }
        return instance_;
    }

    private BatteryInfoParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = mAVLinkMessage.msgid;
        if (i == 200) {
            updateDischargeDayAndHistorylogs((msg_ptz_frame_cmd) mAVLinkMessage);
        } else if (i == 214) {
            initBatteryStatus(getBatteryStatus(), (msg_custom_battery_status) mAVLinkMessage);
        }
    }

    public void parseParamValue(Parameter parameter) {
        String name = parameter.getName();
        name.hashCode();
        if (name.equals(BatteryRequestCmdName.CRITICAL_BATTERY_WARNING)) {
            setCriticalBatteryWarning(parameter.getValue());
            setUpdateTimeLowBatteryWarning(3);
        } else if (name.equals(BatteryRequestCmdName.LOW_BATTERY_WARNING)) {
            setLowBatteryWarning(parameter.getValue());
            setUpdateTimeLowBatteryWarning(1);
        }
    }

    private void updateDischargeDayAndHistorylogs(msg_ptz_frame_cmd msg_ptz_frame_cmd) {
        setDischargeDay(msg_ptz_frame_cmd.batteryDischargeDay);
        setUpdateTimeLowBatteryWarning(5);
        if ((msg_ptz_frame_cmd.fram_id & -16776961) == 251658493) {
            setBatteryHistoryRecord(msg_ptz_frame_cmd.batteryHistorylogs);
            setUpdateTimeLowBatteryWarning(6);
        }
    }

    private void setUpdateTimeLowBatteryWarning(int i) {
        if (i == 1) {
            this.updateTime_lowBatteryWarning = System.currentTimeMillis();
        } else if (i == 3) {
            this.updateTime_criticalBatteryWarning = System.currentTimeMillis();
        } else if (i == 5) {
            this.updateTime_dischargeDay = System.currentTimeMillis();
        } else if (i == 6) {
            this.updateTime_History = System.currentTimeMillis();
        }
    }

    public boolean isNewInfo(int i, long j) {
        switch (i) {
            case 0:
            case 1:
                if (this.updateTime_lowBatteryWarning > j) {
                    return true;
                }
                return false;
            case 2:
            case 3:
                if (this.updateTime_criticalBatteryWarning > j) {
                    return true;
                }
                return false;
            case 4:
            case 5:
                if (this.updateTime_dischargeDay > j) {
                    return true;
                }
                return false;
            case 6:
                return this.updateTime_History > j;
            default:
                return false;
        }
    }

    public void clearBatteryHistoryRecords() {
        this.isBatteryHistoryRecordsChecked = false;
    }

    public boolean isBatteryVersionAboveV522() {
        String batteryVersion = AutelAircraftInfoManager.getAircraftComponentVersionInfo().getBatteryVersion();
        if (batteryVersion == null) {
            return false;
        }
        String str = "0";
        String replace = batteryVersion.replace("V", str);
        if (!"".equals(replace)) {
            str = replace;
        }
        try {
            if (Float.valueOf(str).floatValue() > 5.21f) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void initBatteryStatus(AutelBatteryStatusInternal autelBatteryStatusInternal, msg_custom_battery_status msg_custom_battery_status) {
        autelBatteryStatusInternal.setBatteryCells(new int[]{msg_custom_battery_status.voltage_cell_1, msg_custom_battery_status.voltage_cell_2, msg_custom_battery_status.voltage_cell_3, msg_custom_battery_status.voltage_cell_4});
        autelBatteryStatusInternal.setVoltage_mv((double) msg_custom_battery_status.voltage_mv);
        autelBatteryStatusInternal.setCapacity_mah(msg_custom_battery_status.capacity_mah);
        autelBatteryStatusInternal.setCurrent_ma(msg_custom_battery_status.current_ma);
        autelBatteryStatusInternal.setTemperature(msg_custom_battery_status.temperature);
        autelBatteryStatusInternal.setCycleCount(msg_custom_battery_status.CycleCount);
        autelBatteryStatusInternal.setDesignCap(msg_custom_battery_status.DesignCap);
        autelBatteryStatusInternal.setFullChgCap(msg_custom_battery_status.FullChgCap);
        autelBatteryStatusInternal.setRSOC(msg_custom_battery_status.RSOC);
        autelBatteryStatusInternal.setSn(msg_custom_battery_status.getSNId());
        autelBatteryStatusInternal.setVer(msg_custom_battery_status.getVersionId());
    }

    public float getRemainTime() {
        return getCapacity() / 204.0f;
    }

    public BatteryWarning getBatteryWarning() {
        return ErrorWarningInternalParser.getInstance().getBatteryWarning();
    }

    public boolean isBatteryOverHeated() {
        return ErrorWarningInternalParser.getInstance().isBatteryOverHeated();
    }

    public String toString() {
        return super.toString();
    }
}
