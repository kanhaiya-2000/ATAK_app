package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity;

public enum ObstacleAvoidanceCmd {
    OBSTACLE_AVOIDANCE(1),
    LIMIT_SPEED(2),
    ALLOW_LEFT(3),
    ACTIVE_TRACKING(4),
    RADAR(5),
    ACTIVE_TRACKING_ALLOW_BACK(6),
    LANDING_PROTECT(7),
    BACK_PATH_DETECTION(8),
    VISUAL_LOCATION(9),
    LANDING_ACCURATE_FUNCTION(10),
    FLY_COORDINATE(11),
    FLY_SPEED(12),
    FLY_TASK(13),
    MAP_FOLLOW(14),
    FOLLOW_MODE(15),
    SPIDER_MODE(16),
    VIDEO_MODE(17),
    REGULAR_MODE(18),
    GESTURE(19),
    CALIBRATION(20);
    
    private int value;

    private ObstacleAvoidanceCmd(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
