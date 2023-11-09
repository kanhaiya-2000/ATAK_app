package com.autel.AutelNet2.aircraft.firmware.bean;

import com.autel.common.dsp.evo.DeviceVersionInfo;
import java.util.List;

public class FirmwareDeviceInfo {
    private int TotalComponet;
    private List<VersionBean> Version;

    public int getTotalComponet() {
        return this.TotalComponet;
    }

    public void setTotalComponet(int i) {
        this.TotalComponet = i;
    }

    public List<VersionBean> getVersion() {
        return this.Version;
    }

    public void setVersion(List<VersionBean> list) {
        this.Version = list;
    }

    public static class VersionBean implements DeviceVersionInfo {
        private String Bootloader;
        private String ComponetName;
        private String Hardware;
        private String SerialNumber;
        private String Software;

        public void setComponetName(String str) {
            this.ComponetName = str;
        }

        public String getComponentName() {
            return this.ComponetName;
        }

        public String getSoftware() {
            return this.Software;
        }

        public void setSoftware(String str) {
            this.Software = str;
        }

        public String getHardware() {
            return this.Hardware;
        }

        public void setHardware(String str) {
            this.Hardware = str;
        }

        public String getBootloader() {
            return this.Bootloader;
        }

        public void setBootloader(String str) {
            this.Bootloader = str;
        }

        public String getSerialNumber() {
            return this.SerialNumber;
        }

        public void setSerialNumber(String str) {
            this.SerialNumber = str;
        }
    }
}
