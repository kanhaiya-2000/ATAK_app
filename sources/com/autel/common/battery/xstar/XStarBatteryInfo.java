package com.autel.common.battery.xstar;

import com.autel.common.battery.BatteryState;

public interface XStarBatteryInfo extends BatteryState {
    int getFullChargeCapacity();

    float getNumberOfDischarges();

    String getSerialNumber();

    String getVersion();

    boolean isBatteryOverHeated();
}
