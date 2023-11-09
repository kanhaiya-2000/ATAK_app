package com.autel.sdk10.AutelNet.AutelBattery.enums;

public final class BatteryRequestId {
    public static final int HistoryLogs = 6;
    public static final int queryCriticalBatteryWarning = 3;
    public static final int queryDischargeDay = 5;
    public static final int queryLowBatteryWarning = 1;
    public static final int setCriticalBatteryWarning = 2;
    public static final int setDischargeDay = 4;
    public static final int setLowBatteryWarning = 0;

    private BatteryRequestId() {
    }
}
