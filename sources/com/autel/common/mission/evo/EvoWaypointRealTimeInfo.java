package com.autel.common.mission.evo;

import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;

public interface EvoWaypointRealTimeInfo extends RealTimeInfo {
    int getActionSequence();

    MissionExecuteState getExecuteState();

    float getSpeed();

    int getWaypointSequence();

    boolean isArrived();

    boolean isDirecting();
}
