package com.autel.AutelNet2.aircraft.mission.enmus;

public enum OrbitAction {
    START(24),
    END(25);
    
    private int value;

    private OrbitAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
