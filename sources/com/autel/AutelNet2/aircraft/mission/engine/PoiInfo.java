package com.autel.AutelNet2.aircraft.mission.engine;

public class PoiInfo {
    private int Altitude;
    private int Latitude;
    private int Longitude;

    /* renamed from: id */
    private int f8429id;

    public int getId() {
        return this.f8429id;
    }

    public void setId(int i) {
        this.f8429id = i;
    }

    public int getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(int i) {
        this.Latitude = i;
    }

    public int getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(int i) {
        this.Longitude = i;
    }

    public int getAltitude() {
        return this.Altitude;
    }

    public void setAltitude(int i) {
        this.Altitude = i;
    }
}
