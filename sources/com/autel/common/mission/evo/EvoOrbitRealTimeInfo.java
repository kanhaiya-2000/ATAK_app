package com.autel.common.mission.evo;

import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;

public interface EvoOrbitRealTimeInfo extends RealTimeInfo {
    float getDesignedSpeed();

    double getLatitude();

    double getLongitude();

    MissionExecuteState getMissionExecuteState();

    int getNumberOfLaps();

    OrbitMode getOrbitMode();

    float getRadius();
}
