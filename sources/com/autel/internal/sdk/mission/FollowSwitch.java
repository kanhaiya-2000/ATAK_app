package com.autel.internal.sdk.mission;

public enum FollowSwitch {
    DISABLE(0),
    ENABLE(1),
    UNKNOWN(-1);
    
    private int value;

    private FollowSwitch(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FollowSwitch find(int i) {
        FollowSwitch followSwitch = DISABLE;
        if (followSwitch.getValue() == i) {
            return followSwitch;
        }
        FollowSwitch followSwitch2 = ENABLE;
        if (followSwitch2.getValue() == i) {
            return followSwitch2;
        }
        return null;
    }
}
