package com.autel.AutelNet2.aircraft.gimbal.engine;

import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.evo.EvoAngleInfo;

public class GimbalAngle implements EvoAngleInfo {
    private int GimbalState = -1;
    private float Pitch;
    private float PitchSpeed;
    private float Roll;
    private float RollSpeed;
    private float Timestamp;
    private float Yaw;
    private float YawSpeed;

    public float getTimestamp() {
        return this.Timestamp;
    }

    public void setTimestamp(float f) {
        this.Timestamp = f;
    }

    public float getPitch() {
        return (-this.Pitch) / 100.0f;
    }

    public void setPitch(float f) {
        this.Pitch = f;
    }

    public float getYaw() {
        return this.Yaw / 100.0f;
    }

    public void setYaw(float f) {
        this.Yaw = f;
    }

    public float getRoll() {
        return this.Roll / 100.0f;
    }

    public void setRoll(float f) {
        this.Roll = f;
    }

    public float getPitchSpeed() {
        return this.PitchSpeed / 100.0f;
    }

    public void setPitchSpeed(float f) {
        this.PitchSpeed = f;
    }

    public float getYawSpeed() {
        return this.YawSpeed / 100.0f;
    }

    public void setYawSpeed(float f) {
        this.YawSpeed = f;
    }

    public float getRollSpeed() {
        return this.RollSpeed / 100.0f;
    }

    public void setRollSpeed(float f) {
        this.RollSpeed = f;
    }

    public GimbalState getGimbalState() {
        GimbalState gimbalState = GimbalState.UNKNOWN;
        if (this.GimbalState == 0) {
            return GimbalState.NORMAL;
        }
        int gimbalActuatorStatus = getGimbalActuatorStatus();
        if (gimbalActuatorStatus == 0) {
            gimbalState = GimbalState.NORMAL;
        } else if (gimbalActuatorStatus == 1) {
            gimbalState = GimbalState.GIMBAL_PROTECT;
        } else if (gimbalActuatorStatus == 2) {
            gimbalState = GimbalState.GIMBAL_MOTOR_SHUTDOWN;
        }
        if (isHardwareFail()) {
            return GimbalState.HARDWARE_FAIL;
        }
        if (isOverTemperature()) {
            return GimbalState.OVER_TEMPERATURE;
        }
        if (isSleep()) {
            return GimbalState.SLEEP;
        }
        if (isAngleLimit()) {
            return GimbalState.ANGLE_LIMIT;
        }
        if (isCalibrationFail()) {
            return GimbalState.CALIBRATION_FAIL;
        }
        if (isWorkError()) {
            return GimbalState.WORK_ERROR;
        }
        switch (GimbalCalibrationStatus()) {
            case 1:
                return GimbalState.CALIBRATION_START;
            case 2:
                return GimbalState.CALIBRATING;
            case 3:
                return GimbalState.CALIBRATION_OK;
            case 4:
                return GimbalState.CALIBRATION_FAIL;
            case 5:
                return GimbalState.CALIBRATION_SAVE_FAILED;
            case 6:
                return GimbalState.CALIBRATION_VALID;
            case 7:
                return GimbalState.CALIBRATION_ATTI_SLOPED;
            case 8:
                return GimbalState.CALIBRATION_VIBRATORY;
            case 9:
                return GimbalState.CALIBRATION_MOTOR_RUNNING;
            default:
                return gimbalState;
        }
    }

    public void setGimbalState(int i) {
        this.GimbalState = i;
    }

    public boolean isOverTemperature() {
        return ((this.GimbalState >> 2) & 1) == 1;
    }

    public boolean isHardwareFail() {
        return ((this.GimbalState >> 3) & 1) == 1;
    }

    public int getGimbalActuatorStatus() {
        return (this.GimbalState >> 14) & 3;
    }

    public boolean isSleep() {
        return (this.GimbalState & 1) == 1;
    }

    public boolean isAngleLimit() {
        return ((this.GimbalState >> 1) & 1) == 1;
    }

    public boolean isCalibrationFail() {
        return ((this.GimbalState >> 4) & 1) == 1;
    }

    public boolean isWorkError() {
        return ((this.GimbalState >> 6) & 1) == 1;
    }

    public int GimbalCalibrationStatus() {
        return (this.GimbalState >> 10) & 15;
    }

    public String toString() {
        return "Timestamp=" + this.Timestamp + "GimbalState=" + this.GimbalState + " Pitch=" + this.Pitch + " Yaw=" + this.Yaw + " Roll=" + this.Roll + " PitchSpeed=" + this.PitchSpeed + " YawSpeed=" + this.YawSpeed + " RollSpeed=" + this.RollSpeed;
    }
}
