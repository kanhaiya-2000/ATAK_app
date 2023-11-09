package com.autel.common.mission.evo;

public enum GroundFollowMode {
    CURRENT_ALTITUDE(0),
    ONLY_INCREASE_ALTITUDE(1),
    CHANGEABLE_ALTITUDE(2),
    UNKNOWN(-1);
    
    int value;

    private GroundFollowMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static GroundFollowMode find(int i) {
        GroundFollowMode groundFollowMode = CURRENT_ALTITUDE;
        if (groundFollowMode.value == i) {
            return groundFollowMode;
        }
        GroundFollowMode groundFollowMode2 = ONLY_INCREASE_ALTITUDE;
        if (groundFollowMode2.value == i) {
            return groundFollowMode2;
        }
        GroundFollowMode groundFollowMode3 = CHANGEABLE_ALTITUDE;
        if (groundFollowMode3.value == i) {
            return groundFollowMode3;
        }
        return UNKNOWN;
    }
}
