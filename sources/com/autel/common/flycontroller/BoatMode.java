package com.autel.common.flycontroller;

public enum BoatMode {
    TAKEOFF(0),
    NORMAL(1),
    UNKNOWN(-1);
    
    private int value;

    private BoatMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BoatMode find(int i) {
        BoatMode boatMode = TAKEOFF;
        if (boatMode.value == i) {
            return boatMode;
        }
        BoatMode boatMode2 = NORMAL;
        if (boatMode2.value == i) {
            return boatMode2;
        }
        return UNKNOWN;
    }
}
