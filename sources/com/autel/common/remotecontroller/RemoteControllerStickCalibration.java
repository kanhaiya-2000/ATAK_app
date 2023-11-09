package com.autel.common.remotecontroller;

public enum RemoteControllerStickCalibration {
    NO_CALIBRATE(0),
    CALIBRATING(1),
    START(2),
    COMPLETE(3),
    UNKNOWN(-1);
    
    private int value;

    private RemoteControllerStickCalibration(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteControllerStickCalibration find(int i) {
        RemoteControllerStickCalibration remoteControllerStickCalibration = NO_CALIBRATE;
        if (remoteControllerStickCalibration.getValue() == i) {
            return remoteControllerStickCalibration;
        }
        RemoteControllerStickCalibration remoteControllerStickCalibration2 = CALIBRATING;
        if (remoteControllerStickCalibration2.getValue() == i) {
            return remoteControllerStickCalibration2;
        }
        RemoteControllerStickCalibration remoteControllerStickCalibration3 = START;
        if (remoteControllerStickCalibration3.getValue() == i) {
            return remoteControllerStickCalibration3;
        }
        RemoteControllerStickCalibration remoteControllerStickCalibration4 = COMPLETE;
        if (remoteControllerStickCalibration4.getValue() == i) {
            return remoteControllerStickCalibration4;
        }
        return UNKNOWN;
    }
}
