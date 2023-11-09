package com.autel.common.mission.evo2;

import com.autel.common.mission.RealTimeInfo;

public interface BreakPointMissionInfo extends RealTimeInfo {
    int getExecuteIndex();

    String getGUID();

    int getMissionId();

    int getMissionType();
}
