package com.autel.internal.sdk.mission;

public enum FollowMode {
    FOLLOW(0),
    UNKNOWN(-1);
    
    private int value;

    private FollowMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
