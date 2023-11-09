package com.autel.common.mission.evo;

public enum OrbitHeadingDirection {
    FORWARD(1),
    FACE_TO_POI(2),
    OUTWARD(3),
    BACKWARD(4),
    CUSTOM(5),
    UNKNOWN(0);
    
    int value;

    private OrbitHeadingDirection(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitHeadingDirection find(int i) {
        OrbitHeadingDirection orbitHeadingDirection = FORWARD;
        if (orbitHeadingDirection.value == i) {
            return orbitHeadingDirection;
        }
        OrbitHeadingDirection orbitHeadingDirection2 = FACE_TO_POI;
        if (orbitHeadingDirection2.value == i) {
            return orbitHeadingDirection2;
        }
        OrbitHeadingDirection orbitHeadingDirection3 = BACKWARD;
        if (orbitHeadingDirection3.value == i) {
            return orbitHeadingDirection3;
        }
        OrbitHeadingDirection orbitHeadingDirection4 = OUTWARD;
        if (orbitHeadingDirection4.value == i) {
            return orbitHeadingDirection4;
        }
        OrbitHeadingDirection orbitHeadingDirection5 = CUSTOM;
        if (orbitHeadingDirection5.value == i) {
            return orbitHeadingDirection5;
        }
        return UNKNOWN;
    }
}
