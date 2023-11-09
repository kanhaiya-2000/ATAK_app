package com.autel.AutelNet2.aircraft.gimbal.engine;

public enum GimbalCmdType {
    REPORT(1),
    RANGE(2),
    QUERY_MODE(3),
    SET_MODE(4),
    SET_GIMBAL_ADJUSTMENT(5),
    GET_GIMBAL_ADJUSTMENT(6),
    CMD_ANGLE_RESET(7),
    CMD_SET_MIN_ANGLE(8),
    CMD_SET_MAX_ANGLE(9),
    CMD_CALIBRATION(11),
    CMD_SET_PITCH_LIMIT_UPWARD(13),
    CMD_GET_PITCH_LIMIT_UPWARD(14),
    UNKNOWN(-1);
    
    private int value;

    private GimbalCmdType(int i) {
        this.value = i;
    }

    public static GimbalCmdType find(int i) {
        GimbalCmdType gimbalCmdType = REPORT;
        if (gimbalCmdType.getValue() == i) {
            return gimbalCmdType;
        }
        GimbalCmdType gimbalCmdType2 = RANGE;
        if (gimbalCmdType2.getValue() == i) {
            return gimbalCmdType2;
        }
        GimbalCmdType gimbalCmdType3 = QUERY_MODE;
        if (gimbalCmdType3.getValue() == i) {
            return gimbalCmdType3;
        }
        GimbalCmdType gimbalCmdType4 = SET_MODE;
        if (gimbalCmdType4.getValue() == i) {
            return gimbalCmdType4;
        }
        GimbalCmdType gimbalCmdType5 = SET_GIMBAL_ADJUSTMENT;
        if (gimbalCmdType5.getValue() == i) {
            return gimbalCmdType5;
        }
        GimbalCmdType gimbalCmdType6 = GET_GIMBAL_ADJUSTMENT;
        if (gimbalCmdType6.getValue() == i) {
            return gimbalCmdType6;
        }
        GimbalCmdType gimbalCmdType7 = CMD_ANGLE_RESET;
        if (gimbalCmdType7.getValue() == i) {
            return gimbalCmdType7;
        }
        GimbalCmdType gimbalCmdType8 = CMD_SET_MIN_ANGLE;
        if (gimbalCmdType8.getValue() == i) {
            return gimbalCmdType8;
        }
        GimbalCmdType gimbalCmdType9 = CMD_SET_MAX_ANGLE;
        if (gimbalCmdType9.getValue() == i) {
            return gimbalCmdType9;
        }
        GimbalCmdType gimbalCmdType10 = CMD_CALIBRATION;
        if (gimbalCmdType10.getValue() == i) {
            return gimbalCmdType10;
        }
        GimbalCmdType gimbalCmdType11 = CMD_SET_PITCH_LIMIT_UPWARD;
        if (gimbalCmdType11.getValue() == i) {
            return gimbalCmdType11;
        }
        GimbalCmdType gimbalCmdType12 = CMD_GET_PITCH_LIMIT_UPWARD;
        if (gimbalCmdType12.getValue() == i) {
            return gimbalCmdType12;
        }
        return UNKNOWN;
    }

    public int getValue() {
        return this.value;
    }
}
