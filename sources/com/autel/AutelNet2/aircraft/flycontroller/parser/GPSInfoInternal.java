package com.autel.AutelNet2.aircraft.flycontroller.parser;

import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.evo.EvoGpsInfo;
import com.autel.common.mission.AutelCoordinate3D;

public class GPSInfoInternal implements GPSInfo, EvoGpsInfo {
    private int Altitude;
    private int FixType;
    private int GPSSpeed;
    private int HeightMeanSeaLevel;
    private int HorizontalAccuracy;
    private int Latitude = -1000;
    private int Longitude = -1000;
    private int SatellitesVisible;
    private int SpeedAccurary;
    private float TimeUsec;
    private long Timestamp;
    private int VelNedValid;
    private int VelocityDown;
    private int VelocityEast;
    private int VelocityNorth;
    private int VerticalAccuracy;

    public String toString() {
        return "Timestamp:" + this.Timestamp + " Lat:" + this.Latitude + " Lon:" + this.Longitude + " Alt:" + this.Altitude + " hmsl:" + this.HeightMeanSeaLevel + " VelocityNorth:" + this.VelocityNorth + " VelocityEast:" + this.VelocityEast + " VelocityDown:" + this.VelocityDown + " GPSSpeed:" + this.GPSSpeed + " HorizontalAccuracy:" + this.HorizontalAccuracy + " VerticalAccuracy:" + this.VerticalAccuracy + " SpeedAccurary:" + this.SpeedAccurary + " TimeUsec:" + this.TimeUsec + " VelNedValid:" + this.VelNedValid + ", Fixtype : " + this.FixType + ", SatellitesVisible : " + this.SatellitesVisible + "\n\n";
    }

    public int getGpsCount() {
        return this.SatellitesVisible;
    }

    public AutelCoordinate3D getCoordinate() {
        return new AutelCoordinate3D(getLatitude(), getLongitude());
    }

    public int getSatelliteStrength() {
        return getFixType();
    }

    public long getTimestamp() {
        return this.Timestamp;
    }

    public double getLatitude() {
        return ((double) this.Latitude) / 1.0E7d;
    }

    public double getLongitude() {
        return ((double) this.Longitude) / 1.0E7d;
    }

    public double getAltitude() {
        return (double) (this.Altitude / 1000);
    }

    public void setTimestamp(int i) {
        this.Timestamp = (long) i;
    }

    public void setLatitude(int i) {
        this.Latitude = i;
    }

    public void setLongitude(int i) {
        this.Longitude = i;
    }

    public void setAltitude(int i) {
        this.Altitude = i;
    }

    public void setHeightMeanSeaLevel(int i) {
        this.HeightMeanSeaLevel = i;
    }

    public int getVelocityNorth() {
        return this.VelocityNorth;
    }

    public void setVelocityNorth(int i) {
        this.VelocityNorth = i;
    }

    public int getVelocityEast() {
        return this.VelocityEast;
    }

    public void setVelocityEast(int i) {
        this.VelocityEast = i;
    }

    public int getVelocityDown() {
        return this.VelocityDown;
    }

    public void setVelocityDown(int i) {
        this.VelocityDown = i;
    }

    public int getGPSSpeed() {
        return this.GPSSpeed;
    }

    public void setGPSSpeed(int i) {
        this.GPSSpeed = i;
    }

    public int getHorizontalAccuracy() {
        return this.HorizontalAccuracy;
    }

    public void setHAcc(int i) {
        this.HorizontalAccuracy = i;
    }

    public int getVerticalAccuracy() {
        return this.VerticalAccuracy;
    }

    public void setVAcc(int i) {
        this.VerticalAccuracy = i;
    }

    public int getSpeedAccuracy() {
        return this.SpeedAccurary / 100;
    }

    public void setSAcc(int i) {
        this.SpeedAccurary = i;
    }

    public float getTimeUsec() {
        return this.TimeUsec;
    }

    public void setTimeUsec(float f) {
        this.TimeUsec = f;
    }

    public int getVelNedValid() {
        return this.VelNedValid;
    }

    public int getFixType() {
        return this.FixType;
    }

    public void setVelNedValid(int i) {
        this.VelNedValid = i;
    }

    public void setFixType(int i) {
        this.FixType = i;
    }

    public int getSatellitesVisible() {
        return this.SatellitesVisible;
    }

    public void setSatellitesVisible(int i) {
        this.SatellitesVisible = i;
    }
}
