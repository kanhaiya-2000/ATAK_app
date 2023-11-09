package com.autel.common.battery;

public interface BatteryState {
    BatteryWarning getBatteryWarning();

    float getCapacity();

    float getCurrent();

    float getDesignedCapacity();

    float getRemainTime();

    int getRemainingPercent();

    float getTemperature();

    float getVoltage();

    int[] getVoltageCells();
}
