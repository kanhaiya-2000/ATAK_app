package com.autel.common.battery;

public enum BatteryRecordState {
    Normal(0),
    OverCurrent_in_Charge(1),
    OverCurrent_in_Discharge(2),
    OverTemperature_in_Charge(3),
    OverTemperature_in_Discharge(4),
    Overload_in_Discharge(5),
    QMAX_not_updated(6),
    UNKNOWN(-1);
    
    private int value;

    private BatteryRecordState(int i) {
        this.value = -1;
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BatteryRecordState find(int i) {
        BatteryRecordState batteryRecordState = OverCurrent_in_Charge;
        if (batteryRecordState.getValue() == i) {
            return batteryRecordState;
        }
        BatteryRecordState batteryRecordState2 = OverCurrent_in_Discharge;
        if (batteryRecordState2.getValue() == i) {
            return batteryRecordState2;
        }
        BatteryRecordState batteryRecordState3 = OverTemperature_in_Charge;
        if (batteryRecordState3.getValue() == i) {
            return batteryRecordState3;
        }
        BatteryRecordState batteryRecordState4 = OverTemperature_in_Discharge;
        if (batteryRecordState4.getValue() == i) {
            return batteryRecordState4;
        }
        BatteryRecordState batteryRecordState5 = Overload_in_Discharge;
        if (batteryRecordState5.getValue() == i) {
            return batteryRecordState5;
        }
        BatteryRecordState batteryRecordState6 = QMAX_not_updated;
        if (batteryRecordState6.getValue() == i) {
            return batteryRecordState6;
        }
        return Normal;
    }
}
