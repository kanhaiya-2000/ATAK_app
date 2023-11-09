package com.autel.sdk.product;

import com.autel.sdk.battery.EvoBattery;
import com.autel.sdk.dsp.EvoDsp;
import com.autel.sdk.flycontroller.Evo2FlyController;
import com.autel.sdk.gimbal.EvoGimbal;

public interface Evo2Aircraft extends BaseProduct {
    EvoBattery getBattery();

    EvoDsp getDsp();

    Evo2FlyController getFlyController();

    EvoGimbal getGimbal();
}
