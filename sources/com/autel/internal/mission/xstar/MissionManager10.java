package com.autel.internal.mission.xstar;

import android.location.Location;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerParameterRangeManager;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.xstar.FollowMission;
import com.autel.common.mission.xstar.OrbitMission;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.common.mission.xstar.WaypointMission;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.mission.AbsMissionManager;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.List;

public class MissionManager10 extends AbsMissionManager {
    protected FlyControllerStatus flyControllerStatus;
    float maxDistance;
    float maxHeight;

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxMissionManager toRx() {
        return null;
    }

    public MissionManager10(FlyControllerStatus flyControllerStatus2, C4930AutelFlyController autelFlyController) {
        super(autelFlyController);
        this.flyControllerStatus = flyControllerStatus2;
    }

    /* access modifiers changed from: protected */
    public void checkMissionValidate(C2700AutelMission autelMission, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            if (autelMission instanceof FollowMission) {
                followDataOK((FollowMission) autelMission, callbackWithNoParam);
            } else if (autelMission instanceof OrbitMission) {
                orbitDataOK((OrbitMission) autelMission, callbackWithNoParam);
            } else if (autelMission instanceof WaypointMission) {
                waypointDataOK((WaypointMission) autelMission, callbackWithNoParam);
            }
        }
    }

    private void waypointDataOK(WaypointMission waypointMission, CallbackWithNoParam callbackWithNoParam) {
        final List<Waypoint> list = waypointMission.wpList;
        if (list == null || list.size() == 0) {
            callbackWithNoParam.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        } else if (!this.flyControllerStatus.isHomePointValid()) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_HOME_POINT_INVALID);
        } else {
            FlyControllerParameterRangeManager parameterRangeManager = this.autelFlyController.getParameterRangeManager();
            RangePair<Float> horizontalSpeedRange = parameterRangeManager.getHorizontalSpeedRange();
            if (((float) waypointMission.speed) < horizontalSpeedRange.getValueFrom().floatValue() || ((float) waypointMission.speed) > horizontalSpeedRange.getValueTo().floatValue()) {
                callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_SPEED_IS_OUT_OF_RANGE);
                return;
            }
            final float floatValue = parameterRangeManager.getReturnHeightRange().getValueFrom().floatValue();
            final WaypointMission waypointMission2 = waypointMission;
            final CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
            this.autelFlyController.getReturnHeight(new CallbackWithOneParam<Float>() {
                public void onSuccess(Float f) {
                    if (((float) waypointMission2.finishReturnHeight) > f.floatValue() || ((float) waypointMission2.finishReturnHeight) < floatValue) {
                        callbackWithNoParam2.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE);
                    } else {
                        MissionManager10.this.autelFlyController.getMaxHeight(new CallbackWithOneParam<Float>() {
                            public void onSuccess(Float f) {
                                MissionManager10.this.maxHeight = f.floatValue();
                                MissionManager10.this.autelFlyController.getMaxRange(new CallbackWithOneParam<Float>() {
                                    public void onSuccess(Float f) {
                                        MissionManager10.this.maxDistance = f.floatValue();
                                        MissionManager10.this.checkWaypointList(list, callbackWithNoParam2);
                                    }

                                    public void onFailure(AutelError autelError) {
                                        callbackWithNoParam2.onFailure(autelError);
                                    }
                                });
                            }

                            public void onFailure(AutelError autelError) {
                                callbackWithNoParam2.onFailure(autelError);
                            }
                        });
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam2.onFailure(autelError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void checkWaypointList(List<Waypoint> list, CallbackWithNoParam callbackWithNoParam) {
        for (Waypoint next : list) {
            if (next.getAutelCoordinate3D() != null) {
                if (((float) next.getAutelCoordinate3D().getAltitude()) > this.maxHeight) {
                    callbackWithNoParam.onFailure(AutelError.WAYPOINT_HAS_NOT_PREPARED_AS_HEIGHT_IS_OUT_OF_RANGE);
                    return;
                } else if (getDistanceFromHomePoint((double) ((float) next.getAutelCoordinate3D().getLatitude()), (double) ((float) next.getAutelCoordinate3D().getLongitude())) > this.maxDistance) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_RANGE_IS_OUT_OF_RANGE);
                    return;
                }
            }
        }
        callbackWithNoParam.onSuccess();
    }

    /* access modifiers changed from: private */
    public float getDistanceFromHomePoint(double d, double d2) {
        AutelHomeInternal autelFlyControllerHomeInfo = AutelAircraftInfoManager.getAutelFlyControllerHomeInfo();
        if (autelFlyControllerHomeInfo == null || !autelFlyControllerHomeInfo.isValid() || autelFlyControllerHomeInfo.getAutelCoord3D() == null) {
            return Float.MAX_VALUE;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(autelFlyControllerHomeInfo.getAutelCoord3D().getLatitude(), autelFlyControllerHomeInfo.getAutelCoord3D().getLongitude(), d, d2, fArr);
        return fArr[0];
    }

    private void orbitDataOK(final OrbitMission orbitMission, final CallbackWithNoParam callbackWithNoParam) {
        if (!this.flyControllerStatus.isHomePointValid()) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_HOME_POINT_INVALID);
            return;
        }
        FlyControllerParameterRangeManager parameterRangeManager = this.autelFlyController.getParameterRangeManager();
        RangePair<Float> horizontalSpeedRange = parameterRangeManager.getHorizontalSpeedRange();
        final float floatValue = parameterRangeManager.getReturnHeightRange().getValueFrom().floatValue();
        if (orbitMission.speed < horizontalSpeedRange.getValueFrom().floatValue() || orbitMission.speed > horizontalSpeedRange.getValueTo().floatValue()) {
            callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_SPEED_IS_OUT_OF_RANGE);
        } else {
            this.autelFlyController.getReturnHeight(new CallbackWithOneParam<Float>() {
                public void onSuccess(Float f) {
                    if (((float) orbitMission.finishReturnHeight) > f.floatValue() || ((float) orbitMission.finishReturnHeight) < floatValue) {
                        callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE);
                    } else {
                        MissionManager10.this.autelFlyController.getMaxRange(new CallbackWithOneParam<Float>() {
                            public void onSuccess(Float f) {
                                if (((double) orbitMission.radius) + ((double) MissionManager10.this.getDistanceFromHomePoint(orbitMission.lat, orbitMission.lng)) > ((double) f.floatValue())) {
                                    callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_RANGE_IS_OUT_OF_RANGE);
                                } else {
                                    callbackWithNoParam.onSuccess();
                                }
                            }

                            public void onFailure(AutelError autelError) {
                                callbackWithNoParam.onFailure(autelError);
                            }
                        });
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                }
            });
        }
    }

    private void followDataOK(final FollowMission followMission, final CallbackWithNoParam callbackWithNoParam) {
        final float floatValue = this.autelFlyController.getParameterRangeManager().getReturnHeightRange().getValueFrom().floatValue();
        this.autelFlyController.getReturnHeight(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                if (((float) followMission.finishReturnHeight) > f.floatValue() || ((float) followMission.finishReturnHeight) < floatValue) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE);
                } else {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initPrepare(final C2700AutelMission autelMission, final CallbackWithOneParamProgress callbackWithOneParamProgress) {
        MissionManager.getAutelMissonCommonRequestManager().setMissionFinishedType(getFinishAction(autelMission), autelMission.finishReturnHeight, new AutelCompletionCallback.ICompletionCallbackWith<MissionFinishedAction>() {
            public void onResult(MissionFinishedAction missionFinishedAction) {
                com.autel.sdk.mission.MissionManager unused = MissionManager10.this.currentMissionManager = MissionManagerFactory10.createMissionManager(autelMission);
                MissionManager10.this.currentMissionManager.prepareMission(autelMission, callbackWithOneParamProgress);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(autelError);
                }
            }
        });
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        downloadMission(callbackWithOneParamProgress);
    }

    public void yawRestore(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().yawRecover(new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
            public void onResult(Boolean bool) {
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

    public void downloadMission(CallbackWithOneParamProgress callbackWithOneParamProgress) {
        FlyMode flyMode = this.flyControllerStatus.getFlyMode();
        if (flyMode == FlyMode.WAYPOINT_MODE || flyMode == FlyMode.WAYPOINT_MODE_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof XStarWaypointMissionManager)) {
                this.currentMissionManager = new XStarWaypointMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.ORBIT_ORBIT || flyMode == FlyMode.ORBIT_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof XStarOrbitMissionManager)) {
                this.currentMissionManager = new XStarOrbitMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.FOLLOW_FOLLOW || flyMode == FlyMode.FOLLOW_HOLD) {
            if (callbackWithOneParamProgress != null) {
                callbackWithOneParamProgress.onFailure(AutelError.MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE);
                return;
            }
            return;
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_DOWNLOAD_NEED_MISSION_MODE);
            return;
        } else {
            return;
        }
        this.currentMissionManager.downloadMission(callbackWithOneParamProgress);
    }
}
