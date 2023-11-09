package com.autel.internal.mission;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.battery.BatteryState;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class MissionManagerPreconditionProxy implements MissionManagerService {
    private BatteryState batteryStatus;
    private CallbackWithOneParam<RealTimeInfo> breakPointInfoListener;
    protected FlyControllerStatus flyControllerStatus;
    protected GPSInfo gpsInfo;
    private MissionManager missionManager;
    /* access modifiers changed from: private */
    public CallbackWithOneParam<RealTimeInfo> realTimeInfoListener;

    public void connect() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public MissionManagerPreconditionProxy(MissionManager missionManager2, FlyControllerStatus flyControllerStatus2, GPSInfo gPSInfo, BatteryState batteryState) {
        this.batteryStatus = batteryState;
        this.flyControllerStatus = flyControllerStatus2;
        this.gpsInfo = gPSInfo;
        this.missionManager = missionManager2;
    }

    public void prepareMission(C2700AutelMission autelMission, final CallbackWithOneParamProgress callbackWithOneParamProgress) {
        this.missionManager.prepareMission(autelMission, new CallbackWithOneParamProgress<Boolean>() {
            public void onProgress(float f) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onProgress(f);
                }
            }

            public void onSuccess(Boolean bool) {
                MissionManagerPreconditionProxy missionManagerPreconditionProxy = MissionManagerPreconditionProxy.this;
                missionManagerPreconditionProxy.setRealTimeInfoListener(missionManagerPreconditionProxy.realTimeInfoListener);
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onSuccess(bool);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            }
        });
    }

    public synchronized void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        this.realTimeInfoListener = callbackWithOneParam;
        this.missionManager.setRealTimeInfoListener(callbackWithOneParam);
    }

    public void startMission(final CallbackWithNoParam callbackWithNoParam) {
        this.missionManager.startMission(new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null && callbackWithNoParam != null) {
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
        this.missionManager.pauseMission(new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null && callbackWithNoParam != null) {
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
        this.missionManager.resumeMission(new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null && callbackWithNoParam != null) {
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
        this.missionManager.cancelMission(new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null && callbackWithNoParam != null) {
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
        this.missionManager.cancelMission(i, new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null && callbackWithNoParam != null) {
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

    public void downloadMissionForEvo(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        this.missionManager.downloadMissionForEvo(new CallbackWithOneParamProgress<C2700AutelMission>() {
            public void onProgress(float f) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onProgress(f);
                }
            }

            public void onSuccess(C2700AutelMission autelMission) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onSuccess(autelMission);
                }
                MissionManagerPreconditionProxy missionManagerPreconditionProxy = MissionManagerPreconditionProxy.this;
                missionManagerPreconditionProxy.setRealTimeInfoListener(missionManagerPreconditionProxy.realTimeInfoListener);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            }
        });
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
        this.missionManager.yawRestore(callbackWithNoParam);
    }

    public C2700AutelMission getCurrentMission() {
        return this.missionManager.getCurrentMission();
    }

    public MissionExecuteState getMissionExecuteState() {
        return this.missionManager.getMissionExecuteState();
    }

    public void downloadMission(final CallbackWithOneParamProgress callbackWithOneParamProgress) {
        this.missionManager.downloadMission(new CallbackWithOneParamProgress<C2700AutelMission>() {
            public void onProgress(float f) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onProgress(f);
                }
            }

            public void onSuccess(C2700AutelMission autelMission) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onSuccess(autelMission);
                }
                MissionManagerPreconditionProxy missionManagerPreconditionProxy = MissionManagerPreconditionProxy.this;
                missionManagerPreconditionProxy.setRealTimeInfoListener(missionManagerPreconditionProxy.realTimeInfoListener);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            }
        });
    }

    public void destroy() {
        this.realTimeInfoListener = null;
    }
}
