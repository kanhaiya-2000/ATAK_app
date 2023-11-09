package com.autel.common.flycontroller;

public enum CalibrateIMUStatus {
    START_CALIBRATION(1),
    IN_CALIBRATION(2),
    DRONE_SHAKING(3),
    ORIENTATION_ERROR(4),
    SUCCESS(5),
    FAILED(6),
    UNKNOWN(-1);
    
    private int value;

    private CalibrateIMUStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CalibrateIMUStatus find(int i) {
        CalibrateIMUStatus calibrateIMUStatus = START_CALIBRATION;
        if (calibrateIMUStatus.getValue() == i) {
            return calibrateIMUStatus;
        }
        CalibrateIMUStatus calibrateIMUStatus2 = IN_CALIBRATION;
        if (calibrateIMUStatus2.getValue() == i) {
            return calibrateIMUStatus2;
        }
        CalibrateIMUStatus calibrateIMUStatus3 = DRONE_SHAKING;
        if (calibrateIMUStatus3.getValue() == i) {
            return calibrateIMUStatus3;
        }
        CalibrateIMUStatus calibrateIMUStatus4 = ORIENTATION_ERROR;
        if (calibrateIMUStatus4.getValue() == i) {
            return calibrateIMUStatus4;
        }
        CalibrateIMUStatus calibrateIMUStatus5 = SUCCESS;
        if (calibrateIMUStatus5.getValue() == i) {
            return calibrateIMUStatus5;
        }
        CalibrateIMUStatus calibrateIMUStatus6 = FAILED;
        if (calibrateIMUStatus6.getValue() == i) {
            return calibrateIMUStatus6;
        }
        return UNKNOWN;
    }
}
