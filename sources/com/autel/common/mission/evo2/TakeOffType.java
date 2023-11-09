package com.autel.common.mission.evo2;

public enum TakeOffType {
    HUNG_UP(0),
    SKATE(1);
    
    private final int value;

    private TakeOffType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
