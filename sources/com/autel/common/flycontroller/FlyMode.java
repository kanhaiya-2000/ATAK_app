package com.autel.common.flycontroller;

public enum FlyMode {
    DISARM(0),
    MOTOR_SPINNING(1),
    LANDING(2),
    TAKEOFF(3),
    ATTI_FLIGHT(4),
    GPS_FLIGHT(5),
    IOC(6),
    NORMAL_GO_HOME(7),
    LOW_BATTERY_GO_HOME(8),
    EXCEED_RANGE_GO_HOME(9),
    RC_LOST_GO_HOME(10),
    GO_HOME_HOVER(11),
    WAYPOINT_MODE(12),
    WAYPOINT_MODE_HOLD(13),
    MISSION_GO_HOME(14),
    FOLLOW_FOLLOW(15),
    ORBIT_ORBIT(16),
    FOLLOW_HOLD(17),
    ORBIT_HOLD(18),
    TRIPOD(30),
    PHOTOGRAPHER(31),
    RECTANGLE(32),
    RECTANGLE_HOLD(33),
    POLYGON(34),
    POLYGON_HOLD(35),
    MOTION_DELAY(36),
    MOTION_DELAY_PAUSE(37),
    TRACK_COMMON_MODE(200),
    TRACK_PARALLEL_MODE(201),
    TRACK_LOCKED_MODE(202),
    POINT_FLY_INSIDE(203),
    POINT_FLY_OUTSIDE(204),
    UNKNOWN(-1);
    
    private int value;

    private FlyMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FlyMode find(int i) {
        FlyMode flyMode = DISARM;
        if (flyMode.value == i) {
            return flyMode;
        }
        FlyMode flyMode2 = MOTOR_SPINNING;
        if (flyMode2.value == i) {
            return flyMode2;
        }
        FlyMode flyMode3 = LANDING;
        if (flyMode3.value == i) {
            return flyMode3;
        }
        FlyMode flyMode4 = TAKEOFF;
        if (flyMode4.value == i) {
            return flyMode4;
        }
        FlyMode flyMode5 = ATTI_FLIGHT;
        if (flyMode5.value == i) {
            return flyMode5;
        }
        FlyMode flyMode6 = GPS_FLIGHT;
        if (flyMode6.value == i) {
            return flyMode6;
        }
        FlyMode flyMode7 = IOC;
        if (flyMode7.value == i) {
            return flyMode7;
        }
        FlyMode flyMode8 = NORMAL_GO_HOME;
        if (flyMode8.value == i) {
            return flyMode8;
        }
        FlyMode flyMode9 = LOW_BATTERY_GO_HOME;
        if (flyMode9.value == i) {
            return flyMode9;
        }
        FlyMode flyMode10 = EXCEED_RANGE_GO_HOME;
        if (flyMode10.value == i) {
            return flyMode10;
        }
        FlyMode flyMode11 = RC_LOST_GO_HOME;
        if (flyMode11.value == i) {
            return flyMode11;
        }
        FlyMode flyMode12 = GO_HOME_HOVER;
        if (flyMode12.value == i) {
            return flyMode12;
        }
        FlyMode flyMode13 = WAYPOINT_MODE;
        if (flyMode13.value == i) {
            return flyMode13;
        }
        FlyMode flyMode14 = WAYPOINT_MODE_HOLD;
        if (flyMode14.value == i) {
            return flyMode14;
        }
        FlyMode flyMode15 = MISSION_GO_HOME;
        if (flyMode15.value == i) {
            return flyMode15;
        }
        FlyMode flyMode16 = FOLLOW_FOLLOW;
        if (flyMode16.value == i) {
            return flyMode16;
        }
        FlyMode flyMode17 = ORBIT_HOLD;
        if (flyMode17.value == i) {
            return flyMode17;
        }
        FlyMode flyMode18 = FOLLOW_HOLD;
        if (flyMode18.value == i) {
            return flyMode18;
        }
        FlyMode flyMode19 = ORBIT_ORBIT;
        if (flyMode19.value == i) {
            return flyMode19;
        }
        FlyMode flyMode20 = TRACK_COMMON_MODE;
        if (flyMode20.value == i) {
            return flyMode20;
        }
        FlyMode flyMode21 = TRACK_PARALLEL_MODE;
        if (flyMode21.value == i) {
            return flyMode21;
        }
        FlyMode flyMode22 = TRACK_LOCKED_MODE;
        if (flyMode22.value == i) {
            return flyMode22;
        }
        FlyMode flyMode23 = POINT_FLY_INSIDE;
        if (flyMode23.value == i) {
            return flyMode23;
        }
        FlyMode flyMode24 = POINT_FLY_OUTSIDE;
        if (flyMode24.value == i) {
            return flyMode24;
        }
        FlyMode flyMode25 = TRIPOD;
        if (flyMode25.value == i) {
            return flyMode25;
        }
        FlyMode flyMode26 = PHOTOGRAPHER;
        if (flyMode26.value == i) {
            return flyMode26;
        }
        FlyMode flyMode27 = RECTANGLE;
        if (flyMode27.value == i) {
            return flyMode27;
        }
        FlyMode flyMode28 = RECTANGLE_HOLD;
        if (flyMode28.value == i) {
            return flyMode28;
        }
        FlyMode flyMode29 = POLYGON;
        if (flyMode29.value == i) {
            return flyMode29;
        }
        FlyMode flyMode30 = POLYGON_HOLD;
        if (flyMode30.value == i) {
            return flyMode30;
        }
        FlyMode flyMode31 = MOTION_DELAY;
        if (flyMode31.value == i) {
            return flyMode31;
        }
        FlyMode flyMode32 = MOTION_DELAY_PAUSE;
        if (flyMode32.value == i) {
            return flyMode32;
        }
        return UNKNOWN;
    }
}
