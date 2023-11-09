package com.autel.common.flycontroller;

import com.autel.common.mission.AutelCoordinate3D;

public interface GPSInfo {
    AutelCoordinate3D getCoordinate();

    int getGpsCount();

    int getSatelliteStrength();
}
