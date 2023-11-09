package com.autel.common.battery.evo;

import com.autel.common.battery.BatteryState;

public interface EvoBatteryInfo extends BatteryState {
    int getCellNumber();

    int getDeviceStatus();

    float getFullCapacity();

    int getResidualTime();

    int getSafeStatus();

    boolean isBatteryOutOfService();

    boolean isCellOverVoltage();

    boolean isCellUnderVoltage();

    boolean isCellVoltageExceptional();

    boolean isCommunicationFailed();

    boolean isOverCurrentForCharge();

    boolean isOverTemperatureForCharge();

    boolean isOverTemperatureForCharge2();

    boolean isOverTemperatureForDischarge();

    boolean isOverloadForDischarge();

    boolean isShortCircuitForCharge();

    boolean isShortCircuitForDischarge();

    boolean isShortCircuitForDischargeLatch();

    boolean isShutdownNotifyOpened();

    boolean isUnderTemperatureForCharge();

    boolean isUnderTemperatureForDischarge();

    boolean isUnderTemperatureForDischarge2();

    boolean isUnderVoltageForCellCompensated();
}
