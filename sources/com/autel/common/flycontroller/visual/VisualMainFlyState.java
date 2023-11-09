package com.autel.common.flycontroller.visual;

public enum VisualMainFlyState {
    FAULT(0),
    NORMAL(1),
    PAUSE(2),
    UNKNOWN(-1);
    
    private final int value;

    private VisualMainFlyState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VisualMainFlyState find(int i) {
        VisualMainFlyState visualMainFlyState = FAULT;
        if (visualMainFlyState.getValue() == i) {
            return visualMainFlyState;
        }
        VisualMainFlyState visualMainFlyState2 = NORMAL;
        if (visualMainFlyState2.getValue() == i) {
            return visualMainFlyState2;
        }
        VisualMainFlyState visualMainFlyState3 = PAUSE;
        if (visualMainFlyState3.getValue() == i) {
            return visualMainFlyState3;
        }
        return UNKNOWN;
    }
}
