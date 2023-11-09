package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity;

public class ViewpointInfo {
    private float PointflyHorizon;
    private float PointflyLimitBottom;
    private float PointflyLimitTop;
    private int PointflyOngoing;
    private float PointflyScaleX;
    private float PointflyScaleY;
    private int PointflySpeed;

    public int getPointflySpeed() {
        return this.PointflySpeed;
    }

    public void setPointflySpeed(int i) {
        this.PointflySpeed = i;
    }

    public float getPointflyScaleX() {
        return this.PointflyScaleX / 100.0f;
    }

    public void setPointflyScaleX(float f) {
        this.PointflyScaleX = f;
    }

    public float getPointflyScaleY() {
        return this.PointflyScaleY / 100.0f;
    }

    public void setPointflyScaleY(float f) {
        this.PointflyScaleY = f;
    }

    public float getPointflyHorizon() {
        return this.PointflyHorizon / 100.0f;
    }

    public void setPointflyHorizon(float f) {
        this.PointflyHorizon = f;
    }

    public float getPointflyLimitTop() {
        return this.PointflyLimitTop / 100.0f;
    }

    public void setPointflyLimitTop(float f) {
        this.PointflyLimitTop = f;
    }

    public float getPointflyLimitBottom() {
        return this.PointflyLimitBottom / 100.0f;
    }

    public void setPointflyLimitBottom(float f) {
        this.PointflyLimitBottom = f;
    }

    public int getPointflyOngoing() {
        return this.PointflyOngoing;
    }

    public void setPointflyOngoing(int i) {
        this.PointflyOngoing = i;
    }
}
