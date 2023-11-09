package com.autel.AutelNet2.aircraft.mission.enmus;

public enum WayPointAction {
    START(20),
    END(21);
    
    private int value;

    private WayPointAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
