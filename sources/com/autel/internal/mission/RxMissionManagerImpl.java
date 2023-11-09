package com.autel.internal.mission;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.util.log.AutelLog;
import io.reactivex.Observable;

public class RxMissionManagerImpl implements RxMissionManager {
    /* access modifiers changed from: private */
    public MissionManager mMissionManager;

    public RxMissionManagerImpl(MissionManager missionManager) {
        this.mMissionManager = missionManager;
    }

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        this.mMissionManager.setRealTimeInfoListener(callbackWithOneParam);
    }

    public Observable<Boolean> prepareMission(final C2700AutelMission autelMission) {
        return new RxLock<Boolean>(90000) {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.prepareMission(autelMission, new CallbackWithOneParamProgress<Boolean>() {
                    public void onProgress(float f) {
                    }

                    public void onSuccess(Boolean bool) {
                        C46401.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C46401.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startMission() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                AutelLog.debug_i("uploadMission", "startMission start RxMissionManager------- " + RxMissionManagerImpl.this.mMissionManager);
                RxMissionManagerImpl.this.mMissionManager.startMission(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46442.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46442.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> pauseMission() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.pauseMission(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46463.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46463.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> resumeMission() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.resumeMission(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46484.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46484.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> cancelMission() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.cancelMission(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46505.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46505.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> cancelMission(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.cancelMission(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46526.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46526.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<C2700AutelMission> downloadMission() {
        return new RxLock<C2700AutelMission>(60000) {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.downloadMission(new CallbackWithOneParamProgress<C2700AutelMission>() {
                    public void onProgress(float f) {
                    }

                    public void onSuccess(C2700AutelMission autelMission) {
                        C46547.this.setData(autelMission);
                    }

                    public void onFailure(AutelError autelError) {
                        C46547.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<C2700AutelMission> downloadMissionForEvo() {
        return new RxLock<C2700AutelMission>(60000) {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.downloadMissionForEvo(new CallbackWithOneParamProgress<C2700AutelMission>() {
                    public void onProgress(float f) {
                    }

                    public void onSuccess(C2700AutelMission autelMission) {
                        C46568.this.setData(autelMission);
                    }

                    public void onFailure(AutelError autelError) {
                        C46568.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> yawRestore() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxMissionManagerImpl.this.mMissionManager.yawRestore(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C46589.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C46589.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<C2700AutelMission> getCurrentMission() {
        return new RxLock<C2700AutelMission>() {
            /* access modifiers changed from: protected */
            public void run() {
                C2700AutelMission currentMission = RxMissionManagerImpl.this.mMissionManager.getCurrentMission();
                if (currentMission == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(currentMission);
                }
            }
        }.fire();
    }

    public Observable<MissionExecuteState> getMissionExecuteState() {
        return new RxLock<MissionExecuteState>() {
            /* access modifiers changed from: protected */
            public void run() {
                MissionExecuteState missionExecuteState = RxMissionManagerImpl.this.mMissionManager.getMissionExecuteState();
                if (missionExecuteState == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(missionExecuteState);
                }
            }
        }.fire();
    }
}
