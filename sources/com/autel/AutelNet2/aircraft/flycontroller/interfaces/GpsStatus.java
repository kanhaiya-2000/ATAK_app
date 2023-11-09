package com.autel.AutelNet2.aircraft.flycontroller.interfaces;

public interface GpsStatus {
    int[] getSatelliteAzimuth();

    int[] getSatelliteElevation();

    int[] getSatellitePrn();

    int[] getSatelliteSnr();

    int[] getSatelliteUsed();

    int getSatellitesVisible();
}
