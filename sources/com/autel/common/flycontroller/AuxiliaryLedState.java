package com.autel.common.flycontroller;

public enum AuxiliaryLedState {
    OFF(0),
    OPEN(1),
    AUTO(2),
    FLASHING_MODE_1(3),
    FLASHING_MODE_2(4),
    UNKNOWN(-1);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private AuxiliaryLedState(int i) {
        this.value = i;
    }

    public static AuxiliaryLedState find(int i) {
        AuxiliaryLedState auxiliaryLedState = OFF;
        if (auxiliaryLedState.value == i) {
            return auxiliaryLedState;
        }
        AuxiliaryLedState auxiliaryLedState2 = OPEN;
        if (auxiliaryLedState2.value == i) {
            return auxiliaryLedState2;
        }
        AuxiliaryLedState auxiliaryLedState3 = AUTO;
        if (auxiliaryLedState3.value == i) {
            return auxiliaryLedState3;
        }
        AuxiliaryLedState auxiliaryLedState4 = FLASHING_MODE_1;
        if (auxiliaryLedState4.value == i) {
            return auxiliaryLedState4;
        }
        AuxiliaryLedState auxiliaryLedState5 = FLASHING_MODE_2;
        if (auxiliaryLedState5.value == i) {
            return auxiliaryLedState5;
        }
        return UNKNOWN;
    }
}
