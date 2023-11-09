package com.autel.common.flycontroller;

public enum DroneLocationType {
    GNSS(0),
    RTK(1),
    UNKNOWN(-1);
    
    private int value;

    private DroneLocationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static DroneLocationType find(int i) {
        DroneLocationType droneLocationType = GNSS;
        if (droneLocationType.value == i) {
            return droneLocationType;
        }
        DroneLocationType droneLocationType2 = RTK;
        if (droneLocationType2.value == i) {
            return droneLocationType2;
        }
        return UNKNOWN;
    }
}
