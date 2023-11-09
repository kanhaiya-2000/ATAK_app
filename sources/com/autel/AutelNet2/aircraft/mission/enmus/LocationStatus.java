package com.autel.AutelNet2.aircraft.mission.enmus;

public enum LocationStatus {
    DRONE(0),
    PHONE(1);
    
    private int value;

    private LocationStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
