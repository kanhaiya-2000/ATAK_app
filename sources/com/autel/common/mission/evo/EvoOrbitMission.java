package com.autel.common.mission.evo;

import com.autel.common.mission.OrbitFinishedAction;
import com.autel.internal.sdk.mission.evo.EvoOrbitMissionWithUpdate;

public class EvoOrbitMission extends EvoMission {
    public float altitude;
    public int cycles;
    public OrbitFinishedAction finishedAction = OrbitFinishedAction.RETURN_HOME;
    public double latitude;
    public double longitude;
    public OrbitEntryDirection mEntryDirection;
    public OrbitHeadingDirection mHeadingDirection;
    public OrbitRotateDirection mRotateDirection;
    public float oRadius;
    public float oSpeed;
    public int radius;
    public int remainDegree;
    public int speed;

    public static EvoOrbitMission createMission() {
        return new EvoOrbitMissionWithUpdate();
    }

    protected EvoOrbitMission() {
    }

    public String toString() {
        return "radius : " + this.radius + ", speed : " + this.speed + ", cycles : " + this.cycles + ", remainDegree : " + this.remainDegree + ", finishedAction : " + this.finishedAction + ", mRotateDirection : " + this.mRotateDirection + ", mHeadingDirection : " + this.mHeadingDirection + ", mEntryDirection : " + this.mEntryDirection + ", altitude : " + this.altitude + ", latitude : " + this.latitude + ", longitude : " + this.longitude;
    }
}
