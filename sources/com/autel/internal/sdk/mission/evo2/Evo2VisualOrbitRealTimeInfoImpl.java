package com.autel.internal.sdk.mission.evo2;

import com.autel.common.mission.evo2.Evo2VisualOrbitRealTimeInfo;
import com.autel.common.mission.evo2.OrbitExecuteState;
import com.autel.common.mission.evo2.RotateDirect;

public class Evo2VisualOrbitRealTimeInfoImpl implements Evo2VisualOrbitRealTimeInfo {
    public float actualHeight;
    public float actualRadius;
    public RotateDirect direct;
    public boolean directFlag;
    public OrbitExecuteState executeState = OrbitExecuteState.UNKNOWN;
    public float expectHeight;
    public float expectRadius;
    public boolean heightFlag;
    public float maxSpeed;
    public float orbitSpeed;
    public boolean radiusFlag;
    public boolean speedFlag;

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public float getExpectHeight() {
        return this.expectHeight;
    }

    public float getExpectRadius() {
        return this.expectRadius;
    }

    public float getActualHeight() {
        return this.actualHeight;
    }

    public float getActualRadius() {
        return this.actualRadius;
    }

    public boolean directFlag() {
        return this.directFlag;
    }

    public boolean speedFlag() {
        return this.speedFlag;
    }

    public boolean heightFlag() {
        return this.heightFlag;
    }

    public boolean radiusFlag() {
        return this.radiusFlag;
    }

    public float getSpeed() {
        return this.orbitSpeed;
    }

    public RotateDirect getCircleDirect() {
        return this.direct;
    }

    public OrbitExecuteState getExecuteState() {
        return this.executeState;
    }
}
