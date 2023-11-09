package com.atakmap.android.uastool.flightlog;

import java.util.UUID;

public class FlightLogItem {
    private static final String TAG = FlightLog.class.getSimpleName();
    private final String altitude;
    private final String command;
    private final String dateTime;
    private final String heading;
    private final String latitude;
    private final String longitude;
    private final String message;
    private final String speed;
    private final String uid = (UUID.randomUUID().toString() + "_UAS_Flight_Log");

    public FlightLogItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.dateTime = str;
        this.latitude = str2;
        this.longitude = str3;
        this.altitude = str4;
        this.speed = str5;
        this.heading = str6;
        this.message = str7;
        this.command = str8;
    }

    public String getUID() {
        return this.uid;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getAltitude() {
        return this.altitude;
    }

    public String getSpeed() {
        return this.speed;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCommand() {
        return this.command;
    }
}
