package com.autel.AutelNet2.aircraft.mission.engine;

public class HotPointInfoInternal {
    private float Altitude;
    private int Centered;
    private float Latitude;
    private float Longitude;
    private int OrbitCount;
    private int Radius;
    private int SpeedSet;
    private int Status;
    private int TimeBootMs;
    private int Type;

    public int getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(int i) {
        this.TimeBootMs = i;
    }

    public double getLatitude() {
        return ((double) this.Latitude) / 1.0E7d;
    }

    public void setLatitude(float f) {
        this.Latitude = f;
    }

    public double getLongitude() {
        return ((double) this.Longitude) / 1.0E7d;
    }

    public void setLongitude(float f) {
        this.Longitude = f;
    }

    public float getAltitude() {
        return this.Altitude / 1000.0f;
    }

    public void setAltitude(float f) {
        this.Altitude = f;
    }

    public float getSpeedSet() {
        return ((float) this.SpeedSet) / 1000.0f;
    }

    public void setSpeedSet(int i) {
        this.SpeedSet = i;
    }

    public float getRadius() {
        return ((float) this.Radius) / 10.0f;
    }

    public void setRadius(int i) {
        this.Radius = i;
    }

    public int getCentered() {
        return this.Centered;
    }

    public int getOrbitCount() {
        return this.OrbitCount;
    }

    public void setOrbitCount(int i) {
        this.OrbitCount = i;
    }

    public void setCentered(int i) {
        this.Centered = i;
    }

    public int getType() {
        return this.Type;
    }

    public void setType(int i) {
        this.Type = i;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public String toString() {
        return "TimeBootMs:" + this.TimeBootMs + " SpeedSet:" + this.SpeedSet + " Latitude:" + this.Latitude + " Longitude:" + this.Longitude + " Altitude " + this.Altitude + " Radius:" + this.Radius + " Status:" + this.Status + " Centered:" + this.Centered + " Type:" + this.Type + " OrbitCount:" + this.OrbitCount;
    }
}
