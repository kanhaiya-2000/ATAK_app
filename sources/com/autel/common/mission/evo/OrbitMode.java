package com.autel.common.mission.evo;

public enum OrbitMode {
    FixPoint(0),
    PhoneLocation(1),
    UNKNOWN(-1);
    
    private int value;

    private OrbitMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitMode find(int i) {
        OrbitMode orbitMode = FixPoint;
        if (orbitMode.getValue() == i) {
            return orbitMode;
        }
        OrbitMode orbitMode2 = PhoneLocation;
        if (orbitMode2.getValue() == i) {
            return orbitMode2;
        }
        return null;
    }
}
