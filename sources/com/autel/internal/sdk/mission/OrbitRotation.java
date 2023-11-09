package com.autel.internal.sdk.mission;

public enum OrbitRotation {
    ANTICLOCKWISE(0),
    CLOCKWISE(1),
    UNKNOWN(-1);
    
    private int value;

    private OrbitRotation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitRotation find(int i) {
        OrbitRotation orbitRotation = ANTICLOCKWISE;
        if (orbitRotation.getValue() == i) {
            return orbitRotation;
        }
        OrbitRotation orbitRotation2 = CLOCKWISE;
        if (orbitRotation2.getValue() == i) {
            return orbitRotation2;
        }
        return null;
    }
}
