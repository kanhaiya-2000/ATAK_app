package com.autel.internal.sdk.mission;

public class MissionInfo {
    protected AutelOrbit autelOrbit = new AutelOrbit();
    protected MissionFinishedAction missionFinishedAction;
    protected float missionFlySpeed;
    protected OrbitRotation orbitRotation;
    protected long updatetime_missionFlySpeed;

    public float getMissionFlySpeed() {
        return this.missionFlySpeed;
    }

    public AutelOrbit getAutelOrbit() {
        return this.autelOrbit;
    }

    public OrbitRotation getAutelOrbitRotation() {
        return this.orbitRotation;
    }

    public MissionFinishedAction getAutelMissionFinishedAction() {
        return this.missionFinishedAction;
    }
}
