package com.autel.common.dsp.evo;

public enum AircraftRole {
    COMMON(0),
    MASTER(1),
    SLAVER(2),
    UNKNOWN(-1);
    
    private int value;

    private AircraftRole(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AircraftRole find(int i) {
        AircraftRole aircraftRole = COMMON;
        if (aircraftRole.value == i) {
            return aircraftRole;
        }
        AircraftRole aircraftRole2 = MASTER;
        if (aircraftRole2.value == i) {
            return aircraftRole2;
        }
        AircraftRole aircraftRole3 = SLAVER;
        if (aircraftRole3.value == i) {
            return aircraftRole3;
        }
        return UNKNOWN;
    }
}
