package com.autel.AutelNet2.aircraft.mission.enmus;

public enum TrackingAction {
    FOLLOW(26),
    FOLLOW_TARGET(27);
    
    private int value;

    private TrackingAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
