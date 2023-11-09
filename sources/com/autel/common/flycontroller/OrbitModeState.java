package com.autel.common.flycontroller;

public enum OrbitModeState {
    IDLE(0),
    DETECTION(1),
    TRACKING(2),
    UNKNOWN(-1);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private OrbitModeState(int i) {
        this.value = i;
    }

    public static OrbitModeState find(int i) {
        OrbitModeState orbitModeState = DETECTION;
        if (orbitModeState.value == i) {
            return orbitModeState;
        }
        OrbitModeState orbitModeState2 = IDLE;
        if (orbitModeState2.value == i) {
            return orbitModeState2;
        }
        OrbitModeState orbitModeState3 = TRACKING;
        if (orbitModeState3.value == i) {
            return orbitModeState3;
        }
        return UNKNOWN;
    }
}
