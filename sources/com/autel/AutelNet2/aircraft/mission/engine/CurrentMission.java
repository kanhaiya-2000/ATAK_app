package com.autel.AutelNet2.aircraft.mission.engine;

public class CurrentMission {
    private int ActionSeq;
    private int Arrived;
    private int Directing;
    private int PhotoCount;
    private int ResidualDistance;
    private int ResidualTime;
    private float SpeedSet;
    private int Status;
    private long TimeBootMs;
    private int WaypointSeq;

    public int getResidualTime() {
        return this.ResidualTime;
    }

    public void setResidualTime(int i) {
        this.ResidualTime = i;
    }

    public int getResidualDistance() {
        return this.ResidualDistance;
    }

    public void setResidualDistance(int i) {
        this.ResidualDistance = i;
    }

    public int getPhotoCount() {
        return this.PhotoCount;
    }

    public void setPhotoCount(int i) {
        this.PhotoCount = i;
    }

    public long getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(long j) {
        this.TimeBootMs = j;
    }

    public float getSpeedSet() {
        return this.SpeedSet / 1000.0f;
    }

    public void setSpeedSet(float f) {
        this.SpeedSet = f;
    }

    public int getWaypointSeq() {
        return this.WaypointSeq;
    }

    public void setWaypointSeq(int i) {
        this.WaypointSeq = i;
    }

    public int getArrived() {
        return this.Arrived;
    }

    public void setArrived(int i) {
        this.Arrived = i;
    }

    public int getDirecting() {
        return this.Directing;
    }

    public void setDirecting(int i) {
        this.Directing = i;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public int getActionSeq() {
        return this.ActionSeq;
    }

    public void setActionSeq(int i) {
        this.ActionSeq = i;
    }
}
