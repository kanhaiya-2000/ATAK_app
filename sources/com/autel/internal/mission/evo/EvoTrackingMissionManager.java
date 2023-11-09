package com.autel.internal.mission.evo;

import com.autel.AutelNet2.aircraft.visual.VisualModelManager;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.camera.protocol.protocol20.interfaces.Xb015.CameraXb015;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.camera.protocol.protocol20.util.TrackingUtils;
import com.autel.camera.protocol.protocol20.xb015.C2416Xb015;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.camera.visual.TrackingArea;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.mission.MissionManagerWithState;
import com.autel.internal.sdk.mission.evo.EvoFollowRealTimeInfoImpl;
import com.autel.internal.sdk.mission.evo.EvoTrackingMissionWithUpdate;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.util.log.AutelLog;
import java.util.concurrent.LinkedBlockingDeque;

public class EvoTrackingMissionManager extends MissionManagerWithState {
    /* access modifiers changed from: private */
    public boolean isTrackingCache = TrackingUtils.isCacheTracking();
    EvoTrackingMissionWithUpdate mTrackingMission;
    /* access modifiers changed from: private */
    public EvoFollowRealTimeInfoImpl realTimeInfo = new EvoFollowRealTimeInfoImpl();
    /* access modifiers changed from: private */
    public LinkedBlockingDeque<TrackingArea> trackingList = new LinkedBlockingDeque<>();
    /* access modifiers changed from: private */
    public CameraXb015 trackingRequest = ((CameraXb015) CameraFactory.getCameraProduct(C2416Xb015.class));

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public EvoTrackingMissionManager(FlyControllerStatus flyControllerStatus) {
        super(flyControllerStatus);
    }

    public void setRealTimeInfoListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().setTrackingListener((CallbackWithOneParam<TrackingArea>) null);
            return;
        }
        VisualModelManager.instance().setTrackingListener(new CallbackWithOneParam<TrackingArea>() {
            public void onSuccess(TrackingArea trackingArea) {
                EvoTrackingMissionManager.this.realTimeInfo.mTrackingArea = trackingArea;
                if (EvoTrackingMissionManager.this.isTrackingCache) {
                    EvoTrackingMissionManager.this.trackingList.offer(trackingArea);
                }
                callbackWithOneParam.onSuccess(EvoTrackingMissionManager.this.realTimeInfo);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        if (this.isTrackingCache) {
            TrackingUtils.isFlag = true;
            new Thread(new Runnable() {
                public void run() {
                    while (TrackingUtils.isFlag) {
                        try {
                            TrackingUtils.writeTrackingData((TrackingArea) EvoTrackingMissionManager.this.trackingList.take());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public void prepareMission(C2700AutelMission autelMission, CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (autelMission != null) {
            EvoTrackingMissionWithUpdate evoTrackingMissionWithUpdate = (EvoTrackingMissionWithUpdate) autelMission;
            this.mTrackingMission = evoTrackingMissionWithUpdate;
            evoTrackingMissionWithUpdate.setUpdateListener(new EvoTrackingMissionWithUpdate.UpdateListener() {
                public void lockTarget(TrackingTarget trackingTarget, final CallbackWithNoParam callbackWithNoParam) {
                    EvoTrackingMissionManager.this.trackingRequest.setTrackingGoalArea(trackingTarget, new CallbackWithNoParam() {
                        public void onSuccess() {
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

                public void unlockTarget(CallbackWithNoParam callbackWithNoParam) {
                    EvoTrackingMissionManager.this.trackingRequest.cancelTracking(callbackWithNoParam);
                }

                public void switchFollowMode(DynamicTrackMode dynamicTrackMode, final CallbackWithNoParam callbackWithNoParam) {
                    if (EvoTrackingMissionManager.this.missionExecuteState == MissionExecuteState.RUNNING) {
                        VisualModelManager.instance().setVisualTrackingFightMode(EvoTrackingMissionManager.this.mTrackingMission.getVisualFollowMode().getMode(), new CallbackWithOneParam<VisualSettingAckInfo>() {
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
                    MissionExecuteState unused = EvoTrackingMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
                    MissionExecuteState unused = EvoTrackingMissionManager.this.missionExecuteState = MissionExecuteState.PAUSE;
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
                    MissionExecuteState unused = EvoTrackingMissionManager.this.missionExecuteState = MissionExecuteState.RUNNING;
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
        this.trackingRequest.cancelTracking(new CallbackWithNoParam() {
            public void onSuccess() {
                if (PacketDisPatcher.getInstance().isDebug()) {
                    AutelLog.debug_i("Tracking_Test", "tracking send stop cmd to camera success ");
                }
                TrackingUtils.stopRecordData();
                MissionExecuteState unused = EvoTrackingMissionManager.this.missionExecuteState = MissionExecuteState.CANCEL;
                if (EvoTrackingMissionManager.this.mTrackingMission != null) {
                    EvoTrackingMissionManager.this.mTrackingMission.setUpdateListener((EvoTrackingMissionWithUpdate.UpdateListener) null);
                }
                EvoTrackingMissionManager.this.mTrackingMission = null;
                VisualModelManager.instance().setResetVisualTrackingFightMode(new CallbackWithOneParam<VisualSettingAckInfo>() {
                    public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                        callbackWithNoParam.onSuccess();
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithNoParam.onFailure(autelError);
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                if (PacketDisPatcher.getInstance().isDebug()) {
                    AutelLog.debug_i("Tracking_Test", "tracking send stop cmd to camera failure ");
                }
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
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
