package com.autel.common.mission;

import java.io.Serializable;

public class AutelCoordinate3D implements Serializable {
    private double altitude;
    private double latitude = -1000.0d;
    private double longitude = -1000.0d;

    public AutelCoordinate3D(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public AutelCoordinate3D(double d) {
        this.latitude = d;
    }

    public AutelCoordinate3D(double d, double d2, double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public String toString() {
        return "latitude = " + this.latitude + "  longitude = " + this.longitude + "  altitude = " + this.altitude;
    }
}
