package com.autel.internal.mission.evo;

import android.location.Location;
import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.engine.HotPointInfoInternal;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo.EvoOrbitMission;
import com.autel.common.mission.evo.OrbitMode;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.mission.FollowMissionWithUpdate;
import com.autel.internal.sdk.mission.evo.EvoOrbitMissionWithUpdate;
import com.autel.internal.sdk.mission.evo.EvoOrbitRealTimeInfoImpl;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class EvoOrbitMissionManager extends MissionManagerWithState {
    private static final String orbitInfoListenerTag = "OrbitInfoListener";
    EvoOrbitRealTimeInfoImpl mEvoOrbitRealTimeInfo = new EvoOrbitRealTimeInfoImpl();
    EvoOrbitMissionWithUpdate orbitMission;

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public EvoOrbitMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            MissionCommonManager2.getInstance().removeMissionHotPointListener(orbitInfoListenerTag);
        } else {
            MissionCommonManager2.getInstance().addMissionHotPointListener(orbitInfoListenerTag, new CallbackWithOneParam<HotPointInfoInternal>() {
                public void onSuccess(HotPointInfoInternal hotPointInfoInternal) {
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mDesignedSpeed = hotPointInfoInternal.getSpeedSet();
                    EvoOrbitRealTimeInfoImpl evoOrbitRealTimeInfoImpl = EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo;
                    boolean z = true;
                    if (hotPointInfoInternal.getCentered() != 1) {
                        z = false;
                    }
                    evoOrbitRealTimeInfoImpl.isCentered = z;
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mLatitude = hotPointInfoInternal.getLatitude();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mLongitude = hotPointInfoInternal.getLongitude();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mAltitude = hotPointInfoInternal.getAltitude();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mRadius = hotPointInfoInternal.getRadius();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mOrbitMode = OrbitMode.find(hotPointInfoInternal.getType());
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mLaps = hotPointInfoInternal.getOrbitCount();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.timeBootMs = (long) hotPointInfoInternal.getTimeBootMs();
                    EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo.mMissionExecuteState = MissionExecuteState.find(hotPointInfoInternal.getStatus());
                    callbackWithOneParam.onSuccess(EvoOrbitMissionManager.this.mEvoOrbitRealTimeInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            EvoOrbitMissionWithUpdate evoOrbitMissionWithUpdate = (EvoOrbitMissionWithUpdate) autelMission;
            this.orbitMission = evoOrbitMissionWithUpdate;
            evoOrbitMissionWithUpdate.setUpdateListener(new FollowMissionWithUpdate.UpdateListener() {
                public void update(Location location) {
                }
            });
            MissionAllInternal missionAllInternal = new MissionAllInternal();
            missionAllInternal.setFMUMissionInfo(MissionSerializeUtil.getMissionSingleInfo((EvoOrbitMission) this.orbitMission));
            missionAllInternal.setOrbitInfo(MissionSerializeUtil.getOrbitInfo(this.orbitMission));
            MissionCommonManager2.getInstance().uploadMission(missionAllInternal, new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.PREPARE;
                    if (bool.booleanValue()) {
                        callbackWithOneParamProgress.onSuccess(bool);
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
                MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_PAUSE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
    }

    public void resumeMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_CONTINUE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_STOP, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateStopMissionByCmd(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoOrbitMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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

    public void downloadMission(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        MissionCommonManager2.getInstance().downloadAllMissionInfo(new CallbackWithOneParam<MissionAllInternal>() {
            public void onSuccess(MissionAllInternal missionAllInternal) {
                EvoOrbitMission evoOrbitMission = MissionSerializeUtil.getEvoOrbitMission(missionAllInternal);
                if (evoOrbitMission == null) {
                    callbackWithOneParamProgress.onFailure(AutelError.COMMAND_FAILED);
                } else {
                    callbackWithOneParamProgress.onSuccess(evoOrbitMission);
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
        return this.orbitMission;
    }
}
