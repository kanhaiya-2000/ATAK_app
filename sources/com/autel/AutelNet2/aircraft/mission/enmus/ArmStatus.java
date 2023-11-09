package com.autel.AutelNet2.aircraft.mission.enmus;

public enum ArmStatus {
    ARM(1),
    DISARM(0);
    
    private int value;

    private ArmStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
