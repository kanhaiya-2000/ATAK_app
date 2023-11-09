package com.autel.common.flycontroller;

public enum VisualTrackState {
    IDLE(0),
    DETECTION(1),
    TRACKING(2),
    UNKNOWN(-1);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private VisualTrackState(int i) {
        this.value = i;
    }

    public static VisualTrackState find(int i) {
        VisualTrackState visualTrackState = DETECTION;
        if (visualTrackState.value == i) {
            return visualTrackState;
        }
        VisualTrackState visualTrackState2 = IDLE;
        if (visualTrackState2.value == i) {
            return visualTrackState2;
        }
        VisualTrackState visualTrackState3 = TRACKING;
        if (visualTrackState3.value == i) {
            return visualTrackState3;
        }
        return UNKNOWN;
    }
}
