package com.autel.internal.sdk.mission.evo2;

import com.autel.common.mission.MissionExecuteMode;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.evo2.Evo2WaypointRealTimeInfo;

public class Evo2WaypointRealTimeInfoImpl implements Evo2WaypointRealTimeInfo {
    public int actionSequence;
    public MissionExecuteMode executeMode = MissionExecuteMode.UNKNOWN;
    public MissionExecuteState executeState = MissionExecuteState.UNKNOWN;
    public boolean isArrived;
    public boolean isDirecting;
    public int photoCount;
    public int remainFlyDistance;
    public int remainFlyTime;
    public float speed;
    public long timeStamp;
    public int waypointSequence;

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getPhotoCount() {
        return this.photoCount;
    }

    public int getRemainFlyTime() {
        return this.remainFlyTime;
    }

    public int getRemainFlyDistance() {
        return this.remainFlyDistance;
    }

    public MissionExecuteMode getMissionExecuteMode() {
        return this.executeMode;
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

    public MissionExecuteMode getExecuteMode() {
        return this.executeMode;
    }
}
