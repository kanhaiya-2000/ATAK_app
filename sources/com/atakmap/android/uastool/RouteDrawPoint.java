package com.atakmap.android.uastool;

public class RouteDrawPoint {
    private final String desc;
    private final String hae;
    private final String latitude;
    private final String longitude;
    private final String name;
    private final String orbitRad;

    public RouteDrawPoint(String str, String str2, String str3, String str4, String str5, String str6) {
        this.name = str;
        this.desc = str2;
        this.latitude = str3;
        this.longitude = str4;
        this.hae = str5;
        this.orbitRad = str6;
    }

    public RouteDrawPoint(String[] strArr) {
        this.name = strArr[0];
        this.desc = strArr[1];
        this.latitude = strArr[2];
        this.longitude = strArr[3];
        this.hae = strArr[4];
        this.orbitRad = strArr[5];
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getLat() {
        return this.latitude;
    }

    public String getLon() {
        return this.longitude;
    }

    public String getHae() {
        return this.hae;
    }

    public String getOrbitRad() {
        return this.orbitRad;
    }
}
