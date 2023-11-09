package com.autel.internal.mission.xstar;

import android.location.Location;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.FollowMissionWithUpdate;
import com.autel.internal.sdk.mission.FollowMode;
import com.autel.internal.sdk.mission.FollowSwitch;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class XStarFollowMissionManager extends MissionManagerWithState {
    FollowMissionWithUpdate followMission;

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public XStarFollowMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelError.MISSION_FOLLOW_REAL_TIME_IS_NOT_NEED);
        }
    }

    public void prepareMission(C2700AutelMission autelMission, CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            FollowMissionWithUpdate followMissionWithUpdate = (FollowMissionWithUpdate) autelMission;
            if (followMissionWithUpdate.location != null) {
                this.followMission = followMissionWithUpdate;
                followMissionWithUpdate.setUpdateListener(new FollowMissionWithUpdate.UpdateListener() {
                    public void update(Location location) {
                        if (XStarFollowMissionManager.this.getMissionExecuteState() == MissionExecuteState.RUNNING) {
                            MissionManager.getAutelFollowMissionRequestManager().followFromLocation(location);
                        }
                    }
                });
                MissionManager.getAutelFollowMissionRequestManager().followFromLocation(this.followMission.location);
                callbackWithOneParamProgress.onProgress(1.0f);
                callbackWithOneParamProgress.onSuccess(Boolean.TRUE);
                this.missionExecuteState = MissionExecuteState.PREPARE;
                return;
            }
        }
        if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelFollowMissionRequestManager().switchFollow(FollowSwitch.ENABLE, FollowMode.FOLLOW, new AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch>() {
            public void onResult(FollowSwitch followSwitch) {
                MissionExecuteState unused = XStarFollowMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelFollowMissionRequestManager().switchFollow(FollowSwitch.DISABLE, FollowMode.FOLLOW, new AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch>() {
            public void onResult(FollowSwitch followSwitch) {
                MissionExecuteState unused = XStarFollowMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void resumeMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelFollowMissionRequestManager().switchFollow(FollowSwitch.ENABLE, FollowMode.FOLLOW, new AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch>() {
            public void onResult(FollowSwitch followSwitch) {
                MissionExecuteState unused = XStarFollowMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelFollowMissionRequestManager().switchFollow(FollowSwitch.DISABLE, FollowMode.FOLLOW, new AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch>() {
            public void onResult(FollowSwitch followSwitch) {
                MissionExecuteState unused = XStarFollowMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                if (XStarFollowMissionManager.this.followMission != null) {
                    XStarFollowMissionManager.this.followMission.setUpdateListener((FollowMissionWithUpdate.UpdateListener) null);
                }
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.followMission;
    }

    public void downloadMission(CallbackWithOneParamProgress callbackWithOneParamProgress) {
        if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE);
        }
    }
}
