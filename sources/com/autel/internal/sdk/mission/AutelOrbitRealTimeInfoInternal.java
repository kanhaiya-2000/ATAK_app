package com.autel.internal.sdk.mission;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.xstar.OrbitRealTimeInfo;

public class AutelOrbitRealTimeInfoInternal implements OrbitRealTimeInfo {
    private AutelCoordinate3D coord;
    private int lap;
    private float radius;
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
    public void setLap(int i) {
        this.lap = i;
    }

    public int getLap() {
        return this.lap;
    }

    /* access modifiers changed from: protected */
    public void setCoord(AutelCoordinate3D autelCoordinate3D) {
        this.coord = autelCoordinate3D;
    }

    public AutelCoordinate3D getCoordinate() {
        return this.coord;
    }

    /* access modifiers changed from: protected */
    public void setRadius(float f) {
        this.radius = f;
    }

    public float getRadius() {
        return this.radius;
    }
}
