package com.autel.common.remotecontroller;

public enum RemoteControllerParameterUnit {
    METRIC(0),
    IMPERIAL(1),
    METRIC_KM_H(2),
    UNKNOWN(-1);
    
    private int value;

    private RemoteControllerParameterUnit(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteControllerParameterUnit find(int i) {
        RemoteControllerParameterUnit remoteControllerParameterUnit = METRIC;
        if (remoteControllerParameterUnit.getValue() == i) {
            return remoteControllerParameterUnit;
        }
        RemoteControllerParameterUnit remoteControllerParameterUnit2 = IMPERIAL;
        if (remoteControllerParameterUnit2.getValue() == i) {
            return remoteControllerParameterUnit2;
        }
        RemoteControllerParameterUnit remoteControllerParameterUnit3 = METRIC_KM_H;
        if (remoteControllerParameterUnit3.getValue() == i) {
            return remoteControllerParameterUnit3;
        }
        return UNKNOWN;
    }
}
