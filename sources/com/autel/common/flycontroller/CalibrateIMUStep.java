package com.autel.common.flycontroller;

public enum CalibrateIMUStep {
    HORIZONTAL_UP(1),
    HORIZONTAL_DOWN(2),
    RIGHT_SIDE_UP(3),
    LEFT_SIDE_UP(4),
    VERTICAL_UP(5),
    VERTICAL_DOWN(6),
    UNKNOWN(-1);
    
    private int value;

    private CalibrateIMUStep(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CalibrateIMUStep find(int i) {
        CalibrateIMUStep calibrateIMUStep = HORIZONTAL_UP;
        if (calibrateIMUStep.getValue() == i) {
            return calibrateIMUStep;
        }
        CalibrateIMUStep calibrateIMUStep2 = HORIZONTAL_DOWN;
        if (calibrateIMUStep2.getValue() == i) {
            return calibrateIMUStep2;
        }
        CalibrateIMUStep calibrateIMUStep3 = RIGHT_SIDE_UP;
        if (calibrateIMUStep3.getValue() == i) {
            return calibrateIMUStep3;
        }
        CalibrateIMUStep calibrateIMUStep4 = LEFT_SIDE_UP;
        if (calibrateIMUStep4.getValue() == i) {
            return calibrateIMUStep4;
        }
        CalibrateIMUStep calibrateIMUStep5 = VERTICAL_UP;
        if (calibrateIMUStep5.getValue() == i) {
            return calibrateIMUStep5;
        }
        CalibrateIMUStep calibrateIMUStep6 = VERTICAL_DOWN;
        if (calibrateIMUStep6.getValue() == i) {
            return calibrateIMUStep6;
        }
        return UNKNOWN;
    }
}
