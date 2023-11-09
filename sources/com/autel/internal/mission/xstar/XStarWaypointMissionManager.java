package com.autel.internal.mission.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.common.mission.xstar.WaypointMission;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.internal.sdk.mission.MissionStatus;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import java.util.ArrayList;

public class XStarWaypointMissionManager extends MissionManagerWithState {
    private static final String WaypointInfoListener = "WaypointInfo";
    WaypointMission waypointMission;

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public XStarWaypointMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            MissionManager.getAutelWaypointMissionRequestManager().removeRealTimeWaypointInfoListener(WaypointInfoListener);
        } else {
            MissionManager.getAutelWaypointMissionRequestManager().addRealTimeWaypointInfoListener(WaypointInfoListener, new AutelMissionInterface.IWaypointRealtimeInfoListener() {
                public void onWaypointRealtimeInfo(AutelWaypointRealTimeInfoInternal autelWaypointRealTimeInfoInternal) {
                    callbackWithOneParam.onSuccess(autelWaypointRealTimeInfoInternal);
                }
            });
        }
    }

    public void prepareMission(final C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            WaypointMission waypointMission2 = (WaypointMission) autelMission;
            this.waypointMission = waypointMission2;
            if (waypointMission2.wpList == null || this.waypointMission.wpList.size() == 0) {
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
                }
            } else if (this.waypointMission.wpList.size() <= 99) {
                MissionManager.getAutelWaypointMissionRequestManager().uploadWaypoint(this.waypointMission.wpList, new AutelMissionInterface.IWaypointMissionUploadListener() {
                    public void onResult(final boolean z) {
                        MissionManager.getAutelMissonCommonRequestManager().setMissionFinishedType(MissionFinishedAction.convert(((WaypointMission) autelMission).finishedAction), autelMission.finishReturnHeight, new AutelCompletionCallback.ICompletionCallbackWith<MissionFinishedAction>() {
                            public void onResult(MissionFinishedAction missionFinishedAction) {
                                MissionExecuteState unused = XStarWaypointMissionManager.this.missionExecuteState = MissionExecuteState.PREPARE;
                                if (callbackWithOneParamProgress != null) {
                                    callbackWithOneParamProgress.onProgress(1.0f);
                                    callbackWithOneParamProgress.onSuccess(Boolean.valueOf(z));
                                }
                            }

                            public void onFailure(AutelError autelError) {
                                if (callbackWithOneParamProgress != null) {
                                    callbackWithOneParamProgress.onFailure(autelError);
                                }
                            }
                        });
                    }

                    public void onProgress(float f) {
                        CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                        if (callbackWithOneParamProgress != null && f != 1.0f) {
                            callbackWithOneParamProgress.onProgress(f);
                        }
                    }
                });
            } else if (callbackWithOneParamProgress != null) {
                callbackWithOneParamProgress.onFailure(AutelError.WAYPOINT_OUT_OF_MAX_POINTS);
            }
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        if (this.waypointMission != null) {
            MissionManager.getAutelWaypointMissionRequestManager().startWayPointMission(this.waypointMission.speed, new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
                public void onResult(Boolean bool) {
                    MissionExecuteState unused = XStarWaypointMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
        }
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelWaypointMissionRequestManager().setWayPointMissionStatus(MissionStatus.PAUSE, new AutelCompletionCallback.ICompletionCallbackWith<MissionStatus>() {
            public void onResult(MissionStatus missionStatus) {
                MissionExecuteState unused = XStarWaypointMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
        MissionManager.getAutelWaypointMissionRequestManager().setWayPointMissionStatus(MissionStatus.CONTINUE, new AutelCompletionCallback.ICompletionCallbackWith<MissionStatus>() {
            public void onResult(MissionStatus missionStatus) {
                MissionExecuteState unused = XStarWaypointMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        if (callbackWithNoParam != null) {
            MissionManager.getAutelWaypointMissionRequestManager().setWayPointMissionStatus(MissionStatus.CANCEL, new AutelCompletionCallback.ICompletionCallbackWith<MissionStatus>() {
                public void onResult(MissionStatus missionStatus) {
                    MissionExecuteState unused = XStarWaypointMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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
    }

    public void downloadMission(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        MissionManager.getAutelWaypointMissionRequestManager().requestCurrentWaypointMission(new AutelMissionInterface.IWaypointMissionDownloadListener() {
            public void onResult(ArrayList<Waypoint> arrayList) {
                WaypointMission waypointMission = new WaypointMission();
                waypointMission.wpList = arrayList;
                XStarWaypointMissionManager.this.waypointMission = waypointMission;
                callbackWithOneParamProgress.onSuccess(waypointMission);
            }

            public void onProgress(float f) {
                callbackWithOneParamProgress.onProgress(f);
            }
        });
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.waypointMission;
    }
}
