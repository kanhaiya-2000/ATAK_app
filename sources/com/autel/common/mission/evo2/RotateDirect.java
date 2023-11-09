package com.autel.common.mission.evo2;

public enum RotateDirect {
    CLOCKWISE(0),
    COUNTERCLOCKWISE(1);
    
    private final int value;

    private RotateDirect(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RotateDirect find(int i) {
        RotateDirect rotateDirect = CLOCKWISE;
        if (rotateDirect.value == i) {
            return rotateDirect;
        }
        RotateDirect rotateDirect2 = COUNTERCLOCKWISE;
        return rotateDirect2.value == i ? rotateDirect2 : rotateDirect;
    }
}
