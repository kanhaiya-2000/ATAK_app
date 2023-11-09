package com.autel.common.flycontroller.evo;

import com.autel.common.flycontroller.AltitudeAndSpeedInfo;

public interface LocalCoordinateInfo extends AltitudeAndSpeedInfo {
    int getDistance();

    double getHomeAltitude();

    int getHomeCoordinate();

    int getHomeEnable();

    double getHomeLatitude();

    double getHomeLongitude();

    float getHomeYaw();

    double getLatitude();

    double getLongitude();
}
