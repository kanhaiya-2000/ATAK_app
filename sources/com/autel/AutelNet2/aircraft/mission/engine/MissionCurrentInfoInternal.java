package com.autel.AutelNet2.aircraft.mission.engine;

public class MissionCurrentInfoInternal {
    private int Arrived;
    private int Directing;
    private int SpeedSet;
    private int Status;
    private int TimeBootMs;
    private int WaypointSeq;

    public int getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(int i) {
        this.TimeBootMs = i;
    }

    public int getSpeedSet() {
        return this.SpeedSet;
    }

    public void setSpeedSet(int i) {
        this.SpeedSet = i;
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

    public String toString() {
        return "TimeBootMs:" + this.TimeBootMs + " SpeedSet:" + this.SpeedSet + " WaypointSeq:" + this.WaypointSeq + " Arrived:" + this.Arrived + " Directing:" + this.Directing + " Status:" + this.Status;
    }
}
