package com.autel.common.mission.evo2;

import com.autel.common.mission.RealTimeInfo;

public interface Evo2VisualOrbitRealTimeInfo extends RealTimeInfo {
    boolean directFlag();

    float getActualHeight();

    float getActualRadius();

    RotateDirect getCircleDirect();

    OrbitExecuteState getExecuteState();

    float getExpectHeight();

    float getExpectRadius();

    float getMaxSpeed();

    float getSpeed();

    boolean heightFlag();

    boolean radiusFlag();

    boolean speedFlag();
}
