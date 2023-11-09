package com.autel.internal.mission.evo2;

import com.autel.AutelNet2.aircraft.visual.VisualModelManager;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportOrbitInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.camera.visual.TargetArea;
import com.autel.common.camera.visual.VisualAction;
import com.autel.common.camera.visual.VisualOrbitParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo2.OrbitExecuteState;
import com.autel.common.mission.evo2.RotateDirect;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.evo2.Evo2VisualOrbitMissionWithUpdate;
import com.autel.internal.sdk.mission.evo2.Evo2VisualOrbitRealTimeInfoImpl;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class Evo2VisualOrbitMissionManager extends MissionManagerWithState {
    Evo2VisualOrbitMissionWithUpdate mTrackingMission;
    /* access modifiers changed from: private */
    public Evo2VisualOrbitRealTimeInfoImpl realTimeInfo = new Evo2VisualOrbitRealTimeInfoImpl();

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public Evo2VisualOrbitMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeVisualOrbitReportListener("setRealTimeInfoListener");
        } else {
            VisualModelManager.instance().setVisualOrbitReportListener("setRealTimeInfoListener", new CallbackWithOneParam<ReportOrbitInfo>() {
                public void onSuccess(ReportOrbitInfo reportOrbitInfo) {
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.maxSpeed = reportOrbitInfo.getMaxSpeed();
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.expectHeight = reportOrbitInfo.getExpectHeight();
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.expectRadius = reportOrbitInfo.getExpectRadius();
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.actualHeight = reportOrbitInfo.getActualHeight();
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.actualRadius = reportOrbitInfo.getActualRadius();
                    boolean z = false;
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.heightFlag = ((reportOrbitInfo.getRotate() >> 31) & 1) == 1;
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.radiusFlag = ((reportOrbitInfo.getRotate() >> 30) & 1) == 1;
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.directFlag = ((reportOrbitInfo.getRotate() >> 28) & 1) == 1;
                    Evo2VisualOrbitRealTimeInfoImpl access$000 = Evo2VisualOrbitMissionManager.this.realTimeInfo;
                    if (((reportOrbitInfo.getRotate() >> 29) & 1) == 1) {
                        z = true;
                    }
                    access$000.speedFlag = z;
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.orbitSpeed = reportOrbitInfo.getSetSpeed();
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.direct = RotateDirect.find(reportOrbitInfo.getRotate() & 1);
                    Evo2VisualOrbitMissionManager.this.realTimeInfo.executeState = OrbitExecuteState.find(reportOrbitInfo.getStatus());
                    callbackWithOneParam.onSuccess(Evo2VisualOrbitMissionManager.this.realTimeInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            Evo2VisualOrbitMissionWithUpdate evo2VisualOrbitMissionWithUpdate = (Evo2VisualOrbitMissionWithUpdate) autelMission;
            this.mTrackingMission = evo2VisualOrbitMissionWithUpdate;
            evo2VisualOrbitMissionWithUpdate.setUpdateListener(new Evo2VisualOrbitMissionWithUpdate.UpdateListener() {
                public void lockTarget(TargetArea targetArea, final CallbackWithNoParam callbackWithNoParam) {
                    VisualModelManager.instance().setVisualOrbitGoalArea(targetArea, new CallbackWithOneParam<VisualSettingAckInfo>() {
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
                    VisualModelManager.instance().setVisualOrbitAction(VisualAction.STOP, new CallbackWithOneParam<VisualSettingAckInfo>() {
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

                public void setOrbitParams(float f, float f2, float f3, RotateDirect rotateDirect, final CallbackWithNoParam callbackWithNoParam) {
                    VisualOrbitParams visualOrbitParams = new VisualOrbitParams();
                    visualOrbitParams.height = f;
                    visualOrbitParams.radius = f2;
                    visualOrbitParams.speed = f3;
                    visualOrbitParams.direct = rotateDirect;
                    VisualModelManager.instance().setVisualOrbitParams(visualOrbitParams, new CallbackWithOneParam<VisualSettingAckInfo>() {
                        public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                            if (callbackWithNoParam != null && visualSettingAckInfo.getAck() == 0) {
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

                public void resetOrbitYaw(final CallbackWithNoParam callbackWithNoParam) {
                    VisualModelManager.instance().resetOrbitYaw(new CallbackWithOneParam<VisualSettingAckInfo>() {
                        public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                            if (callbackWithNoParam == null || visualSettingAckInfo.getAck() != 0) {
                                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                                if (callbackWithNoParam != null) {
                                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                                    return;
                                }
                                return;
                            }
                            callbackWithNoParam.onSuccess();
                        }

                        public void onFailure(AutelError autelError) {
                            CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                            if (callbackWithNoParam != null) {
                                callbackWithNoParam.onFailure(autelError);
                            }
                        }
                    });
                }
            });
            this.missionExecuteState = MissionExecuteState.PREPARE;
            VisualModelManager.instance().setVisualOrbitAction(VisualAction.ENTER, new CallbackWithOneParam<VisualSettingAckInfo>() {
                public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                    if (visualSettingAckInfo.getAck() == 0) {
                        callbackWithOneParamProgress.onSuccess(true);
                    } else {
                        callbackWithOneParamProgress.onFailure(AutelError.COMMAND_FAILED);
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

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualOrbitAction(VisualAction.START, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2VisualOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        VisualModelManager.instance().setVisualSettingSwitchblade(VisualSettingSwitchblade.VISUAL_PAUSE_TASK.getCmdValue(), true, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2VisualOrbitMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
        VisualModelManager.instance().setVisualSettingSwitchblade(VisualSettingSwitchblade.VISUAL_PAUSE_TASK.getCmdValue(), false, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2VisualOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        VisualModelManager.instance().setVisualOrbitAction(VisualAction.EXIT, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    MissionExecuteState unused = Evo2VisualOrbitMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                    if (Evo2VisualOrbitMissionManager.this.mTrackingMission != null) {
                        Evo2VisualOrbitMissionManager.this.mTrackingMission.setUpdateListener((Evo2VisualOrbitMissionWithUpdate.UpdateListener) null);
                    }
                    Evo2VisualOrbitMissionManager.this.mTrackingMission = null;
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
