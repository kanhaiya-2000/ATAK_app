package com.autel.common.mission;

public enum FollowFinishedAction {
    RETURN_TO_MY_LOCATION(0),
    RETURN_HOME(1),
    UNKNOWN(-1);
    
    private int value;

    private FollowFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FollowFinishedAction find(int i) {
        FollowFinishedAction followFinishedAction = RETURN_TO_MY_LOCATION;
        if (followFinishedAction.getValue() == i) {
            return followFinishedAction;
        }
        FollowFinishedAction followFinishedAction2 = RETURN_HOME;
        if (followFinishedAction2.getValue() == i) {
            return followFinishedAction2;
        }
        return UNKNOWN;
    }
}
