package com.autel.common.camera.visual;

public enum ViewpointAction {
    EXIT(0),
    ENTER(1),
    PAUSE(2),
    STOP(3),
    UNKNOWN(-1);
    
    private int value;

    private ViewpointAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static ViewpointAction find(int i) {
        ViewpointAction viewpointAction = EXIT;
        if (viewpointAction.getValue() == i) {
            return viewpointAction;
        }
        ViewpointAction viewpointAction2 = ENTER;
        if (viewpointAction2.getValue() == i) {
            return viewpointAction2;
        }
        ViewpointAction viewpointAction3 = PAUSE;
        if (viewpointAction3.getValue() == i) {
            return viewpointAction3;
        }
        ViewpointAction viewpointAction4 = STOP;
        if (viewpointAction4.getValue() == i) {
            return viewpointAction4;
        }
        return UNKNOWN;
    }
}
