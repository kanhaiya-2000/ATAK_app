package com.autel.internal.mission.evo;

import android.location.Location;
import com.autel.AutelNet2.aircraft.mission.engine.ActionInfo;
import com.autel.AutelNet2.aircraft.mission.engine.GpsFollowMeInfo;
import com.autel.AutelNet2.aircraft.mission.engine.GpsTargetInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.aircraft.mission.engine.MissionSingleInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MotionDelayInfo;
import com.autel.AutelNet2.aircraft.mission.engine.OneShotVideo;
import com.autel.AutelNet2.aircraft.mission.engine.OrbitInfo;
import com.autel.AutelNet2.aircraft.mission.engine.PoiInfo;
import com.autel.AutelNet2.aircraft.mission.engine.TripodInfo;
import com.autel.AutelNet2.aircraft.mission.engine.VertexInfo;
import com.autel.AutelNet2.aircraft.mission.engine.WaypointBean;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.MissionType;
import com.autel.common.mission.OrbitFinishedAction;
import com.autel.common.mission.evo.EvoOrbitMission;
import com.autel.common.mission.evo.EvoWaypoint;
import com.autel.common.mission.evo.EvoWaypointFinishedAction;
import com.autel.common.mission.evo.EvoWaypointMission;
import com.autel.common.mission.evo.ImageStabilityMission;
import com.autel.common.mission.evo.MissionActionType;
import com.autel.common.mission.evo.MotionDelayMission;
import com.autel.common.mission.evo.ObstacleAvoidanceMode;
import com.autel.common.mission.evo.OneShotVideoMission;
import com.autel.common.mission.evo.OrbitEntryDirection;
import com.autel.common.mission.evo.OrbitHeadingDirection;
import com.autel.common.mission.evo.OrbitRotateDirection;
import com.autel.common.mission.evo.RemoteControlLostSignalAction;
import com.autel.common.mission.evo.TripodMission;
import com.autel.common.mission.evo.WaypointAction;
import com.autel.common.mission.evo.WaypointBezierMode;
import com.autel.common.mission.evo.WaypointHeadingMode;
import com.autel.common.mission.evo.WaypointType;
import com.autel.common.mission.evo2.Evo2Waypoint;
import com.autel.common.mission.evo2.Evo2WaypointFinishedAction;
import com.autel.common.mission.evo2.Evo2WaypointMission;
import com.autel.common.mission.evo2.MotionDelayType;
import com.autel.common.mission.evo2.Poi;
import com.autel.common.mission.evo2.Vertex;
import com.autel.common.mission.xstar.WaypointFinishedAction;
import com.autel.internal.sdk.mission.VideoType;
import com.autel.internal.sdk.mission.evo.EvoFollowMissionWithUpdate;
import java.util.ArrayList;
import java.util.List;

public class MissionSerializeUtil {
    private static int missionId;

    public static MissionAllInternal getMissionAllInternal(EvoWaypointMission evoWaypointMission) {
        MissionAllInternal missionAllInternal = new MissionAllInternal();
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setFinishAction(evoWaypointMission.finishedAction.getValue());
        missionSingleInfo.setLostControlAction(evoWaypointMission.remoteControlLostSignalAction.getValue());
        int i = missionId + 1;
        missionId = i;
        missionSingleInfo.setMissionId(i);
        missionSingleInfo.setObstacleAvoidanceMode(evoWaypointMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(evoWaypointMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setMissionType(MissionType.Waypoint.getValue());
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        ArrayList arrayList = new ArrayList();
        if (evoWaypointMission.wpList != null) {
            missionSingleInfo.setNumberOfWaypoints(evoWaypointMission.wpList.size());
            for (int i2 = 0; i2 < evoWaypointMission.wpList.size(); i2++) {
                WaypointBean waypointBean = new WaypointBean();
                EvoWaypoint evoWaypoint = evoWaypointMission.wpList.get(i2);
                waypointBean.setWaypointId(i2);
                waypointBean.setAltitude((int) (evoWaypoint.getAutelCoordinate3D().getAltitude() * 1000.0d));
                waypointBean.setLatitude((int) (evoWaypoint.getAutelCoordinate3D().getLatitude() * 1.0E7d));
                waypointBean.setLongitude((int) (evoWaypoint.getAutelCoordinate3D().getLongitude() * 1.0E7d));
                waypointBean.setFocusAltitude((int) (evoWaypoint.focusAltitude * 1000.0d));
                waypointBean.setFocusLatitude((int) (evoWaypoint.focusLatitude * 1.0E7d));
                waypointBean.setFocusLongitude((int) (evoWaypoint.focusLongitude * 1.0E7d));
                waypointBean.setSpeed(evoWaypoint.speed);
                waypointBean.setwSpeed(evoWaypoint.wSpeed);
                waypointBean.setBeizerParameter(evoWaypoint.bezierMode.getValue());
                waypointBean.setWaypointType(evoWaypoint.waypointType.getValue());
                waypointBean.setHeadingMode(evoWaypoint.headingMode.getValue());
                waypointBean.setCameraPitch(evoWaypoint.cameraPitch);
                waypointBean.setCameraYaw(evoWaypoint.cameraYaw);
                waypointBean.setUserdefinedHeading(evoWaypoint.customHeadingDirection);
                waypointBean.setAltitudePriorityMode(evoWaypoint.isAltitudePriority ? 1 : 0);
                if (evoWaypoint.actions != null) {
                    int size = evoWaypoint.actions.size();
                    waypointBean.setNumberOfActions(size);
                    List<WaypointAction> list = evoWaypoint.actions;
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        ActionInfo actionInfo = new ActionInfo();
                        WaypointAction waypointAction = list.get(i3);
                        actionInfo.setActionId(i3);
                        actionInfo.setActionParameters(waypointAction.parameters);
                        actionInfo.setActionTimeout(waypointAction.timeout);
                        actionInfo.setActionType(waypointAction.actionType.getValue());
                        arrayList2.add(actionInfo);
                    }
                    waypointBean.setActions(arrayList2);
                }
                arrayList.add(waypointBean);
            }
        }
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        missionAllInternal.setWaypoints(arrayList);
        return missionAllInternal;
    }

    public static EvoWaypointMission getEvoWaypointMission(MissionAllInternal missionAllInternal) {
        EvoWaypointMission evoWaypointMission = new EvoWaypointMission();
        evoWaypointMission.missionId = missionAllInternal.getFMUMissionInfo().getMissionId();
        evoWaypointMission.missionType = MissionType.find(missionAllInternal.getFMUMissionInfo().getMissionType());
        evoWaypointMission.finishedAction = EvoWaypointFinishedAction.find(missionAllInternal.getFMUMissionInfo().getFinishAction());
        evoWaypointMission.avoidanceMode = ObstacleAvoidanceMode.find(missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceMode());
        evoWaypointMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(missionAllInternal.getFMUMissionInfo().getLostControlAction());
        evoWaypointMission.obstacleAvoidanceTimeout = missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceTimeout();
        ArrayList arrayList = new ArrayList();
        if (missionAllInternal.getWaypoints() != null) {
            for (int i = 0; i < missionAllInternal.getWaypoints().size(); i++) {
                WaypointBean waypointBean = missionAllInternal.getWaypoints().get(i);
                EvoWaypoint evoWaypoint = new EvoWaypoint(new AutelCoordinate3D(((double) waypointBean.getLatitude()) / 1.0E7d, ((double) waypointBean.getLongitude()) / 1.0E7d, ((double) waypointBean.getAltitude()) / 1000.0d));
                boolean z = true;
                evoWaypoint.isAltitudePriority = waypointBean.getAltitudePriorityMode() == 1;
                evoWaypoint.focusAltitude = ((double) waypointBean.getFocusAltitude()) / 1000.0d;
                evoWaypoint.focusLatitude = ((double) waypointBean.getFocusLatitude()) / 1.0E7d;
                evoWaypoint.focusLongitude = ((double) waypointBean.getFocusLongitude()) / 1.0E7d;
                evoWaypoint.waypointType = WaypointType.find(waypointBean.getWaypointType());
                evoWaypoint.wSpeed = waypointBean.getwSpeed();
                if (-1.0f != evoWaypoint.wSpeed) {
                    evoWaypoint.speed = (int) waypointBean.getwSpeed();
                } else {
                    evoWaypoint.speed = waypointBean.getSpeed();
                }
                evoWaypoint.bezierMode = WaypointBezierMode.find(waypointBean.getBeizerParameter());
                evoWaypoint.headingMode = WaypointHeadingMode.find(waypointBean.getHeadingMode());
                evoWaypoint.cameraPitch = waypointBean.getCameraPitch();
                evoWaypoint.cameraYaw = waypointBean.getCameraYaw();
                evoWaypoint.customHeadingDirection = waypointBean.getUserdefinedHeading();
                if (waypointBean.getAltitudePriorityMode() != 1) {
                    z = false;
                }
                evoWaypoint.isAltitudePriority = z;
                List<ActionInfo> actions = waypointBean.getActions();
                if (actions != null) {
                    int size = actions.size();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        ActionInfo actionInfo = actions.get(i2);
                        WaypointAction waypointAction = new WaypointAction();
                        waypointAction.actionType = MissionActionType.find(actionInfo.getActionType());
                        waypointAction.parameters = actionInfo.getActionParameters();
                        waypointAction.timeout = actionInfo.getActionTimeout();
                        arrayList2.add(waypointAction);
                    }
                    evoWaypoint.actions = arrayList2;
                }
                arrayList.add(evoWaypoint);
            }
            evoWaypointMission.wpList = arrayList;
        }
        return evoWaypointMission;
    }

    public static GpsFollowMeInfo getGpsFollowMeInfo(EvoFollowMissionWithUpdate evoFollowMissionWithUpdate) {
        if (evoFollowMissionWithUpdate == null) {
            return null;
        }
        GpsFollowMeInfo gpsFollowMeInfo = new GpsFollowMeInfo();
        gpsFollowMeInfo.setAttitudeStrategy(evoFollowMissionWithUpdate.mFollowAttitudeMode.getValue());
        gpsFollowMeInfo.setGroundFollowMode(evoFollowMissionWithUpdate.groundFollowMode.getValue());
        gpsFollowMeInfo.setHeadingMode(evoFollowMissionWithUpdate.mFollowHeadingMode.getValue());
        gpsFollowMeInfo.setOrbitDirection(evoFollowMissionWithUpdate.orbitDirection.getValue());
        gpsFollowMeInfo.setOrbitRadius(evoFollowMissionWithUpdate.orbitRadius);
        gpsFollowMeInfo.setOrbitSpeed(evoFollowMissionWithUpdate.orbitSpeed);
        gpsFollowMeInfo.setReverseFlightAllowed(evoFollowMissionWithUpdate.canInvertedFlight ? 1 : 0);
        gpsFollowMeInfo.setUserHeading(evoFollowMissionWithUpdate.customHeading);
        return gpsFollowMeInfo;
    }

    public static GpsTargetInfo getGpsTargetInfo(Location location) {
        if (location == null) {
            return null;
        }
        GpsTargetInfo gpsTargetInfo = new GpsTargetInfo();
        gpsTargetInfo.setAlt((int) (location.getAltitude() * 1000.0d));
        gpsTargetInfo.setLat((int) (location.getLatitude() * 1.0E7d));
        gpsTargetInfo.setLon((int) (location.getLongitude() * 1.0E7d));
        gpsTargetInfo.setPrecision(2);
        return gpsTargetInfo;
    }

    public static OrbitInfo getOrbitInfo(EvoOrbitMission evoOrbitMission) {
        OrbitInfo orbitInfo = new OrbitInfo();
        orbitInfo.setRadius(evoOrbitMission.radius);
        orbitInfo.setoRadius((int) (evoOrbitMission.oRadius * 1000.0f));
        orbitInfo.setRemainDegree(evoOrbitMission.remainDegree);
        orbitInfo.setCycles(evoOrbitMission.cycles);
        orbitInfo.setSpeed(evoOrbitMission.speed);
        orbitInfo.setoSpeed(evoOrbitMission.oSpeed);
        orbitInfo.setEntryDirection(evoOrbitMission.mEntryDirection);
        orbitInfo.setHeadingDirection(evoOrbitMission.mHeadingDirection);
        orbitInfo.setRotateDirection(evoOrbitMission.mRotateDirection);
        orbitInfo.setCenterAltitude((int) (evoOrbitMission.altitude * 1000.0f));
        orbitInfo.setCenterLatitude((int) (evoOrbitMission.latitude * 1.0E7d));
        orbitInfo.setCenterLongitude((int) (evoOrbitMission.longitude * 1.0E7d));
        return orbitInfo;
    }

    public static OneShotVideo getOneShotVideo(OneShotVideoMission oneShotVideoMission) {
        OneShotVideo oneShotVideo = new OneShotVideo();
        oneShotVideo.setCycles(oneShotVideoMission.cycles);
        oneShotVideo.setMoveDistance(oneShotVideoMission.moveDistance);
        oneShotVideo.setMoveSpeed(oneShotVideoMission.moveSpeed);
        oneShotVideo.setRotateDirection(oneShotVideoMission.rotateDirection);
        oneShotVideo.setRotateSpeed(oneShotVideoMission.rotateSpeed);
        oneShotVideo.setVideoType(oneShotVideoMission.videoType.getValue());
        return oneShotVideo;
    }

    public static TripodInfo getTripodInfo(TripodMission tripodMission) {
        TripodInfo tripodInfo = new TripodInfo();
        tripodInfo.setRSpeed(tripodMission.rotateSpeed);
        tripodInfo.setVSpeed(tripodMission.verticalSpeed);
        tripodInfo.setHSpeed(tripodMission.horizontalSpeed);
        tripodInfo.setMissionId(tripodMission.missionId);
        return tripodInfo;
    }

    public static MotionDelayInfo getMotionDelayInfo(MotionDelayMission motionDelayMission) {
        MotionDelayInfo motionDelayInfo = new MotionDelayInfo();
        motionDelayInfo.setTimelapseType(motionDelayMission.motionDelayType.getValue());
        motionDelayInfo.setRSpeed(motionDelayMission.rotateSpeed);
        motionDelayInfo.setVSpeed(motionDelayMission.verticalSpeed);
        motionDelayInfo.setHSpeed(motionDelayMission.horizontalSpeed);
        motionDelayInfo.setTotalTime(motionDelayMission.totalTime);
        motionDelayInfo.setMissionId(motionDelayMission.missionId);
        return motionDelayInfo;
    }

    public static MissionSingleInfo getMissionSingleInfo(EvoOrbitMission evoOrbitMission) {
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        int i = 1;
        int i2 = missionId + 1;
        missionId = i2;
        missionSingleInfo.setMissionId(i2);
        missionSingleInfo.setMissionType(MissionType.Orbit.getValue());
        if (evoOrbitMission.finishedAction != OrbitFinishedAction.HOVER) {
            i = evoOrbitMission.finishedAction == OrbitFinishedAction.RETURN_HOME ? 2 : 0;
        }
        missionSingleInfo.setFinishAction(i);
        missionSingleInfo.setObstacleAvoidanceMode(evoOrbitMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(evoOrbitMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setLostControlAction(evoOrbitMission.remoteControlLostSignalAction.getValue());
        return missionSingleInfo;
    }

    public static MissionSingleInfo getMissionSingleInfo(OneShotVideoMission oneShotVideoMission) {
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setMissionId(oneShotVideoMission.missionId);
        missionSingleInfo.setMissionType(oneShotVideoMission.missionType.getValue());
        missionSingleInfo.setFinishAction(oneShotVideoMission.finishedAction.getValue());
        missionSingleInfo.setObstacleAvoidanceMode(oneShotVideoMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(oneShotVideoMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setLostControlAction(oneShotVideoMission.remoteControlLostSignalAction.getValue());
        return missionSingleInfo;
    }

    public static MissionSingleInfo getMissionSingleInfo(TripodMission tripodMission) {
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setMissionId(tripodMission.missionId);
        missionSingleInfo.setMissionType(MissionType.TRIPOD.getValue());
        missionSingleInfo.setFinishAction(tripodMission.finishedAction.getValue());
        missionSingleInfo.setObstacleAvoidanceMode(tripodMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(tripodMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setLostControlAction(tripodMission.remoteControlLostSignalAction.getValue());
        return missionSingleInfo;
    }

    public static MissionSingleInfo getMissionSingleInfo(MotionDelayMission motionDelayMission) {
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setMissionId(motionDelayMission.missionId);
        missionSingleInfo.setMissionType(MissionType.MOTION_DELAY.getValue());
        missionSingleInfo.setFinishAction(motionDelayMission.finishedAction.getValue());
        missionSingleInfo.setObstacleAvoidanceMode(motionDelayMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(motionDelayMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setLostControlAction(motionDelayMission.remoteControlLostSignalAction.getValue());
        return missionSingleInfo;
    }

    public static MissionSingleInfo getMissionSingleInfo(ImageStabilityMission imageStabilityMission) {
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setMissionId(imageStabilityMission.missionId);
        missionSingleInfo.setMissionType(MissionType.IMAGE_STABILITY.getValue());
        missionSingleInfo.setFinishAction(WaypointFinishedAction.RETURN_HOME.getValue());
        missionSingleInfo.setObstacleAvoidanceMode(imageStabilityMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(imageStabilityMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setLostControlAction(imageStabilityMission.remoteControlLostSignalAction.getValue());
        return missionSingleInfo;
    }

    public static EvoOrbitMission getEvoOrbitMission(MissionAllInternal missionAllInternal) {
        OrbitInfo orbitInfo = missionAllInternal.getOrbitInfo();
        if (orbitInfo == null) {
            return null;
        }
        MissionSingleInfo fMUMissionInfo = missionAllInternal.getFMUMissionInfo();
        EvoOrbitMission createMission = EvoOrbitMission.createMission();
        if (fMUMissionInfo.getFinishAction() == 1) {
            createMission.finishedAction = OrbitFinishedAction.HOVER;
        } else if (fMUMissionInfo.getFinishAction() == 2) {
            createMission.finishedAction = OrbitFinishedAction.RETURN_HOME;
        } else {
            createMission.finishedAction = OrbitFinishedAction.UNKNOWN;
        }
        int i = missionId + 1;
        missionId = i;
        fMUMissionInfo.setMissionId(i);
        createMission.obstacleAvoidanceTimeout = fMUMissionInfo.getObstacleAvoidanceTimeout();
        createMission.avoidanceMode = ObstacleAvoidanceMode.find(fMUMissionInfo.getObstacleAvoidanceMode());
        createMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(fMUMissionInfo.getLostControlAction());
        createMission.longitude = ((double) orbitInfo.getCenterLongitude()) / 1.0E7d;
        createMission.latitude = ((double) orbitInfo.getCenterLatitude()) / 1.0E7d;
        createMission.altitude = (float) (orbitInfo.getCenterAltitude() / 1000);
        createMission.cycles = orbitInfo.getCycles();
        createMission.mEntryDirection = OrbitEntryDirection.find(orbitInfo.getEntryDirection());
        createMission.mHeadingDirection = OrbitHeadingDirection.find(orbitInfo.getHeadingDirection());
        createMission.mRotateDirection = OrbitRotateDirection.find(orbitInfo.getRotateDirection());
        createMission.remainDegree = orbitInfo.getRemainDegree();
        createMission.oSpeed = orbitInfo.getoSpeed();
        createMission.oRadius = orbitInfo.getoRadius();
        if (-1.0f != orbitInfo.getoSpeed()) {
            createMission.speed = (int) orbitInfo.getoSpeed();
        } else {
            createMission.speed = orbitInfo.getSpeed();
        }
        if (-1.0f != orbitInfo.getoRadius()) {
            createMission.radius = (int) orbitInfo.getoRadius();
        } else {
            createMission.radius = orbitInfo.getRadius();
        }
        return createMission;
    }

    public static OneShotVideoMission getOneShortVideoMission(MissionAllInternal missionAllInternal) {
        OneShotVideo oneShotVideo = missionAllInternal.getOneShotVideo();
        if (oneShotVideo == null) {
            return null;
        }
        MissionSingleInfo fMUMissionInfo = missionAllInternal.getFMUMissionInfo();
        OneShotVideoMission createMission = OneShotVideoMission.createMission();
        if (fMUMissionInfo.getFinishAction() == 1) {
            createMission.finishedAction = WaypointFinishedAction.HOVER;
        } else if (fMUMissionInfo.getFinishAction() == 2) {
            createMission.finishedAction = WaypointFinishedAction.RETURN_HOME;
        } else {
            createMission.finishedAction = WaypointFinishedAction.UNKNOWN;
        }
        createMission.missionType = MissionType.find(fMUMissionInfo.getMissionType());
        createMission.obstacleAvoidanceTimeout = fMUMissionInfo.getObstacleAvoidanceTimeout();
        createMission.avoidanceMode = ObstacleAvoidanceMode.find(fMUMissionInfo.getObstacleAvoidanceMode());
        createMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(fMUMissionInfo.getLostControlAction());
        createMission.moveDistance = oneShotVideo.getMoveDistance();
        createMission.moveSpeed = oneShotVideo.getMoveSpeed();
        createMission.rotateDirection = oneShotVideo.getRotateDirection();
        createMission.cycles = oneShotVideo.getCycles();
        createMission.rotateSpeed = oneShotVideo.getRotateSpeed();
        createMission.videoType = VideoType.find(oneShotVideo.getVideoType());
        return createMission;
    }

    public static TripodMission getTripodMission(MissionAllInternal missionAllInternal) {
        TripodInfo tripod = missionAllInternal.getTripod();
        if (tripod == null) {
            return null;
        }
        MissionSingleInfo fMUMissionInfo = missionAllInternal.getFMUMissionInfo();
        TripodMission createMission = TripodMission.createMission();
        if (fMUMissionInfo.getFinishAction() == 1) {
            createMission.finishedAction = WaypointFinishedAction.HOVER;
        } else if (fMUMissionInfo.getFinishAction() == 2) {
            createMission.finishedAction = WaypointFinishedAction.RETURN_HOME;
        } else {
            createMission.finishedAction = WaypointFinishedAction.UNKNOWN;
        }
        createMission.missionType = MissionType.find(fMUMissionInfo.getMissionType());
        createMission.obstacleAvoidanceTimeout = fMUMissionInfo.getObstacleAvoidanceTimeout();
        createMission.avoidanceMode = ObstacleAvoidanceMode.find(fMUMissionInfo.getObstacleAvoidanceMode());
        createMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(fMUMissionInfo.getLostControlAction());
        createMission.verticalSpeed = tripod.getVSpeed();
        createMission.horizontalSpeed = tripod.getHSpeed();
        createMission.rotateSpeed = tripod.getRSpeed();
        createMission.missionId = fMUMissionInfo.getMissionId();
        createMission.rotateSpeed = tripod.getRSpeed();
        return createMission;
    }

    public static MotionDelayMission getMotionDelayMission(MissionAllInternal missionAllInternal) {
        MotionDelayInfo motionDelayInfo = missionAllInternal.getMotionDelayInfo();
        if (motionDelayInfo == null) {
            return null;
        }
        MissionSingleInfo fMUMissionInfo = missionAllInternal.getFMUMissionInfo();
        MotionDelayMission createMission = MotionDelayMission.createMission();
        if (fMUMissionInfo.getFinishAction() == 1) {
            createMission.finishedAction = WaypointFinishedAction.HOVER;
        } else if (fMUMissionInfo.getFinishAction() == 2) {
            createMission.finishedAction = WaypointFinishedAction.RETURN_HOME;
        } else {
            createMission.finishedAction = WaypointFinishedAction.UNKNOWN;
        }
        createMission.missionType = MissionType.find(fMUMissionInfo.getMissionType());
        createMission.obstacleAvoidanceTimeout = fMUMissionInfo.getObstacleAvoidanceTimeout();
        createMission.avoidanceMode = ObstacleAvoidanceMode.find(fMUMissionInfo.getObstacleAvoidanceMode());
        createMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(fMUMissionInfo.getLostControlAction());
        createMission.verticalSpeed = motionDelayInfo.getVSpeed();
        createMission.horizontalSpeed = motionDelayInfo.getHSpeed();
        createMission.rotateSpeed = motionDelayInfo.getRSpeed();
        createMission.totalTime = motionDelayInfo.getTotalTime();
        createMission.motionDelayType = MotionDelayType.find(motionDelayInfo.getTimelapseType());
        createMission.missionId = fMUMissionInfo.getMissionId();
        return createMission;
    }

    public static ImageStabilityMission getImageStabilityMission(MissionAllInternal missionAllInternal) {
        MissionSingleInfo fMUMissionInfo = missionAllInternal.getFMUMissionInfo();
        ImageStabilityMission createMission = ImageStabilityMission.createMission();
        if (fMUMissionInfo.getFinishAction() == 1) {
            createMission.finishedAction = WaypointFinishedAction.HOVER;
        } else if (fMUMissionInfo.getFinishAction() == 2) {
            createMission.finishedAction = WaypointFinishedAction.RETURN_HOME;
        } else {
            createMission.finishedAction = WaypointFinishedAction.UNKNOWN;
        }
        createMission.missionType = MissionType.find(fMUMissionInfo.getMissionType());
        createMission.obstacleAvoidanceTimeout = fMUMissionInfo.getObstacleAvoidanceTimeout();
        createMission.avoidanceMode = ObstacleAvoidanceMode.find(fMUMissionInfo.getObstacleAvoidanceMode());
        createMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(fMUMissionInfo.getLostControlAction());
        createMission.missionId = fMUMissionInfo.getMissionId();
        return createMission;
    }

    public static MissionAllInternal getCruiserWaypointMissionForEvo(Evo2WaypointMission evo2WaypointMission) {
        MissionAllInternal missionAllInternal = new MissionAllInternal();
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setFinishAction(evo2WaypointMission.finishedAction.getValue());
        missionSingleInfo.setLostControlAction(evo2WaypointMission.remoteControlLostSignalAction.getValue());
        missionSingleInfo.setMissionId(evo2WaypointMission.missionId);
        missionSingleInfo.setObstacleAvoidanceMode(evo2WaypointMission.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(evo2WaypointMission.obstacleAvoidanceTimeout);
        missionSingleInfo.setMissionType(MissionType.Waypoint.getValue());
        missionSingleInfo.setVFOV(evo2WaypointMission.VerticalFOV);
        missionSingleInfo.setHFOV(evo2WaypointMission.HorizontalFOV);
        missionSingleInfo.setPhotoIntervalMin(evo2WaypointMission.PhotoIntervalMin);
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        ArrayList arrayList = new ArrayList();
        if (evo2WaypointMission.wpList != null) {
            missionSingleInfo.setNumberOfWaypoints(evo2WaypointMission.wpList.size());
            for (int i = 0; i < evo2WaypointMission.wpList.size(); i++) {
                WaypointBean waypointBean = new WaypointBean();
                Evo2Waypoint evo2Waypoint = evo2WaypointMission.wpList.get(i);
                waypointBean.setWaypointId(i);
                waypointBean.setAltitude((int) (evo2Waypoint.getAutelCoordinate3D().getAltitude() * 1000.0d));
                waypointBean.setLatitude((int) (evo2Waypoint.getAutelCoordinate3D().getLatitude() * 1.0E7d));
                waypointBean.setLongitude((int) (evo2Waypoint.getAutelCoordinate3D().getLongitude() * 1.0E7d));
                waypointBean.setWaypointType(evo2Waypoint.waypointType.getValue());
                waypointBean.setFocusAltitude((int) (evo2Waypoint.focusAltitude * 1000.0d));
                waypointBean.setFocusLatitude((int) (evo2Waypoint.focusLatitude * 1.0E7d));
                waypointBean.setFocusLongitude((int) (evo2Waypoint.focusLongitude * 1.0E7d));
                waypointBean.setSpeed(evo2Waypoint.speed);
                waypointBean.setwSpeed(evo2Waypoint.wSpeed);
                waypointBean.setBeizerParameter(evo2Waypoint.bezierMode.getValue());
                waypointBean.setHeadingMode(evo2Waypoint.headingMode.getValue());
                waypointBean.setCameraPitch(evo2Waypoint.cameraPitch);
                waypointBean.setCameraYaw(evo2Waypoint.cameraYaw);
                waypointBean.setUserdefinedHeading(evo2Waypoint.customHeadingDirection);
                waypointBean.setAltitudePriorityMode(evo2Waypoint.isAltitudePriority ? 1 : 0);
                if (evo2Waypoint.actions != null) {
                    int size = evo2Waypoint.actions.size();
                    waypointBean.setNumberOfActions(size);
                    List<WaypointAction> list = evo2Waypoint.actions;
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        ActionInfo actionInfo = new ActionInfo();
                        WaypointAction waypointAction = list.get(i2);
                        actionInfo.setActionId(i2);
                        actionInfo.setActionParameters(waypointAction.parameters);
                        actionInfo.setActionTimeout(waypointAction.timeout);
                        actionInfo.setActionType(waypointAction.actionType.getValue());
                        arrayList2.add(actionInfo);
                    }
                    waypointBean.setActions(arrayList2);
                }
                arrayList.add(waypointBean);
            }
        }
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        missionAllInternal.setWaypoints(arrayList);
        return missionAllInternal;
    }

    public static Evo2WaypointMission getCruiserWaypointMissionForEvo(MissionAllInternal missionAllInternal) {
        Evo2WaypointMission evo2WaypointMission = new Evo2WaypointMission();
        evo2WaypointMission.missionId = missionAllInternal.getFMUMissionInfo().getMissionId();
        evo2WaypointMission.missionType = MissionType.find(missionAllInternal.getFMUMissionInfo().getMissionType());
        evo2WaypointMission.finishedAction = Evo2WaypointFinishedAction.find(missionAllInternal.getFMUMissionInfo().getFinishAction());
        evo2WaypointMission.avoidanceMode = ObstacleAvoidanceMode.find(missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceMode());
        evo2WaypointMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(missionAllInternal.getFMUMissionInfo().getLostControlAction());
        evo2WaypointMission.obstacleAvoidanceTimeout = missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceTimeout();
        evo2WaypointMission.VerticalFOV = missionAllInternal.getFMUMissionInfo().getVFOV();
        evo2WaypointMission.HorizontalFOV = missionAllInternal.getFMUMissionInfo().getHFOV();
        evo2WaypointMission.PhotoIntervalMin = missionAllInternal.getFMUMissionInfo().getPhotoIntervalMin();
        ArrayList arrayList = new ArrayList();
        if (missionAllInternal.getWaypoints() != null) {
            for (int i = 0; i < missionAllInternal.getWaypoints().size(); i++) {
                WaypointBean waypointBean = missionAllInternal.getWaypoints().get(i);
                Evo2Waypoint evo2Waypoint = new Evo2Waypoint(new AutelCoordinate3D(((double) waypointBean.getLatitude()) / 1.0E7d, ((double) waypointBean.getLongitude()) / 1.0E7d, ((double) waypointBean.getAltitude()) / 1000.0d));
                boolean z = true;
                evo2Waypoint.isAltitudePriority = waypointBean.getAltitudePriorityMode() == 1;
                evo2Waypoint.focusAltitude = ((double) waypointBean.getFocusAltitude()) / 1000.0d;
                evo2Waypoint.focusLatitude = ((double) waypointBean.getFocusLatitude()) / 1.0E7d;
                evo2Waypoint.focusLongitude = ((double) waypointBean.getFocusLongitude()) / 1.0E7d;
                evo2Waypoint.waypointType = WaypointType.find(waypointBean.getWaypointType());
                evo2Waypoint.wSpeed = waypointBean.getwSpeed();
                if (-1.0f != evo2Waypoint.wSpeed) {
                    evo2Waypoint.speed = (int) waypointBean.getwSpeed();
                } else {
                    evo2Waypoint.speed = waypointBean.getSpeed();
                }
                evo2Waypoint.bezierMode = WaypointBezierMode.find(waypointBean.getBeizerParameter());
                evo2Waypoint.headingMode = WaypointHeadingMode.find(waypointBean.getHeadingMode());
                evo2Waypoint.cameraPitch = waypointBean.getCameraPitch();
                evo2Waypoint.cameraYaw = waypointBean.getCameraYaw();
                evo2Waypoint.hoverTime = waypointBean.getHoverTime();
                evo2Waypoint.customHeadingDirection = waypointBean.getUserdefinedHeading();
                if (waypointBean.getAltitudePriorityMode() != 1) {
                    z = false;
                }
                evo2Waypoint.isAltitudePriority = z;
                List<ActionInfo> actions = waypointBean.getActions();
                if (actions != null) {
                    int size = actions.size();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        ActionInfo actionInfo = actions.get(i2);
                        WaypointAction waypointAction = new WaypointAction();
                        waypointAction.actionType = MissionActionType.find(actionInfo.getActionType());
                        waypointAction.parameters = actionInfo.getActionParameters();
                        waypointAction.timeout = actionInfo.getActionTimeout();
                        arrayList2.add(waypointAction);
                    }
                    evo2Waypoint.actions = arrayList2;
                }
                arrayList.add(evo2Waypoint);
            }
            evo2WaypointMission.wpList = arrayList;
        }
        return evo2WaypointMission;
    }

    public static MissionAllInternal getCruiserWaypointMission(Evo2WaypointMission evo2WaypointMission) {
        Evo2WaypointMission evo2WaypointMission2 = evo2WaypointMission;
        MissionAllInternal missionAllInternal = new MissionAllInternal();
        MissionSingleInfo missionSingleInfo = new MissionSingleInfo();
        missionSingleInfo.setFinishAction(evo2WaypointMission2.finishedAction.getValue());
        missionSingleInfo.setLostControlAction(evo2WaypointMission2.remoteControlLostSignalAction.getValue());
        missionSingleInfo.setMissionId(evo2WaypointMission2.missionId);
        missionSingleInfo.setObstacleAvoidanceMode(evo2WaypointMission2.avoidanceMode.getValue());
        missionSingleInfo.setObstacleAvoidanceTimeout(evo2WaypointMission2.obstacleAvoidanceTimeout);
        missionSingleInfo.setMissionType(evo2WaypointMission2.missionType.getValue());
        missionSingleInfo.setTotalTimes(evo2WaypointMission2.totalFlyTime);
        missionSingleInfo.setTotalDistance(evo2WaypointMission2.totalDistance);
        missionSingleInfo.setVFOV(evo2WaypointMission2.VerticalFOV);
        missionSingleInfo.setHFOV(evo2WaypointMission2.HorizontalFOV);
        missionSingleInfo.setPhotoIntervalMin(evo2WaypointMission2.PhotoIntervalMin);
        missionSingleInfo.setExecuteIndex(evo2WaypointMission2.ExecuteIndex);
        missionSingleInfo.setExecutePhotos(evo2WaypointMission2.ExecutePhotos);
        missionSingleInfo.setGUID(evo2WaypointMission2.GUID);
        missionSingleInfo.setNumberVertexPoints(evo2WaypointMission2.NumberVertexPoints);
        double d = 1000.0d;
        missionSingleInfo.setDroneAltitude((int) (evo2WaypointMission2.DroneAltitude * 1000.0d));
        missionSingleInfo.setDroneLatitude((int) (evo2WaypointMission2.DroneLatitude * 1.0E7d));
        missionSingleInfo.setDroneLongitude((int) (evo2WaypointMission2.DroneLongitude * 1.0E7d));
        missionSingleInfo.setMissionName(evo2WaypointMission2.MissionName);
        missionSingleInfo.setGridEnable(evo2WaypointMission2.DoubleGridEnable);
        missionSingleInfo.setAutoAngle(evo2WaypointMission2.autoAngel);
        missionSingleInfo.setMissionAction(evo2WaypointMission2.missionAction);
        missionSingleInfo.setAltitudeType(evo2WaypointMission2.altitudeType);
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        ArrayList arrayList = new ArrayList();
        if (evo2WaypointMission2.wpoiList != null) {
            List<Poi> list = evo2WaypointMission2.wpoiList;
            for (int i = 0; i < list.size(); i++) {
                PoiInfo poiInfo = new PoiInfo();
                Poi poi = list.get(i);
                poiInfo.setId(poi.f8470id);
                poiInfo.setAltitude((int) (poi.coordinate3D.getAltitude() * 1000.0d));
                poiInfo.setLongitude((int) (poi.coordinate3D.getLongitude() * 1.0E7d));
                poiInfo.setLatitude((int) (poi.coordinate3D.getLatitude() * 1.0E7d));
                arrayList.add(poiInfo);
            }
        }
        missionSingleInfo.setNumberOfInterestPoint(arrayList.size());
        missionAllInternal.setPoiList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (evo2WaypointMission2.vertexList != null) {
            List<Vertex> list2 = evo2WaypointMission2.vertexList;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                VertexInfo vertexInfo = new VertexInfo();
                Vertex vertex = list2.get(i2);
                vertexInfo.setId(vertex.f8471id);
                vertexInfo.setAltitude((int) (vertex.coordinate3D.getAltitude() * 1000.0d));
                vertexInfo.setLongitude((int) (vertex.coordinate3D.getLongitude() * 1.0E7d));
                vertexInfo.setLatitude((int) (vertex.coordinate3D.getLatitude() * 1.0E7d));
                arrayList2.add(vertexInfo);
            }
        }
        missionSingleInfo.setNumberVertexPoints(arrayList2.size());
        missionAllInternal.setVertex(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (evo2WaypointMission2.wpList != null) {
            missionSingleInfo.setNumberOfWaypoints(evo2WaypointMission2.wpList.size());
            int i3 = 0;
            while (i3 < evo2WaypointMission2.wpList.size()) {
                WaypointBean waypointBean = new WaypointBean();
                Evo2Waypoint evo2Waypoint = evo2WaypointMission2.wpList.get(i3);
                waypointBean.setWaypointId(i3);
                waypointBean.setAltitude((int) (evo2Waypoint.getAutelCoordinate3D().getAltitude() * d));
                waypointBean.setLatitude((int) (evo2Waypoint.getAutelCoordinate3D().getLatitude() * 1.0E7d));
                waypointBean.setLongitude((int) (evo2Waypoint.getAutelCoordinate3D().getLongitude() * 1.0E7d));
                waypointBean.setWaypointType(evo2Waypoint.waypointType.getValue());
                waypointBean.setPoiIndex(evo2Waypoint.poiIndex);
                waypointBean.setParam1(evo2Waypoint.param1);
                waypointBean.setParam2(evo2Waypoint.param2);
                waypointBean.setParam3(evo2Waypoint.param3);
                waypointBean.setParam4(evo2Waypoint.param4);
                waypointBean.setParam5(evo2Waypoint.param5);
                waypointBean.setParam6(evo2Waypoint.param6);
                waypointBean.setParam7(evo2Waypoint.param7);
                waypointBean.setSpeed(evo2Waypoint.speed);
                waypointBean.setwSpeed(evo2Waypoint.wSpeed);
                waypointBean.setHoverTime(evo2Waypoint.hoverTime);
                waypointBean.setCurFlyTime(evo2Waypoint.flyTime);
                waypointBean.setCurFlyDistance(evo2Waypoint.flyDistance);
                waypointBean.setBeizerParameter(evo2Waypoint.bezierMode.getValue());
                waypointBean.setHeadingMode(evo2Waypoint.headingMode.getValue());
                waypointBean.setCameraPitch(-evo2Waypoint.cameraPitch);
                waypointBean.setCameraYaw(evo2Waypoint.cameraYaw);
                waypointBean.setUserdefinedHeading(evo2Waypoint.customHeadingDirection);
                waypointBean.setAltitudePriorityMode(evo2Waypoint.isAltitudePriority ? 1 : 0);
                if (evo2Waypoint.actions != null) {
                    int size = evo2Waypoint.actions.size();
                    waypointBean.setNumberOfActions(size);
                    List<WaypointAction> list3 = evo2Waypoint.actions;
                    ArrayList arrayList4 = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        ActionInfo actionInfo = new ActionInfo();
                        WaypointAction waypointAction = list3.get(i4);
                        actionInfo.setActionId(i4);
                        actionInfo.setActionParameters(waypointAction.parameters);
                        actionInfo.setActionTimeout(waypointAction.timeout);
                        actionInfo.setActionType(waypointAction.actionType.getValue());
                        arrayList4.add(actionInfo);
                    }
                    waypointBean.setActions(arrayList4);
                }
                arrayList3.add(waypointBean);
                i3++;
                d = 1000.0d;
            }
        }
        missionAllInternal.setFMUMissionInfo(missionSingleInfo);
        missionAllInternal.setWaypoints(arrayList3);
        return missionAllInternal;
    }

    public static Evo2WaypointMission getCruiserWaypointMission(MissionAllInternal missionAllInternal) {
        Evo2WaypointMission evo2WaypointMission = new Evo2WaypointMission();
        evo2WaypointMission.missionId = missionAllInternal.getFMUMissionInfo().getMissionId();
        evo2WaypointMission.missionType = MissionType.find(missionAllInternal.getFMUMissionInfo().getMissionType());
        evo2WaypointMission.finishedAction = Evo2WaypointFinishedAction.find(missionAllInternal.getFMUMissionInfo().getFinishAction());
        evo2WaypointMission.avoidanceMode = ObstacleAvoidanceMode.find(missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceMode());
        evo2WaypointMission.remoteControlLostSignalAction = RemoteControlLostSignalAction.find(missionAllInternal.getFMUMissionInfo().getLostControlAction());
        evo2WaypointMission.obstacleAvoidanceTimeout = missionAllInternal.getFMUMissionInfo().getObstacleAvoidanceTimeout();
        evo2WaypointMission.totalDistance = missionAllInternal.getFMUMissionInfo().getTotalDistance();
        evo2WaypointMission.totalFlyTime = missionAllInternal.getFMUMissionInfo().getTotalTimes();
        evo2WaypointMission.VerticalFOV = missionAllInternal.getFMUMissionInfo().getVFOV();
        evo2WaypointMission.HorizontalFOV = missionAllInternal.getFMUMissionInfo().getHFOV();
        evo2WaypointMission.PhotoIntervalMin = missionAllInternal.getFMUMissionInfo().getPhotoIntervalMin();
        evo2WaypointMission.GUID = missionAllInternal.getFMUMissionInfo().getGUID();
        evo2WaypointMission.NumberVertexPoints = missionAllInternal.getFMUMissionInfo().getNumberVertexPoints();
        evo2WaypointMission.ExecutePhotos = missionAllInternal.getFMUMissionInfo().getExecutePhotos();
        evo2WaypointMission.ExecuteIndex = missionAllInternal.getFMUMissionInfo().getExecuteIndex();
        evo2WaypointMission.DroneAltitude = (double) missionAllInternal.getFMUMissionInfo().getDroneAltitude();
        evo2WaypointMission.DroneLatitude = (double) missionAllInternal.getFMUMissionInfo().getDroneLatitude();
        evo2WaypointMission.DroneLongitude = (double) missionAllInternal.getFMUMissionInfo().getDroneLongitude();
        evo2WaypointMission.MissionName = missionAllInternal.getFMUMissionInfo().getMissionName();
        evo2WaypointMission.DoubleGridEnable = missionAllInternal.getFMUMissionInfo().getGridEnable();
        evo2WaypointMission.autoAngel = missionAllInternal.getFMUMissionInfo().getAutoAngle();
        evo2WaypointMission.missionAction = missionAllInternal.getFMUMissionInfo().getMissionAction();
        evo2WaypointMission.altitudeType = missionAllInternal.getFMUMissionInfo().getAltitudeType();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        double d = 1.0E7d;
        if (missionAllInternal.getPoiList() != null) {
            int i = 0;
            while (i < missionAllInternal.getPoiList().size()) {
                Poi poi = new Poi();
                PoiInfo poiInfo = missionAllInternal.getPoiList().get(i);
                AutelCoordinate3D autelCoordinate3D = r11;
                AutelCoordinate3D autelCoordinate3D2 = new AutelCoordinate3D(((double) poiInfo.getLatitude()) / d, ((double) poiInfo.getLongitude()) / d, ((double) poiInfo.getAltitude()) / 1000.0d);
                Poi poi2 = poi;
                poi2.coordinate3D = autelCoordinate3D;
                poi2.f8470id = poiInfo.getId();
                arrayList2.add(poi2);
                i++;
                d = 1.0E7d;
            }
        }
        evo2WaypointMission.wpoiList = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        if (missionAllInternal.getVertex() != null) {
            for (int i2 = 0; i2 < missionAllInternal.getVertex().size(); i2++) {
                Vertex vertex = new Vertex();
                VertexInfo vertexInfo = missionAllInternal.getVertex().get(i2);
                vertex.coordinate3D = new AutelCoordinate3D(((double) vertexInfo.getLatitude()) / 1.0E7d, ((double) vertexInfo.getLongitude()) / 1.0E7d, ((double) vertexInfo.getAltitude()) / 1000.0d);
                vertex.f8471id = vertexInfo.getId();
                arrayList3.add(vertex);
            }
        }
        evo2WaypointMission.vertexList = arrayList3;
        if (missionAllInternal.getWaypoints() != null) {
            for (int i3 = 0; i3 < missionAllInternal.getWaypoints().size(); i3++) {
                WaypointBean waypointBean = missionAllInternal.getWaypoints().get(i3);
                Evo2Waypoint evo2Waypoint = new Evo2Waypoint(new AutelCoordinate3D(((double) waypointBean.getLatitude()) / 1.0E7d, ((double) waypointBean.getLongitude()) / 1.0E7d, ((double) waypointBean.getAltitude()) / 1000.0d));
                boolean z = true;
                evo2Waypoint.isAltitudePriority = waypointBean.getAltitudePriorityMode() == 1;
                evo2Waypoint.poiIndex = waypointBean.getPoiIndex();
                evo2Waypoint.hoverTime = waypointBean.getHoverTime();
                evo2Waypoint.flyDistance = waypointBean.getCurFlyDistance();
                evo2Waypoint.flyTime = waypointBean.getCurFlyTime();
                evo2Waypoint.param1 = waypointBean.getParam1();
                evo2Waypoint.param2 = waypointBean.getParam2();
                evo2Waypoint.param3 = waypointBean.getParam3();
                evo2Waypoint.param4 = waypointBean.getParam4();
                evo2Waypoint.param5 = waypointBean.getParam5();
                evo2Waypoint.param6 = waypointBean.getParam6();
                evo2Waypoint.param7 = waypointBean.getParam7();
                evo2Waypoint.waypointType = WaypointType.find(waypointBean.getWaypointType());
                evo2Waypoint.wSpeed = waypointBean.getwSpeed();
                if (-1.0f != evo2Waypoint.wSpeed) {
                    evo2Waypoint.speed = (int) waypointBean.getwSpeed();
                } else {
                    evo2Waypoint.speed = waypointBean.getSpeed();
                }
                evo2Waypoint.bezierMode = WaypointBezierMode.find(waypointBean.getBeizerParameter());
                evo2Waypoint.headingMode = WaypointHeadingMode.find(waypointBean.getHeadingMode());
                evo2Waypoint.cameraPitch = -waypointBean.getCameraPitch();
                evo2Waypoint.cameraYaw = waypointBean.getCameraYaw();
                evo2Waypoint.customHeadingDirection = waypointBean.getUserdefinedHeading();
                if (waypointBean.getAltitudePriorityMode() != 1) {
                    z = false;
                }
                evo2Waypoint.isAltitudePriority = z;
                List<ActionInfo> actions = waypointBean.getActions();
                if (actions != null) {
                    int size = actions.size();
                    ArrayList arrayList4 = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        ActionInfo actionInfo = actions.get(i4);
                        WaypointAction waypointAction = new WaypointAction();
                        waypointAction.actionType = MissionActionType.find(actionInfo.getActionType());
                        waypointAction.parameters = actionInfo.getActionParameters();
                        waypointAction.timeout = actionInfo.getActionTimeout();
                        arrayList4.add(waypointAction);
                    }
                    evo2Waypoint.actions = arrayList4;
                }
                arrayList.add(evo2Waypoint);
            }
            evo2WaypointMission.wpList = arrayList;
        }
        return evo2WaypointMission;
    }
}
