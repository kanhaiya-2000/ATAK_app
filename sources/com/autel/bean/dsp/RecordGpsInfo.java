package com.autel.bean.dsp;

import java.util.List;

public class RecordGpsInfo {
    private List<GpsInfoBean> GpsInfo;

    public List<GpsInfoBean> getGpsInfo() {
        return this.GpsInfo;
    }

    public void setGpsInfo(List<GpsInfoBean> list) {
        this.GpsInfo = list;
    }

    public static class GpsInfoBean {
        private int Altitude;
        private int Distance;
        private double Latitude;
        private double Longitude;
        private int RsocRemainPercent;
        private long TimeBootMs;
        private int Yaw;

        /* renamed from: vx */
        private float f8452vx;

        /* renamed from: vy */
        private float f8453vy;

        /* renamed from: vz */
        private float f8454vz;

        public long getTimeBootMs() {
            return this.TimeBootMs;
        }

        public void setTimeBootMs(long j) {
            this.TimeBootMs = j;
        }

        public double getLatitude() {
            return this.Latitude;
        }

        public void setLatitude(double d) {
            this.Latitude = d;
        }

        public double getLongitude() {
            return this.Longitude;
        }

        public void setLongitude(double d) {
            this.Longitude = d;
        }

        public int getAltitude() {
            return this.Altitude;
        }

        public void setAltitude(int i) {
            this.Altitude = i;
        }

        public int getDistance() {
            return this.Distance;
        }

        public void setDistance(int i) {
            this.Distance = i;
        }

        public int getRsocRemainPercent() {
            return this.RsocRemainPercent;
        }

        public void setRsocRemainPercent(int i) {
            this.RsocRemainPercent = i;
        }

        public float getVx() {
            return this.f8452vx;
        }

        public void setVx(float f) {
            this.f8452vx = f;
        }

        public float getVy() {
            return this.f8453vy;
        }

        public void setVy(float f) {
            this.f8453vy = f;
        }

        public float getVz() {
            return this.f8454vz;
        }

        public void setVz(float f) {
            this.f8454vz = f;
        }

        public int getYaw() {
            return this.Yaw;
        }

        public void setYaw(int i) {
            this.Yaw = i;
        }
    }
}
