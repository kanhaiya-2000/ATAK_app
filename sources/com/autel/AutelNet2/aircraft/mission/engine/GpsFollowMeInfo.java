package com.autel.AutelNet2.aircraft.mission.engine;

public class GpsFollowMeInfo {
    private int AttitudeStrategy;
    private int GroundFollowMode;
    private int HeadingMode;
    private int OrbitDirection;
    private int OrbitRadius;
    private int OrbitSpeed;
    private int ReverseFlightAllowed;
    private int UserHeading;

    public int getAttitudeStrategy() {
        return this.AttitudeStrategy;
    }

    public void setAttitudeStrategy(int i) {
        this.AttitudeStrategy = i;
    }

    public int getReverseFlightAllowed() {
        return this.ReverseFlightAllowed;
    }

    public void setReverseFlightAllowed(int i) {
        this.ReverseFlightAllowed = i;
    }

    public int getHeadingMode() {
        return this.HeadingMode;
    }

    public void setHeadingMode(int i) {
        this.HeadingMode = i;
    }

    public int getUserHeading() {
        return this.UserHeading;
    }

    public void setUserHeading(int i) {
        this.UserHeading = i;
    }

    public int getGroundFollowMode() {
        return this.GroundFollowMode;
    }

    public void setGroundFollowMode(int i) {
        this.GroundFollowMode = i;
    }

    public int getOrbitRadius() {
        return this.OrbitRadius;
    }

    public void setOrbitRadius(int i) {
        this.OrbitRadius = i;
    }

    public int getOrbitSpeed() {
        return this.OrbitSpeed;
    }

    public void setOrbitSpeed(int i) {
        this.OrbitSpeed = i;
    }

    public int getOrbitDirection() {
        return this.OrbitDirection;
    }

    public void setOrbitDirection(int i) {
        this.OrbitDirection = i;
    }
}
