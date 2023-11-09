package com.autel.internal.mission.evo;

import android.location.Location;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.evo.EvoFollowMission;
import com.autel.common.mission.evo.EvoOrbitMission;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.mission.AbsMissionManager;
import com.autel.internal.mission.evo2.Evo2WaypointMissionManager;
import com.autel.internal.mission.evo2.ImageStabilityMissionManager;
import com.autel.internal.mission.evo2.MotionDelayMissionManager;
import com.autel.internal.mission.evo2.TripodMissionManager;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.mission.p009rx.RxMissionManager;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import com.autel.util.log.AutelLog;

public class EvoMissionManager extends AbsMissionManager {
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

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
    }

    public EvoMissionManager(FlyControllerStatus flyControllerStatus2, C4930AutelFlyController autelFlyController) {
        super(autelFlyController);
        this.flyControllerStatus = flyControllerStatus2;
    }

    /* access modifiers changed from: protected */
    public void checkMissionValidate(C2700AutelMission autelMission, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            if (autelMission != null) {
                callbackWithNoParam.onSuccess();
            } else {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        }
    }

    private float getDistanceFromHomePoint(double d, double d2) {
        AutelHomeInternal autelFlyControllerHomeInfo = AutelAircraftInfoManager.getAutelFlyControllerHomeInfo();
        if (autelFlyControllerHomeInfo == null || !autelFlyControllerHomeInfo.isValid() || autelFlyControllerHomeInfo.getAutelCoord3D() == null) {
            return Float.MAX_VALUE;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(autelFlyControllerHomeInfo.getAutelCoord3D().getLatitude(), autelFlyControllerHomeInfo.getAutelCoord3D().getLongitude(), d, d2, fArr);
        return fArr[0];
    }

    private void orbitDataOK(EvoOrbitMission evoOrbitMission, CallbackWithNoParam callbackWithNoParam) {
        callbackWithNoParam.onSuccess();
    }

    private void followDataOK(EvoFollowMission evoFollowMission, CallbackWithNoParam callbackWithNoParam) {
        callbackWithNoParam.onSuccess();
    }

    /* access modifiers changed from: protected */
    public void initPrepare(C2700AutelMission autelMission, CallbackWithOneParamProgress callbackWithOneParamProgress) {
        this.currentMissionManager = MissionManagerFactory20.createMissionManager(autelMission);
        this.currentMissionManager.prepareMission(autelMission, callbackWithOneParamProgress);
    }

    public void startMission(CallbackWithNoParam callbackWithNoParam) {
        if (this.currentMissionManager == null) {
            AutelLog.debug_i("uploadMission", "startMission EvoMissionManager is null------ ");
            this.currentMissionManager = new Evo2WaypointMissionManager(this.flyControllerStatus);
            this.currentMissionManager.startMission(callbackWithNoParam);
        }
        super.startMission(callbackWithNoParam);
    }

    public void downloadMission(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        FlyMode flyMode = this.flyControllerStatus.getFlyMode();
        if (flyMode == FlyMode.WAYPOINT_MODE || flyMode == FlyMode.WAYPOINT_MODE_HOLD || flyMode == FlyMode.MISSION_GO_HOME || flyMode == FlyMode.RECTANGLE || flyMode == FlyMode.RECTANGLE_HOLD || flyMode == FlyMode.POLYGON || flyMode == FlyMode.POLYGON_HOLD || flyMode == FlyMode.DISARM || flyMode == FlyMode.GPS_FLIGHT) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof Evo2WaypointMissionManager)) {
                this.currentMissionManager = new Evo2WaypointMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.ORBIT_ORBIT || flyMode == FlyMode.ORBIT_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof EvoOrbitMissionManager)) {
                this.currentMissionManager = new EvoOrbitMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.FOLLOW_FOLLOW || flyMode == FlyMode.FOLLOW_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof EvoFollowMissionManager)) {
                this.currentMissionManager = new EvoFollowMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.TRIPOD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof TripodMissionManager)) {
                this.currentMissionManager = new TripodMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.PHOTOGRAPHER) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof ImageStabilityMissionManager)) {
                this.currentMissionManager = new ImageStabilityMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.MOTION_DELAY) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof MotionDelayMissionManager)) {
                this.currentMissionManager = new MotionDelayMissionManager(this.flyControllerStatus);
            }
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_DOWNLOAD_NEED_MISSION_MODE);
            return;
        } else {
            return;
        }
        this.currentMissionManager.downloadMission(callbackWithOneParamProgress);
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        FlyMode flyMode = this.flyControllerStatus.getFlyMode();
        if (flyMode == FlyMode.WAYPOINT_MODE || flyMode == FlyMode.WAYPOINT_MODE_HOLD || flyMode == FlyMode.MISSION_GO_HOME) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof EvoWaypointMissionManager)) {
                this.currentMissionManager = new EvoWaypointMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.ORBIT_ORBIT || flyMode == FlyMode.ORBIT_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof EvoOrbitMissionManager)) {
                this.currentMissionManager = new EvoOrbitMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.FOLLOW_FOLLOW || flyMode == FlyMode.FOLLOW_HOLD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof EvoFollowMissionManager)) {
                this.currentMissionManager = new EvoFollowMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.TRIPOD) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof TripodMissionManager)) {
                this.currentMissionManager = new TripodMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.PHOTOGRAPHER) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof ImageStabilityMissionManager)) {
                this.currentMissionManager = new ImageStabilityMissionManager(this.flyControllerStatus);
            }
        } else if (flyMode == FlyMode.MOTION_DELAY) {
            if (this.currentMissionManager == null || !(this.currentMissionManager instanceof MotionDelayMissionManager)) {
                this.currentMissionManager = new MotionDelayMissionManager(this.flyControllerStatus);
            }
        } else if (callbackWithOneParamProgress != null) {
            callbackWithOneParamProgress.onFailure(AutelError.MISSION_DOWNLOAD_NEED_MISSION_MODE);
            return;
        } else {
            return;
        }
        this.currentMissionManager.downloadMission(callbackWithOneParamProgress);
    }
}
