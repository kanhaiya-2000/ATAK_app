package com.autel.internal.sdk.mission.evo;

import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.evo.EvoWaypointRealTimeInfo;

public class EvoWaypointRealTimeInfoImpl implements EvoWaypointRealTimeInfo {
    public int actionSequence;
    public MissionExecuteState executeState;
    public boolean isArrived;
    public boolean isDirecting;
    public float speed;
    public long timeStamp;
    public int waypointSequence;

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean isArrived() {
        return this.isArrived;
    }

    public int getWaypointSequence() {
        return this.waypointSequence;
    }

    public int getActionSequence() {
        return this.actionSequence;
    }

    public boolean isDirecting() {
        return this.isDirecting;
    }

    public MissionExecuteState getExecuteState() {
        return this.executeState;
    }
}
