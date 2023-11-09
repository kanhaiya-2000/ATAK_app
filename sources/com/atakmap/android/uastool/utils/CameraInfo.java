package com.atakmap.android.uastool.utils;

public class CameraInfo {
    private final double focalLength;
    private final boolean isInLandscapeOrientation;
    private final String name;
    private final double sensorHeight;
    private final double sensorResolution;
    private final double sensorWidth;

    public CameraInfo(String str, double d, double d2, double d3, double d4, boolean z) {
        this.name = str;
        this.sensorWidth = d;
        this.sensorHeight = d2;
        this.sensorResolution = d3;
        this.focalLength = d4;
        this.isInLandscapeOrientation = z;
    }

    public CameraInfo(CameraInfo cameraInfo) {
        this(cameraInfo.name, cameraInfo.sensorWidth, cameraInfo.sensorHeight, cameraInfo.sensorResolution, cameraInfo.focalLength, cameraInfo.isInLandscapeOrientation);
    }

    public String getName() {
        return this.name;
    }

    public double getSensorWidth() {
        return this.sensorWidth;
    }

    public double getSensorHeight() {
        return this.sensorHeight;
    }

    public double getSensorResolution() {
        return this.sensorResolution;
    }

    public double getFocalLength() {
        return this.focalLength;
    }

    public boolean isInLandscapeOrientation() {
        return this.isInLandscapeOrientation;
    }

    public Double getSensorLateralSize() {
        return Double.valueOf(this.isInLandscapeOrientation ? this.sensorWidth : this.sensorHeight);
    }

    public Double getSensorLongitudinalSize() {
        return Double.valueOf(this.isInLandscapeOrientation ? this.sensorHeight : this.sensorWidth);
    }
}
