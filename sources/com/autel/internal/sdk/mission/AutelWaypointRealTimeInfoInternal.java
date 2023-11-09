package com.autel.internal.sdk.mission;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.xstar.WaypointRealTimeInfo;

public class AutelWaypointRealTimeInfoInternal implements WaypointRealTimeInfo {
    private AutelCoordinate3D nextWaypointCoord;
    private int seq;
    private float velocity_sp;

    public CurrentMissionState getCurrentMissionState() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void setVelocitySpeed(float f) {
        this.velocity_sp = f;
    }

    public float getAngularVelocity() {
        return this.velocity_sp;
    }

    /* access modifiers changed from: protected */
    public void setSeq(int i) {
        this.seq = i;
    }

    public int getSeq() {
        return this.seq;
    }

    public AutelCoordinate3D getNextWaypointCoordinate() {
        return this.nextWaypointCoord;
    }

    /* access modifiers changed from: protected */
    public void setNextWaypointCoord(AutelCoordinate3D autelCoordinate3D) {
        this.nextWaypointCoord = autelCoordinate3D;
    }
}
