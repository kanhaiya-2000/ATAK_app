package com.autel.sdk10.AutelCommunity.engine;

public class UserRecordInfo {
    private String autelId;
    private int spaceInUse;
    private int spaceQuota;
    private int total_flights;
    private float total_flyDistance;
    private int total_flyTimeDuration;

    public String getAutelId() {
        return this.autelId;
    }

    public void setAutelId(String str) {
        this.autelId = str;
    }

    public int getSpaceQuota() {
        return this.spaceQuota;
    }

    public void setSpaceQuota(int i) {
        this.spaceQuota = i;
    }

    public int getSpaceInUse() {
        return this.spaceInUse;
    }

    public void setSpaceInUse(int i) {
        this.spaceInUse = i;
    }

    public float getTotal_flyDistance() {
        return this.total_flyDistance;
    }

    public void setTotal_flyDistance(float f) {
        this.total_flyDistance = f;
    }

    public int getTotal_flyTimeDuration() {
        return this.total_flyTimeDuration;
    }

    public void setTotal_flyTimeDuration(int i) {
        this.total_flyTimeDuration = i;
    }

    public int getTotal_flights() {
        return this.total_flights;
    }

    public void setTotal_flights(int i) {
        this.total_flights = i;
    }
}
