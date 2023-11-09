package com.autel.common.camera.visual;

public enum VisualAction {
    EXIT(0),
    ENTER(1),
    STOP(2),
    START(3),
    UNKNOWN(-1);
    
    private int value;

    private VisualAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VisualAction find(int i) {
        VisualAction visualAction = EXIT;
        if (visualAction.getValue() == i) {
            return visualAction;
        }
        VisualAction visualAction2 = ENTER;
        if (visualAction2.getValue() == i) {
            return visualAction2;
        }
        VisualAction visualAction3 = START;
        if (visualAction3.getValue() == i) {
            return visualAction3;
        }
        VisualAction visualAction4 = STOP;
        if (visualAction4.getValue() == i) {
            return visualAction4;
        }
        return UNKNOWN;
    }
}
