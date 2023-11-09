package com.autel.AutelNet2.aircraft.mission.engine;

public class CylinderInfo {
    private int CenterAltitude;
    private int CenterLattidue;
    private int CenterLongitude;
    private int Cycles;
    private int EntryDirection;
    private int HeadingDirection;
    private int MissionId;
    private int Radius;
    private int RemainDegree;
    private int RotateDirection;
    private int Speed;
    private int WaypointId;

    public int getMissionId() {
        return this.MissionId;
    }

    public void setMissionId(int i) {
        this.MissionId = i;
    }

    public int getWaypointId() {
        return this.WaypointId;
    }

    public void setWaypointId(int i) {
        this.WaypointId = i;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int i) {
        this.Speed = i;
    }

    public int getRadius() {
        return this.Radius;
    }

    public void setRadius(int i) {
        this.Radius = i;
    }

    public int getCycles() {
        return this.Cycles;
    }

    public void setCycles(int i) {
        this.Cycles = i;
    }

    public int getRemainDegree() {
        return this.RemainDegree;
    }

    public void setRemainDegree(int i) {
        this.RemainDegree = i;
    }

    public int getRotateDirection() {
        return this.RotateDirection;
    }

    public void setRotateDirection(int i) {
        this.RotateDirection = i;
    }

    public int getHeadingDirection() {
        return this.HeadingDirection;
    }

    public void setHeadingDirection(int i) {
        this.HeadingDirection = i;
    }

    public int getCenterLattidue() {
        return this.CenterLattidue;
    }

    public void setCenterLattidue(int i) {
        this.CenterLattidue = i;
    }

    public int getCenterLongitude() {
        return this.CenterLongitude;
    }

    public void setCenterLongitude(int i) {
        this.CenterLongitude = i;
    }

    public int getCenterAltitude() {
        return this.CenterAltitude;
    }

    public void setCenterAltitude(int i) {
        this.CenterAltitude = i;
    }

    public int getEntryDirection() {
        return this.EntryDirection;
    }

    public void setEntryDirection(int i) {
        this.EntryDirection = i;
    }
}
