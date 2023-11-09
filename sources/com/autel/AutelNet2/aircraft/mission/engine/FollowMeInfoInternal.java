package com.autel.AutelNet2.aircraft.mission.engine;

public class FollowMeInfoInternal {
    private int Status;
    private int TimeBootMs;

    public int getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(int i) {
        this.TimeBootMs = i;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public String toString() {
        return "TimeBootMs:" + this.TimeBootMs + " Status:" + this.Status;
    }
}
