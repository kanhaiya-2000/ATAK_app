package com.autel.sdk10.AutelNet.AutelMission.info;

import com.autel.internal.sdk.mission.AutelOrbit;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.sdk10.AutelNet.AutelMission.enums.AutelOrbitWise;

public class AutelMissionInfo {
    protected MissionFinishedAction autelMissionFinishedType;
    protected AutelOrbit autelOrbit = new AutelOrbit();
    protected AutelOrbitWise autelOrbitWise;
    protected float missionFlySpeed;
    protected long updatetime_missionFlySpeed;

    public float getMissionFlySpeed() {
        return this.missionFlySpeed;
    }

    public AutelOrbit getAutelOrbit() {
        return this.autelOrbit;
    }

    public AutelOrbitWise getAutelOrbitWise() {
        return this.autelOrbitWise;
    }

    public MissionFinishedAction getAutelMissionFinishedType() {
        return this.autelMissionFinishedType;
    }
}
