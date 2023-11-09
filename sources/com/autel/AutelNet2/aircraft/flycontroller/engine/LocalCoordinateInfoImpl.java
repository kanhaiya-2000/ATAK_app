package com.autel.AutelNet2.aircraft.flycontroller.engine;

import com.autel.common.flycontroller.evo.LocalCoordinateInfo;

public class LocalCoordinateInfoImpl implements LocalCoordinateInfo {
    private int Altitude;
    private int Distance;
    private int HomeAltitude;
    private int HomeCoordinate;
    private int HomeEnable;
    private int HomeLatitude;
    private int HomeLongitude;
    private int HomeYaw;
    private int Latitude;
    private int Longitude;
    private int TimeBootMs;
    private float VelocityX;
    private float VelocityXYZ;
    private float VelocityY;
    private float VelocityZ;

    public float getAltitude() {
        return ((float) this.Altitude) / 100.0f;
    }

    public float getXSpeed() {
        return this.VelocityX / 10.0f;
    }

    public float getYSpeed() {
        return this.VelocityY / 10.0f;
    }

    public float getZSpeed() {
        return this.VelocityZ / 10.0f;
    }

    public float getSpeed() {
        return (float) (((double) this.VelocityXYZ) / 100.0d);
    }

    public void setVelocityXYZ(float f) {
        this.VelocityXYZ = f;
    }

    public int getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(int i) {
        this.TimeBootMs = i;
    }

    public double getLatitude() {
        return ((double) this.Latitude) / 1.0E7d;
    }

    public void setLat(int i) {
        this.Latitude = i;
    }

    public double getLongitude() {
        return ((double) this.Longitude) / 1.0E7d;
    }

    public void setLon(int i) {
        this.Longitude = i;
    }

    public void setAltitude(int i) {
        this.Altitude = i;
    }

    public double getHomeLatitude() {
        return ((double) this.HomeLatitude) / 1.0E7d;
    }

    public void setHomeLatitude(int i) {
        this.HomeLatitude = i;
    }

    public double getHomeLongitude() {
        return ((double) this.HomeLongitude) / 1.0E7d;
    }

    public void setHomeLongitude(int i) {
        this.HomeLongitude = i;
    }

    public double getHomeAltitude() {
        return (double) this.HomeAltitude;
    }

    public void setHomeAltitude(int i) {
        this.HomeAltitude = i;
    }

    public void setVelocityX(float f) {
        this.VelocityX = f;
    }

    public void setVelocityY(float f) {
        this.VelocityY = f;
    }

    public void setVelocityZ(float f) {
        this.VelocityZ = f;
    }

    public int getDistance() {
        return this.Distance;
    }

    public void setDistance(int i) {
        this.Distance = i;
    }

    public float getHomeYaw() {
        return (float) (((double) this.HomeYaw) / 1000.0d);
    }

    public void setHomeYaw(int i) {
        this.HomeYaw = i;
    }

    public int getHomeEnable() {
        return this.HomeEnable;
    }

    public void setHomeEnable(int i) {
        this.HomeEnable = i;
    }

    public int getHomeCoordinate() {
        return this.HomeCoordinate;
    }

    public void setHomeCoordinate(int i) {
        this.HomeCoordinate = i;
    }

    public String toString() {
        return "TimeBootMs:" + this.TimeBootMs + " Lat:" + this.Latitude + " Lon:" + this.Longitude + " Alt:" + this.Altitude + " HomeLatitude:" + this.HomeLatitude + " HomeLongitude:" + this.HomeLongitude + " HomeAltitude:" + this.HomeAltitude + " VelocityX:" + this.VelocityX + " VelocityY:" + this.VelocityY + " VelocityZ:" + this.VelocityZ + " Distance:" + this.Distance + " HomeYaw:" + this.HomeYaw + " HomeEnable:" + this.HomeEnable + " HomeCoordinate:" + this.HomeCoordinate + " \n\n";
    }
}
