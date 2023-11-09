package com.autel.common.gimbal;

public enum GimbalState {
    OVER_TEMPERATURE(1, "The gimbal motor is overheated caused by failing to spin the motor or other reasons"),
    HARDWARE_FAIL(2, "The gimbal is abnormal caused by the failure of sensors or actuators"),
    SLEEP(4, "No attitude data, the gimbal enters into the sleep mode"),
    ANGLE_LIMIT(6, "The large tilt angle makes the gimbal reach its limit"),
    ANGLE_LIMIT_TO_SLEEP(7, "The large tilt angle makes the gimbal enter into the sleep mode"),
    CALIBRATION_FAIL(8, "Failed to calibrate the compass"),
    WORK_ERROR(118, "work exception"),
    NORMAL(-1, "The aircraft gimbal state is normal"),
    CALIBRATION_NULL(10, "The aircraft gimbal data is null"),
    CALIBRATION_START(11, "The aircraft will start calibrating"),
    CALIBRATING(12, "The aircraft is calibrating"),
    CALIBRATION_OK(13, "The calibration is finished without saving"),
    CALIBRATION_SAVE_FAILED(15, "The aircraft failed to save the calibration data"),
    CALIBRATION_VALID(16, "The calibration is valid and backup to the flash"),
    CALIBRATION_ATTI_SLOPED(17, "The aircraft is not positioned horizontally"),
    CALIBRATION_VIBRATORY(18, "The aircraft vibrates"),
    CALIBRATION_MOTOR_RUNNING(19, "The aircraft motor is still running"),
    GIMBAL_PROTECT(20, "The aircraft's gimbal is protect"),
    GIMBAL_MOTOR_SHUTDOWN(21, "The aircraft's gimbal shutdown"),
    UNKNOWN(-2, "The aircraft gimbal state is unknown");
    
    private String description;
    private int value;

    private GimbalState(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static GimbalState find(int i) {
        GimbalState gimbalState = SLEEP;
        if (gimbalState.getValue() == i) {
            return gimbalState;
        }
        GimbalState gimbalState2 = ANGLE_LIMIT;
        if (gimbalState2.getValue() == i) {
            return gimbalState2;
        }
        GimbalState gimbalState3 = ANGLE_LIMIT_TO_SLEEP;
        if (gimbalState3.getValue() == i) {
            return gimbalState3;
        }
        GimbalState gimbalState4 = OVER_TEMPERATURE;
        if (gimbalState4.getValue() == i) {
            return gimbalState4;
        }
        GimbalState gimbalState5 = HARDWARE_FAIL;
        if (gimbalState5.getValue() == i) {
            return gimbalState5;
        }
        GimbalState gimbalState6 = CALIBRATION_FAIL;
        if (gimbalState6.getValue() == i) {
            return gimbalState6;
        }
        GimbalState gimbalState7 = NORMAL;
        if (gimbalState7.getValue() == i) {
            return gimbalState7;
        }
        if (gimbalState6.getValue() == i) {
            return gimbalState6;
        }
        GimbalState gimbalState8 = WORK_ERROR;
        if (gimbalState8.getValue() == i) {
            return gimbalState8;
        }
        GimbalState gimbalState9 = CALIBRATION_NULL;
        if (gimbalState9.getValue() == i) {
            return gimbalState9;
        }
        GimbalState gimbalState10 = CALIBRATION_START;
        if (gimbalState10.getValue() == i) {
            return gimbalState10;
        }
        GimbalState gimbalState11 = CALIBRATING;
        if (gimbalState11.getValue() == i) {
            return gimbalState11;
        }
        GimbalState gimbalState12 = CALIBRATION_OK;
        if (gimbalState12.getValue() == i) {
            return gimbalState12;
        }
        GimbalState gimbalState13 = CALIBRATION_SAVE_FAILED;
        if (gimbalState13.getValue() == i) {
            return gimbalState13;
        }
        GimbalState gimbalState14 = CALIBRATION_VALID;
        if (gimbalState14.getValue() == i) {
            return gimbalState14;
        }
        GimbalState gimbalState15 = CALIBRATION_ATTI_SLOPED;
        if (gimbalState15.getValue() == i) {
            return gimbalState15;
        }
        GimbalState gimbalState16 = CALIBRATION_VIBRATORY;
        if (gimbalState16.getValue() == i) {
            return gimbalState16;
        }
        GimbalState gimbalState17 = CALIBRATION_MOTOR_RUNNING;
        if (gimbalState17.getValue() == i) {
            return gimbalState17;
        }
        GimbalState gimbalState18 = GIMBAL_PROTECT;
        if (gimbalState18.getValue() == i) {
            return gimbalState18;
        }
        GimbalState gimbalState19 = GIMBAL_MOTOR_SHUTDOWN;
        if (gimbalState19.getValue() == i) {
            return gimbalState19;
        }
        return UNKNOWN;
    }
}
