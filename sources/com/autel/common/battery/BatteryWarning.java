package com.autel.common.battery;

public enum BatteryWarning {
    NORMAL(0, "Battery in normal condition"),
    LOW(1, "Low battery warning"),
    CRITICAL(2, "Extremely low battery warning"),
    UNKNOWN(3, "Unknown battery warning");
    
    private String description;
    private int value;

    private BatteryWarning(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static BatteryWarning find(int i) {
        BatteryWarning batteryWarning = NORMAL;
        if (batteryWarning.getValue() == i) {
            return batteryWarning;
        }
        BatteryWarning batteryWarning2 = LOW;
        if (batteryWarning2.getValue() == i) {
            return batteryWarning2;
        }
        BatteryWarning batteryWarning3 = CRITICAL;
        if (batteryWarning3.getValue() == i) {
            return batteryWarning3;
        }
        return UNKNOWN;
    }
}
