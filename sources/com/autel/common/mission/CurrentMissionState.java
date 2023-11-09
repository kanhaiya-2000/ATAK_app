package com.autel.common.mission;

public enum CurrentMissionState {
    NOTHING(-1, "No mission state"),
    WAY_POINT(0, "Waypoint mode"),
    TRACKING(7, "Tracking mode"),
    ORBIT(3, "Orbit mode"),
    GPS_PRECISION_LOW(4, "Low GPS precision (Orbit or GPS Follow mode)"),
    GPS_TOO_FAR_100(5, "The distance between the aircraft and cell phone is over 100 meters (Orbit or GPS Follow mode)"),
    GPS_TOO_FAR_200(6, "The distance between the aircraft and cell phone is over 200 meters (Orbit or GPS Follow mode)"),
    UNKNOWN(-2, "");
    
    private String description;
    private int value;

    private CurrentMissionState(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static CurrentMissionState find(int i) {
        if (i == -1) {
            return NOTHING;
        }
        if (i == 0) {
            return WAY_POINT;
        }
        if (i == 1 || i == 2) {
            return ORBIT;
        }
        if (i == 4) {
            return GPS_PRECISION_LOW;
        }
        if (i == 5) {
            return GPS_TOO_FAR_100;
        }
        if (i != 6) {
            return NOTHING;
        }
        return GPS_TOO_FAR_200;
    }
}
