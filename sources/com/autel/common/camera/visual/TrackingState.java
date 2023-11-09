package com.autel.common.camera.visual;

public enum TrackingState {
    FAILED(0),
    SUCCESS(1),
    STOP(3),
    LOW_CREDIBILITY(5),
    NO_SIGNIFICANT_GOAL(8),
    UNKNOWN(-1);
    
    private int value;

    private TrackingState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TrackingState find(int i) {
        TrackingState trackingState = SUCCESS;
        if (trackingState.getValue() == i) {
            return trackingState;
        }
        TrackingState trackingState2 = FAILED;
        if (trackingState2.getValue() == i) {
            return trackingState2;
        }
        TrackingState trackingState3 = STOP;
        if (trackingState3.getValue() == i) {
            return trackingState3;
        }
        TrackingState trackingState4 = LOW_CREDIBILITY;
        if (trackingState4.getValue() == i) {
            return trackingState4;
        }
        TrackingState trackingState5 = NO_SIGNIFICANT_GOAL;
        if (trackingState5.getValue() == i) {
            return trackingState5;
        }
        return UNKNOWN;
    }
}
