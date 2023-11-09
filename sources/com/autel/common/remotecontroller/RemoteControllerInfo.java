package com.autel.common.remotecontroller;

public interface RemoteControllerInfo {
    int getBatteryCapacityPercentage();

    int getControllerSignalPercentage();

    int getDSPPercentage();

    RemoteControllerStickCalibration getStickCalibration();
}
