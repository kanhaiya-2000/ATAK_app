package com.autel.common.mission.evo2;

import com.autel.common.mission.MissionExecuteMode;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;

public interface Evo2WaypointRealTimeInfo extends RealTimeInfo {
    int getActionSequence();

    MissionExecuteState getExecuteState();

    MissionExecuteMode getMissionExecuteMode();

    int getPhotoCount();

    int getRemainFlyDistance();

    int getRemainFlyTime();

    float getSpeed();

    int getWaypointSequence();

    boolean isArrived();

    boolean isDirecting();
}
