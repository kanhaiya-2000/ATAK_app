package com.autel.internal.sdk.mission;

public class AutelOrbit {
    private short command = 106;
    private double lat;
    private double lng;
    private short missionFinishType;
    private float radius;
    private float returnHeight;
    private short round;
    private float speed;

    public void setCommand(short s) {
        this.command = s;
    }

    public short getCommand() {
        return this.command;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setReturnHeight(float f) {
        this.returnHeight = f;
    }

    public float getReturnHeight() {
        return this.returnHeight;
    }

    public void setRound(short s) {
        this.round = s;
    }

    public short getRound() {
        return this.round;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public double getLng() {
        return this.lng;
    }

    public void setMissionFinishTypeValue(short s) {
        this.missionFinishType = s;
    }

    public int getMissonFinishedType() {
        return this.missionFinishType;
    }

    public String toString() {
        return "半径 == " + this.radius + ",速度 == " + this.speed + ",返航高度 == " + this.returnHeight + ",跟随类型 == ,圈数 == " + this.round + ",返航模式 == " + this.missionFinishType + ",纬度 == " + this.lat + ",经度 == " + this.lng;
    }
}
