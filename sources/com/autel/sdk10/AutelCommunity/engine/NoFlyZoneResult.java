package com.autel.sdk10.AutelCommunity.engine;

import java.util.List;

public class NoFlyZoneResult {
    private String action;
    private String msg;
    private List<NoFlyZoneModel> noflyzones;
    private long synctime;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public long getSynctime() {
        return this.synctime;
    }

    public void setSynctime(long j) {
        this.synctime = j;
    }

    public List<NoFlyZoneModel> getNoflyzones() {
        return this.noflyzones;
    }

    public void setNoflyzones(List<NoFlyZoneModel> list) {
        this.noflyzones = list;
    }

    public static class NoFlyZonePoint {
        private int height_limit_radius;
        private double latitude;
        private String latitude_type;
        private double longitude;
        private String longitude_type;
        private int nofly_radius;
        private int warning_radius;

        public double getLongitude() {
            return this.longitude;
        }

        public void setLongitude(double d) {
            this.longitude = d;
        }

        public String getLongitude_type() {
            return this.longitude_type;
        }

        public void setLongitude_type(String str) {
            this.longitude_type = str;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public void setLatitude(double d) {
            this.latitude = d;
        }

        public String getLatitude_type() {
            return this.latitude_type;
        }

        public void setLatitude_type(String str) {
            this.latitude_type = str;
        }

        public int getNofly_radius() {
            return this.nofly_radius;
        }

        public void setNofly_radius(int i) {
            this.nofly_radius = i;
        }

        public int getHeight_limit_radius() {
            return this.height_limit_radius;
        }

        public void setHeight_limit_radius(int i) {
            this.height_limit_radius = i;
        }

        public int getWarning_radius() {
            return this.warning_radius;
        }

        public void setWarning_radius(int i) {
            this.warning_radius = i;
        }
    }

    public static class NoFlyZone {
        private int dot_type;
        private List<NoFlyZonePoint> locations;

        public int getDot_type() {
            return this.dot_type;
        }

        public void setDot_type(int i) {
            this.dot_type = i;
        }

        public List<NoFlyZonePoint> getLocations() {
            return this.locations;
        }

        public void setLocations(List<NoFlyZonePoint> list) {
            this.locations = list;
        }
    }

    public static class NoFlyZoneModel {
        private String city;
        private String continent;
        private String country;
        private List<NoFlyZone> nfz_dots;
        private String nfz_name;
        private String nfz_type;

        public String getContinent() {
            return this.continent;
        }

        public void setContinent(String str) {
            this.continent = str;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public String getNfz_name() {
            return this.nfz_name;
        }

        public void setNfz_name(String str) {
            this.nfz_name = str;
        }

        public String getNfz_type() {
            return this.nfz_type;
        }

        public void setNfz_type(String str) {
            this.nfz_type = str;
        }

        public List<NoFlyZone> getNfz_dots() {
            return this.nfz_dots;
        }

        public void setNfz_dots(List<NoFlyZone> list) {
            this.nfz_dots = list;
        }
    }
}
