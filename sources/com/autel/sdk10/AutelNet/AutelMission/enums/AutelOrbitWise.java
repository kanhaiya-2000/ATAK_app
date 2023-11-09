package com.autel.sdk10.AutelNet.AutelMission.enums;

public enum AutelOrbitWise {
    ANTICLOCKWISE(0),
    CLOCKWISE(1);
    
    private int value;

    private AutelOrbitWise(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AutelOrbitWise find(int i) {
        AutelOrbitWise autelOrbitWise = ANTICLOCKWISE;
        if (autelOrbitWise.getValue() == i) {
            return autelOrbitWise;
        }
        AutelOrbitWise autelOrbitWise2 = CLOCKWISE;
        if (autelOrbitWise2.getValue() == i) {
            return autelOrbitWise2;
        }
        return null;
    }
}
