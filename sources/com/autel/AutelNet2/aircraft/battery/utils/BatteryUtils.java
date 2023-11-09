package com.autel.AutelNet2.aircraft.battery.utils;

import com.autel.AutelNet2.constant.FmuCmdConstant;

public final class BatteryUtils {
    public static final int GET_DISCHARGET_DAYS_ID = 251658466;
    public static final int SET_DISCHARGET_DAYS_ID = 251658465;
    public static int[] history_flags = {227, 228};

    public static boolean isBatteryPacket(int i) {
        return (i & -16776961) == 251658493;
    }

    public static boolean isGetSetDischargetDays(int i) {
        return i == 251658465 || i == 251658466;
    }

    private BatteryUtils() {
    }

    public static boolean isBatteryRequestCmdName(String str) {
        return str.equals(FmuCmdConstant.CRITICAL_BATTERY_WARNING) || str.equals(FmuCmdConstant.LOW_BATTERY_WARNING);
    }
}
