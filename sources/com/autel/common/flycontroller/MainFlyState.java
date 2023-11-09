package com.autel.common.flycontroller;

public enum MainFlyState {
    UNKNOWN(0),
    ATTITUDE(1),
    GPS(2),
    IOC(3),
    STAR_POINT(4);
    
    private int value;

    private MainFlyState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MainFlyState find(int i) {
        MainFlyState mainFlyState = ATTITUDE;
        if (mainFlyState.value == i) {
            return mainFlyState;
        }
        MainFlyState mainFlyState2 = GPS;
        if (mainFlyState2.value == i) {
            return mainFlyState2;
        }
        MainFlyState mainFlyState3 = IOC;
        if (mainFlyState3.value == i) {
            return mainFlyState3;
        }
        MainFlyState mainFlyState4 = STAR_POINT;
        if (mainFlyState4.value == i) {
            return mainFlyState4;
        }
        return UNKNOWN;
    }
}
