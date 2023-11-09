package com.autel.internal.mission.evo2;

import com.autel.AutelNet2.aircraft.visual.VisualModelManager;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.UploadGoalArea;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.evo.EvoFollowRealTimeInfoImpl;
import com.autel.internal.sdk.mission.evo2.Evo2TrackingMissionWithUpdate;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class Evo2TrackingMissionManager extends MissionManagerWithState {
    Evo2TrackingMissionWithUpdate mTrackingMission;
    /* access modifiers changed from: private */
    public EvoFollowRealTimeInfoImpl realTimeInfo = new EvoFollowRealTimeInfoImpl();

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public Evo2TrackingMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeTrackingListener("setRealTimeInfoListener");
        } else {
            VisualModelManager.instance().registerTrackingListener("setRealTimeInfoListener", new CallbackWithOneParam<UploadGoalArea>() {
                public void onSuccess(UploadGoalArea uploadGoalArea) {
                    Evo2TrackingMissionManager.this.realTimeInfo.mTrackingArea = uploadGoalArea;
                    callbackWithOneParam.onSuccess(Evo2TrackingMissionManager.this.realTimeInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void prepareMission(C2700AutelMission autelMission, CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            Evo2TrackingMissionWithUpdate evo2TrackingMissionWithUpdate = (Evo2TrackingMissionWithUpdate) autelMission;
            this.mTrackingMission = evo2TrackingMissionWithUpdate;
            evo2TrackingMissionWithUpdate.setUpdateListener(new Evo2TrackingMissionWithUpdate.UpdateListener() {
                public void lockTarget(TrackingTarget trackingTarget, final CallbackWithNoParam callbackWithNoParam) {
                    VisualModelManager.instance().setTrackingGoalArea(trackingTarget, new CallbackWithOneParam<VisualSettingAckInfo>() {
                        public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                            if (visualSettingAckInfo.getAck() == 0) {
                                callbackWithNoParam.onSuccess();
                            } else {
                                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithNoParam.onFailure(autelError);
                        }
                    });
                }

                public void unlockTarget(final CallbackWithNoParam callbackWithNoParam) {
                    VisualModelManager.instance().setVisualTrackingAction(TrackingAction.STOP.getValue(), new CallbackWithOneParam<VisualSettingAckInfo>() {
                        public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                            if (visualSettingAckInfo.getAck() == 0) {
                                callbackWithNoParam.onSuccess();
                            } else {
                                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithNoParam.onFailure(autelError);
                        }
                    });
                }

                public void switchFollowMode(DynamicTrackMode dynamicTrackMode, final CallbackWithNoParam callbackWithNoParam) {
                    if (Evo2TrackingMissionManager.this.missionExecuteState == MissionExecuteState.RUNNING) {
                        VisualModelManager.instance().setVisualTrackingFightMode(Evo2TrackingMissionManager.this.mTrackingMission.getVisualFollowMode().getMode(), new CallbackWithOneParam<VisualSettingAckInfo>() {
                            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
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
                        callbackWithNoParam.onSuccess();
                    }
                }
            });
            this.missionExecuteState = MissionExecuteState.PREPARE;
            callbackWithOneParamProgress.onSuccess(Boolean.TRUE);
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingFightMode(this.mTrackingMission.getVisualFollowMode().getMode(), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2TrackingMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingFightMode(0, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2TrackingMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void resumeMission(final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingFightMode(this.mTrackingMission.getVisualFollowMode().getMode(), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2TrackingMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingAction(TrackingAction.STOP.getValue(), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2TrackingMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                    if (Evo2TrackingMissionManager.this.mTrackingMission != null) {
                        Evo2TrackingMissionManager.this.mTrackingMission.setUpdateListener((Evo2TrackingMissionWithUpdate.UpdateListener) null);
                    }
                    Evo2TrackingMissionManager.this.mTrackingMission = null;
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.mTrackingMission;
    }

    public void downloadMission(CallbackWithOneParamProgress callbackWithOneParamProgress) {
        if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE);
        }
    }
}
