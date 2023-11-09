package com.autel.common.gimbal.evo;

public class GimbalAngleData {
    private float Pitch = 2.14748365E9f;
    private float Roll = 2.14748365E9f;
    private float Yaw = 2.14748365E9f;

    public float getPitch() {
        return -this.Pitch;
    }

    public void setPitch(float f) {
        this.Pitch = f;
    }

    public float getYaw() {
        return this.Yaw;
    }

    public void setYaw(float f) {
        this.Yaw = f;
    }

    public float getRoll() {
        return this.Roll;
    }

    public void setRoll(float f) {
        this.Roll = f;
    }
}
