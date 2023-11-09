package com.autel.common.mission.evo;

public enum ObstacleAvoidanceMode {
    INVALID(0),
    HOVER(1),
    HORIZONTAL(2),
    CLIMB_FIRST(3),
    UNKNOWN(-1);
    
    private int value;

    private ObstacleAvoidanceMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static ObstacleAvoidanceMode find(int i) {
        ObstacleAvoidanceMode obstacleAvoidanceMode = INVALID;
        if (obstacleAvoidanceMode.value == i) {
            return obstacleAvoidanceMode;
        }
        ObstacleAvoidanceMode obstacleAvoidanceMode2 = HOVER;
        if (obstacleAvoidanceMode2.value == i) {
            return obstacleAvoidanceMode2;
        }
        ObstacleAvoidanceMode obstacleAvoidanceMode3 = HORIZONTAL;
        if (obstacleAvoidanceMode3.value == i) {
            return obstacleAvoidanceMode3;
        }
        return UNKNOWN;
    }
}
