package com.autel.sdk.product;

import com.autel.sdk.battery.XStarBattery;
import com.autel.sdk.dsp.XStarDsp;
import com.autel.sdk.flycontroller.XStarFlyController;
import com.autel.sdk.gimbal.XStarGimbal;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;

public interface XStarAircraft extends BaseProduct {
    XStarBattery getBattery();

    XStarDsp getDsp();

    XStarFlyController getFlyController();

    XStarGimbal getGimbal();

    C4932AutelRemoteController getRemoteController();
}
