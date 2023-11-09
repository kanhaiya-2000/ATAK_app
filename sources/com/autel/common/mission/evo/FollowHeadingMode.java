package com.autel.common.mission.evo;

public enum FollowHeadingMode {
    FREE_HEADING(0),
    CUSTOM_HEADING(1),
    ORBIT_HEADING(2),
    UNKNOWN(-1);
    
    int value;

    private FollowHeadingMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FollowHeadingMode find(int i) {
        FollowHeadingMode followHeadingMode = FREE_HEADING;
        if (followHeadingMode.value == i) {
            return followHeadingMode;
        }
        FollowHeadingMode followHeadingMode2 = CUSTOM_HEADING;
        if (followHeadingMode2.value == i) {
            return followHeadingMode2;
        }
        FollowHeadingMode followHeadingMode3 = ORBIT_HEADING;
        if (followHeadingMode3.value == i) {
            return followHeadingMode3;
        }
        return UNKNOWN;
    }
}
