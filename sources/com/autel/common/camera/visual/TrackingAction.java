package com.autel.common.camera.visual;

public enum TrackingAction {
    EXIT(0),
    ENTER(1),
    STOP(2),
    UNKNOWN(-1);
    
    private int value;

    private TrackingAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TrackingAction find(int i) {
        TrackingAction trackingAction = EXIT;
        if (trackingAction.getValue() == i) {
            return trackingAction;
        }
        TrackingAction trackingAction2 = ENTER;
        if (trackingAction2.getValue() == i) {
            return trackingAction2;
        }
        TrackingAction trackingAction3 = STOP;
        if (trackingAction3.getValue() == i) {
            return trackingAction3;
        }
        return UNKNOWN;
    }
}
