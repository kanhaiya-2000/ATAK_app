package com.autel.common.mission.evo;

public enum FollowAttitudeMode {
    FREE_MODE(0),
    AIRCRAFT_FIRST(1),
    CAMERA_FIRST(2),
    UNKNOWN(-1);
    
    int value;

    private FollowAttitudeMode(int i) {
        this.value = i;
    }

    public static FollowAttitudeMode find(int i) {
        FollowAttitudeMode followAttitudeMode = FREE_MODE;
        if (followAttitudeMode.value == i) {
            return followAttitudeMode;
        }
        FollowAttitudeMode followAttitudeMode2 = AIRCRAFT_FIRST;
        if (followAttitudeMode2.value == i) {
            return followAttitudeMode2;
        }
        FollowAttitudeMode followAttitudeMode3 = CAMERA_FIRST;
        if (followAttitudeMode3.value == i) {
            return followAttitudeMode3;
        }
        return UNKNOWN;
    }

    public int getValue() {
        return this.value;
    }
}
