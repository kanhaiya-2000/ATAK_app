package com.autel.internal.mission.evo;

import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.engine.CurrentMission;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.aircraft.mission.engine.MissionOperateInfoInternal;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo.EvoWaypointMission;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.mission.evo.EvoWaypointRealTimeInfoImpl;
import com.autel.internal.sdk.mission.evo.MissionOperateType;
import com.autel.internal.sdk.mission.evo.OperateDataType;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.util.log.AutelLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class EvoWaypointMissionManager extends MissionManagerWithState {
    private static final String WaypointInfoListener = "WaypointInfo";
    /* access modifiers changed from: private */
    public AtomicBoolean hasCallback = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public EvoWaypointRealTimeInfoImpl mEvoWaypointRealTimeInfoImpl = new EvoWaypointRealTimeInfoImpl();
    private MyPostRunnable myPostRunnable;
    EvoWaypointMission waypointMission;

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public EvoWaypointMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            MissionCommonManager2.getInstance().removeMissionCurrentInfoListener(WaypointInfoListener);
        } else {
            MissionCommonManager2.getInstance().addMissionCurrentInfoListener(WaypointInfoListener, new CallbackWithOneParam<CurrentMission>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(CurrentMission currentMission) {
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.timeStamp = currentMission.getTimeBootMs();
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.actionSequence = currentMission.getActionSeq();
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.waypointSequence = currentMission.getWaypointSeq();
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.executeState = MissionExecuteState.find(currentMission.getStatus());
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.speed = currentMission.getSpeedSet();
                    boolean z = false;
                    EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.isArrived = currentMission.getArrived() == 1;
                    EvoWaypointRealTimeInfoImpl access$000 = EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl;
                    if (currentMission.getDirecting() == 1) {
                        z = true;
                    }
                    access$000.isDirecting = z;
                    callbackWithOneParam.onSuccess(EvoWaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl);
                }
            });
        }
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            EvoWaypointMission evoWaypointMission = (EvoWaypointMission) autelMission;
            this.waypointMission = evoWaypointMission;
            if (evoWaypointMission.wpList != null && this.waypointMission.wpList.size() != 0) {
                this.hasCallback.set(false);
                MissionCommonManager2.getInstance().uploadMission(MissionSerializeUtil.getMissionAllInternal(this.waypointMission), new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        if (!bool.booleanValue()) {
                            AutelLog.debug_i("missionDebug", "prepareMission failed prepare callback result is false");
                            if (EvoWaypointMissionManager.this.hasCallback.compareAndSet(false, true)) {
                                callbackWithOneParamProgress.onFailure(AutelErrorUtil.createCommandFailedError("prepare callback result is false"));
                            }
                        } else if (EvoWaypointMissionManager.this.hasCallback.compareAndSet(false, true)) {
                            callbackWithOneParamProgress.onSuccess(bool);
                        }
                    }

                    public void onFailure(AutelError autelError) {
                        if (autelError != AutelError.COMMON_TIMEOUT) {
                            AutelLog.debug_i("missionDebug", "prepareMission failed " + autelError.getDescription());
                            if (EvoWaypointMissionManager.this.hasCallback.compareAndSet(false, true)) {
                                callbackWithOneParamProgress.onFailure(autelError);
                            }
                        }
                    }
                });
                if (this.myPostRunnable != null) {
                    MsgPostManager.instance().removeCallbacks(this.myPostRunnable);
                }
                MsgPostManager instance = MsgPostManager.instance();
                MyPostRunnable myPostRunnable2 = new MyPostRunnable(callbackWithOneParamProgress);
                this.myPostRunnable = myPostRunnable2;
                instance.postDelayed(myPostRunnable2, 60000);
            } else if (callbackWithOneParamProgress != null) {
                callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
            }
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        }
    }

    class MyPostRunnable extends PostRunnable {
        private CallbackWithOneParamProgress callback;

        public MyPostRunnable(CallbackWithOneParamProgress callbackWithOneParamProgress) {
            this.callback = callbackWithOneParamProgress;
        }

        /* access modifiers changed from: protected */
        public void task() {
            if (EvoWaypointMissionManager.this.hasCallback.compareAndSet(false, true)) {
                this.callback.onFailure(AutelError.COMMON_TIMEOUT);
                MissionCommonManager2.getInstance().unRegisterUploadMission();
                AutelLog.debug_i("missionDebug", "prepareMission failed prepare time out");
            }
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        if (this.waypointMission != null) {
            MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_START, new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        callbackWithNoParam.onSuccess();
                        return;
                    }
                    AutelLog.debug_i("missionDebug", "startMission failed callback result is false");
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("start callback result is false"));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                    AutelLog.debug_i("missionDebug", "startMission failed " + autelError.getDescription());
                }
            });
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
        }
    }

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionOperateInfoInternal missionOperateInfoInternal = new MissionOperateInfoInternal();
        missionOperateInfoInternal.setOperateType(MissionOperateType.REQUEST_PAUSE_TASK);
        missionOperateInfoInternal.setParam1(OperateDataType.WAYPOINT);
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_PAUSE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                    return;
                }
                AutelLog.debug_i("missionDebug", "pauseMission failed callback result is false");
                callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("pause callback result is false"));
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("missionDebug", "pauseMission failed " + autelError.getDescription());
            }
        });
    }

    public void resumeMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_CONTINUE, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("resume callback result is false"));
                AutelLog.debug_i("missionDebug", "resumeMission failed callback result is false");
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("missionDebug", "resumeMission failed " + autelError.getDescription());
            }
        });
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_STOP, new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        callbackWithNoParam.onSuccess();
                        return;
                    }
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("cancel callback result is false"));
                    AutelLog.debug_i("missionDebug", "cancelMission failed callback result is false");
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                    AutelLog.debug_i("missionDebug", "cancelMission failed " + autelError.getDescription());
                }
            });
        }
    }

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateStopMissionByCmd(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                MissionExecuteState unused = EvoWaypointMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MissionCommonManager2.getInstance().downloadAllMissionInfo(new CallbackWithOneParam<MissionAllInternal>() {
            public void onSuccess(MissionAllInternal missionAllInternal) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    AutelLog.debug_i("Mission", "downloadMission onSuccess ");
                    if (missionAllInternal.getWaypoints() == null) {
                        callbackWithOneParamProgress.onFailure(AutelError.COMMAND_FAILED);
                    } else {
                        callbackWithOneParamProgress.onSuccess(MissionSerializeUtil.getEvoWaypointMission(missionAllInternal));
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                AutelLog.debug_i("Mission", "downloadMission onFailure ");
                if (autelError != AutelError.COMMON_TIMEOUT && atomicBoolean.compareAndSet(false, true)) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            }
        });
        MsgPostManager.instance().postDelayed(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    callbackWithOneParamProgress.onFailure(AutelError.COMMON_TIMEOUT);
                    AutelLog.debug_i("Mission", "downloadMission failed prepare time out");
                }
            }
        }, 30000);
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.waypointMission;
    }
}
