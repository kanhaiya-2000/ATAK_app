package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.mission.AutelCoordinate3D;

public class AutelGPSInfoInternal implements GPSInfo {
    private AutelCoordinate3D coord;
    private int fixType = -1;
    private int gpsCount = 0;
    private double gps_eph = -1.0d;

    /* access modifiers changed from: protected */
    public void setGpsCount(int i) {
        this.gpsCount = i;
    }

    /* access modifiers changed from: protected */
    public void setFixType(int i) {
        this.fixType = i;
    }

    /* access modifiers changed from: protected */
    public void setEph(int i) {
        this.gps_eph = ((double) i) / 100.0d;
    }

    /* access modifiers changed from: protected */
    public void setCoord(AutelCoordinate3D autelCoordinate3D) {
        this.coord = autelCoordinate3D;
    }

    public int getGpsCount() {
        return this.gpsCount;
    }

    private int getFixType() {
        return this.fixType;
    }

    public AutelCoordinate3D getCoordinate() {
        return this.coord;
    }

    public int getSatelliteStrength() {
        if (getFixType() <= 2) {
            return 0;
        }
        double d = this.gps_eph;
        if (d >= 5.0d) {
            return 0;
        }
        if (d >= 3.925d) {
            return 1;
        }
        if (d >= 2.85d) {
            return 2;
        }
        if (d >= 1.775d) {
            return 3;
        }
        return d >= 0.7d ? 4 : 5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gpsCount : ");
        sb.append(this.gpsCount);
        sb.append(", satelliteStrength : ");
        sb.append(getSatelliteStrength());
        sb.append(",　AutelCoordinate3D : ");
        AutelCoordinate3D autelCoordinate3D = this.coord;
        sb.append(autelCoordinate3D == null ? "null" : autelCoordinate3D.toString());
        return sb.toString();
    }
}
