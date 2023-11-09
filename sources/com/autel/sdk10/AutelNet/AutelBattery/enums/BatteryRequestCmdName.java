package com.autel.sdk10.AutelNet.AutelBattery.enums;

public final class BatteryRequestCmdName {
    public static final String CRITICAL_BATTERY_WARNING = "BAT_THR_ONE";
    public static final String LOW_BATTERY_WARNING = "BAT_THR_TWO";

    private BatteryRequestCmdName() {
    }

    public static boolean isBatteryRequestCmdName(String str) {
        return str.equals(CRITICAL_BATTERY_WARNING) || str.equals(LOW_BATTERY_WARNING);
    }
}
