package com.autel.common.remotecontroller;

public enum RFPower {
    FCC(0),
    CE(1),
    UNKNOWN(-1);
    
    private int value;

    private RFPower(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RFPower find(int i) {
        RFPower rFPower = FCC;
        if (rFPower.getValue() == i) {
            return rFPower;
        }
        RFPower rFPower2 = CE;
        if (rFPower2.getValue() == i) {
            return rFPower2;
        }
        return UNKNOWN;
    }
}
