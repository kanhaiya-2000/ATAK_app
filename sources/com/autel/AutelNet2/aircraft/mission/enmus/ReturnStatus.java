package com.autel.AutelNet2.aircraft.mission.enmus;

public enum ReturnStatus {
    LAND(0),
    CANCEL(1);
    
    private int value;

    private ReturnStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
