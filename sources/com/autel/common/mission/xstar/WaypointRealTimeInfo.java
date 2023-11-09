package com.autel.common.mission.xstar;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.RealTimeInfo;

public interface WaypointRealTimeInfo extends RealTimeInfo {
    float getAngularVelocity();

    CurrentMissionState getCurrentMissionState();

    AutelCoordinate3D getNextWaypointCoordinate();

    int getSeq();
}
