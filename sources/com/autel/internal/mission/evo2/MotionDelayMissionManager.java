package com.autel.internal.mission.evo2;

import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.camera.protocol.protocol20.interfaces.CameraXT701;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.camera.protocol.protocol20.xtbasic.C2630XT701;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo.MotionDelayMission;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.mission.evo.MissionSerializeUtil;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class MotionDelayMissionManager extends MissionManagerWithState {
    private CameraXT701 cameraRequest = ((CameraXT701) CameraFactory.getCameraProduct(C2630XT701.class));
    MotionDelayMission missionWithUpdate;

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public MotionDelayMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            this.missionWithUpdate = (MotionDelayMission) autelMission;
            MissionAllInternal missionAllInternal = new MissionAllInternal();
            missionAllInternal.setFMUMissionInfo(MissionSerializeUtil.getMissionSingleInfo(this.missionWithUpdate));
            missionAllInternal.setMotionDelayInfo(MissionSerializeUtil.getMotionDelayInfo(this.missionWithUpdate));
            MissionCommonManager2.getInstance().uploadMission(missionAllInternal, new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.PREPARE;
                    if (bool.booleanValue()) {
                        callbackWithOneParamProgress.onSuccess(true);
                    } else {
                        callbackWithOneParamProgress.onFailure(AutelErrorUtil.createCommandFailedError("prepare callback result is false"));
                    }
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                    if (callbackWithOneParamProgress != null) {
                        callbackWithOneParamProgress.onFailure(autelError);
                    }
                }
            });
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_START, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("start callback result is false"));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
        this.cameraRequest.startMotionDelayShot(callbackWithNoParam);
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_PAUSE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("pause callback result is false"));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
        this.cameraRequest.pauseMotionDelayShot(callbackWithNoParam);
    }

    public void resumeMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_CONTINUE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("resume callback result is false"));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
        this.cameraRequest.resumeMotionDelayShot(callbackWithNoParam);
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_STOP, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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
        this.cameraRequest.stopMotionDelayShot(callbackWithNoParam);
    }

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_STOP, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = MotionDelayMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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
        this.cameraRequest.stopMotionDelayShot(callbackWithNoParam);
    }

    public void downloadMission(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        MissionCommonManager2.getInstance().downloadAllMissionInfo(new CallbackWithOneParam<MissionAllInternal>() {
            public void onSuccess(MissionAllInternal missionAllInternal) {
                MotionDelayMission motionDelayMission = MissionSerializeUtil.getMotionDelayMission(missionAllInternal);
                if (motionDelayMission == null) {
                    callbackWithOneParamProgress.onFailure(AutelError.COMMAND_FAILED);
                } else {
                    callbackWithOneParamProgress.onSuccess(motionDelayMission);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParamProgress.onFailure(autelError);
            }
        });
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.missionWithUpdate;
    }
}
