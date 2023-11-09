package com.autel.AutelNet2.aircraft.visual.tracking.entity;

public class ReportOrbitInfo {
    private float ActualHeight;
    private float ActualRadius;
    private float ExpectHeight;
    private float ExpectRadius;
    private int Flag;
    private float MaxSpeed;
    private int Reserve;
    private int Rotate;
    private float SetSpeed;
    private int Status;
    private long Timestamp;

    public float getSetSpeed() {
        return this.SetSpeed;
    }

    public void setSetSpeed(float f) {
        this.SetSpeed = f;
    }

    public int getFlag() {
        return this.Flag;
    }

    public void setFlag(int i) {
        this.Flag = i;
    }

    public int getReserve() {
        return this.Reserve;
    }

    public void setReserve(int i) {
        this.Reserve = i;
    }

    public float getActualHeight() {
        return this.ActualHeight;
    }

    public void setActualHeight(float f) {
        this.ActualHeight = f;
    }

    public float getActualRadius() {
        return this.ActualRadius;
    }

    public void setActualRadius(float f) {
        this.ActualRadius = f;
    }

    public float getExpectHeight() {
        return this.ExpectHeight;
    }

    public void setExpectHeight(float f) {
        this.ExpectHeight = f;
    }

    public float getExpectRadius() {
        return this.ExpectRadius;
    }

    public void setExpectRadius(float f) {
        this.ExpectRadius = f;
    }

    public float getMaxSpeed() {
        return this.MaxSpeed;
    }

    public void setMaxSpeed(float f) {
        this.MaxSpeed = f;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public long getTimestamp() {
        return this.Timestamp;
    }

    public void setTimestamp(long j) {
        this.Timestamp = j;
    }

    public int getRotate() {
        return this.Rotate;
    }

    public void setRotate(int i) {
        this.Rotate = i;
    }
}
