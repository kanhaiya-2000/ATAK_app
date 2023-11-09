package com.autel.internal.mission.evo2;

import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
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
import com.autel.common.mission.MissionExecuteMode;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo2.Evo2WaypointMission;
import com.autel.common.product.AutelProductType;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.mission.evo.MissionSerializeUtil;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.mission.evo.MissionOperateType;
import com.autel.internal.sdk.mission.evo.OperateDataType;
import com.autel.internal.sdk.mission.evo2.Evo2WaypointRealTimeInfoImpl;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.util.log.AutelLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class Evo2WaypointMissionManager extends MissionManagerWithState {
    private static final String WaypointInfoListener = "WaypointInfo";
    /* access modifiers changed from: private */
    public boolean isPrintLog = false;
    /* access modifiers changed from: private */
    public Evo2WaypointRealTimeInfoImpl mEvoWaypointRealTimeInfoImpl = new Evo2WaypointRealTimeInfoImpl();
    private Evo2WaypointMission waypointMission;

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public Evo2WaypointMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            AircraftHeatBeatManager2.getInstance().removeIAutelHeartBeatListener(WaypointInfoListener);
            MissionCommonManager2.getInstance().removeMissionCurrentInfoListener(WaypointInfoListener);
            return;
        }
        AircraftHeatBeatManager2.getInstance().addFlyControllerStatusListener(WaypointInfoListener, new CallbackWithOneParam<FlyControllerStatus>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(FlyControllerStatus flyControllerStatus) {
                MissionExecuteMode missionExecuteMode = MissionExecuteMode.UNKNOWN;
                switch (C471912.$SwitchMap$com$autel$common$flycontroller$FlyMode[flyControllerStatus.getFlyMode().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        missionExecuteMode = MissionExecuteMode.GOING_LANDING;
                        break;
                    case 6:
                        missionExecuteMode = MissionExecuteMode.LANDING;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        missionExecuteMode = MissionExecuteMode.IN_MISSION;
                        break;
                    case 10:
                        missionExecuteMode = MissionExecuteMode.TAKE_OFF;
                        break;
                    case 11:
                    case 12:
                    case 13:
                        missionExecuteMode = MissionExecuteMode.HOVER;
                        break;
                }
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.executeMode = missionExecuteMode;
            }
        });
        MissionCommonManager2.getInstance().addMissionCurrentInfoListener(WaypointInfoListener, new CallbackWithOneParam<CurrentMission>() {
            public void onSuccess(CurrentMission currentMission) {
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.timeStamp = currentMission.getTimeBootMs();
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.actionSequence = currentMission.getActionSeq();
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.waypointSequence = currentMission.getWaypointSeq();
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.executeState = MissionExecuteState.find(currentMission.getStatus());
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.speed = currentMission.getSpeedSet();
                boolean z = true;
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.isArrived = currentMission.getArrived() == 1;
                Evo2WaypointRealTimeInfoImpl access$000 = Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl;
                if (currentMission.getDirecting() != 1) {
                    z = false;
                }
                access$000.isDirecting = z;
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.photoCount = currentMission.getPhotoCount();
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.remainFlyTime = currentMission.getResidualTime();
                Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl.remainFlyDistance = currentMission.getResidualDistance();
                if (Evo2WaypointMissionManager.this.isPrintLog) {
                    boolean unused = Evo2WaypointMissionManager.this.isPrintLog = false;
                    AutelLog.debug_i("RealTimeInfoListener", "TimeBootMs-> " + currentMission.getTimeBootMs());
                }
                callbackWithOneParam.onSuccess(Evo2WaypointMissionManager.this.mEvoWaypointRealTimeInfoImpl);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    /* renamed from: com.autel.internal.mission.evo2.Evo2WaypointMissionManager$12 */
    /* synthetic */ class C471912 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$flycontroller$FlyMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.autel.common.flycontroller.FlyMode[] r0 = com.autel.common.flycontroller.FlyMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$flycontroller$FlyMode = r0
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.LOW_BATTERY_GO_HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.EXCEED_RANGE_GO_HOME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.NORMAL_GO_HOME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.RC_LOST_GO_HOME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.MISSION_GO_HOME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.LANDING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.WAYPOINT_MODE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x006c }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.POLYGON     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.WAYPOINT_MODE_HOLD     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.POLYGON_HOLD     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$autel$common$flycontroller$FlyMode     // Catch:{ NoSuchFieldError -> 0x009c }
                com.autel.common.flycontroller.FlyMode r1 = com.autel.common.flycontroller.FlyMode.RECTANGLE_HOLD     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.mission.evo2.Evo2WaypointMissionManager.C471912.<clinit>():void");
        }
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        MissionAllInternal missionAllInternal;
        if (autelMission != null) {
            Evo2WaypointMission evo2WaypointMission = (Evo2WaypointMission) autelMission;
            this.waypointMission = evo2WaypointMission;
            if (evo2WaypointMission.wpList != null && this.waypointMission.wpList.size() != 0) {
                this.isPrintLog = true;
                AutelLog.debug_i("UploadMission", "Cruiser Waypoint Mission prepared start ");
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                AutelProductType product = AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getProduct();
                if (AutelProductType.EVO == product) {
                    missionAllInternal = MissionSerializeUtil.getCruiserWaypointMissionForEvo(this.waypointMission);
                } else {
                    missionAllInternal = MissionSerializeUtil.getCruiserWaypointMission(this.waypointMission);
                }
                AutelLog.debug_i("UploadMission", "prepareMission waypoint list size " + this.waypointMission.wpList.size() + " " + product);
                MissionCommonManager2.getInstance().uploadMission(missionAllInternal, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        AutelLog.debug_i("UploadMission", "Cruiser Waypoint Mission prepared recv data " + bool);
                        if (!bool.booleanValue()) {
                            AutelLog.debug_i("UploadMission", "prepareMission failed prepare callback result is false");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                callbackWithOneParamProgress.onFailure(AutelErrorUtil.createCommandFailedError("prepare callback result is false"));
                            }
                        } else if (atomicBoolean.compareAndSet(false, true)) {
                            callbackWithOneParamProgress.onSuccess(bool);
                        }
                        MsgPostManager.instance().removeCallbacks();
                    }

                    public void onFailure(AutelError autelError) {
                        AutelLog.debug_i("UploadMission", "Cruiser Waypoint Mission prepared recv data error " + autelError.getDescription());
                        if (autelError != AutelError.COMMON_TIMEOUT) {
                            AutelLog.debug_i("UploadMission", "prepareMission failed " + autelError.getDescription());
                            if (atomicBoolean.compareAndSet(false, true)) {
                                callbackWithOneParamProgress.onFailure(autelError);
                            }
                        }
                        MsgPostManager.instance().removeCallbacks();
                    }
                });
                MsgPostManager.instance().removeCallbacks();
                MsgPostManager.instance().postDelayed(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            callbackWithOneParamProgress.onFailure(AutelError.COMMON_TIMEOUT);
                            MissionCommonManager2.getInstance().unRegisterUploadMission();
                            AutelLog.debug_i("UploadMission", "prepareMission failed prepare time out");
                        }
                    }
                }, 180000);
            } else if (callbackWithOneParamProgress != null) {
                callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
            }
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        }
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        AutelLog.debug_i("UploadMission", "startMission send msg");
        MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_START, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                    return;
                }
                AutelLog.debug_i("UploadMission", "startMission failed callback result is false");
                callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("start callback result is false"));
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("UploadMission", "startMission failed " + autelError.getDescription());
            }
        });
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
                AutelLog.debug_i("UploadMission", "pauseMission failed callback result is false");
                callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("pause callback result is false"));
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("UploadMission", "pauseMission failed " + autelError.getDescription());
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
                AutelLog.debug_i("UploadMission", "resumeMission failed callback result is false");
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("UploadMission", "resumeMission failed " + autelError.getDescription());
            }
        });
    }

    public void cancelMission(final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.isPrintLog = false;
            MissionCommonManager2.getInstance().operateMissionByCmd(FmuCmdConstant.MAV_CMD_MISSION_STOP, new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        callbackWithNoParam.onSuccess();
                        return;
                    }
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("cancel callback result is false"));
                    AutelLog.debug_i("UploadMission", "cancelMission failed callback result is false");
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                    AutelLog.debug_i("UploadMission", "cancelMission failed " + autelError.getDescription());
                }
            });
        }
    }

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateStopMissionByCmd(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                    return;
                }
                callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("cancel callback result is false"));
                AutelLog.debug_i("UploadMission", "cancelMission failed callback result is false");
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
                AutelLog.debug_i("UploadMission", "cancelMission failed " + autelError.getDescription());
            }
        });
    }

    public void downloadMission(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MissionCommonManager2.getInstance().downloadAllMissionInfo(new CallbackWithOneParam<MissionAllInternal>() {
            public void onSuccess(MissionAllInternal missionAllInternal) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    Log.d("Mission", "download waypoint size:" + missionAllInternal.getWaypoints().size());
                    if (missionAllInternal.getWaypoints() == null) {
                        callbackWithOneParamProgress.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    if (AutelProductType.EVO == AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getProduct()) {
                        callbackWithOneParamProgress.onSuccess(MissionSerializeUtil.getCruiserWaypointMissionForEvo(missionAllInternal));
                    } else {
                        callbackWithOneParamProgress.onSuccess(MissionSerializeUtil.getCruiserWaypointMission(missionAllInternal));
                    }
                    MsgPostManager.instance().removeCallbacks();
                }
            }

            public void onFailure(AutelError autelError) {
                Log.d("Mission", "download onFailure:" + autelError.getDescription());
                if (autelError != AutelError.COMMON_TIMEOUT && atomicBoolean.compareAndSet(false, true)) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
                MsgPostManager.instance().removeCallbacks();
            }
        });
        MsgPostManager.instance().removeCallbacks();
        MsgPostManager.instance().postDelayed(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                    if (callbackWithOneParamProgress != null) {
                        callbackWithOneParamProgress.onFailure(AutelError.COMMON_TIMEOUT);
                    }
                    AutelLog.debug_i("UploadMission", "prepareMission failed prepare time out");
                }
            }
        }, 90000);
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public C2700AutelMission getCurrentMission() {
        return this.waypointMission;
    }
}
