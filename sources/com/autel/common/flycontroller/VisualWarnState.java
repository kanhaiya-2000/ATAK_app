package com.autel.common.flycontroller;

public enum VisualWarnState {
    FAIL_SAFE(21),
    ILLUMINATION_DIM(22),
    ILLUMINATION_DAZZLING(23),
    OPTICAL_FLOW_INVALIDATE(24),
    USER_CANCEL(25),
    TRACK_TARGET_MISS(26),
    PASSING_AROUND(27),
    UNABLE_PASSING_AROUND_AND_LOCK(28),
    ADJUST_ALTITUDE(29),
    DRONE_ARRIVE_MIN_DISTANCE(30),
    DRONE_ARRIVE_MAX_DISTANCE(31),
    DRONE_ARRIVE_MAX_HEIGHT(32),
    DRONE_ARRIVE_MIN_HEIGHT(33),
    TRACKING_FONT_BACK_ROCK(34),
    TRACKING_UNKNOWN_ERROR(35),
    TRACKING_LIMIT_SPEED(36),
    TRACKING_MOVE_OTHER_WAY(37),
    REAR_OBSTACLE_DETECTED(38),
    PAUSE_VISUAL_TASK(39),
    EXIT_VISUAL_TASK(40),
    FLY_OVER(41),
    LEFT_AROUND(42),
    RIGHT_AROUND(43),
    ARRIVE_DISTANCE(44),
    ARRIVE_HEIGHT(45),
    START_LADING(46),
    HAVE_BLOCK(47),
    UNKNOWN_OBSTACLE(48),
    SAFE_LANDING(49),
    ACCURATE_LANDING_REPAIRING(50),
    ENVIRONMENT_SAFE_LANDING(51),
    MOVE_TO_SAFE_LANDING(52),
    LANDING_CANCEL_BY_USER(53),
    SAFE_SPACE_NOT_ENOUGH(54),
    MOVE_SAFE_SPACE_TRY_AGAIN(55),
    VISUAL_NEED_REBOOT(56),
    DOWNWARD_VISION_EXCEPTION(60),
    FONT_SENOR_PARAM_EXCEPTION(61),
    FONT_MODEL_EXCEPTION(62),
    DOWNWARD_VISION_ABNORMAL(63),
    FONT_BELOW_BOTH_MODEL_EXCEPTION(64),
    FONT_VISUAL_MODEL_EXCEPTION(65),
    BACKWARD_VISUAL_MODEL_EXCEPTION(66),
    DOWNWARD_VISUAL_MODEL_EXCEPTION(67),
    RIGHT_VISUAL_MODEL_EXCEPTION(68),
    LEFT_VISUAL_MODEL_EXCEPTION(69),
    TOP_VISUAL_MODEL_EXCEPTION(70),
    MORE_VISUAL_MODEL_EXCEPTION(71),
    VISUAL_ARRIVE_MAX_HEIGHT(72),
    VISUAL_ARRIVE_MIN_HEIGHT(73),
    VISUAL_ARRIVE_MAX_ZOOM(74),
    VISUAL_ARRIVE_MIN_ZOOM(75),
    VISUAL_STOP_VIEW_POINT(76),
    VISUAL_ATTI_MODE(77),
    VISUAL_EXIT_BUTTON(78),
    VISUAL_TRACK_EXCEPTION(79),
    UNKNOWN(-1);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    private VisualWarnState(int i) {
        this.value = i;
    }

    public static VisualWarnState find(int i) {
        VisualWarnState visualWarnState = FAIL_SAFE;
        if (visualWarnState.value == i) {
            return visualWarnState;
        }
        VisualWarnState visualWarnState2 = ILLUMINATION_DIM;
        if (visualWarnState2.value == i) {
            return visualWarnState2;
        }
        VisualWarnState visualWarnState3 = ILLUMINATION_DAZZLING;
        if (visualWarnState3.value == i) {
            return visualWarnState3;
        }
        VisualWarnState visualWarnState4 = OPTICAL_FLOW_INVALIDATE;
        if (visualWarnState4.value == i) {
            return visualWarnState4;
        }
        VisualWarnState visualWarnState5 = USER_CANCEL;
        if (visualWarnState5.value == i) {
            return visualWarnState5;
        }
        VisualWarnState visualWarnState6 = TRACK_TARGET_MISS;
        if (visualWarnState6.value == i) {
            return visualWarnState6;
        }
        VisualWarnState visualWarnState7 = PASSING_AROUND;
        if (visualWarnState7.value == i) {
            return visualWarnState7;
        }
        VisualWarnState visualWarnState8 = UNABLE_PASSING_AROUND_AND_LOCK;
        if (visualWarnState8.value == i) {
            return visualWarnState8;
        }
        VisualWarnState visualWarnState9 = ADJUST_ALTITUDE;
        if (visualWarnState9.value == i) {
            return visualWarnState9;
        }
        VisualWarnState visualWarnState10 = DRONE_ARRIVE_MIN_DISTANCE;
        if (visualWarnState10.value == i) {
            return visualWarnState10;
        }
        VisualWarnState visualWarnState11 = DRONE_ARRIVE_MAX_DISTANCE;
        if (visualWarnState11.value == i) {
            return visualWarnState11;
        }
        VisualWarnState visualWarnState12 = DRONE_ARRIVE_MAX_HEIGHT;
        if (visualWarnState12.value == i) {
            return visualWarnState12;
        }
        VisualWarnState visualWarnState13 = DRONE_ARRIVE_MIN_HEIGHT;
        if (visualWarnState13.value == i) {
            return visualWarnState13;
        }
        VisualWarnState visualWarnState14 = TRACKING_FONT_BACK_ROCK;
        if (visualWarnState14.value == i) {
            return visualWarnState14;
        }
        VisualWarnState visualWarnState15 = TRACKING_UNKNOWN_ERROR;
        if (visualWarnState15.value == i) {
            return visualWarnState15;
        }
        VisualWarnState visualWarnState16 = START_LADING;
        if (visualWarnState16.value == i) {
            return visualWarnState16;
        }
        VisualWarnState visualWarnState17 = HAVE_BLOCK;
        if (visualWarnState17.value == i) {
            return visualWarnState17;
        }
        VisualWarnState visualWarnState18 = UNKNOWN_OBSTACLE;
        if (visualWarnState18.value == i) {
            return visualWarnState18;
        }
        VisualWarnState visualWarnState19 = SAFE_LANDING;
        if (visualWarnState19.value == i) {
            return visualWarnState19;
        }
        VisualWarnState visualWarnState20 = ACCURATE_LANDING_REPAIRING;
        if (visualWarnState20.value == i) {
            return visualWarnState20;
        }
        VisualWarnState visualWarnState21 = ENVIRONMENT_SAFE_LANDING;
        if (visualWarnState21.value == i) {
            return visualWarnState21;
        }
        VisualWarnState visualWarnState22 = MOVE_TO_SAFE_LANDING;
        if (visualWarnState22.value == i) {
            return visualWarnState22;
        }
        VisualWarnState visualWarnState23 = TRACKING_LIMIT_SPEED;
        if (visualWarnState23.value == i) {
            return visualWarnState23;
        }
        VisualWarnState visualWarnState24 = TRACKING_MOVE_OTHER_WAY;
        if (visualWarnState24.value == i) {
            return visualWarnState24;
        }
        VisualWarnState visualWarnState25 = DOWNWARD_VISION_EXCEPTION;
        if (visualWarnState25.value == i) {
            return visualWarnState25;
        }
        VisualWarnState visualWarnState26 = FONT_SENOR_PARAM_EXCEPTION;
        if (visualWarnState26.value == i) {
            return visualWarnState26;
        }
        VisualWarnState visualWarnState27 = REAR_OBSTACLE_DETECTED;
        if (visualWarnState27.value == i) {
            return visualWarnState27;
        }
        VisualWarnState visualWarnState28 = PAUSE_VISUAL_TASK;
        if (visualWarnState28.value == i) {
            return visualWarnState28;
        }
        VisualWarnState visualWarnState29 = LANDING_CANCEL_BY_USER;
        if (visualWarnState29.value == i) {
            return visualWarnState29;
        }
        VisualWarnState visualWarnState30 = EXIT_VISUAL_TASK;
        if (visualWarnState30.value == i) {
            return visualWarnState30;
        }
        VisualWarnState visualWarnState31 = FONT_MODEL_EXCEPTION;
        if (visualWarnState31.value == i) {
            return visualWarnState31;
        }
        VisualWarnState visualWarnState32 = DOWNWARD_VISION_ABNORMAL;
        if (visualWarnState32.value == i) {
            return visualWarnState32;
        }
        VisualWarnState visualWarnState33 = FONT_BELOW_BOTH_MODEL_EXCEPTION;
        if (visualWarnState33.value == i) {
            return visualWarnState33;
        }
        VisualWarnState visualWarnState34 = FLY_OVER;
        if (visualWarnState34.value == i) {
            return visualWarnState34;
        }
        VisualWarnState visualWarnState35 = LEFT_AROUND;
        if (visualWarnState35.value == i) {
            return visualWarnState35;
        }
        VisualWarnState visualWarnState36 = RIGHT_AROUND;
        if (visualWarnState36.value == i) {
            return visualWarnState36;
        }
        VisualWarnState visualWarnState37 = ARRIVE_DISTANCE;
        if (visualWarnState37.value == i) {
            return visualWarnState37;
        }
        VisualWarnState visualWarnState38 = ARRIVE_HEIGHT;
        if (visualWarnState38.value == i) {
            return visualWarnState38;
        }
        VisualWarnState visualWarnState39 = SAFE_SPACE_NOT_ENOUGH;
        if (visualWarnState39.value == i) {
            return visualWarnState39;
        }
        VisualWarnState visualWarnState40 = VISUAL_ARRIVE_MAX_HEIGHT;
        if (visualWarnState40.value == i) {
            return visualWarnState40;
        }
        VisualWarnState visualWarnState41 = VISUAL_ARRIVE_MIN_HEIGHT;
        if (visualWarnState41.value == i) {
            return visualWarnState41;
        }
        VisualWarnState visualWarnState42 = VISUAL_ARRIVE_MAX_ZOOM;
        if (visualWarnState42.value == i) {
            return visualWarnState42;
        }
        VisualWarnState visualWarnState43 = VISUAL_ARRIVE_MIN_ZOOM;
        if (visualWarnState43.value == i) {
            return visualWarnState43;
        }
        VisualWarnState visualWarnState44 = MOVE_SAFE_SPACE_TRY_AGAIN;
        if (visualWarnState44.value == i) {
            return visualWarnState44;
        }
        VisualWarnState visualWarnState45 = FONT_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState45.value == i) {
            return visualWarnState45;
        }
        VisualWarnState visualWarnState46 = BACKWARD_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState46.value == i) {
            return visualWarnState46;
        }
        VisualWarnState visualWarnState47 = DOWNWARD_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState47.value == i) {
            return visualWarnState47;
        }
        VisualWarnState visualWarnState48 = RIGHT_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState48.value == i) {
            return visualWarnState48;
        }
        VisualWarnState visualWarnState49 = LEFT_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState49.value == i) {
            return visualWarnState49;
        }
        VisualWarnState visualWarnState50 = TOP_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState50.value == i) {
            return visualWarnState50;
        }
        VisualWarnState visualWarnState51 = MORE_VISUAL_MODEL_EXCEPTION;
        if (visualWarnState51.value == i) {
            return visualWarnState51;
        }
        VisualWarnState visualWarnState52 = VISUAL_ATTI_MODE;
        if (visualWarnState52.value == i) {
            return visualWarnState52;
        }
        VisualWarnState visualWarnState53 = VISUAL_STOP_VIEW_POINT;
        if (visualWarnState53.value == i) {
            return visualWarnState53;
        }
        VisualWarnState visualWarnState54 = VISUAL_EXIT_BUTTON;
        if (visualWarnState54.value == i) {
            return visualWarnState54;
        }
        VisualWarnState visualWarnState55 = VISUAL_TRACK_EXCEPTION;
        if (visualWarnState55.value == i) {
            return visualWarnState55;
        }
        return UNKNOWN;
    }
}
