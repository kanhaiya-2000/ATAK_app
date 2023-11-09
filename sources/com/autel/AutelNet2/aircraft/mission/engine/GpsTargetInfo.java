package com.autel.AutelNet2.aircraft.mission.engine;

public class GpsTargetInfo {
    private int Alt;
    private int Lat;
    private int Lon;
    private int Precision;

    public int getLat() {
        return this.Lat;
    }

    public void setLat(int i) {
        this.Lat = i;
    }

    public int getLon() {
        return this.Lon;
    }

    public void setLon(int i) {
        this.Lon = i;
    }

    public int getAlt() {
        return this.Alt;
    }

    public void setAlt(int i) {
        this.Alt = i;
    }

    public int getPrecision() {
        return this.Precision;
    }

    public void setPrecision(int i) {
        this.Precision = i;
    }
}
