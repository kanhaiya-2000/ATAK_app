package com.autel.common.flycontroller;

public enum AircraftActivateState {
    INACTIVE(0),
    ACTIVE(1),
    UNKNOWN(-1);
    
    private int value;

    private AircraftActivateState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AircraftActivateState find(int i) {
        AircraftActivateState aircraftActivateState = INACTIVE;
        if (aircraftActivateState.getValue() == i) {
            return aircraftActivateState;
        }
        AircraftActivateState aircraftActivateState2 = ACTIVE;
        if (aircraftActivateState2.getValue() == i) {
            return aircraftActivateState2;
        }
        return UNKNOWN;
    }
}
