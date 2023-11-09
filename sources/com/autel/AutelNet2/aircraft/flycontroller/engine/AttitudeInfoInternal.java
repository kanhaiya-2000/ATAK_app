package com.autel.AutelNet2.aircraft.flycontroller.engine;

import com.autel.common.flycontroller.evo.EvoAttitudeInfo;

public class AttitudeInfoInternal implements EvoAttitudeInfo {
    private double Pitch;
    private double PitchSpeed;
    private double Roll;
    private double RollSpeed;
    private int TimeBootMs;
    private double Yaw;
    private double YawSpeed;

    public int getTimeBootMs() {
        return this.TimeBootMs;
    }

    public void setTimeBootMs(int i) {
        this.TimeBootMs = i;
    }

    public void setRoll(double d) {
        this.Roll = d;
    }

    public void setPitch(double d) {
        this.Pitch = d;
    }

    public void setYaw(double d) {
        this.Yaw = d;
    }

    public double getRollSpeed() {
        return this.RollSpeed;
    }

    public void setRollSpeed(double d) {
        this.RollSpeed = d;
    }

    public double getPitchSpeed() {
        return this.PitchSpeed;
    }

    public void setPitchSpeed(double d) {
        this.PitchSpeed = d;
    }

    public double getYawSpeed() {
        return this.YawSpeed;
    }

    public void setYawSpeed(double d) {
        this.YawSpeed = d;
    }

    public double getRoll() {
        return (this.Roll * 180.0d) / 3.141592653589793d;
    }

    public double getPitch() {
        return (this.Pitch * 180.0d) / 3.141592653589793d;
    }

    public double getYaw() {
        return (this.Yaw * 180.0d) / 3.141592653589793d;
    }

    public String toString() {
        return "Roll : " + this.Roll + " Pitch : " + this.Pitch + " Yaw : " + this.Yaw + " \n\n";
    }
}
