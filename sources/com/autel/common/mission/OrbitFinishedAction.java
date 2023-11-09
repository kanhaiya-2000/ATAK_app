package com.autel.common.mission;

public enum OrbitFinishedAction {
    HOVER(0),
    RETURN_HOME(1),
    UNKNOWN(-1);
    
    private int value;

    private OrbitFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static OrbitFinishedAction find(int i) {
        OrbitFinishedAction orbitFinishedAction = HOVER;
        if (orbitFinishedAction.getValue() == i) {
            return orbitFinishedAction;
        }
        OrbitFinishedAction orbitFinishedAction2 = RETURN_HOME;
        if (orbitFinishedAction2.getValue() == i) {
            return orbitFinishedAction2;
        }
        return UNKNOWN;
    }
}
