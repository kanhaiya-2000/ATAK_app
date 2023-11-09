package com.autel.common.mission.xstar;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.RealTimeInfo;

public interface OrbitRealTimeInfo extends RealTimeInfo {
    float getAngularVelocity();

    AutelCoordinate3D getCoordinate();

    CurrentMissionState getCurrentMissionState();

    int getLap();

    float getRadius();
}
