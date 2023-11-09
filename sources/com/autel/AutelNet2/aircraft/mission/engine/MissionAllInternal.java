package com.autel.AutelNet2.aircraft.mission.engine;

import java.util.List;

public class MissionAllInternal {
    private MissionSingleInfo FMUMissionInfo;
    private OneShotVideo OneShotVideo;
    private OrbitInfo OrbitInfo;
    private List<PoiInfo> PoiList;
    private MotionDelayInfo TimelapsePhoto;
    private TripodInfo Tripod;
    private List<VertexInfo> Vertex;
    private List<WaypointBean> Waypoints;

    public MotionDelayInfo getTimelapsePhoto() {
        return this.TimelapsePhoto;
    }

    public void setTimelapsePhoto(MotionDelayInfo motionDelayInfo) {
        this.TimelapsePhoto = motionDelayInfo;
    }

    public List<VertexInfo> getVertex() {
        return this.Vertex;
    }

    public void setVertex(List<VertexInfo> list) {
        this.Vertex = list;
    }

    public List<PoiInfo> getPoiList() {
        return this.PoiList;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.PoiList = list;
    }

    public MissionSingleInfo getFMUMissionInfo() {
        return this.FMUMissionInfo;
    }

    public void setFMUMissionInfo(MissionSingleInfo missionSingleInfo) {
        this.FMUMissionInfo = missionSingleInfo;
    }

    public List<WaypointBean> getWaypoints() {
        return this.Waypoints;
    }

    public void setWaypoints(List<WaypointBean> list) {
        this.Waypoints = list;
    }

    public OrbitInfo getOrbitInfo() {
        return this.OrbitInfo;
    }

    public void setOrbitInfo(OrbitInfo orbitInfo) {
        this.OrbitInfo = orbitInfo;
    }

    public OneShotVideo getOneShotVideo() {
        return this.OneShotVideo;
    }

    public void setOneShotVideo(OneShotVideo oneShotVideo) {
        this.OneShotVideo = oneShotVideo;
    }

    public TripodInfo getTripod() {
        return this.Tripod;
    }

    public void setTripod(TripodInfo tripodInfo) {
        this.Tripod = tripodInfo;
    }

    public MotionDelayInfo getMotionDelayInfo() {
        return this.TimelapsePhoto;
    }

    public void setMotionDelayInfo(MotionDelayInfo motionDelayInfo) {
        this.TimelapsePhoto = motionDelayInfo;
    }
}
