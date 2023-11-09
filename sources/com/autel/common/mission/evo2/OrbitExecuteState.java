package com.autel.common.mission.evo2;

public enum OrbitExecuteState {
    IDLE(0),
    DETECTION(1),
    CALCULATING(2),
    CALCULATING_PAUSE(3),
    RUNNING(4),
    PAUSE(5),
    UNKNOWN(-1);
    
    private int value;

    private OrbitExecuteState(int i) {
        this.value = i;
    }

    public static OrbitExecuteState find(int i) {
        OrbitExecuteState orbitExecuteState = RUNNING;
        if (orbitExecuteState.value == i) {
            return orbitExecuteState;
        }
        OrbitExecuteState orbitExecuteState2 = PAUSE;
        if (orbitExecuteState2.value == i) {
            return orbitExecuteState2;
        }
        OrbitExecuteState orbitExecuteState3 = IDLE;
        if (orbitExecuteState3.value == i) {
            return orbitExecuteState3;
        }
        OrbitExecuteState orbitExecuteState4 = DETECTION;
        if (orbitExecuteState4.value == i) {
            return orbitExecuteState4;
        }
        OrbitExecuteState orbitExecuteState5 = CALCULATING;
        if (orbitExecuteState5.value == i) {
            return orbitExecuteState5;
        }
        OrbitExecuteState orbitExecuteState6 = CALCULATING_PAUSE;
        if (orbitExecuteState6.value == i) {
            return orbitExecuteState6;
        }
        return UNKNOWN;
    }
}
