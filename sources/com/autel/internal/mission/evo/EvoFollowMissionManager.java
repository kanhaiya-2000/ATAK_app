package com.autel.internal.mission.evo;

import android.location.Location;
import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.engine.GpsTargetInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo.EvoFollowMission;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.mission.FollowMode;
import com.autel.internal.sdk.mission.FollowSwitch;
import com.autel.internal.sdk.mission.evo.EvoFollowMissionWithUpdate;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class EvoFollowMissionManager extends MissionManagerWithState {
    EvoFollowMissionWithUpdate followMission;

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public EvoFollowMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelError.MISSION_FOLLOW_REAL_TIME_IS_NOT_NEED);
        }
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null && (autelMission instanceof EvoFollowMission) && ((EvoFollowMission) autelMission).location != null) {
            EvoFollowMissionWithUpdate evoFollowMissionWithUpdate = (EvoFollowMissionWithUpdate) autelMission;
            this.followMission = evoFollowMissionWithUpdate;
            evoFollowMissionWithUpdate.setUpdateListener(new EvoFollowMissionWithUpdate.UpdateListener() {
                public void update(Location location) {
                    if (EvoFollowMissionManager.this.getMissionExecuteState() == MissionExecuteState.RUNNING) {
                        MissionCommonManager2.getInstance().gpsTargetMission(MissionSerializeUtil.getGpsTargetInfo(EvoFollowMissionManager.this.followMission.location));
                    }
                }
            });
            this.missionExecuteState = MissionExecuteState.PREPARE;
            callbackWithOneParamProgress.onProgress(1.0f);
            MissionCommonManager2.getInstance().gpsTargetMission(MissionSerializeUtil.getGpsTargetInfo(this.followMission.location));
            MissionCommonManager2.getInstance().gpsFollowMeMission(MissionSerializeUtil.getGpsFollowMeInfo(this.followMission), new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        callbackWithOneParamProgress.onSuccess(bool);
                    } else {
                        callbackWithOneParamProgress.onFailure(AutelErrorUtil.createCommandFailedError("prepare callback result is false"));
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            });
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
        }
    }

    public void startMission(CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().gpsTargetMission(new GpsTargetInfo());
        if (callbackWithNoParam != null) {
            callbackWithNoParam.onSuccess();
        }
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelFollowMissionRequestManager().switchFollow(FollowSwitch.DISABLE, FollowMode.FOLLOW, new AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch>() {
            public void onResult(FollowSwitch followSwitch) {
                MissionExecuteState unused = EvoFollowMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
                MissionExecuteState unused = EvoFollowMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
                MissionExecuteState unused = EvoFollowMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                if (EvoFollowMissionManager.this.followMission != null) {
                    EvoFollowMissionManager.this.followMission.setUpdateListener((EvoFollowMissionWithUpdate.UpdateListener) null);
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

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateStopMissionByCmd(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoFollowMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("cancel callback result is false"));
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
