package com.autel.common.mission.evo;

public enum OrbitRotateDirection {
    Clockwise(0),
    Counterclockwise(1),
    UNKNOWN(-1);
    
    int value;

    private OrbitRotateDirection(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitRotateDirection find(int i) {
        OrbitRotateDirection orbitRotateDirection = Clockwise;
        if (orbitRotateDirection.value == i) {
            return orbitRotateDirection;
        }
        OrbitRotateDirection orbitRotateDirection2 = Counterclockwise;
        if (orbitRotateDirection2.value == i) {
            return orbitRotateDirection2;
        }
        return UNKNOWN;
    }
}
