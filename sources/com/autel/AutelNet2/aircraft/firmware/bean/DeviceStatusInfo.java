package com.autel.AutelNet2.aircraft.firmware.bean;

import java.util.List;

public class DeviceStatusInfo {
    private List<DeviceStatusCodeBean> DeviceStatusCode;
    private int TotalComponet;

    public int getTotalComponet() {
        return this.TotalComponet;
    }

    public void setTotalComponet(int i) {
        this.TotalComponet = i;
    }

    public List<DeviceStatusCodeBean> getDeviceStatusCode() {
        return this.DeviceStatusCode;
    }

    public void setDeviceStatusCode(List<DeviceStatusCodeBean> list) {
        this.DeviceStatusCode = list;
    }

    public static class DeviceStatusCodeBean {
        private int CPUUsage;
        private String DeviceName;
        private int MemUsage;
        private String Software;
        private int WorkStatus1;
        private int WorkStatus2;

        public String getDeviceName() {
            return this.DeviceName;
        }

        public void setDeviceName(String str) {
            this.DeviceName = str;
        }

        public String getSoftware() {
            return this.Software;
        }

        public void setSoftware(String str) {
            this.Software = str;
        }

        public int getWorkStatus1() {
            return this.WorkStatus1;
        }

        public void setWorkStatus1(int i) {
            this.WorkStatus1 = i;
        }

        public int getWorkStatus2() {
            return this.WorkStatus2;
        }

        public void setWorkStatus2(int i) {
            this.WorkStatus2 = i;
        }

        public int getCPUUsage() {
            return this.CPUUsage;
        }

        public void setCPUUsage(int i) {
            this.CPUUsage = i;
        }

        public int getMemUsage() {
            return this.MemUsage;
        }

        public void setMemUsage(int i) {
            this.MemUsage = i;
        }
    }
}
