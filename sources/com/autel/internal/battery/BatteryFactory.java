package com.autel.internal.battery;

import com.autel.internal.AutelServiceVersion;
import com.autel.internal.battery.evo.EvoBatteryImpl;
import com.autel.internal.battery.evo.EvoBatteryInitializeProxy;
import com.autel.internal.battery.evo.EvoBatteryService;
import com.autel.internal.battery.evo.EvoBatteryService4Initialize;
import com.autel.internal.battery.xstar.XStarBatteryImpl;
import com.autel.internal.battery.xstar.XStarBatteryInitializeProxy;
import com.autel.internal.battery.xstar.XStarBatteryService;
import com.autel.internal.battery.xstar.XStarBatteryService4Initialize;

public class BatteryFactory {
    public static XStarBatteryService createXStarBattery(AutelServiceVersion autelServiceVersion) {
        return new XStarBatteryImpl();
    }

    public static EvoBatteryService createG2Battery(AutelServiceVersion autelServiceVersion) {
        return new EvoBatteryImpl();
    }

    public static XStarBatteryService4Initialize createXStarBattery() {
        return new XStarBatteryInitializeProxy();
    }

    public static EvoBatteryService4Initialize createG2Battery() {
        return new EvoBatteryInitializeProxy();
    }
}
