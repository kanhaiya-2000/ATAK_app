package com.autel.common.flycontroller;

public interface FlyControllerInfo {
    AltitudeAndSpeedInfo getAltitudeAndSpeedInfo();

    AttitudeInfo getAttitudeInfo();

    FlyControllerStatus getFlyControllerStatus();

    FlyHome getFlyHome();

    GPSInfo getGPSInfo();
}
