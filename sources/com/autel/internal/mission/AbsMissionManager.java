package com.autel.internal.mission;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo.EvoFollowMission;
import com.autel.common.mission.evo.EvoOrbitMission;
import com.autel.common.mission.xstar.FollowMission;
import com.autel.common.mission.xstar.OrbitMission;
import com.autel.common.mission.xstar.WaypointMission;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.mission.MissionManager;

public abstract class AbsMissionManager implements MissionManagerService {
    protected C4930AutelFlyController autelFlyController;
    protected MissionManager currentMissionManager;

    /* access modifiers changed from: protected */
    public abstract void checkMissionValidate(C2700AutelMission autelMission, CallbackWithNoParam callbackWithNoParam);

    /* access modifiers changed from: protected */
    public abstract void initPrepare(C2700AutelMission autelMission, CallbackWithOneParamProgress callbackWithOneParamProgress);

    public AbsMissionManager(C4930AutelFlyController autelFlyController2) {
        this.autelFlyController = autelFlyController2;
    }

    public void prepareMission(final C2700AutelMission autelMission, final CallbackWithOneParamProgress callbackWithOneParamProgress) {
        if (autelMission != null) {
            checkMissionValidate(autelMission, new CallbackWithNoParam() {
                public void onSuccess() {
                    AbsMissionManager.this.initPrepare(autelMission, callbackWithOneParamProgress);
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                    if (callbackWithOneParamProgress != null) {
                        callbackWithOneParamProgress.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    /* access modifiers changed from: protected */
    public MissionFinishedAction getFinishAction(C2700AutelMission autelMission) {
        if (autelMission instanceof FollowMission) {
            return MissionFinishedAction.convert(((FollowMission) autelMission).finishedAction);
        }
        if (autelMission instanceof EvoFollowMission) {
            return MissionFinishedAction.convert(((EvoFollowMission) autelMission).finishedAction);
        }
        if (autelMission instanceof OrbitMission) {
            return MissionFinishedAction.convert(((OrbitMission) autelMission).finishedAction);
        }
        if (autelMission instanceof EvoOrbitMission) {
            return MissionFinishedAction.convert(((EvoOrbitMission) autelMission).finishedAction);
        }
        if (autelMission instanceof WaypointMission) {
            return MissionFinishedAction.convert(((WaypointMission) autelMission).finishedAction);
        }
        return MissionFinishedAction.HOVER;
    }

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.setRealTimeInfoListener(callbackWithOneParam);
        } else if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public void startMission(CallbackWithNoParam callbackWithNoParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.startMission(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public void pauseMission(CallbackWithNoParam callbackWithNoParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.pauseMission(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public void resumeMission(CallbackWithNoParam callbackWithNoParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.resumeMission(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public void cancelMission(CallbackWithNoParam callbackWithNoParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.cancelMission(callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            missionManager.cancelMission(i, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED);
        }
    }

    public C2700AutelMission getCurrentMission() {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            return missionManager.getCurrentMission();
        }
        return null;
    }

    public MissionExecuteState getMissionExecuteState() {
        MissionManager missionManager = this.currentMissionManager;
        if (missionManager != null) {
            return missionManager.getMissionExecuteState();
        }
        return MissionExecuteState.UNKNOWN;
    }
}
