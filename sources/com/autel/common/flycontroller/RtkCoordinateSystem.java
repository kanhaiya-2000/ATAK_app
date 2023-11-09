package com.autel.common.flycontroller;

public enum RtkCoordinateSystem {
    WGS84(0),
    CGCS2000(1),
    UNKNOWN(-1);
    
    private int value;

    private RtkCoordinateSystem(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RtkCoordinateSystem find(int i) {
        RtkCoordinateSystem rtkCoordinateSystem = CGCS2000;
        if (rtkCoordinateSystem.getValue() == i) {
            return rtkCoordinateSystem;
        }
        RtkCoordinateSystem rtkCoordinateSystem2 = WGS84;
        if (rtkCoordinateSystem2.getValue() == i) {
            return rtkCoordinateSystem2;
        }
        return UNKNOWN;
    }
}
