package com.autel.AutelNet2.aircraft.mission.engine;

public class MissionSingleInfo {
    private int AltitudeType;
    private int AutoAngle;
    private int DroneAltitude;
    private int DroneLatitude;
    private int DroneLongitude;
    private int ExecuteIndex;
    private int ExecutePhotos;
    private int FinishAction;
    private String GUID;
    private int GridEnable;
    private float HFOV;
    private int LostControlAction;
    private int MissionAction;
    private int MissionId;
    private String MissionName;
    private int MissionType;
    private int NumberOfInterestPoints;
    private int NumberOfWaypoints;
    private int NumberVertexPoints;
    private int ObstacleAvoidanceMode;
    private int ObstacleAvoidanceTimeout;
    private int PhotoIntervalMin;
    private int TotalDistance;
    private int TotalTimes;
    private float VFOV;

    public int getAltitudeType() {
        return this.AltitudeType;
    }

    public void setAltitudeType(int i) {
        this.AltitudeType = i;
    }

    public int getMissionAction() {
        return this.MissionAction;
    }

    public void setMissionAction(int i) {
        this.MissionAction = i;
    }

    public int getAutoAngle() {
        return this.AutoAngle;
    }

    public void setAutoAngle(int i) {
        this.AutoAngle = i;
    }

    public String getMissionName() {
        return this.MissionName;
    }

    public void setMissionName(String str) {
        this.MissionName = str;
    }

    public int getGridEnable() {
        return this.GridEnable;
    }

    public void setGridEnable(int i) {
        this.GridEnable = i;
    }

    public String getGUID() {
        return this.GUID;
    }

    public void setGUID(String str) {
        this.GUID = str;
    }

    public int getNumberVertexPoints() {
        return this.NumberVertexPoints;
    }

    public void setNumberVertexPoints(int i) {
        this.NumberVertexPoints = i;
    }

    public int getDroneLatitude() {
        return this.DroneLatitude;
    }

    public void setDroneLatitude(int i) {
        this.DroneLatitude = i;
    }

    public int getDroneLongitude() {
        return this.DroneLongitude;
    }

    public void setDroneLongitude(int i) {
        this.DroneLongitude = i;
    }

    public int getDroneAltitude() {
        return this.DroneAltitude;
    }

    public void setDroneAltitude(int i) {
        this.DroneAltitude = i;
    }

    public int getExecuteIndex() {
        return this.ExecuteIndex;
    }

    public void setExecuteIndex(int i) {
        this.ExecuteIndex = i;
    }

    public int getExecutePhotos() {
        return this.ExecutePhotos;
    }

    public void setExecutePhotos(int i) {
        this.ExecutePhotos = i;
    }

    public float getVFOV() {
        return this.VFOV;
    }

    public void setVFOV(float f) {
        this.VFOV = f;
    }

    public float getHFOV() {
        return this.HFOV;
    }

    public void setHFOV(float f) {
        this.HFOV = f;
    }

    public int getPhotoIntervalMin() {
        return this.PhotoIntervalMin;
    }

    public void setPhotoIntervalMin(int i) {
        this.PhotoIntervalMin = i;
    }

    public int getNumberOfInterestPoints() {
        return this.NumberOfInterestPoints;
    }

    public void setNumberOfInterestPoints(int i) {
        this.NumberOfInterestPoints = i;
    }

    public int getTotalTimes() {
        return this.TotalTimes;
    }

    public void setTotalTimes(int i) {
        this.TotalTimes = i;
    }

    public int getTotalDistance() {
        return this.TotalDistance;
    }

    public void setTotalDistance(int i) {
        this.TotalDistance = i;
    }

    public int getMissionId() {
        return this.MissionId;
    }

    public void setMissionId(int i) {
        this.MissionId = i;
    }

    public int getMissionType() {
        return this.MissionType;
    }

    public void setMissionType(int i) {
        this.MissionType = i;
    }

    public int getFinishAction() {
        return this.FinishAction;
    }

    public void setFinishAction(int i) {
        this.FinishAction = i;
    }

    public int getObstacleAvoidanceMode() {
        return this.ObstacleAvoidanceMode;
    }

    public void setObstacleAvoidanceMode(int i) {
        this.ObstacleAvoidanceMode = i;
    }

    public int getObstacleAvoidanceTimeout() {
        return this.ObstacleAvoidanceTimeout;
    }

    public void setObstacleAvoidanceTimeout(int i) {
        this.ObstacleAvoidanceTimeout = i;
    }

    public int getLostControlAction() {
        return this.LostControlAction;
    }

    public void setLostControlAction(int i) {
        this.LostControlAction = i;
    }

    public int getNumberOfWaypoints() {
        return this.NumberOfWaypoints;
    }

    public void setNumberOfWaypoints(int i) {
        this.NumberOfWaypoints = i;
    }

    public int getNumberOfInterestPoint() {
        return this.NumberOfInterestPoints;
    }

    public void setNumberOfInterestPoint(int i) {
        this.NumberOfInterestPoints = i;
    }
}
