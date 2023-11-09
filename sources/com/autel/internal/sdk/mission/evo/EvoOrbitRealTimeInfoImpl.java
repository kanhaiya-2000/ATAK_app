package com.autel.internal.sdk.mission.evo;

import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.evo.EvoOrbitRealTimeInfo;
import com.autel.common.mission.evo.OrbitMode;

public class EvoOrbitRealTimeInfoImpl implements EvoOrbitRealTimeInfo {
    public boolean isCentered;
    public float mAltitude = -1.0f;
    public float mDesignedSpeed;
    public int mLaps = 0;
    public double mLatitude = -1000.0d;
    public double mLongitude = -1000.0d;
    public MissionExecuteState mMissionExecuteState = MissionExecuteState.UNKNOWN;
    public OrbitMode mOrbitMode = OrbitMode.UNKNOWN;
    public float mRadius;
    public long timeBootMs;

    public long getTimeBootMs() {
        return this.timeBootMs;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getDesignedSpeed() {
        return this.mDesignedSpeed;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public OrbitMode getOrbitMode() {
        return this.mOrbitMode;
    }

    public MissionExecuteState getMissionExecuteState() {
        return this.mMissionExecuteState;
    }

    public int getNumberOfLaps() {
        return this.mLaps;
    }
}
