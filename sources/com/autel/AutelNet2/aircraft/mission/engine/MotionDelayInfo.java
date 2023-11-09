package com.autel.AutelNet2.aircraft.mission.engine;

public class MotionDelayInfo {
    private float HSpeed;
    private int MissionId;
    private float RSpeed;
    private int TimelapseType;
    private int TotalTime;
    private float VSpeed;

    public int getTotalTime() {
        return this.TotalTime;
    }

    public void setTotalTime(int i) {
        this.TotalTime = i;
    }

    public int getTimelapseType() {
        return this.TimelapseType;
    }

    public void setTimelapseType(int i) {
        this.TimelapseType = i;
    }

    public int getMissionId() {
        return this.MissionId;
    }

    public void setMissionId(int i) {
        this.MissionId = i;
    }

    public float getHSpeed() {
        return this.HSpeed;
    }

    public void setHSpeed(float f) {
        this.HSpeed = f;
    }

    public float getVSpeed() {
        return this.VSpeed;
    }

    public void setVSpeed(float f) {
        this.VSpeed = f;
    }

    public float getRSpeed() {
        return this.RSpeed;
    }

    public void setRSpeed(float f) {
        this.RSpeed = f;
    }
}
