package com.autel.sdk10.AutelNet.AutelMission.enums;

public enum AutelOrbitMode {
    FixPoint(0),
    PhoneLocation(1);
    
    private int value;

    private AutelOrbitMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
