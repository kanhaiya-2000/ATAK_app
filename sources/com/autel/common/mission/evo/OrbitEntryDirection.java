package com.autel.common.mission.evo;

public enum OrbitEntryDirection {
    NEAREST(0),
    NORTH(1),
    SOUTH(2),
    EAST(3),
    WEST(4),
    UNKNOWN(-1);
    
    int value;

    private OrbitEntryDirection(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitEntryDirection find(int i) {
        OrbitEntryDirection orbitEntryDirection = NEAREST;
        if (orbitEntryDirection.value == i) {
            return orbitEntryDirection;
        }
        OrbitEntryDirection orbitEntryDirection2 = NORTH;
        if (orbitEntryDirection2.value == i) {
            return orbitEntryDirection2;
        }
        OrbitEntryDirection orbitEntryDirection3 = SOUTH;
        if (orbitEntryDirection3.value == i) {
            return orbitEntryDirection3;
        }
        OrbitEntryDirection orbitEntryDirection4 = EAST;
        if (orbitEntryDirection4.value == i) {
            return orbitEntryDirection4;
        }
        OrbitEntryDirection orbitEntryDirection5 = WEST;
        if (orbitEntryDirection5.value == i) {
            return orbitEntryDirection5;
        }
        return UNKNOWN;
    }
}
