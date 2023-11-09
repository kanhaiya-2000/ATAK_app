package com.autel.common.flycontroller.evo;

public interface EvoGpsInfo {
    double getAltitude();

    int getFixType();

    double getLatitude();

    double getLongitude();

    int getSatellitesVisible();
}
