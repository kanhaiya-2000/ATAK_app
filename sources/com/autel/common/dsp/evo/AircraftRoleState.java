package com.autel.common.dsp.evo;

public enum AircraftRoleState {
    ONLY_MASTER_ON(1),
    ONLY_SLAVER_ON(2),
    ALL_ON(3),
    ALL_OFF(0);
    
    private int value;

    private AircraftRoleState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AircraftRoleState find(int i) {
        AircraftRoleState aircraftRoleState = ONLY_MASTER_ON;
        if (aircraftRoleState.value == i) {
            return aircraftRoleState;
        }
        AircraftRoleState aircraftRoleState2 = ONLY_SLAVER_ON;
        if (aircraftRoleState2.value == i) {
            return aircraftRoleState2;
        }
        AircraftRoleState aircraftRoleState3 = ALL_ON;
        if (aircraftRoleState3.value == i) {
            return aircraftRoleState3;
        }
        return ALL_OFF;
    }
}
