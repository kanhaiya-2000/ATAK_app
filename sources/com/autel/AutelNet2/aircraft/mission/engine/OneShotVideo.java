package com.autel.AutelNet2.aircraft.mission.engine;

public class OneShotVideo {
    private int Cycles;
    private int MoveDistance;
    private int MoveSpeed;
    private int RotateDirection;
    private int RotateSpeed;
    private int VideoType;

    public int getVideoType() {
        return this.VideoType;
    }

    public void setVideoType(int i) {
        this.VideoType = i;
    }

    public int getRotateSpeed() {
        return this.RotateSpeed;
    }

    public void setRotateSpeed(int i) {
        this.RotateSpeed = i;
    }

    public int getRotateDirection() {
        return this.RotateDirection;
    }

    public void setRotateDirection(int i) {
        this.RotateDirection = i;
    }

    public int getCycles() {
        return this.Cycles;
    }

    public void setCycles(int i) {
        this.Cycles = i;
    }

    public int getMoveSpeed() {
        return this.MoveSpeed;
    }

    public void setMoveSpeed(int i) {
        this.MoveSpeed = i;
    }

    public int getMoveDistance() {
        return this.MoveDistance;
    }

    public void setMoveDistance(int i) {
        this.MoveDistance = i;
    }
}
