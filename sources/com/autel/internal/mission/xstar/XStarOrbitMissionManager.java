package com.autel.internal.mission.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.OrbitFinishedAction;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.xstar.OrbitMission;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.AutelOrbit;
import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.internal.sdk.mission.MissionStatus;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class XStarOrbitMissionManager extends MissionManagerWithState {
    private static final String orbitInfoListenerTag = "OrbitInfoListener";
    OrbitMission orbitMission;

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public XStarOrbitMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            MissionManager.getAutelOrbitMissionRequestManager().removeRealTimeOrbitInfoListener(orbitInfoListenerTag);
        } else {
            MissionManager.getAutelOrbitMissionRequestManager().addRealTimeOrbitInfoListener(orbitInfoListenerTag, new AutelMissionInterface.IOrbitRealtimeInfoListener() {
                public void onOrbitRealtimeInfo(AutelOrbitRealTimeInfoInternal autelOrbitRealTimeInfoInternal) {
                    callbackWithOneParam.onSuccess(autelOrbitRealTimeInfoInternal);
                }
            });
        }
    }

    public void prepareMission(final C2700AutelMission autelMission, final CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            this.orbitMission = (OrbitMission) autelMission;
            AutelOrbit autelOrbit = new AutelOrbit();
            autelOrbit.setLat(this.orbitMission.lat);
            autelOrbit.setLng(this.orbitMission.lng);
            autelOrbit.setMissionFinishTypeValue((short) this.orbitMission.finishedAction.getValue());
            autelOrbit.setRadius(this.orbitMission.radius);
            autelOrbit.setReturnHeight((float) this.orbitMission.finishReturnHeight);
            autelOrbit.setRound(this.orbitMission.laps);
            autelOrbit.setSpeed(this.orbitMission.speed);
            MissionManager.getAutelOrbitMissionRequestManager().startOrbitMission(autelOrbit, new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
                public void onResult(Boolean bool) {
                    MissionManager.getAutelMissonCommonRequestManager().setMissionFinishedType(MissionFinishedAction.convert(((OrbitMission) autelMission).finishedAction), autelMission.finishReturnHeight, new AutelCompletionCallback.ICompletionCallbackWith<MissionFinishedAction>() {
                        public void onResult(MissionFinishedAction missionFinishedAction) {
                            MissionExecuteState unused = XStarOrbitMissionManager.this.missionExecuteState = MissionExecuteState.PREPARE;
                            if (callbackWithOneParamProgress != null) {
                                callbackWithOneParamProgress.onProgress(1.0f);
                                callbackWithOneParamProgress.onSuccess(true);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            if (callbackWithOneParamProgress != null) {
                                callbackWithOneParamProgress.onFailure(autelError);
                            }
                        }
                    });
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
        MissionManager.getAutelOrbitMissionRequestManager().setOrbitMissionStatus(MissionStatus.START, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                MissionExecuteState unused = XStarOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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

    public void pauseMission(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelOrbitMissionRequestManager().setOrbitMissionStatus(MissionStatus.PAUSE, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                MissionExecuteState unused = XStarOrbitMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
        MissionManager.getAutelOrbitMissionRequestManager().setOrbitMissionStatus(MissionStatus.CONTINUE, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                MissionExecuteState unused = XStarOrbitMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        MissionManager.getAutelOrbitMissionRequestManager().setOrbitMissionStatus(MissionStatus.CANCEL, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                MissionExecuteState unused = XStarOrbitMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
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

    public void downloadMission(final CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        MissionManager.getAutelOrbitMissionRequestManager().requestOrbitData(new AutelCompletionCallback.ICompletionCallbackWith<AutelOrbit>() {
            public void onResult(AutelOrbit autelOrbit) {
                OrbitMission orbitMission = new OrbitMission();
                orbitMission.lat = autelOrbit.getLat();
                orbitMission.lng = autelOrbit.getLng();
                orbitMission.finishedAction = OrbitFinishedAction.find(autelOrbit.getMissonFinishedType());
                orbitMission.radius = autelOrbit.getRadius();
                orbitMission.finishReturnHeight = (int) autelOrbit.getReturnHeight();
                orbitMission.laps = autelOrbit.getRound();
                orbitMission.speed = autelOrbit.getSpeed();
                XStarOrbitMissionManager.this.orbitMission = orbitMission;
                callbackWithOneParamProgress.onSuccess(orbitMission);
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
