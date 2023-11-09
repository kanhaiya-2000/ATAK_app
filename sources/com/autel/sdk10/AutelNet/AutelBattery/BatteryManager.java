package com.autel.sdk10.AutelNet.AutelBattery;

import com.autel.sdk10.AutelNet.AutelBattery.info.AutelBatteryInfo;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.autel.sdk10.AutelNet.AutelBattery.requestmanager.AutelBatteryRequestManager;

public final class BatteryManager {
    private static AutelBatteryRequestManager manager;

    private BatteryManager() {
    }

    public static AutelBatteryRequestManager getAutelBatteryRequestManager() {
        if (manager == null) {
            manager = new AutelBatteryRequestManager();
        }
        return manager;
    }

    public static BatteryInfoParser getAutelBatteryInfoParser() {
        return BatteryInfoParser.getInstance_();
    }

    public static AutelBatteryInfo getAutelBatteryInfo() {
        return BatteryInfoParser.getInstance_();
    }
}
