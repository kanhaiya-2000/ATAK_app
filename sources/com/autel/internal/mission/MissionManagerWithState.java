package com.autel.internal.mission;

import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.mission.MissionExecuteState;
import com.autel.sdk.mission.MissionManager;

public abstract class MissionManagerWithState implements MissionManager {
    protected FlyControllerStatus flyControllerStatus;
    protected volatile MissionExecuteState missionExecuteState = MissionExecuteState.UNKNOWN;

    public MissionManagerWithState(FlyControllerStatus flyControllerStatus2) {
        this.flyControllerStatus = flyControllerStatus2;
    }

    public MissionExecuteState getMissionExecuteState() {
        if (this.flyControllerStatus.getFlyMode() == FlyMode.WAYPOINT_MODE || this.flyControllerStatus.getFlyMode() == FlyMode.RECTANGLE || this.flyControllerStatus.getFlyMode() == FlyMode.POLYGON || this.flyControllerStatus.getFlyMode() == FlyMode.ORBIT_ORBIT || this.flyControllerStatus.getFlyMode() == FlyMode.FOLLOW_FOLLOW || this.flyControllerStatus.getFlyMode() == FlyMode.TRIPOD || this.flyControllerStatus.getFlyMode() == FlyMode.PHOTOGRAPHER) {
            if (this.missionExecuteState == MissionExecuteState.RUNNING) {
                return this.missionExecuteState;
            }
            return MissionExecuteState.RUNNING;
        } else if (this.missionExecuteState == MissionExecuteState.RUNNING) {
            return MissionExecuteState.COMPLETED;
        } else {
            return this.missionExecuteState;
        }
    }
}
