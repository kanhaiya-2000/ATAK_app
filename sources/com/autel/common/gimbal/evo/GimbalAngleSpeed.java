package com.autel.common.gimbal.evo;

public class GimbalAngleSpeed {
    private float PitchSpeed = 0.0f;
    private int RollSpeed = 0;
    private int YawSpeed = 0;

    public float getPitchSpeed() {
        return -this.PitchSpeed;
    }

    public void setPitchSpeed(float f) {
        this.PitchSpeed = f;
    }

    public int getYawSpeed() {
        return this.YawSpeed;
    }

    public void setYawSpeed(int i) {
        this.YawSpeed = i;
    }

    public int getRollSpeed() {
        return this.RollSpeed;
    }

    public void setRollSpeed(int i) {
        this.RollSpeed = i;
    }
}
