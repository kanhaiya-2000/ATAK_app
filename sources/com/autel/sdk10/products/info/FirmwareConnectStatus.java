package com.autel.sdk10.products.info;

public final class FirmwareConnectStatus {
    private static FirmwareConnectStatus instance;
    private boolean isAircraftHeartBeatNormal;
    private boolean isCameraConnected;
    private boolean isRCConnected;

    public static FirmwareConnectStatus getInstance() {
        if (instance == null) {
            instance = new FirmwareConnectStatus();
        }
        return instance;
    }

    private FirmwareConnectStatus() {
    }

    public void setAircraftHeartBeatNormal(boolean z) {
        this.isAircraftHeartBeatNormal = z;
    }

    public void setRCConnected(boolean z) {
        this.isRCConnected = z;
    }

    public void setCameraConnected(boolean z) {
        this.isCameraConnected = z;
    }

    public boolean isAircraftHeartBeatNormal() {
        return this.isAircraftHeartBeatNormal;
    }

    public boolean isRCConnected() {
        return this.isRCConnected;
    }

    public boolean isCameraConnected() {
        return this.isCameraConnected;
    }
}
