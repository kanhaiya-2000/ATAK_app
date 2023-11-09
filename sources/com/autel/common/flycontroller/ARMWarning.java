package com.autel.common.flycontroller;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ARMWarning {
    IMU_LOSS(1, "IMU loss"),
    CRITICAL_BATTERY(2, "Critical battery"),
    BARO_LOSS(3, "Baro loss"),
    RED_ZONE(4, "RedZone"),
    IOC_ERROR(5, "IOC error"),
    BEGINNER_NO_GPS(6, "Beginner NO GPS"),
    DISARM_TILT_OVER_45DEG(7, "Disarm tilt over 45deg"),
    DISARM_IMU_LOSS(8, " Disarm IMU loss"),
    IMU_IS_WARMING_UP(9, "IMU is warming up"),
    MAGNETOMETER_IS_CALIBRATING(10, "Magnetometer is calibrating"),
    MULTIPLE_SENSORS_ERROR(11, "Multiple sensors error"),
    GIMBAL_IS_NOT_READY(12, "Gimbal is not ready."),
    UPGRADE_IS_GOING(13, "upgrade is ongoing."),
    NORMAL(0, "normal"),
    UNKNOWN(-1, SoloControllerUnits.UNKNOWN);
    
    private String description;
    private int value;

    private ARMWarning(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static ARMWarning find(int i) {
        ARMWarning aRMWarning = IMU_LOSS;
        if (aRMWarning.getValue() == i) {
            return aRMWarning;
        }
        ARMWarning aRMWarning2 = CRITICAL_BATTERY;
        if (aRMWarning2.getValue() == i) {
            return aRMWarning2;
        }
        ARMWarning aRMWarning3 = BARO_LOSS;
        if (aRMWarning3.getValue() == i) {
            return aRMWarning3;
        }
        ARMWarning aRMWarning4 = RED_ZONE;
        if (aRMWarning4.getValue() == i) {
            return aRMWarning4;
        }
        ARMWarning aRMWarning5 = IOC_ERROR;
        if (aRMWarning5.getValue() == i) {
            return aRMWarning5;
        }
        ARMWarning aRMWarning6 = BEGINNER_NO_GPS;
        if (aRMWarning6.getValue() == i) {
            return aRMWarning6;
        }
        ARMWarning aRMWarning7 = DISARM_TILT_OVER_45DEG;
        if (aRMWarning7.getValue() == i) {
            return aRMWarning7;
        }
        ARMWarning aRMWarning8 = DISARM_IMU_LOSS;
        if (aRMWarning8.getValue() == i) {
            return aRMWarning8;
        }
        ARMWarning aRMWarning9 = IMU_IS_WARMING_UP;
        if (aRMWarning9.getValue() == i) {
            return aRMWarning9;
        }
        ARMWarning aRMWarning10 = MAGNETOMETER_IS_CALIBRATING;
        if (aRMWarning10.getValue() == i) {
            return aRMWarning10;
        }
        ARMWarning aRMWarning11 = MULTIPLE_SENSORS_ERROR;
        if (aRMWarning11.getValue() == i) {
            return aRMWarning11;
        }
        ARMWarning aRMWarning12 = GIMBAL_IS_NOT_READY;
        if (aRMWarning12.getValue() == i) {
            return aRMWarning12;
        }
        ARMWarning aRMWarning13 = NORMAL;
        if (aRMWarning13.getValue() == i) {
            return aRMWarning13;
        }
        ARMWarning aRMWarning14 = UPGRADE_IS_GOING;
        if (aRMWarning14.getValue() == i) {
            return aRMWarning14;
        }
        return UNKNOWN;
    }
}
