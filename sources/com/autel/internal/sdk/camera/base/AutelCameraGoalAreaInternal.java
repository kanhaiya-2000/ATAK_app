package com.autel.internal.sdk.camera.base;

public class AutelCameraGoalAreaInternal implements CameraGoalArea {
    private double Hight = 0.0d;
    private double StartX = 0.0d;
    private double StartY = 0.0d;
    private double Width = 0.0d;

    public AutelCameraGoalAreaInternal() {
    }

    public AutelCameraGoalAreaInternal(double d, double d2, double d3, double d4) {
        this.StartX = d;
        this.StartY = d2;
        this.Width = d3;
        this.Hight = d4;
    }

    public void setStartX(double d) {
        this.StartX = d;
    }

    public double getStartX() {
        return this.StartX;
    }

    public void setStartY(double d) {
        this.StartY = d;
    }

    public double getStartY() {
        return this.StartY;
    }

    public void setWidth(double d) {
        this.Width = d;
    }

    public double getWidth() {
        return this.Width;
    }

    public void setHight(double d) {
        this.Hight = d;
    }

    public double getHeight() {
        return this.Hight;
    }
}
