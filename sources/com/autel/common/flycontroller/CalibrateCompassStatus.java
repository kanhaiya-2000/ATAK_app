package com.autel.common.flycontroller;

public enum CalibrateCompassStatus {
    NORMAL(0),
    START_HORIZONTAL(1),
    HORIZONTAL_CALCULATE(2),
    START_VERTICAL(3),
    VERTICAL_CALCULATE(4),
    LATERAL_ROTATE(9),
    SUCCESS(5),
    FAILED(6),
    NO_GPS(7),
    TIMEOUT(8),
    UNKNOWN(-1);
    
    private int value;

    private CalibrateCompassStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CalibrateCompassStatus find(int i) {
        CalibrateCompassStatus calibrateCompassStatus = NORMAL;
        if (calibrateCompassStatus.getValue() == i) {
            return calibrateCompassStatus;
        }
        CalibrateCompassStatus calibrateCompassStatus2 = START_HORIZONTAL;
        if (calibrateCompassStatus2.getValue() == i) {
            return calibrateCompassStatus2;
        }
        CalibrateCompassStatus calibrateCompassStatus3 = HORIZONTAL_CALCULATE;
        if (calibrateCompassStatus3.getValue() == i) {
            return calibrateCompassStatus3;
        }
        CalibrateCompassStatus calibrateCompassStatus4 = START_VERTICAL;
        if (calibrateCompassStatus4.getValue() == i) {
            return calibrateCompassStatus4;
        }
        CalibrateCompassStatus calibrateCompassStatus5 = VERTICAL_CALCULATE;
        if (calibrateCompassStatus5.getValue() == i) {
            return calibrateCompassStatus5;
        }
        CalibrateCompassStatus calibrateCompassStatus6 = SUCCESS;
        if (calibrateCompassStatus6.getValue() == i) {
            return calibrateCompassStatus6;
        }
        CalibrateCompassStatus calibrateCompassStatus7 = FAILED;
        if (calibrateCompassStatus7.getValue() == i) {
            return calibrateCompassStatus7;
        }
        CalibrateCompassStatus calibrateCompassStatus8 = NO_GPS;
        if (calibrateCompassStatus8.getValue() == i) {
            return calibrateCompassStatus8;
        }
        CalibrateCompassStatus calibrateCompassStatus9 = TIMEOUT;
        if (calibrateCompassStatus9.getValue() == i) {
            return calibrateCompassStatus9;
        }
        CalibrateCompassStatus calibrateCompassStatus10 = LATERAL_ROTATE;
        if (calibrateCompassStatus10.getValue() == i) {
            return calibrateCompassStatus10;
        }
        return UNKNOWN;
    }
}
