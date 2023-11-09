package com.autel.camera.protocol.protocol20.entity;

public class CameraDeviceStatus {
    private int SdcardStatus;
    private int SensorStatus;

    public int getSdcardStatus() {
        return this.SdcardStatus;
    }

    public void setSdcardStatus(int i) {
        this.SdcardStatus = i;
    }

    public int getSensorStatus() {
        return this.SensorStatus;
    }

    public void setSensorStatus(int i) {
        this.SensorStatus = i;
    }
}
