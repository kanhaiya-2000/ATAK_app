package com.autel.sdk.product;

import com.autel.sdk.battery.EvoBattery;
import com.autel.sdk.dsp.EvoDsp;
import com.autel.sdk.flycontroller.EvoFlyController;
import com.autel.sdk.gimbal.EvoGimbal;

public interface EvoAircraft extends BaseProduct {
    EvoBattery getBattery();

    EvoDsp getDsp();

    EvoFlyController getFlyController();

    EvoGimbal getGimbal();
}
